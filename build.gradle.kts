import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

val logbackVersion = extra["logback.version"] as String
val postgresqlVersion = extra["postgresql.version"] as String
val exposedVersion = extra["exposed.version"] as String
val kotlinxDatetimeVersion = extra["kotlinx.datetime.version"] as String
val hikariVersion = extra["hikari.version"] as String
val flywayVersion = extra["flyway.version"] as String

plugins {
    application
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("io.ktor.plugin")
}

application {
    mainClass.set("moe.crx.roadblock.ApplicationKt")
}

group = "moe.crx"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
}

tasks.named<ShadowJar>("shadowJar") {
    mergeServiceFiles()
}

dependencies {
    implementation("org.fusesource.jansi:jansi:2.4.2")
    implementation("org.bouncycastle:bcpkix-jdk18on:1.80")
    implementation("org.bouncycastle:bcprov-jdk18on:1.80")
    implementation("org.lz4:lz4-java:1.8.0")

    implementation("org.jetbrains.kotlinx:kotlinx-datetime:$kotlinxDatetimeVersion")

    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")

    implementation("io.ktor:ktor-client-core")
    implementation("io.ktor:ktor-client-cio")
    implementation("io.ktor:ktor-client-content-negotiation-jvm")

    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("io.ktor:ktor-server-host-common-jvm")
    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    implementation("io.ktor:ktor-server-status-pages")
    implementation("io.ktor:ktor-server-rate-limit")
    implementation("io.ktor:ktor-server-call-logging")
    implementation("io.ktor:ktor-server-websockets")
    implementation("io.ktor:ktor-network-tls-certificates")

    testImplementation("io.ktor:ktor-server-test-host-jvm")

    // Will be used in future
    //implementation("org.flywaydb:flyway-core:$flywayVersion")
    //implementation("org.flywaydb:flyway-database-postgresql:$flywayVersion")
    //implementation("com.zaxxer:HikariCP:$hikariVersion")
    //implementation("org.postgresql:postgresql:$postgresqlVersion")

    //implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    //implementation("org.jetbrains.exposed:exposed-crypt:$exposedVersion")
    //implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    //implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    //implementation("org.jetbrains.exposed:exposed-kotlin-datetime:$exposedVersion")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}