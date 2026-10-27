// UniversalAdmin Voice Chat - an official extension for Simple Voice Chat:
// mutes reach the voice chat (chat, voice or full mute), vanished staff stay
// silent, the profile shows the voice status, and staff get their own voice
// group. A separate plugin jar, built only against the public API
// (:universaladmin-api) like any third-party extension would be.

plugins {
    java
}

group = "dev.universaladmin.voicechat"
version = "1.6.0"
base.archivesName.set("universaladmin-voicechat")

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
    // Java 21 bytecode like every UniversalAdmin jar - see gradle.properties.
    disableAutoTargetJvm()
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") { name = "papermc" }
    // UniversalAdmin's releases - its jar contains the extension API.
    maven("https://api.modrinth.com/maven") { name = "modrinth" }
    maven("https://maven.maxhenkel.de/repository/public") { name = "voicechat" }
}

/** UniversalAdmin to compile against: a local build (-PuniversaladminJar=...) or the release from Modrinth. */
val universalAdmin: Any = providers.gradleProperty("universaladminJar").orNull?.let { files(it) }
    ?: "maven.modrinth:universaladmin:${property("universaladminVersion")}"

dependencies {
    compileOnly(universalAdmin)
    compileOnly("io.papermc.paper:paper-api:${property("paperApiVersion")}")
    // The oldest API version with everything used here, so the extension
    // runs with every Simple Voice Chat release for the supported Minecraft
    // versions. Provided by the voicechat plugin at runtime, never shaded.
    compileOnly("de.maxhenkel.voicechat:voicechat-api:2.5.0")

    testImplementation(platform("org.junit:junit-bom:5.12.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation(universalAdmin)
    testImplementation("io.papermc.paper:paper-api:${property("paperApiVersion")}")
    testImplementation("de.maxhenkel.voicechat:voicechat-api:2.5.0")
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.release.set(21)
    options.compilerArgs.add("-parameters")
}

tasks.test {
    useJUnitPlatform()
}

tasks.processResources {
    val props = mapOf("version" to project.version)
    inputs.properties(props)
    filesMatching("plugin.yml") {
        expand(props)
    }
}

// Every jar carries its license (GPL-3.0-or-later).
tasks.withType<Jar>().configureEach {
    from("LICENSE") {
        into("META-INF")
    }
}

tasks.register("printVersion") {
    group = "help"
    description = "Prints the project version (used by the release workflow's tag check)."
    val projectVersion = project.version.toString()
    doLast { println(projectVersion) }
}
