# Simple Meeting

This is an example used
in a lecture for the Hogeschool
Utrecht regarding basic automated testing.

Students are invited to take a look at:

* the [pom.xml](pom.xml)
  for Maven plug-ins, dependencies and goals
* the [maven.yml](.github/workflows/maven.yml)
  for configuration of the steps in the GitHub Actions build pipeline
* the [test directory](src/test)
  for examples of automated testing
* the [Postman collection](Simple%20Meeting.postman_collection.json)
  for empowering local development (import/export through the Postman GUI)

## Badges

![Java CI with Maven](https://github.com/arothuis-hu/simple-meeting-example/workflows/Java%20CI%20with%20Maven/badge.svg)
[![codecov](https://codecov.io/gh/arothuis-hu/simple-meeting-example/branch/master/graph/badge.svg)](https://codecov.io/gh/arothuis-hu/simple-meeting-example)

Badges can display the status and the metrics for your
projects.

In this example,
GitHub Actions is used as a build pipeline. The badge
shows whether the recent build was successful.
Coverage is generated via JaCoCo and Maven (see `pom.xml`).
Afterwards, the coverage is published to [codecov](https://codecov.io/#features).
Codecov gives online insight in the coverage of the project
over time.

Right now, coverage could be better!

## To do

This example project, although useful, is incomplete.

* Allow more detailed coverage reports in codecov
* Improve overall coverage
* Add tests for controllers
* Show more examples of test doubles using Mockito
* Add test to demonstrate difference assertSame and assertEquals
* Add Spring system tests
* Add more internal integration tests
* Add end-to-end tests using cucumber and Selenium
    * Requires a live application
* Add complexity analysis tools and badges like SonarCloud

## Demo implementation code answers

### TimeSlot constructor

``java
if (end.isBefore(start)) {
          throw InvalidTimeSlot.wrongSequence(start, end);
      }``

### TimeSlot.isWithin

``java
return this.start.isAfter(other.start) || this.start.equals(other.start)
                && this.end.isBefore(other.end) || this.end.equals(other.end);
``
