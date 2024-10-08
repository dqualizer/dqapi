# dqApi

The dqApi is a REST API, which is responsible to execute CRUD Operations on different dqualizer components. It is used
to manage Runtime Quality Analysis (RQAs) and Domain Architecture Mappings (DAMs) in the mongoDB..

## Usage

### Docker

* This package is published via a GitHub Workflow to [ghcr.io](https://github.com/dqualizer/dqapi/pkgs/container/dqapi)
* `docker pull ghcr.io/dqualizer/dqapi`

### Maven

To setup your maven for using this package, have a look the
"[Authenticating to GitHub Packages](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry)"
guide.

In short:

1. Copy the template from the guide to your `~/.m2/settings.xml` or `%userprofile%\.m2\settings.xml`.
1. Replace the repository url with `https://maven.pkg.github.com/dqualizer/dqlang`. **Do not use uppercase letters here!
   **
1. Create a [(classic) personal access token (PAT) ](https://github.com/settings/tokens) with `read:packages`
   permissions.
1. Enter your GitHub user name and PAT (as password) for the 'github' server.

Then you can use:

```
<dependency>
    <groupId>dqualizer</groupId>
    <artifactId>dqlang</artifactId>
    <version>${dqlang.version}</version>
</dependency>
```

### Gradle

The gradle setup is very similar to the maven setup:

1. Create a `gradle.properties` file in `%userprofile%\.gradle\`.
2. Create a [(classic) personal access token (PAT) ](https://github.com/settings/tokens) with `read:packages`
   permissions.
3. Paste the following content into your gradle.properties:
   ```
   gprUsername=YOUR_GITHUB_USERNAME
   gprPassword=YOUR_GITHUB_ACCESS_TOKEN
   ```
5. Paste the following code into your projects build.gradle or build.gradle.kts file:

Groovy:

    ```
    repositories {
     maven {
        name = 'gpr'
        url = uri("https://maven.pkg.github.com/dqualizer/dqlang")
        credentials(PasswordCredentials)
      }
    }

    ```

Kotlin:

 ```
repositories {
    maven {
       name="gpr"
       url = uri("https://maven.pkg.github.com/dqualizer/dqlang")
       credentials(PasswordCredentials::class)
    }
}
```

Then you can use dqlang in your gradle dependency declaration:

Groovy:

```groovy
dependencies {
    implementation("io.github.dqualizer:dqlang:{version}")
}
```

Kotlin:

```kotlin
dependencies {
    implementation("io.github.dqualizer:dqlang:{version}")
}
```

## How to build

### Locally

* Set your credentials `gprUsername=YOUR_GITHUB_USERNAME` and `gprPassword=YOUR_GITHUB_ACCESS_TOKEN` in
  either `$GRADLE_USER_HOME/gradle.properties` or `gradle.properties` (be careful not to publish your GitHub Token to
  Git)
* If you set the credentials build with `./gradlew build -x test`
* If you didn't set your credentials build
  with `./gradlew build -x test -PgprUsername=YOUR_GITHUB_USERNAME -PgprPassword=YOUR_GITHUB_ACCESS_TOKEN`

### Docker

* `docker buildx build -f deployment/docker/ubuntu/Dockerfile --tag ghcr.io/dqualizer/dqapi:latest --build-arg="GITHUB_USER=someUser" --build-arg="GITHUB_TOKEN=someToken" .`

### Deploy to Packages

* There is a GitHub action set up, that automatically pushes the dqapi
  to [Github Container Registry](https://github.com/dqualizer/dqapi/pkgs/container/dqapi)

