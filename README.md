<h1 align="center"> BBCRON Core</h1> <br>

![last build](https://github.com/3nauk/bbcron-core/actions/workflows/maven.yml/badge.svg)
![example branch parameter](https://github.com/github/docs/actions/workflows/main.yml/badge.svg?branch=main)

<p align="center">
  Library Core that help us with the common definition for all bbcron-services.
</p>


## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Requirements](#requirements)
- [Testing](#testing)
- [API](#requirements)




## Introduction

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
![last build](https://github.com/3nauk/bbcron-spring-template/actions/workflows/maven.yml/badge.svg)
![example branch parameter](https://github.com/github/docs/actions/workflows/main.yml/badge.svg?branch=main)

To Create a library as springboot project remember 

[Spring Lemon](https://github.com/naturalprogrammer/spring-lemon) would be a good example for this. 
It uses Spring Boot, and is meant to be included in other Spring Boot applications. This is what we did to create it:

- Created a Spring Boot application, using the Spring Boot Starter Wizard of STS.
- Removed the generated application and test class.
- Removed spring-boot-maven-plugin, i.e. the build and the pluginRepositories sections in pom.xml. (See how a pom.xml would look without these sections).


## Features

- Handle Page Response DTO that it´ll be consumed for the controller to get the Info.
- Unified Queries and filter conditions and operations between all services
- CoreExceptions centralized
- Service for Filtering Page. Extract any filters requested by the client.
- BBCronResourceRepository to extends the MongoRepository implementation  to get the findAll 

```
  /**
   * Find All items paginated
   *
   * @param query    as {@link Query}
   * @param pageable as {@link Pageable}
   * @return result as {@link Page}
   */
  Page<T> findAll(Query query, Pageable pageable);

  /**
   * Find All items
   *
   * @param query as {@link Query}
   * @return result as {@link List<T>}
   */
  List<T> findAll(Query query);
```


## Requirements

The library can be consumed by bbcron-service

ShouldBe include two filters:
- filtersAnd
- filtersOr
Example Use:
filtersOr = namespace|like|01&namespace|like|03

### Local
* [Java 11 SDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
* [Maven](https://maven.apache.org/download.cgi)

### Build Local
```bash
$ mvn clean verify
```

## Testing
```bash
$ mvn clean verify
```