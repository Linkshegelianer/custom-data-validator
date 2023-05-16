# Data validator

This repository contains a custom library for data validation written in Java. This is an educational project aimed at the practice of working with Java Collections, Gradle, JUnit, Github Actions.


### Hexlet tests and linter status:
| Type | Status                                                                                                                                                                        |  
| ---- |-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|  
| Java CI | [![Java CI](https://github.com/Linkshegelianer/java-project-78/workflows/Java%20CI/badge.svg)](https://github.com/Linkshegelianer/java-project-78/actions/workflows/java-ci.yml) |  
| Actions Status | [![Actions Status](https://github.com/Linkshegelianer/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/Linkshegelianer/java-project-78/actions)   |  
| Maintainability | [![Maintainability](https://api.codeclimate.com/v1/badges/3148ea9865e7ac3d0cf4/maintainability)](https://codeclimate.com/github/Linkshegelianer/java-project-78/maintainability) |  
| Test Coverage | [![Test Coverage](https://api.codeclimate.com/v1/badges/3148ea9865e7ac3d0cf4/test_coverage)](https://codeclimate.com/github/Linkshegelianer/java-project-78/test_coverage) |  

## Usage

### Validate String data
```java  
Validator v = new Validator();  
StringSchema stringSchema = v.string();  
stringSchema.isValid(""); // true  
stringSchema.isValid(null); // true  
  
stringSchema.required(); // validate only non-null and not empty strings  
  
stringSchema.isValid(null); // false  
stringSchema.isValid(""); // false  
  
stringSchema.minLength(5); // set the minimum length for string 
  
stringSchema.isValid("12345"); // true  
stringSchema.isValid("1234"); // false  
  
stringSchema.contains("example"); // find provided substring
stringSchema.isValid("this example will be true"); // true  
stringSchema.isValid("this will be false"); // false  
```  

### Validate Integer data
```java  
Validator v = new Validator();  
NumberSchema numberSchema = v.numer();  
numberSchema.isValid(null); // true  
  
numberSchema.required(); // validate only non-null objects  
  
numberSchema.isValid(null); // false  
numberSchema.isValid(10); // true  
  
numberSchema.positive(); // validate only positive numbers  
  
numberSchema.isValid(0); // false  
numberSchema.isValid(-10); // false  
numberSchema.isValid(10); // true  
  
numberSchema.range(5, 10); // set lower and upper bound  
  
numberSchema.isValid(5); // true  
numberSchema.isValid(10); // true  
numberSchema.isValid(4); // false  
numberSchema.isValid(11); // false  
```  

### Validate data in Map
```java  
Validator v = new Validator();  
MapSchema mapSchema = v.map();  
mapSchema.isValid(null); // true  
  
mapSchema.required(); // validate only non-null objects  
  
mapSchema.isValid(null); // false  
mapSchema.isValid(new HashMap()); // true  
  
Map<String, String> data = new HashMap<>();  
data.put("key1", "value1");  
mapSchema.isValid(data); // true  
mapSchema.sizeof(2); // set fixed size of the Map  
mapSchema.isValid(data); // false  
data.put("key2", "value2");  
mapSchema.isValid(data); // true  

Map<String, BaseSchema> schemas = new HashMap<>(); 
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());
schema.shape(schemas); // validate data for Map values

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human4.put("name", "Valya");
human4.put("age", -5);
schema.isValid(human2); // false
```  

## Setup

```sh  
make build
```  

## Run
```sh  
make run
```  

## Run tests
```sh  
make test
```  

## Run checkstyle
```sh  
make lint
```