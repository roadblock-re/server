package moe.crx.roadblock

import io.ktor.network.tls.certificates.*
import io.ktor.network.tls.extensions.*
import io.ktor.server.engine.*
import org.bouncycastle.openssl.jcajce.JcaPEMWriter
import java.io.File
import java.io.FileInputStream
import java.io.FileWriter
import java.security.KeyStore
import javax.security.auth.x500.X500Principal

fun ApplicationEngine.Configuration.sslConfig(sslPort: Int) {
    val keyStoreFile = File("certs/keystore.jks")
    val certFile = File("certs/certificate.cer")

    val keyAlias = "roadblock"
    val keyStorePassword = "password"
    val privateKeyPassword = "password"

    if (!keyStoreFile.exists()) {
        val keyStore = buildKeyStore {
            certificate(keyAlias) {
                hash = HashAlgorithm.SHA384
                sign = SignatureAlgorithm.RSA
                password = privateKeyPassword
                domains = listOf("eve.gameloft.com")
                daysValid = 365 * 10
                ipAddresses = listOf()
                subject = X500Principal("CN=eve.gameloft.com,OU=Unknown,O=Unknown,L=Unknown,ST=Unknown,C=Unknown")
            }
        }
        keyStore.saveToFile(keyStoreFile, keyStorePassword)
    }

    val keyStore = KeyStore.getInstance("JKS").apply {
        load(FileInputStream(keyStoreFile), keyStorePassword.toCharArray())
    }

    JcaPEMWriter(FileWriter(certFile)).use { certWriter ->
        certWriter.writeObject(keyStore.run { getCertificate(aliases().nextElement()) })
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