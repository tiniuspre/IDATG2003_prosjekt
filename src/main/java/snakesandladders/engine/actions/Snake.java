package snakesandladders.engine.actions;

import gameengine.player.Player;

import java.util.Map;

public class Snake implements SpecialAction {

  private final Map<Integer, Integer> snakePositions;

  public Snake(final Map<Integer, Integer> snakeContext) {
    this.snakePositions = snakeContext;
  }

  @Override
  public void apply(final Player currentPlayer) {
    int endPos = snakePositions.get(currentPlayer.getPosition());
    int startPos = currentPlayer.getPosition();
    if (endPos < startPos) {
      currentPlayer.setPosition(endPos);
    } else {
      throw new IllegalArgumentException("Invalid snake position: " + endPos);
    }
    System.out.println(currentPlayer.getName() + " hit a snake! Moved from " + startPos + " to " + endPos);
  }

}
