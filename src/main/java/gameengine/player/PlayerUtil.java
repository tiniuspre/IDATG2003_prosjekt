package gameengine.player;

import filehandler.csvhandling.CsvHandler;
import gameengine.grid.GridPlayer;
import gameengine.grid.Marker;
import snakesandladders.engine.SnLPlayer;
import ui.GameId;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class PlayerUtil {
  /**
   * Map containing the game rules for each game.
   */
  private static final Map<GameId, GameRules> GAME_RULES_MAP =
      Map.of(
          GameId.SNAKES_AND_LADDERS, new GameRules(2, 5),
          GameId.TIC_TAC_TOE, new GameRules(2, 2),
          GameId.CONNECT_FOUR, new GameRules(2, 2)
      );

  /**
   * Private constructor to prevent instantiation.
   */
  private PlayerUtil() {
    // Prevent instantiation
  }

  /**
   * Checks if the number of players is within the
   * allowed range for the given game.
   *
   * @param gameId the ID of the game.
   * @return true if the player count is valid, false otherwise.
   */
  public static boolean checkPlayerCount(
      final GameId gameId) {
    int playerCount = new CsvHandler("player/selected_players.csv")
        .readFromFile(SnLPlayer.class).stream().toList().size();
    if (gameId == null) {
      throw new IllegalArgumentException("Game ID cannot be null");
    }
    GameRules rules = GAME_RULES_MAP.get(gameId);
    return playerCount >= rules.getMinPlayers()
        && playerCount <= rules.getMaxPlayers();
  }

  /**
   * Converts the selected players from the CSV
   * file into a list of GridPlayer objects.
   *
   * @return a list of GridPlayer objects.
   */
  public static List<GridPlayer> getGridPlayers() {
    List<SnLPlayer> players = new CsvHandler("player/selected_players.csv")
        .readFromFile(SnLPlayer.class);
    if (players.size() != 2) {
      throw new IllegalArgumentException("Two players are required");
    }
    List<GridPlayer> gridPlayers = new ArrayList<>();
    gridPlayers.add(new GridPlayer(players.getFirst()
        .getName(), Marker.PLAYER_ONE));
    gridPlayers.add(new GridPlayer(players.getLast()
        .getName(), Marker.PLAYER_TWO));
    return gridPlayers;
  }

  /**
   * Class representing the game rules for each game.
   * It contains the minimum and maximum number of players allowed.
   *
   * @author jonastomren
   * @version 20.05.2025
   * @since 20.05.2025
   */
  private static class GameRules {
    /**
     * The minimum number of players allowed.
     */
    private final int minPlayers;
    /**
     * The maximum number of players allowed.
     */
    private final int maxPlayers;

    /**
     * Constructor for GameRules.
     *
     * @param min the minimum number of players.
     * @param max the maximum number of players.
     */
    GameRules(final int min, final int max) {
      if (min < 0 || max < 0) {
        throw new IllegalArgumentException("Player count cannot be negative");
      }
      this.minPlayers = min;
      this.maxPlayers = max;
    }

    /**
     * Returns the minimum number of players allowed.
     *
     * @return the minimum number of players.
     */
    public int getMinPlayers() {
      return minPlayers;
    }

    /**
     * Returns the maximum number of players allowed.
     *
     * @return the maximum number of players.
     */
    public int getMaxPlayers() {
      return maxPlayers;
    }
  }
}

