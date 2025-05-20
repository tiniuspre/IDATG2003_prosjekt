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

  public static boolean checkPlayerCount(
      final GameId gameId) {
    int playerCount = new CsvHandler("player/selected_players.csv")
        .readFromFile(SnLPlayer.class).stream().toList().size();
    if (gameId == null) {
      throw new IllegalArgumentException("Game ID cannot be null");
    }
    GameRules rules = GAME_RULES_MAP.get(gameId);
    return playerCount >= rules.minPlayers && playerCount <= rules.maxPlayers;
  }

  public static List<GridPlayer> getGridPlayers() {
    List<SnLPlayer> players = new CsvHandler("player/selected_players.csv")
        .readFromFile(SnLPlayer.class);
    if (players.size() != 2) {
      throw new IllegalArgumentException("Two players are required");
    }
    List<GridPlayer> gridPlayers = new ArrayList<>();
    gridPlayers.add(new GridPlayer(players.getFirst().getName(), Marker.PLAYER_ONE));
    gridPlayers.add(new GridPlayer(players.getLast().getName(), Marker.PLAYER_TWO));
    return gridPlayers;
  }

  private static class GameRules {
    int minPlayers;
    int maxPlayers;

    GameRules(final int min, final int max) {
      if (min < 0 || max < 0) {
        throw new IllegalArgumentException("Player count cannot be negative");
      }
      this.minPlayers = min;
      this.maxPlayers = max;
    }
  }
}

