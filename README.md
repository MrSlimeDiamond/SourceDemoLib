# SourceDemoLib
Java library for parsing Source Engine demos

Largely a clone of [sdp-java](https://github.com/WalkerKnapp/sdp-java)

## Usage
### Gradle (Groovy)
```groovy
repositories {
    maven {
        url 'https://repo.zenoc.net/repository'
    }
}

dependencies {
    implementation 'net.slimediamond:sourcedemo:1.0-SNAPSHOT'
}
```

### Gradle (Kotlin)
```kotlin
repositories {
    maven("https://repo.zenoc.net/repository")
}

dependencies {
    implementation("net.slimediamond:sourcedemo:1.0-SNAPSHOT")
}
```

### Parsing a demo
```java
SourceDemo demo = SourceDemo.parse(new File("/home/findlayr/demo.dem").toPath());
System.out.println(demo.getGameDirectory());
```