package gameengine.player;

import java.util.List;

import gameengine.BaseIllegalArgumentException;
import snakesandladders.engine.SnLPlayer;

/**
 * The {@code PlayerSelector} class is responsible for
 * selecting players in the game.
 * It provides functionality to select a random player
 * from a list of players, excluding the current player.
 *
 * @author jonastomren
 * @version 25.04.2025
 * @since 14.04.2025
 * @see SnLPlayer
 */
public class PlayerSelector {
  /**
   * The list of all players in the game.
   */
  private List<SnLPlayer> allPlayers;
  /**
   * The current player in the game.
   */
  private Player current;

  /**
   * Constructs a {@code PlayerSelector} with the specified list
   * of players and the current player.
   *
   * @param players The list of all players in the game.
   * @param currentPlayer The current player in the game.
   */
  public PlayerSelector(final List<SnLPlayer> players,
                        final Player currentPlayer) {
    setAllPlayers(players);
    setCurrentPlayer(currentPlayer);
  }

  /**
   * Sets the list of all players in the game.
   *
   * @param inputPlayers The list of all players in the game.
   * @throws BaseIllegalArgumentException If the list of player list
   *        is null or empty.
   */
  public void setAllPlayers(final List<SnLPlayer> inputPlayers) {
    if (inputPlayers == null || inputPlayers.isEmpty()) {
      throw new BaseIllegalArgumentException(
          "Player list cannot be null or empty");
    }
    this.allPlayers = inputPlayers;
  }

  /**
   * Sets the current player the player selector is working with.
   *
   * @param inputPlayer The current player in the game.
   */
  public void setCurrentPlayer(final Player inputPlayer) {
    if (inputPlayer == null) {
      throw new BaseIllegalArgumentException(
          "Current player cannot be null");
    }
    this.current = inputPlayer;
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
