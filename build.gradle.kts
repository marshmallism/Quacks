plugins {
    id("java")
    id("application")
}

group = "java"
version = "1.1-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("front.QuacksRunner")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "front.QuacksRunner"
    }
}
dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}
