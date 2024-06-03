val dqlangVersion = "3.1.7-SNAPSHOT"

plugins {
	id("java")
	id("org.springframework.boot") version "3.2.5"
	id("io.spring.dependency-management") version "1.1.5"
}

group = "dqualizer.research"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_21
java.targetCompatibility = JavaVersion.VERSION_21

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	maven {
		name="gpr"
		url = uri("https://maven.pkg.github.com/dqualizer/dqlang")
		credentials(PasswordCredentials::class)
	}
	mavenLocal()
}


sourceSets {
	main {
		resources {
			exclude("main/java/io/github/dqualizer/dqapi/controllers/old")
			exclude("main/java/io/github/dqualizer/dqapi/repositories/old")
			exclude("main/java/io/github/dqualizer/dqapi/services/old")
			exclude("main/java/io/github/dqualizer/dqapi/models")
			exclude("main/java/io/github/dqualizer/dqapi/dtos/old")
		}
	}
}


dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")
	implementation("org.springframework.boot:spring-boot-starter-actuator:3.2.5")
	implementation("io.github.dqualizer:dqlang:${dqlangVersion}")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
