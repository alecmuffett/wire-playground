import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "me.alecm"
version = "1.0-SNAPSHOT"
description = "playground.wire.MainKt"

plugins {
    kotlin("jvm") version "1.4.10"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("com.squareup.wire") version "3.5.0" // THIS IS IMPORTANT, see also: settings.gradle
}

wire { kotlin { } } // THIS IS IMPORTANT, see also: settings.gradle

dependencies {
    Libs.implementations.forEach{ this.implementation(it) }
    Libs.testImplementations.forEach { this.testImplementation(it) }
}

repositories {
    mavenCentral()
    jcenter()
}

kotlin {
    explicitApiWarning()
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.verbose = true
}

tasks.withType<ShadowJar> {
    manifest {
        attributes["Main-Class"] = "playground.wire.HelloWorldKt"
    }
    minimize()
}
