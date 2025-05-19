package snakesandladders;

import javafx.application.Application;
import snakesandladders.ui.SnakesAndLaddersUI;


/**
 * The {@code TestGameApp} class is the temporary main class
 * for the test snaked and ladders game.
 *
 * @author jonastomren
 * @since 13.02.2025
 * @version 13.02.2025
 * @see SnakesAndLadders
 */
public final class SnakesAndLaddersApp {

  /**
   * Private constructor to hide the implicit public one.
   */
  private SnakesAndLaddersApp() {
    // Private constructor to hide the implicit public one.
  }

  /**
   * The main method for the test snakes and ladders game.
   *
   * @param args the command-line arguments.
   */
  public static void main(final String[] args) {
    Application.launch(SnakesAndLaddersUI.class, args);
  }
}
