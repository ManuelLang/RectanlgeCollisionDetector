# RectanlgeCollisionDetector

A sample application to detect overlapping area on layered rectangles

# Compile
## Using Maven
### Check maven version
```mvn -version``
### Customize .m2 repository folder
Edit file "pom.xml":
```<outputDirectory>${user.home}/.m2/repository/com/codingchallenge/core/rectangleanalyzer/${project.version}/```
### Build with command line
```mvn clean dependency:tree package```
### Run unit testing (TestNG)
```mvn test```

# Run
```
 java -jar <jar_file_path>/rectangleanalyzer-0.1-jar-with-dependencies.jar "<input_file_path>/input.json" "<output_file_path>/output_1.txt"
```