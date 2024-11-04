plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "http"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            api(libs.koin.core)
            implementation(libs.ktor.client.core)

            implementation("io.ktor:ktor-client-auth:3.0.0")
            implementation("io.ktor:ktor-client-logging:3.0.0")
            implementation("io.ktor:ktor-client-content-negotiation:3.0.0") // Ajouté pour la négociation de contenu
            implementation("io.ktor:ktor-serialization-kotlinx-json:3.0.0") // Pour la sérialisation JSON
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0") // Pour la sérialisation JSON

            implementation(libs.multiplatform.settings)
            implementation(project(":shared:core:preferences"))
        }
        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)

        }
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
            //implementation("io.ktor:ktor-client-ios:$3.0.0")
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.edu.shared.http"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
