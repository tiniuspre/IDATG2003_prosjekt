package testgame;

/**
 * The {@code TestGameApp} class is the temporary main class
 * for the test snaked and ladders game.
 *
 * @author jonastomren
 * @since 13.02.2025
 * @version 13.02.2025
 * @see TestGame
 */
public final class TestGameApp {
  /**
   * Initializes a new {@code TestGame} snaked and ladders object.
   */
  private static final TestGame TEST_GAME = new TestGame();

  /**
   * Private constructor to hide the implicit public one.
   */
  private TestGameApp() {
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
