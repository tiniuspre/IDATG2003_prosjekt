package filehandler;

import constants.Constants;
import filehandler.csvhandling.CsvHandler;
import gameengine.Player;
import snakesandladders.engine.SnakesAndLaddersPlayer;

import java.util.ArrayList;
import java.util.List;

public class testMain {
  // TODO: REMOVE THIS CLASS
  public static void main(String[] args) {
    String filePath = Constants.SNL_PLAYER_FILE_PATH;
    CsvHandler csvHandler = new CsvHandler();

    List<SnakesAndLaddersPlayer> newPlayerList = new ArrayList<>();

    List<Player> playerList = List.of(
        new SnakesAndLaddersPlayer("Player1", "cat"),
        new SnakesAndLaddersPlayer("Player2", "hat"),
        new SnakesAndLaddersPlayer("Player3", "car")
    );

    try {
      csvHandler.setPath(filePath);
      csvHandler.writeToFile(playerList);

      newPlayerList = csvHandler.readFromFile(SnakesAndLaddersPlayer.class);
      for (SnakesAndLaddersPlayer player : newPlayerList) {
        System.out.println(player.getName() + " " + player.getPiece());
      }

    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
  }
}
