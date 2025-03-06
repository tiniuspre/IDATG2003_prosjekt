package snakesandladders;

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
   * Initializes a new {@code TestGame} snaked and ladders object.
   */
  private static final SnakesAndLadders TEST_GAME = new SnakesAndLadders();

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
    TEST_GAME.addPlayer("Alice");
    TEST_GAME.addPlayer("Bob");
    TEST_GAME.setBoard();
    TEST_GAME.printStatus();
    while (TEST_GAME.isNotFinished()) {
      TEST_GAME.playOneRound();
      TEST_GAME.printStatus();
    }
    System.out.println(TEST_GAME.getWinner().getName() + " wins!");
  }
}
