import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "me.alecm"
version = "1.0-SNAPSHOT"
description = "playground.wire.MainKt"

plugins {
    kotlin("jvm") version "1.4.10"
    id("com.github.johnrengelman.shadow") version "6.1.0" // we don't need id("application") if using this?
}

dependencies {
    Libs.implementations.forEach{ this.implementation(it) } // be verbose to avoid ambiguity
    Libs.testImplementations.forEach { this.testImplementation(it) }
}

repositories { // see also: settings.gradle
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
