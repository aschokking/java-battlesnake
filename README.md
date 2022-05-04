This is a fork of https://github.com/BattlesnakeOfficial/starter-snake-java that has been modified so that students can write their code knowing only AP CS concepts (ie, no Map or JSON).

## Setting up your battlesnake account

* Vist https://play.battlesnake.com/register/ to create a new account (if you already have a github.com account you can use that, otherwise just create a new username/password account)
* Run your code in replit here to start the your webserver. If it started successfully you should see a browser window on the right side of your screen. The URL of this mini window at the top of the page is what you'll need below when registering your snake. It should look something like https://{challenge name}-{your username}.easton-teals-ap-cs-2021-2022.repl.co
* Register a new battlensnake by visiting https://play.battlesnake.com/account/snakes/create/
  * Give your battlesnake a name, this is what will be shown to other players in the game
  * For the URL, copy in the value from before. It should be something like 
  * The other fields you can leave blank, just click Save

## Where to implement your battlesnake logic

src/main/java/battlesnake/BattleSnake.java

## How to run locally

In case you need to run this code locally for some reason, you can do so with Maven:

To run locally, you can use the following command:

```
mvm compile exec:exec
```

