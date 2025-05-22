package tictactoe.engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import gameengine.grid.GridPlayer;
import gameengine.grid.Marker;

class TicTacToeGameTest {

  private GridPlayer playerOne() {
    return new GridPlayer("P1", Marker.PLAYER_ONE);
  }

  private GridPlayer playerTwo() {
    return new GridPlayer("P2", Marker.PLAYER_TWO);
  }

  @Test
  void canMoveReturnsTrueForEmptyCellWithinBounds() {
    TicTacToeGame game = new TicTacToeGame(playerOne(), playerTwo());
    Assertions.assertTrue(game.canMove(1, 1));
  }

  @Test
  void canMoveReturnsFalseForCellOutOfBounds() {
    TicTacToeGame game = new TicTacToeGame(playerOne(), playerTwo());
    Assertions.assertFalse(game.canMove(-1, 0));
    Assertions.assertFalse(game.canMove(0, -1));
    Assertions.assertFalse(game.canMove(3, 0));
    Assertions.assertFalse(game.canMove(0, 3));
  }

  @Test
  void canMoveReturnsFalseForOccupiedCell() {
    TicTacToeGame game = new TicTacToeGame(playerOne(), playerTwo());
    game.applyMove(0, 0);
    Assertions.assertFalse(game.canMove(0, 0));
  }

  @Test
  void applyMoveSetsMarkerCorrectly() {
    TicTacToeGame game = new TicTacToeGame(playerOne(), playerTwo());
    game.applyMove(2, 2);
    Assertions.assertEquals(Marker.PLAYER_ONE, game.getMarkerAt(2, 2));
  }

  @Test
  void getMarkerAtThrowsExceptionForOutOfBounds() {
    TicTacToeGame game = new TicTacToeGame(playerOne(), playerTwo());
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> game.getMarkerAt(-1, 0));
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> game.getMarkerAt(0, 3));
  }

  @Test
  void checkWinnerReturnsPlayerOneForRowWin() {
    TicTacToeGame game = new TicTacToeGame(playerOne(), playerTwo());
    game.applyMove(0, 0);
    game.applyMove(1, 0); // P1
    game.applyMove(0, 1);
    game.applyMove(1, 1); // P1
    game.applyMove(0, 2);
    Assertions.assertEquals(playerOne().getName(), game.checkWinner().getName());
  }

  @Test
  void checkWinnerReturnsPlayerOneForDiagonalWin() {
    TicTacToeGame game = new TicTacToeGame(playerOne(), playerTwo());
    game.applyMove(0, 0); // P1
    game.applyMove(0, 1); // P2
    game.applyMove(1, 1); // P1
    game.applyMove(0, 2); // P2
    game.applyMove(2, 2); // P1
    Assertions.assertEquals(playerOne().getName(), game.checkWinner().getName());
  }

  @Test
  void checkWinnerReturnsNullWhenNoWinner() {
    TicTacToeGame game = new TicTacToeGame(playerOne(), playerTwo());
    Assertions.assertNull(game.checkWinner());
  }

  @Test
  void isDrawReturnsFalseWhenBoardNotFull() {
    TicTacToeGame game = new TicTacToeGame(playerOne(), playerTwo());
    game.applyMove(0, 0);
    Assertions.assertFalse(game.isDraw());
  }

  @Test
  void isDrawReturnsFalseWhenWinnerExists() {
    TicTacToeGame game = new TicTacToeGame(playerOne(), playerTwo());
    game.applyMove(0, 0);
    game.applyMove(1, 0);
    game.applyMove(0, 1);
    game.applyMove(1, 1);
    game.applyMove(0, 2);
    Assertions.assertFalse(game.isDraw());
  }
}