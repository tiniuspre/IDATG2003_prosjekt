package testgame;

public class TestGameApp {
  static TestGame testGame = new TestGame();

  public static void main(String[] args) {
    testGame.addPlayer("Alice");
    testGame.addPlayer("Bob");
    testGame.setBoard();
    testGame.printStatus();
    while (!testGame.isFinished()) {
      testGame.playOneRound();
      if (!testGame.isFinished()) {
        testGame.printStatus();
      }
    }
    System.out.println(testGame.getWinner().getName() + " wins!");
  }
}
