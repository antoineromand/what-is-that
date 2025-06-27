plugins {
	java
	id("org.springframework.boot") version "3.5.3"
	id("io.spring.dependency-management") version "1.1.7"
	jacoco
	id("com.diffplug.spotless") version "7.0.4"
}

group = "com.ci-cd-example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(24)
	}
}

repositories {
	mavenCentral()
	gradlePluginPortal()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

spotless {
	java {
		googleJavaFormat("1.17.0")
		target("src/**/*.java")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
	finalizedBy(tasks.jacocoTestReport)
	finalizedBy(tasks.jacocoTestCoverageVerification)
}

tasks.jacocoTestReport {
	dependsOn(tasks.test)
}

tasks.check {
	dependsOn(tasks.jacocoTestCoverageVerification)
}

val coverageLimit: BigDecimal = (project.findProperty("limit") as String?)?.toBigDecimalOrNull() ?: BigDecimal("0.8")

tasks.jacocoTestCoverageVerification {
	violationRules {
		rule {
			limit {
				minimum = coverageLimit
			}
		}
	}
}
