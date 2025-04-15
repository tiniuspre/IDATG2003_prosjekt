package snakesandladders.engine;

import filehandler.jsonhandling.JsonHandlerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SnakesLaddersLoaderTest {

  @Test
  @DisplayName("Board is loaded successfully when valid board name is provided")
  void boardIsLoadedSuccessfullyForValidBoardName() throws IOException {
    SnakesAndLaddersBoard board = SnakesLaddersLoader.loadBoard("Classic");
    assertNotNull(board);
    assertEquals("Classic", board.getName());
  }

  @Test
  @DisplayName("Exception is thrown when board name is not found")
  void exceptionThrownWhenBoardNameNotFound() {
    assertThrows(JsonHandlerException.class, () -> SnakesLaddersLoader.loadBoard("NonExistentBoard"));
  }
}