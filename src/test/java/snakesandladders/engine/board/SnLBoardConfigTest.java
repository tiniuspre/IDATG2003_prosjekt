package snakesandladders.engine.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import snakesandladders.engine.board.tile.Jump;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SnLBoardConfigTest {

  private SnLBoardConfig config;

  @BeforeEach
  void setUp() {
    config = new SnLBoardConfig();
  }

  @Test
  @DisplayName("Jumps are configured correctly into snakes, ladders, and switches")
  void jumpsConfiguredCorrectlyIntoSnakesLaddersAndSwitches() {
    List<Jump> jumps = List.of(
        new Jump(14, 7),  // Snake
        new Jump(2, 10),  // Ladder
        new Jump(5, 5)    // Switch
    );
    config.setJumps(jumps);

    assertEquals(1, config.getSnakes().count());
    assertEquals(1, config.getLadders().count());
    assertEquals(1, config.getSwitches().count());
  }

  @Test
  @DisplayName("Exception is thrown when setting null or empty jumps")
  void exceptionThrownWhenSettingNullOrEmptyJumps() {
    assertThrows(IllegalArgumentException.class, () -> config.setJumps(null));
    assertThrows(IllegalArgumentException.class, () -> config.setJumps(List.of()));
  }

  @Test
  @DisplayName("Snakes are retrieved correctly")
  void snakesRetrievedCorrectly() {
    List<Jump> jumps = List.of(new Jump(14, 7));
    config.setJumps(jumps);

    assertTrue(config.getSnakes().anyMatch(jump -> jump.getFrom() == 14 && jump.getTo() == 7));
  }

  @Test
  @DisplayName("Ladders are retrieved correctly")
  void laddersRetrievedCorrectly() {
    List<Jump> jumps = List.of(new Jump(2, 10));
    config.setJumps(jumps);

    assertTrue(config.getLadders().anyMatch(jump -> jump.getFrom() == 2 && jump.getTo() == 10));
  }

  @Test
  @DisplayName("Switches are retrieved correctly")
  void switchesRetrievedCorrectly() {
    List<Jump> jumps = List.of(new Jump(5, 5));
    config.setJumps(jumps);

    assertTrue(config.getSwitches().anyMatch(jump -> jump.getFrom() == 5 && jump.getTo() == 5));
  }
}