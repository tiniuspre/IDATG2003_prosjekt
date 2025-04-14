package gameengine.player;

import java.util.List;

public class PlayerSelector {

  public Player selectRandomPlayer(final List<Player> players, final Player current) {
    // Filter out the current player from the list
    List<Player> availablePlayers = players.stream()
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
