plugins {
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
}

repositories {
    mavenCentral()
}

dependencies {

    implementation(libs.javafx.fxml)
    implementation(libs.javafx.controls)
    implementation(libs.atlantafx)
    implementation(libs.ikonli)
    implementation(libs.ikonli.fontawesome5.pack)
    implementation(libs.ikonli.javafx)
    implementation(libs.richtextfx)

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
