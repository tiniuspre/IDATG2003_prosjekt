package snakesandladders.engine.actions;

import gameengine.player.Player;

import java.util.Map;

public class Ladder implements SpecialAction {

  private final Map<Integer, Integer> ladderPositions;

  public Ladder(final Map<Integer, Integer> ladderContext) {
    this.ladderPositions = ladderContext;
  }

  @Override
  public void apply(final Player currentPlayer) {
    int endPos = ladderPositions.get(currentPlayer.getPosition());
    int startPos = currentPlayer.getPosition();
    if (endPos > startPos) {
      currentPlayer.setPosition(endPos);
    } else {
      throw new IllegalArgumentException("Invalid ladder position: " + endPos);
    }
    System.out.println(currentPlayer.getName() + " hit a ladder! Moved from " + startPos + " to " + endPos);
  }
}
