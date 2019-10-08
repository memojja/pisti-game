##a.Installation

```
1 - mvn install
java -jar target/service-1.0-SNAPSHOT.jar N

N is user count that have to be bigger than 3
```

####a1.Input
```
mvn install
java -jar target/service-1.0-SNAPSHOT.jar 1
````
####a2.output
````
Game Id : bb997c3c-82a0-4178-9510-0bb635f47810
Player 0 11
Player 1 3
Player 2 0
Player 3 2
````

if you want see the output of each turn, like which user scored or which card has been played) you should set `log4j.rootLoggerparameter` to `debug`


##b.Design decision
**Factory Pattern :**   I used factory pattern to create bots.

**Singleton & Iterator Pattern :**   All games have same cards object. So, it doesn't have to create 52 card objects continously I've created a singleton deck then cards reference is being used inside singleton deck. Then I've created a new list and added that references and shuffled deck.

**Chain of Responsibility Pattern :**     I used that pattern to calculate score of card.

**Template Pattern :**  Bots( Smart / Dummy) have same action. Only difference is logic.

