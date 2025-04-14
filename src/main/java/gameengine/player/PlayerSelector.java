package gameengine.player;

import snakesandladders.engine.SnakesAndLaddersPlayer;

import java.util.List;

public class PlayerSelector {

  private final List<SnakesAndLaddersPlayer> allPlayers;

  private final Player current;

  public PlayerSelector(final List<SnakesAndLaddersPlayer> players, final Player currentPlayer) {
    this.allPlayers = players;
    this.current = currentPlayer;
  }

  public Player selectRandomPlayer() {
    // Filter out the current player from the list
    List<SnakesAndLaddersPlayer> availablePlayers = allPlayers.stream()
        .filter(player -> !player.equals(current))
        .toList();
    // If no players are available, throw an exception
    if (availablePlayers.isEmpty()) {
      throw new IllegalArgumentException("No available players to select from.");
    }
    // Select a random player from the available players
    return availablePlayers.get((int) (Math.random() * availablePlayers.size()));
  }
}
