package connectfour.engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import gameengine.grid.GridPlayer;
import gameengine.grid.Marker;

class ConnectFourGameTest {

  private static class DummyPlayer extends GridPlayer {
    public DummyPlayer(Marker marker) {
      super("Dummy", marker);
    }
  }

  @Test
  void initializesBoardWithAllCellsEmpty() {
    ConnectFourGame game = new ConnectFourGame(new DummyPlayer(Marker.PLAYER_ONE), new DummyPlayer(Marker.PLAYER_TWO));
    for (int r = 0; r < 7; r++) {
      for (int c = 0; c < 7; c++) {
        Assertions.assertEquals(Marker.NONE, game.getMarkerAt(r, c));
      }
    }
  }

  @Test
  void canMoveReturnsTrueForEmptyColumn() {
    ConnectFourGame game = new ConnectFourGame(new DummyPlayer(Marker.PLAYER_ONE), new DummyPlayer(Marker.PLAYER_TWO));
    Assertions.assertTrue(game.canMove(0, 3));
  }


  @Test
  void canMoveReturnsFalseForInvalidColumn() {
    ConnectFourGame game = new ConnectFourGame(new DummyPlayer(Marker.PLAYER_ONE), new DummyPlayer(Marker.PLAYER_TWO));
    Assertions.assertFalse(game.canMove(0, -1));
    Assertions.assertFalse(game.canMove(0, 7));
  }

  @Test
  void getMarkerAtThrowsExceptionForOutOfBounds() {
    ConnectFourGame game = new ConnectFourGame(new DummyPlayer(Marker.PLAYER_ONE), new DummyPlayer(Marker.PLAYER_TWO));
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> game.getMarkerAt(-1, 0));
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> game.getMarkerAt(0, -1));
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> game.getMarkerAt(7, 0));
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> game.getMarkerAt(0, 7));
  }

  @Test
  void checkWinnerReturnsNullWhenNoWinner() {
    ConnectFourGame game = new ConnectFourGame(new DummyPlayer(Marker.PLAYER_ONE), new DummyPlayer(Marker.PLAYER_TWO));
    Assertions.assertNull(game.checkWinner());
  }

  @Test
  void checkWinnerDetectsHorizontalWin() {
    DummyPlayer p1 = new DummyPlayer(Marker.PLAYER_ONE);
    DummyPlayer p2 = new DummyPlayer(Marker.PLAYER_TWO);
    ConnectFourGame game = new ConnectFourGame(p1, p2);
    for (int c = 0; c < 4; c++) {
      game.applyMove(0, c);
    }
    Assertions.assertEquals(p1, game.checkWinner());
  }

  @Test
  void checkWinnerDetectsVerticalWin() {
    DummyPlayer p1 = new DummyPlayer(Marker.PLAYER_ONE);
    DummyPlayer p2 = new DummyPlayer(Marker.PLAYER_TWO);
    ConnectFourGame game = new ConnectFourGame(p1, p2);
    for (int i = 0; i < 4; i++) {
      game.applyMove(0, 0);
    }
    Assertions.assertEquals(p1, game.checkWinner());
  }


  @Test
  void isDrawReturnsFalseWhenWinnerExists() {
    DummyPlayer p1 = new DummyPlayer(Marker.PLAYER_ONE);
    DummyPlayer p2 = new DummyPlayer(Marker.PLAYER_TWO);
    ConnectFourGame game = new ConnectFourGame(p1, p2);
    for (int c = 0; c < 4; c++) {
      game.applyMove(0, c);
    }
    Assertions.assertFalse(game.isDraw());
  }
}