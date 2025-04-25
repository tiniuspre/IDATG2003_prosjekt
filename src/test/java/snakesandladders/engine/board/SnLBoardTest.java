package snakesandladders.engine.board;

import constants.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import snakesandladders.engine.board.tile.Jump;
import snakesandladders.engine.board.tile.SnLTile;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SnLBoardTest {

  private SnLBoard board;

  @BeforeEach
  void setUp() {
    List<Jump> snakes = List.of(new Jump(14, 7),
    new Jump(5, 5),
    new Jump(2, 10));
    SnLBoardConfig config = new SnLBoardConfig(snakes);
    board = new SnLBoard(5, 5, config);
  }

  @Test
  @DisplayName("Board size is calculated correctly for valid dimensions")
  void boardSizeCalculatedCorrectlyForValidDimensions() {
    assertEquals(25, board.getBoardSize());
  }

  @Test
  @DisplayName("Exception is thrown for invalid board dimensions")
  void exceptionThrownForInvalidBoardDimensions() {
    assertThrows(IllegalArgumentException.class, () -> new SnLBoard(0, 5, null));
    assertThrows(IllegalArgumentException.class, () -> new SnLBoard(5, -1, null));
  }

  @Test
  @DisplayName("Tile is retrieved correctly for valid position")
  void tileRetrievedCorrectlyForValidPosition() {
    SnLTile tile = board.getTile(2);
    assertEquals(Constants.LADDER, tile.getType());
    assertEquals(10, tile.getNext());
  }

  @Test
  @DisplayName("Exception is thrown for invalid tile position")
  void exceptionThrownForInvalidTilePosition() {
    assertThrows(IllegalArgumentException.class, () -> board.getTile(-1));
    assertThrows(IllegalArgumentException.class, () -> board.getTile(30));
  }

  @Test
  @DisplayName("Tiles are initialized correctly with default type")
  void tilesInitializedCorrectlyWithDefaultType() {
    SnLTile tile = board.getTile(0);
    assertEquals(Constants.NORMAL, tile.getType());
  }

  @Test
  @DisplayName("Snake tile is set correctly")
  void snakeTileSetCorrectly() {
    SnLTile tile = board.getTile(14);
    assertEquals(Constants.SNAKE, tile.getType());
    assertEquals(7, tile.getNext());
  }

  @Test
  @DisplayName("Switch tile is set correctly")
  void switchTileSetCorrectly() {
    SnLTile tile = board.getTile(5);
    assertEquals(Constants.SWITCH, tile.getType());
  }
}