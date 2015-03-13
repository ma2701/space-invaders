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

TODO:

1) move invader army lower so that it gets very close to the barricades -- DONE

2) fix the player game element to look more like the original game      -- DONE

2.1) reset all game elements when the whole game is reset

3) implement different invader types with different points   -- ALMOST DONE

4) display "game over" when game is over

5) implement mystery invader in red with surprise point assigned to it.

6) implement game pausing

7) implement exploded player - display it before resetting the game for another round

8) implement variable velocity for invader army

