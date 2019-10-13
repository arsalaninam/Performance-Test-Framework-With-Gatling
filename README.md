# Performance Test Framework with Gatling using Gradle

This Framework is designed for Performance Testing of Webservices. It consists of Gatling using Gradle as dependency management tool.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

* [Java 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java Dev Kit
* [Gradle](https://gradle.org/install/) - Dependency Manager

### Installation

Run the following command in Terminal and build the project. It will automatically download all the required dependencies.
```sh
$ gradle build
```

If the build is successful. All the required dependencies are installed successfully.
### Running the tests

Add Simulation class path in build.gradle file in order to run the Simulation.
```sh
$ '--simulation', 'simulation.CreateUserSimulation'
```

Run the following command in Terminal to clean the build directory. To avoid conflicts, make sure to execute this command everytime before you run 'gradlew testLoad' command.
```sh
$ gradle clean build
```

Run the following command in Terminal to execute a Java Task.
```sh
$ gradlew testLoad
```

### View Response JSON files

You can find the created response JSON files in the following directory of the Project.
```sh
\build\reports\resource
```
These files are generated at runtime. The data in these files can be used as inputs for other APIs.

### Validating Gatling Reports

You can find the HTML reports of the executed simulations in the following directory of the Project.
```sh
\build\gatling-results
```
Under the gatling-results directory, go to simulation folder and open ‘index.html’ file.
