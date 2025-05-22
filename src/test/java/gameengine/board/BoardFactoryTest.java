package gameengine.board;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

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
  void createBoard_ReturnsEmpty_WhenInvalidBoardName_Integration() {
    Optional<Board> result = BoardFactory.createBoard("snl", "NonExistentBoard");
    Assertions.assertTrue(result.isEmpty());
  }

}