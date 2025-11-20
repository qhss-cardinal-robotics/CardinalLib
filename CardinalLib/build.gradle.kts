plugins {
    id("com.android.library") version "8.3.0"
    id("maven-publish")
}

android {
    namespace = "org.lib.cardinallib"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("org.firstinspires.ftc:RobotCore:11.0.0")
    implementation("org.firstinspires.ftc:Hardware:11.0.0")
    implementation("org.firstinspires.ftc:FtcCommon:11.0.0")
}

// Optional: Maven publishing for JitPack or local
publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "org.example"
            artifactId = "CardinalLib"
            version = "1.0.5"

            // Point to the AAR output
            artifact(layout.buildDirectory.file("outputs/aar/CardinalLib-release.aar"))
        }
    }
    repositories {
        mavenLocal()
    }
}

tasks.named("publishReleasePublicationToMavenLocal") {
    dependsOn("assembleRelease")
}



//plugins {
//    id("com.android.library") version "8.3.0"
//    id("maven-publish")
//}
//
//android {
//    namespace = "org.lib.cardinallib"
//    compileSdk = 33
//
//    defaultConfig {
//        minSdk = 24
//    }
//
//    buildTypes {
//        release {
//            isMinifyEnabled = false
//        }
//    }
//
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_11
//        targetCompatibility = JavaVersion.VERSION_11
//    }
//}
//
//
//
//repositories {
//    google()
//    mavenCentral()
////    maven { url = uri("https://jitpack.io") } added line
//}
//
//dependencies {
//    implementation("org.firstinspires.ftc:RobotCore:11.0.0")
//    implementation("org.firstinspires.ftc:Hardware:11.0.0")
//    implementation("org.firstinspires.ftc:FtcCommon:11.0.0")
//
//}
//
////publishing {
////    publications {
////        create<MavenPublication>("release") {
////            groupId = "org.example"
////            artifactId = "CardinalLib"
////            version = "1.0.0"
////
////            // Specify the .aar artifact
////            artifact("$buildDir/outputs/aar/CardinalLib-release.aar")
////        }
////    }
////    repositories {
////        mavenLocal()
////    }
////}