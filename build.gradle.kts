import org.jetbrains.kotlin.config.AnalysisFlag.Flags.experimental
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion: String = "1.2.51"

plugins {
  java
  kotlin("jvm") version "1.2.51"
}

group = "io.github.pouyaesm"
version = "1.0-SNAPSHOT"

apply {
  plugin("kotlin")
}



repositories {
  mavenCentral()
}

dependencies {
  compile(kotlin("stdlib-jdk8"))
  testCompile("junit", "junit", "4.12")

  // kotlin-reflect is used for reflection related codes like class.simpleName
  compile("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")

  compile("org.jetbrains.kotlinx:kotlinx-coroutines-core:0.23.4")
}

configure<JavaPluginConvention> {
  sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}

