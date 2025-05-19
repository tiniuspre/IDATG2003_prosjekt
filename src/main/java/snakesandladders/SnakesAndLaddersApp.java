package snakesandladders;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import snakesandladders.engine.SnLPlayer;
import snakesandladders.ui.SnLController;
import snakesandladders.ui.SnLView;
import ui.util.GameScreen;

import java.util.ArrayList;
import java.util.List;


/**
 * The {@code TestGameApp} class is the temporary main class
 * for the test snaked and ladders game.
 *
 * @author jonastomren
 * @since 13.02.2025
 * @version 13.02.2025
 * @see SnakesAndLadders
 */
public final class SnakesAndLaddersApp implements GameScreen {

  private final SnLView view;

  private final SnLController controller;

  private final SnakesAndLadders game = new SnakesAndLadders();


  public SnakesAndLaddersApp() {
    game.setBoard();
    game.addPlayer("Player 1", "hat");
    game.addPlayer("Player 2", "car");
    view = new SnLView(game);
    controller = new SnLController(view, game);
  }


  @Override
  public Parent getView() {
    view.setPrefWidth(800);  // Set preferred width
    view.setPrefHeight(600); // Set preferred height
    VBox.setVgrow(view, javafx.scene.layout.Priority.ALWAYS);
    return view;
  }
}
