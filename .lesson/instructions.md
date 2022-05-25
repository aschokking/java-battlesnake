# Instructions  


## Setting up your battlesnake account

* Vist https://play.battlesnake.com/register/ to create a new account (if you already have a github.com account you can use that, otherwise just create a new username/password account)
* Run your code in replit here to start the your webserver (big green button on top of the screen)
  * If it started successfully you should see a browser window on the right side of your screen. The URL of this mini window at the top of the page is what you'll need below when registering your snake. This can take a few minutes the first time you run your snake server in a session.
  * The url you want should look something like https://{challenge name}-{your username}.easton-teals-ap-cs-2021-2022.repl.co
* Register a new battlensnake by visiting https://play.battlesnake.com/account/snakes/create/
  * Give your battlesnake a name, this is what will be shown to other players in the game
  * For the URL, copy in the value from replit from a few steps ago (the one that ended in `.easton-teals-ap-cs-2021-2022.repl.co`)
  * The other fields you can leave alone, just click Save

## Episode 1: Avoid walls

* Visit https://play.battlesnake.com/challenges/ and click "Attempt" on the first Avoid Walls challenge.
* This will pop up a dialog with a dropdown of your battlesnake(s), pick the snake you created and select "Start challenge game"
* Your snake will try and fail the challenge of surviving for 100 turns.
  * If your snake hits timeout errors, it's probably because the replit takes ~10s to warm up, just keep hitting "retry challenge" a few times

Our out of the box snake here is very dumb and will mindlessly slam into walls (or itself), instantly dieing. You're going to help give it smarts to avoid such a fate!

* Here in replit, open the file src/main/java/battlesnake/BattleSnake.java . This is where your snakes logic lives.
* Start by customizing the first 4 methods which contain identifying information for your snake in the game (author, color, head and tail). You can find a list of head/tail values here: https://play.battlesnake.com/references/customizations/
* Verify your customizations worked by:
  * stopping + starting your snake server here in replit (big button at the top of the screen)
  * retry the avoid walls challenge on battlesnakes.com and you should see your customizations reflected in your snake
* Now it's time to actually start avoiding walls! Back in src/main/java/battlesnake/BattleSnake.java `computeMove()` is the primary method that determines what your snake does every round of the game. It's given the state of the world and asked to return what direction your snake should move in `"up", "down", "left", "right"`
* We've given you some starter code to help get you going with avoiding walls. Implement the `avoidWalls()` and `avoidNeck()` methods. When those are working your snake should pass the avoid walls challenge.

## Submitting

* When you're done, push the 'submit' button here in replit in the upper-right corner.
  * Then in Schoology, submit a gif showing your snake passing the challenge! There's a `view gif` link on the battlensnake avoid walls challenge page you can use to get a gif of your snake like this: https://exporter.battlesnake.com/games/cfba9b38-3cc2-401b-b607-aa65693d2796/gif