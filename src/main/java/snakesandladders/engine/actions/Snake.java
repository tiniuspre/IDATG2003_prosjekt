package snakesandladders.engine.actions;

import gameengine.player.Player;

import java.util.Map;

public class Snake implements SpecialAction {

  @Override
  public void apply(final Map.Entry<Integer, Integer> snakePosition, final Player currentPlayer) {
    // Logic for applying the snake action
    System.out.println("Snake action applied!");
  };

}
