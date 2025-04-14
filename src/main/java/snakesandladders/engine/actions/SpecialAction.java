package snakesandladders.engine.actions;

import gameengine.player.Player;

import java.util.Map;

public interface SpecialAction {

  void apply(Map.Entry<Integer, Integer> snakePosition, Player currentPlayer);
}
