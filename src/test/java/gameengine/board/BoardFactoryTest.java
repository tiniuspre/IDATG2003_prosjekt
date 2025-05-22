package gameengine.board;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BoardFactoryIntegrationTest {

  @Test
  void createBoard_ReturnsBoard_WhenValidSnLTypeAndName_Integration() {
    Optional<Board> result = BoardFactory.createBoard("snl", "Classic");
    Assertions.assertTrue(result.isPresent());
  }

  @Test
  void createBoard_ReturnsEmpty_WhenUnknownBoardType_Integration() {
    Optional<Board> result = BoardFactory.createBoard("unknown", "AnyName");
    Assertions.assertTrue(result.isEmpty());
  }
  @Test
  void createBoard_ThrowsBoardLoadException_WhenUnexpectedExceptionOccurs_Integration() {
    assertThrows(BoardLoadException.class, () -> {
      BoardFactory.createBoard("snl", "CauseUnexpectedException");
    });
  }
}