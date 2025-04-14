package snakesandladders.engine.actions;

import gameengine.player.Player;

import java.util.Map;

public class Switch implements SpecialAction {

  @Override
  public void apply(final Map.Entry<Integer, Integer> switchPosition, final Player currentPlayer) {
    // Logic for applying the switch action
    System.out.println("Switch action applied!");
  }
}
