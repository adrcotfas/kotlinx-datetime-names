@file:OptIn(ExperimentalKotlinGradlePluginApi::class)

import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.vanniktech.mavenPublish)
    alias(libs.plugins.detekt)
    alias(libs.plugins.ktlint)
}

group = "io.github.adrcotfas"
version = "0.2.0"

kotlin {
    jvm()
    android {
        namespace = "io.github.adrcotfas.datetime.names"
        compileSdk =
            libs.versions.android.compileSdk
                .get()
                .toInt()
        minSdk =
            libs.versions.android.minSdk
                .get()
                .toInt()

        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }

        compilations.configureEach {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_11)
                }
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    applyDefaultHierarchyTemplate()

    sourceSets {
        val jvmAndAndroidMain =
            create("jvmAndAndroidMain") {
                dependsOn(commonMain.get())
            }

        jvmMain {
            dependsOn(jvmAndAndroidMain)
        }

        androidMain {
            dependsOn(jvmAndAndroidMain)
        }

        commonMain.dependencies {
            implementation(libs.kotlinx.datetime)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        named("androidDeviceTest").dependencies {
            implementation(libs.androidx.runner)
            implementation(libs.androidx.core)
            implementation(libs.androidx.junit)
        }
    }
}

mavenPublishing {
    publishToMavenCentral()

    signAllPublications()

    coordinates(group.toString(), "kotlinx-datetime-names", version.toString())

    pom {
        name = "kotlinx-datetime-names"
        description = "Kotlin Multiplatform library for getting localized display names for kotlinx-datetime types"
        inceptionYear = "2025"
        url = "https://github.com/adrcotfas/kotlinx-datetime-names/"
        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                distribution = "repo"
            }
        }
        developers {
            developer {
                id = "adrcotfas"
                name = "Adrian Cotfas"
                email = "adrcotfas@duck.com"
                organization = "Goodtime"
                organizationUrl = "https://goodtime.tools"
                url = "https://github.com/adrcotfas"
            }
        }
        scm {
            url = "https://github.com/adrcotfas/kotlinx-datetime-names"
            connection = "scm:git:git://github.com/adrcotfas/kotlinx-datetime-names.git"
            developerConnection = "scm:git:ssh://git@github.com/adrcotfas/kotlinx-datetime-names.git"
        }
    }
}
