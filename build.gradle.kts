import Versions.withVer


plugins {
    base
    java
    kotlin("jvm") version Versions.kotlin
    id("io.spring.dependency-management") version Versions.dependency_management

}

allprojects {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

subprojects {

    apply {
        plugin<JavaLibraryPlugin>()
        plugin<org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin>()
    }

    tasks {
        test {
            useJUnitPlatform()
        }
    }

    val implementation by configurations
    val testImplementation by configurations

    dependencies {
        // Align versions of all Kotlin components
        implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

        // Use the Kotlin JDK 8 standard library.
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        // This dependency is used by the application.
        implementation("com.google.guava:guava:31.0.1-jre")

        // Testing
        testImplementation("org.junit.jupiter:junit-jupiter".withVer(Versions.junit_jupiter))
        testImplementation("org.junit.jupiter:junit-jupiter-api".withVer(Versions.junit_jupiter))
        testImplementation("org.junit.jupiter:junit-jupiter-engine".withVer(Versions.junit_jupiter))
        testImplementation("org.junit.jupiter:junit-jupiter-params".withVer(Versions.junit_jupiter))
        testImplementation("org.junit.jupiter:junit-jupiter-migrationsupport".withVer(Versions.junit_jupiter))
        testImplementation("org.junit.platform:junit-platform-engine".withVer(Versions.junit_platform))

        testImplementation("io.mockk:mockk".withVer(Versions.mockk))
        testImplementation("org.amshove.kluent:kluent".withVer(Versions.kluent))
        testImplementation("org.assertj:assertj-core".withVer(Versions.assertj_core))

        // Use the Kotlin test library.
        // testImplementation("org.jetbrains.kotlin:kotlin-test")

        // Use the Kotlin JUnit integration.
        // testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    }

}