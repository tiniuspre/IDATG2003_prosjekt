package snakesandladders.engine.actions;

import gameengine.board.TileAction;
import snakesandladders.engine.SnakesAndLaddersPlayer;

import java.util.List;
import java.util.Random;

public class SwitchAction implements TileAction<SnakesAndLaddersPlayer, List<SnakesAndLaddersPlayer>>{

  @Override
  public void landAction(SnakesAndLaddersPlayer playerToSwitch, List<SnakesAndLaddersPlayer> listOfPlayers) {
    Random random = new Random();
    int randomPlayer;
    do {
      randomPlayer = random.nextInt(listOfPlayers.size());
    } while (listOfPlayers.get(randomPlayer).equals(playerToSwitch));
    SnakesAndLaddersPlayer playerToSwitchWith = listOfPlayers.get(randomPlayer);
    int temp = playerToSwitch.getPosition();
    playerToSwitch.setPosition(playerToSwitchWith.getPosition());
    playerToSwitchWith.setPosition(temp);
    System.out.println(playerToSwitch.getName() + " is now at position "
        + playerToSwitch.getPosition() + " and " + playerToSwitchWith.getName() +
        " is now at position " + playerToSwitchWith.getPosition());
  }
}
