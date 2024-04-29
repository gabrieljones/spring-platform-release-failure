plugins {
    application
    id("io.spring.dependency-management") version "1.1.4"
}

dependencies {
    implementation("com.google.guava:guava:33.1.0-jre")
    implementation("org.example:transitive-platform-latest-release:latest.integration")
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter("5.10.1")
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

application {
    mainClass = "org.example.App"
}
