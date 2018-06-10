### will it rain?

This small Java program is build for a job interview at CTK.

### What is the program doing
It will check if there is going to be rain in the next 24 hours on a given location. 

### How to run
To run the program maven is needed. 
[Install instructions here](https://maven.apache.org/install.html) <br>
why maven? to easier access the org.json library

##### run from terminal
``` 
git clone https://github.com/mattssonj/will-it-rain.git
```

```
cd will-it-rain
```
```
mvn package
```
```
java -jar target/rain-app-1.0-SNAPSHOT.jar <together with your flag and position>
```

Eg.
```
java -jar target/rain-app-1.0-SNAPSHOT.jar l gothenburg
```
