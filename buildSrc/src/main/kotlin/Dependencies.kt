object Meta {
    const val description = "com.alecmuffett.playground.wire"
    const val group = "me.alecm"
    const val version = "1.0-SNAPSHOT"
    const val jvmMain = "playground.wire.MainKt"
    const val jvmTarget = "1.8"
}

object Versions {
    const val guava = "30.0-jre"
    const val junit = "4.13"
    const val junitJupiter = "5.6.3"
    const val kodeinDefault = "7.1.0"
    const val kotlinDefault = "1.4.10"
    const val kotlinLogging = "2.0.3"
    const val mavenAssembly = "3.3.0"
    const val mavenJar = "3.2.0"
    const val slf4jDefault = "1.7.30"
}

object Libs {
    val implementations = listOf(
        "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinDefault}",
        "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlinDefault}",
        "org.kodein.di:kodein-di-jvm:${Versions.kodeinDefault}",
        "com.google.guava:guava:${Versions.guava}",
        "io.github.microutils:kotlin-logging-jvm:${Versions.kotlinLogging}",
        "org.slf4j:slf4j-simple:${Versions.slf4jDefault}",
        "org.apache.maven.plugins:maven-assembly-plugin:${Versions.mavenAssembly}",
        "org.apache.maven.plugins:maven-jar-plugin:${Versions.mavenJar}"
    )

    val testImplementations = listOf(
        "junit:junit:${Versions.junit}",
        "org.junit.jupiter:junit-jupiter:${Versions.junitJupiter}",
        "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlinDefault}"
    )
}
