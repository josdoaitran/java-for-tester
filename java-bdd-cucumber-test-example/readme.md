# Overview
This example project is show to how we can apply Java, TestNG, Cucumber to build a test framework

# Steps to build a test framework
- Create a Java 11 - Maven projects.
```agsl
<properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
 </properties>
```
- Add the essential dependencies from https://mvnrepository.com/ for a Java project.
## List of Dependencies
- Cucumber
```angular2html
<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>7.16.1</version>
</dependency>
```
- Cucumber and TestNG
```angular2html
<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-testng -->
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-testng</artifactId>
    <version>7.16.1</version>
</dependency>

```
- TestNG
```angular2html
<!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.9.0</version>
    <scope>test</scope>
</dependency>
```
## Write the example test cases in Gherkin language
- As file: `TestCaseExampleLogin.feature`
## Define the steps definitions for each steps in each scenario of feature file.

