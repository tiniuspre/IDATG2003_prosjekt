package snakesandladders.engine;

import java.util.List;

public class SnLGameContext {

  private SnLPlayer currentPlayer;
  private List<SnLPlayer> players;
  private static SnLGameContext instance;

  public static SnLGameContext getInstance() {
    if (instance == null) {
      instance = new SnLGameContext();
    }
    return instance;
  }

  public SnLPlayer getCurrentPlayer() {
    return currentPlayer;
  }

  public void setCurrentPlayer(SnLPlayer currentPlayer) {
    if (currentPlayer == null) {
      throw new IllegalArgumentException("Current player cannot be null");
    }
    this.currentPlayer = currentPlayer;
  }

  public List<SnLPlayer> getPlayers() {
    return players;
  }

  public void setPlayers(List<SnLPlayer> players) {
    if (players == null || players.isEmpty()) {
      throw new IllegalArgumentException("Players cannot be null or empty");
    }
    this.players = players;
  }

}
