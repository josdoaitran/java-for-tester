# Steps:
- Create a maven project - Java
```
mvn archetype:generate                      \
   "-DarchetypeGroupId=io.cucumber"           \
   "-DarchetypeArtifactId=cucumber-archetype" \
   "-DarchetypeVersion=7.16.1"               \
   "-DgroupId=example.cucumber"                  \
   "-DartifactId=example.cucumber"               \
   "-Dpackage=example.cumber"                  \
   "-Dversion=1.0.0-SNAPSHOT"                 \
   "-DinteractiveMode=false"
```


- Cucumber Java in 10 minutes: https://cucumber.io/docs/guides/10-minute-tutorial/?lang=java