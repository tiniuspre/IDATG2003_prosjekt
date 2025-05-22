package snakesandladders.engine.board;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SnLLoaderIntegrationTest {

  @Test
  void loadBoardReturnsSnLBoardWhenBoardNameExists() {
    SnLBoard board = SnLLoader.loadBoard("Classic");
    Assertions.assertNotNull(board);
  }

  @Test
  void loadBoardThrowsExceptionWhenBoardNameIsNull() {
    Assertions.assertThrows(SnLBoardException.class, () -> SnLLoader.loadBoard(null));
  }

  @Test
  void loadBoardThrowsExceptionWhenBoardNameIsEmpty() {
    Assertions.assertThrows(SnLBoardException.class, () -> SnLLoader.loadBoard(""));
  }

  @Test
  void loadBoardThrowsExceptionWhenBoardNameNotFound() {
    Assertions.assertThrows(SnLBoardException.class, () -> SnLLoader.loadBoard("NonExistentBoard"));
  }
}