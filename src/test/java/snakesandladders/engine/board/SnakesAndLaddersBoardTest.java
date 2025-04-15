package snakesandladders.engine.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SnakesAndLaddersBoardTest {

  private SnakesAndLaddersBoard board;

  @BeforeEach
  void setUp() {
    board = new SnakesAndLaddersBoard(10, 10);
  }

  @Test
  @DisplayName("Snakes are set correctly when valid input is provided")
  void snakesAreSetCorrectlyForValidInput() {
    board.setSnakes(Map.of(14, 7, 22, 5));
    assertEquals(Map.of(14, 7, 22, 5), board.getSnakes());
  }

  @Test
  @DisplayName("Exception is thrown when setting null snakes")
  void exceptionThrownWhenSettingNullSnakes() {
    assertThrows(IllegalArgumentException.class, () -> board.setSnakes(null));
  }

  @Test
  @DisplayName("Exception is thrown when setting empty snakes")
  void exceptionThrownWhenSettingEmptySnakes() {
    assertThrows(IllegalArgumentException.class, () -> board.setSnakes(Map.of()));
  }

  @Test
  @DisplayName("Ladders are set correctly when valid input is provided")
  void laddersAreSetCorrectlyForValidInput() {
    board.setLadders(Map.of(2, 10, 5, 15));
    assertEquals(Map.of(2, 10, 5, 15), board.getLadders());
  }

  @Test
  @DisplayName("Exception is thrown when setting null ladders")
  void exceptionThrownWhenSettingNullLadders() {
    assertThrows(IllegalArgumentException.class, () -> board.setLadders(null));
  }

  @Test
  @DisplayName("Exception is thrown when setting empty ladders")
  void exceptionThrownWhenSettingEmptyLadders() {
    assertThrows(IllegalArgumentException.class, () -> board.setLadders(Map.of()));
  }

  @Test
  @DisplayName("Switches are set correctly when valid input is provided")
  void switchesAreSetCorrectlyForValidInput() {
    board.setSwitches(List.of(3, 8, 12));
    assertEquals(List.of(3, 8, 12), board.getSwitches());
  }

  @Test
  @DisplayName("Exception is thrown when setting null switches")
  void exceptionThrownWhenSettingNullSwitches() {
    assertThrows(IllegalArgumentException.class, () -> board.setSwitches(null));
  }

  @Test
  @DisplayName("Exception is thrown when setting empty switches")
  void exceptionThrownWhenSettingEmptySwitches() {
    assertThrows(IllegalArgumentException.class, () -> board.setSwitches(List.of()));
  }

  @Test
  @DisplayName("Board size is set correctly when valid input is provided")
  void boardSizeIsSetCorrectlyForValidInput() {
    board.setSize(100);
    assertEquals(100, board.getBoardSize());
  }

  @Test
  @DisplayName("Exception is thrown when setting invalid board size")
  void exceptionThrownWhenSettingInvalidBoardSize() {
    assertThrows(IllegalArgumentException.class, () -> board.setSize(0));
    assertThrows(IllegalArgumentException.class, () -> board.setSize(-1));
  }
}