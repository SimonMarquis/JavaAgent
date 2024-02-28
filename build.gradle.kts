import org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
import org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED
import org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED
import org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED


plugins {
    alias(libs.plugins.jvm)
}

kotlin {
    jvmToolchain(8)
}

tasks.jar {
    manifest {
        attributes("Premain-Class" to "Agent")
    }
    isPreserveFileTimestamps = false
    isReproducibleFileOrder = true
}

tasks.test {
    setupJavaAgent()
    useJUnitPlatform()
    testLogging {
        events = setOf(SKIPPED, PASSED, FAILED)
        showExceptions = true
        showStackTraces = true
        exceptionFormat = FULL
    }
}

fun Test.setupJavaAgent() {
    providers.gradleProperty("java_agent").orNull ?: return
    jvmArgs("-javaagent:${tasks.jar.get().archiveFile.get().asFile.absolutePath}")
    dependsOn(tasks.jar)
}

repositories {
    mavenCentral()
}

dependencies {
    testRuntimeOnly(libs.junit.runtime)
    testImplementation(libs.junit.api)
    testImplementation(libs.kotlin.test)
    testImplementation(libs.rxjava2)
}
