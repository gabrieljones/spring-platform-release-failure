plugins {
  `java-library`
  `maven-publish`
}

group = "org.example"

//val jacksonBomVersion = "latest.release" // breaks
val jacksonBomVersion = "[2,3[" // works

dependencies {
  implementation(platform("com.fasterxml.jackson:jackson-bom:$jacksonBomVersion"))
}

publishing {
  publications {
    register<MavenPublication>("maven") {
      from(components["java"])
    }
  }
}
