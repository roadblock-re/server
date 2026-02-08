package moe.crx.roadblock

import io.ktor.server.engine.*
import org.bouncycastle.asn1.x509.BasicConstraints
import org.bouncycastle.asn1.x509.Extension
import org.bouncycastle.asn1.x509.GeneralName
import org.bouncycastle.asn1.x509.GeneralNames
import org.bouncycastle.cert.X509v3CertificateBuilder
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder
import org.bouncycastle.jce.provider.BouncyCastleProvider
import org.bouncycastle.openssl.jcajce.JcaPEMWriter
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.FileWriter
import java.math.BigInteger
import java.security.KeyPairGenerator
import java.security.KeyStore
import java.security.Security
import java.security.cert.X509Certificate
import java.util.*
import javax.security.auth.x500.X500Principal

fun generateKeyStore(
    keyAlias: String,
    keyStorePassword: String,
    privateKeyPassword: String,
    keyStoreFile: File,
    ksProvider: KeyStore,
    pemFile: File,
    eveDomain: String,
) {
    val keyPairGen = KeyPairGenerator.getInstance("RSA")
    keyPairGen.initialize(1024)
    val keyPair = keyPairGen.generateKeyPair()

    val now = Date()
    val validUntil = Date(now.time + 3650L * 24 * 60 * 60 * 1000)
    val serialNumber = BigInteger.valueOf(System.currentTimeMillis())

    val subject = X500Principal("CN=$eveDomain,OU=Unknown,O=Unknown,L=Unknown,ST=Unknown,C=Unknown")

    val certBuilder: X509v3CertificateBuilder = JcaX509v3CertificateBuilder(
        subject, serialNumber, now, validUntil, subject, keyPair.public
    )

    certBuilder.addExtension(
        Extension.basicConstraints,
        true,
        BasicConstraints(true)
    )

    val san = GeneralNames(
        arrayOf(
            GeneralName(GeneralName.dNSName, eveDomain)
        )
    )

    certBuilder.addExtension(
        Extension.subjectAlternativeName,
        false,
        san
    )

    val signer = JcaContentSignerBuilder("SHA384withRSA").build(keyPair.private)
    val certificate: X509Certificate = JcaX509CertificateConverter()
        .setProvider(BouncyCastleProvider())
        .getCertificate(certBuilder.build(signer))

    val keyStore = ksProvider.apply {
        load(null, null)
        setKeyEntry(keyAlias, keyPair.private, privateKeyPassword.toCharArray(), arrayOf(certificate))
    }

    FileOutputStream(keyStoreFile).use {
        keyStore.store(it, keyStorePassword.toCharArray())
    }

    JcaPEMWriter(FileWriter(pemFile)).use { pemWriter ->
        pemWriter.writeObject(certificate)
    }
}

fun ApplicationEngine.Configuration.sslConfig(workingDirectory: String, sslPort: Int, eveDomain: String) {
    Security.addProvider(BouncyCastleProvider())

    val certsDirectory = File(workingDirectory, "certs")

    certsDirectory.mkdirs()

    val (ksProvider, keyStoreFile) = try {
        KeyStore.getInstance("JKS") to File(certsDirectory, "roadblock.jks")
    } catch (_: Exception) {
        KeyStore.getInstance("PKCS12") to File(certsDirectory, "roadblock.p12")
    }

    val keyAlias = "roadblock"
    val keyStorePassword = "password"
    val privateKeyPassword = "password"
    val pemFile = File(certsDirectory, "roadblock.cer")

    if (!keyStoreFile.exists()) {
        generateKeyStore(
            keyAlias,
            keyStorePassword,
            privateKeyPassword,
            keyStoreFile,
            ksProvider,
            pemFile,
            eveDomain,
        )
    }

    val keyStore = ksProvider.apply {
        load(FileInputStream(keyStoreFile), keyStorePassword.toCharArray())
    }

    sslConnector(
        keyStore = keyStore,
        keyAlias = keyAlias,
        keyStorePassword = { keyStorePassword.toCharArray() },
        privateKeyPassword = { privateKeyPassword.toCharArray() }) {
        port = sslPort
        keyStorePath = keyStoreFile
    }
}