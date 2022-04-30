package battlesnake.webserver;

public class TestWebserver {
    public static void main(String[] args){
        String moveRequest = """
            {
                "game" : {
                  "id" : "501dbf77-ce1b-45d7-8bab-8e618cded3c5",
                  "ruleset" : {
                    "name" : "solo",
                    "version" : "v1.0.33",
                    "settings" : {
                      "foodSpawnChance" : 0,
                      "minimumFood" : 0,
                      "hazardDamagePerTurn" : 0,
                      "hazardMap" : "",
                      "hazardMapAuthor" : "",
                      "royale" : {
                        "shrinkEveryNTurns" : 0
                      },
                      "squad" : {
                        "allowBodyCollisions" : false,
                        "sharedElimination" : false,
                        "sharedHealth" : false,
                        "sharedLength" : false
                      }
                    }
                  },
                  "timeout" : 500,
                  "source" : "challenge"
                },
                "turn" : 2,
                "board" : {
                  "height" : 5,
                  "width" : 5,
                  "snakes" : [ {
                    "id" : "gs_d8qBmmTrTRbqKwcBv4KMPQC6",
                    "name" : "Java Snake (local)",
                    "latency" : "141",
                    "health" : 98,
                    "body" : [ {
                      "x" : 2,
                      "y" : 4
                    }, {
                      "x" : 2,
                      "y" : 3
                    }, {
                      "x" : 2,
                      "y" : 2
                    } ],
                    "head" : {
                      "x" : 2,
                      "y" : 4
                    },
                    "length" : 3,
                    "shout" : "",
                    "squad" : "",
                    "customizations" : {
                      "color" : "#888888",
                      "head" : "default",
                      "tail" : "default"
                    }
                  } ],
                  "food" : [ ],
                  "hazards" : [ ]
                },
                "you" : {
                  "id" : "gs_d8qBmmTrTRbqKwcBv4KMPQC6",
                  "name" : "Java Snake (local)",
                  "latency" : "141",
                  "health" : 98,
                  "body" : [ {
                    "x" : 2,
                    "y" : 4
                  }, {
                    "x" : 2,
                    "y" : 3
                  }, {
                    "x" : 2,
                    "y" : 2
                  } ],
                  "head" : {
                    "x" : 2,
                    "y" : 4
                  },
                  "length" : 3,
                  "shout" : "",
                  "squad" : "",
                  "customizations" : {
                    "color" : "#888888",
                    "head" : "default",
                    "tail" : "default"
                  }
                }
              }
                """;
    }
}
