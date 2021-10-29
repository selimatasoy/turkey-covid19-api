import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	war
	kotlin("jvm") version "1.5.21"
	kotlin("plugin.spring") version "1.5.21"
}

group = "com.selimatasoy"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.5.2")

	implementation("org.springframework.boot:spring-boot-starter-security")
	testImplementation("org.springframework.security:spring-security-test")

	implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.3.1")

	implementation("io.ktor:ktor-client-okhttp:1.6.2")
	implementation("io.ktor:ktor-client-gson:1.6.2")
	implementation("io.ktor:ktor-client-logging-jvm:1.6.2")
	implementation("ch.qos.logback:logback-classic:1.2.5")

	implementation( "org.jsoup:jsoup:1.14.3")


	implementation("io.springfox:springfox-boot-starter:3.0.0")
	compileOnly("io.springfox:springfox-swagger-ui:3.0.0")

	developmentOnly("org.springframework.boot:spring-boot-devtools")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
