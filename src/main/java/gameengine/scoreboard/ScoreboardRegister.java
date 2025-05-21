package gameengine.scoreboard;

import filehandler.csvhandling.CsvHandler;
import gameengine.player.Player;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardRegister {
  /**
   * The CSV handler for managing scoreboard data.
   */
  private CsvHandler csvHandler;

  /**
   * Constructor for the ScoreboardRegister class.
   * Initializes the CSV handler with a default file name.
   */
  public ScoreboardRegister() {
    setCsvHandler(new CsvHandler("player/scoreboard.csv"));
  }

  private void setCsvHandler(final CsvHandler csvHandlerInstance) {
    this.csvHandler = csvHandlerInstance;
  }

  private CsvHandler getCsvHandler() {
    return this.csvHandler;
  }

  /**
   * Adds a player to the scoreboard.
   *
   * @param player the player instance
   * @param game the name of the game
   * @param score the score of the player
   */
  public void addPlayerToScoreboard(
      final Player player,
      final String game,
      final int score
  ) {
    ArrayList<String> playerData = new ArrayList<>();
    playerData.add(player.getName());
    playerData.add(game);
    playerData.add(String.valueOf(score));
    playerData.add(java.time.LocalDateTime.now().toString());
    getCsvHandler().addStringToFile(playerData);
  }
  /**
   * Retrieves the scoreboard data.
   *
   * @return a list of player data
   */
  public List<String> getScoreboardData() {
    return getCsvHandler().readFromFile(String.class);
  }
}
