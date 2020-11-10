import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "me.alecm"
version = "1.0-SNAPSHOT"
description = "playground.wire.MainKt"

// unlike:
// https://github.com/Egorand/wire-multiplatform-sample/blob/master/protos/build.gradle.kts
// I am hoping to keep this simple and neither embrace multiplatform
// nor multi-project builds.  I am hoping to build something quite
// small...

plugins {
    kotlin("jvm") version "1.4.10"
    id("com.github.johnrengelman.shadow") version "6.1.0" // we don't need id("application") if using this?

    // ATTEMPT #1
    // id("com.squareup.wire")
    // Plugin [id: 'com.squareup.wire'] was not found in any of the following sources:
    // - Gradle Core Plugins (plugin is not in 'org.gradle' namespace)
    // - Plugin Repositories (plugin dependency must include a version number for this source)

    // ATTEMPT #2
    // id("com.squareup.wire") version "3.5.0"
    // Plugin [id: 'com.squareup.wire', version: '3.5.0'] was not found in any of the following sources:
    // - Gradle Core Plugins (plugin is not in 'org.gradle' namespace)
    // - Plugin Repositories (could not resolve plugin artifact 'com.squareup.wire:com.squareup.wire.gradle.plugin:3.5.0')
    // Searched in the following repositories:
    // MavenRepo
    // Gradle Central Plugin Repository

}

// THIS IS NOT VIABLE UNTIL THE PLUGIN IS INTEGRATED
// wire { kotlin { } }

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
        attributes["Main-Class"] = "playground.wire.HelloWorldKt" // replaces application.setMainClassName stuff
    }
    minimize()
}
