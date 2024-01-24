plugins {
    kotlin("jvm") version "1.9.21"
    `java-gradle-plugin`
    id("org.jetbrains.kotlinx.kover") version "0.7.5"
    `jvm-test-suite`
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.intellij.deps:intellij-coverage-reporter:1.0.744")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
//    testRuntimeOnly("org.jetbrains.kotlinx:kover-gradle-plugin:0.7.5")
    testRuntimeOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.21")
}

testing.suites {
    val test by getting(JvmTestSuite::class) {
        useJUnitJupiter()
    }
}

kotlin {
    jvmToolchain(17)
}

gradlePlugin {
    plugins {
        create("plugin-with-cover") {
            id = "org.example.plugin-with-cover"
            implementationClass = "org.example.MyPlugin"
        }
    }
}

kover {
    excludeInstrumentation {
        classes("*CompileOptions*")
        packages("com.android")
        packages("*.android.*")
    }
}
