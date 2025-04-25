package gameengine.player;

import java.util.List;
import snakesandladders.engine.SnLPlayer;

/**
 * The {@code PlayerSelector} class is responsible for
 * selecting players in the game.
 * It provides functionality to select a random player
 * from a list of players, excluding the current player.
 *
 * @author jonastomren
 * @version 14.04.2025
 * @since 14.04.2025
 * @see SnLPlayer
 */
public class PlayerSelector {
  /**
   * The list of all players in the game.
   */
  private final List<SnLPlayer> allPlayers;
  /**
   * The current player in the game.
   */
  private final Player current;

  /**
   * Constructs a {@code PlayerSelector} with the specified list
   * of players and the current player.
   *
   * @param players The list of all players in the game.
   * @param currentPlayer The current player in the game.
   */
  public PlayerSelector(final List<SnLPlayer> players,
                        final Player currentPlayer) {
    this.allPlayers = players;
    this.current = currentPlayer;
  }

  /**
   * Selects a random player from the list of players,
   * excluding the current player.
   *
   * @return A randomly selected {@code Player}
   *        from the list of available players.
   * @throws IllegalArgumentException If no players are
   *        available to select from.
   */
  public Player selectRandomPlayer() {
    // Filter out the current player from the list
    List<SnLPlayer> availablePlayers = allPlayers.stream()
        .filter(player -> !player.equals(current))
        .toList();
    // If no players are available, throw an exception
    if (availablePlayers.isEmpty()) {
      throw new IllegalArgumentException(
          "No available players to select from.");
    }
    // Select a random player from the available players
    return availablePlayers.get((int)
        (Math.random() * availablePlayers.size()));
  }
}
