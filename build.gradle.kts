val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    application
    kotlin("jvm") version "1.8.10"
    //id("io.ktor.plugin") //version "2.2.4"
    //id("org.jetbrains.kotlin.plugin.serialization")// version "1.8.0"

}

group = "com.steve_md"
version = "0.0.1"
application {
    mainClass.set("com.example.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {

    // Adds Ktor's core components
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")

    // Adds Netty Engines allowing us to use server functionality
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")

    // See logs in console
    implementation("ch.qos.logback:logback-classic:$logback_version")

    // Testing
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    // Handle JSON formats for user input (request) & for API output(response)
    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
}