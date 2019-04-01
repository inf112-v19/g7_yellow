# YellowBots

## Status
[![Build Status](https://img.shields.io/jenkins/s/http/build.raknoel.no/job/RoboRally.svg?style=flat-square&logo=buffer)](http://build.raknoel.no/job/RoboRally/)
[![Build Health](https://img.shields.io/badge/dynamic/json.svg?label=Build%20Health&url=http%3A%2F%2Fbuild.raknoel.no%2Fjob%2FRoboRally%2Fapi%2Fjson&query=%24.healthReport%5B1%5D.score&colorB=blue&style=flat-square&logo=twoo&suffix=%)](http://build.raknoel.no/job/RoboRally/)
[![Tests](https://img.shields.io/jenkins/t/http/build.raknoel.no/job/RoboRally.svg?style=flat-square&logo=jekyll)](http://build.raknoel.no/job/RoboRally/lastCompletedBuild/testReport/)

[![Known Vulnerabilities](https://snyk.io/test/github/inf112-v19/YellowBots/badge.svg?style=flat-square&targetFile=pom.xml)](https://snyk.io/test/github/inf112-v19/YellowBots?targetFile=pom.xml)
[![Codacy Grade](https://api.codacy.com/project/badge/Grade/84a8bbe98cb344748204171a5b003e6d?style=flat-square)](https://www.codacy.com/app/YellowBots/YellowBots?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=inf112-v19/YellowBots&amp;utm_campaign=Badge_Grade)
[![Codacy Coverage](https://api.codacy.com/project/badge/Coverage/84a8bbe98cb344748204171a5b003e6d)](https://www.codacy.com/app/YellowBots/YellowBots?utm_source=github.com&utm_medium=referral&utm_content=inf112-v19/YellowBots&utm_campaign=Badge_Coverage)

![Github Repo size](https://img.shields.io/github/repo-size/inf112-v19/YellowBots.svg?style=flat-square&logo=GitHub)
[![Java Version](https://img.shields.io/badge/Java_Version-11-blue.svg?style=flat-square&logo=Java)](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

## How to build/compile
This project uses maven and can be built using that tool, and due to the ease of doing so, it is recommended to allways run all unit-tests at the same time. This can be done using a simple mvn install. We also recommend allways using the mvn clean before any build to ensure no old file are present at compile time.

```mvn clean install```


Unfortunately this will not produce an ease-of-use JAR and it is therefore recommended to use the following line to assure that all dependencies are also added to the JAR.

```mvn clean assembly:assembly```



Test coverage reports can be generated using the Jacoco maven plugin. We recommend ding so by using the following command.

```mvn clean jacoco:prepare-agent install jacoco:report```


We are currently working on implementing the usage of the SpotBugs plugin to the development, but is currently not in use. However the report may be produced by using the following maven command.

```mvn clean install spotbugs:spotbugs```


## Compatible OS 
Ths product should run perfectly fine with linux and windows, but we've had some issues on OSX. If you are running the project on a Mac 
and it's not working, you should try to run it from the editor. This should fix the problem. 
