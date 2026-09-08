plugins {
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.openjfx:javafx-fxml:21.0.12")
    implementation("org.openjfx:javafx-controls:21.0.12")
    implementation("io.github.mkpaz:atlantafx-base:2.0.0")
    implementation("org.kordamp.ikonli:ikonli-core:12.4.0")
    implementation("org.kordamp.ikonli:ikonli-javafx:12.4.0")
    implementation("org.kordamp.ikonli:ikonli-fontawesome5-pack:12.4.0")

    // Source: https://mvnrepository.com/artifact/org.fxmisc.richtext/richtextfx
    implementation("org.fxmisc.richtext:richtextfx:0.11.7")

    // uncomment to reuse widgets and models from the main app
    // implementation(project(":app"))
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter("5.12.1")
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

javafx {
    version = "21.0.12"
    modules = listOf("javafx.controls", "javafx.fxml")
}

application {
    mainClass = "e.dream.learn.Sandbox"
}
