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

- Add Log4J
```agsl
<dependency>
     <groupId>org.slf4j</groupId>
     <artifactId>slf4j-api</artifactId>
     <version>${slf4j.version}</version>
</dependency>
<dependency>
     <groupId>org.slf4j</groupId>
     <artifactId>slf4j-simple</artifactId>
     <version>${slf4j.version}</version>
</dependency>
```

## Write the example test cases in Gherkin language
- As file: `TestCaseExampleLogin.feature`
## Define the steps definitions for each steps in each scenario of feature file.
- In the class: `LoginSteps.java`

## Advanced and Bonus
Setup and run TestNG Cucumber test push report to Elastic and Visual on Kibana

- Setup an Elastic and Kibana local
- Following this file: `docker-compose.yml`
### Setup ElasticSearch from kibana
- Access to http://localhost:5601/app/management/data/index_management/indices
- Create a template: Name: `automation-cucumber-test`, Index patterns `result`
- 

# References:
- Cucumber Java in 10 minutes: https://cucumber.io/docs/guides/10-minute-tutorial/?lang=java
- Push Cucumber into elasticsearch:
+ https://github.com/AshisRaj/cucelastic-maven-plugin
+ https://github.com/AshisRaj/cucelastic-maven-plugin/blob/master/USAGE.md?plain=1