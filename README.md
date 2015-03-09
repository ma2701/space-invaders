space-invaders, fun with scala
==============================

<h3>Required tools</h3>

scala 2.10

sbt 0.13.2

<h3>To generate and run executable jar</h3>
```
sbt> assembly
```
and then:

```
java -jar target/scala-2.10/SI.jar
````

To run the game from within sbt:

```
sbt> run Driver
```