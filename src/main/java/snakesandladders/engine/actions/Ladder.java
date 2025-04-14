package snakesandladders.engine.actions;

import gameengine.player.Player;

import java.util.Map;

public class Ladder implements SpecialAction {

  @Override
  public void apply(final Map.Entry<Integer, Integer> ladderPosition, final Player currentPlayer) {
    // Logic for applying the ladder action
    System.out.println("Ladder action applied!");
  };
}
