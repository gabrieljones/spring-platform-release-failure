# Spring Dependency Management Gradle Plugin Fails on Transitive Platform latest.release

Affected Version 1.1.4

https://docs.spring.io/dependency-management-plugin/docs/current/reference/html/

## Run
```shell
./gradlew publishToMavenLocal; ./gradlew test
```

## Detail

```kts
// ./transitive-platform-latest-release/build.gradle.kts
// ...
val jacksonBomVersion = "latest.release" // breaks
//val jacksonBomVersion = "[2,3[" // works

dependencies {
  implementation(platform("com.fasterxml.jackson:jackson-bom:$jacksonBomVersion"))
}
// ...
```

with `latest.release` the build fails with:

```log
> Could not resolve all artifacts for configuration ':app:detachedConfiguration8'.
   > Could not find com.fasterxml.jackson:jackson-bom:RELEASE.
     Searched in the following locations:
       - file:/Users/xxxx/.m2/repository/com/fasterxml/jackson/jackson-bom/RELEASE/jackson-bom-RELEASE.pom
       - https://repo.maven.apache.org/maven2/com/fasterxml/jackson/jackson-bom/RELEASE/jackson-bom-RELEASE.pom
     Required by:
         project :app
```

with `[2,3[` the build succeeds
