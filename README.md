# Performance Test Framework with Gatling using Gradle

This Framework is designed for Performance Testing of Webservices. It consists of Gatling using Gradle as dependency management tool.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

* [Java 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java Dev Kit
* [Gradle](https://gradle.org/install/) - Dependency Management

### Installation

Run the following command in Terminal and build the project. It will automatically download all the required dependencies.

```sh
$ gradle build
```

If the build is successful. All the required dependencies are installed successfully.
### Running the tests

Run the following command in Terminal to execute a Java Task. An example of Gatling testLoad task in Gradle is given below.

```sh
$ gradlew testLoad
```

### Validating Reports

You can find the HTML reports of the executed simulations in the following directory of the Project.

```sh
\build\gatling-results
```

Under the gatling-results directory, there will be multiple test simulation folders. Open the related simulation folder and open 'index.html' file.