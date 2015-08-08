space-invaders, fun with scala
==============================

<h3>Required tools</h3>

scala 2.10

sbt 0.13.2

<h3>To create .jar and run the game</h3>

```
sbt assembly && java -jar target/scala-2.10/SI.jar
````

To run the game from within sbt:

```
sbt> run Driver
```

This is my version of the Space invader game. It was done as a fun project using Scala.

The main challenge was to minimize mutability. As this is a game, it has to maintain state

from one frame to the next so having mutable state is a must, the trick was to keep it minimal.


<h3>Game logic</h3>

Every 10K points the player is rewarded with an extra life.

As the player shoots invaders and gets points the game becomes more and more difficult as in

invaders move around faster and the bombs they drop also drop at a faster rate.

