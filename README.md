space-invaders
==========
# fun with scala

Required tools
==========
scala 2.10
sbt 0.13.2

To generate and run executable jar
=======================
sbt> assembly

java -jar target/scala-2.10/SI.jar

to run the game from within sbt
sbt> run Driver
