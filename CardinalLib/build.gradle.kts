plugins {
    id("com.android.library") version "8.3.0"
    id("maven-publish")
}

group = "org.example"
version = "1.0.0"

android {
    namespace = "org.example.cardinallib"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
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

//publishing {
//    publications {
//        create<MavenPublication>("release") {
//            groupId = "org.example"
//            artifactId = "CardinalLib"
//            version = "1.0.0"
//
//            // Specify the .aar artifact
//            artifact("$buildDir/outputs/aar/CardinalLib-release.aar")
//        }
//    }
//    repositories {
//        mavenLocal()
//    }
//}