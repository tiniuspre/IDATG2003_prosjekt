package snakesandladders.engine.actions;

import gameengine.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import snakesandladders.engine.SnLPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SnakeTest {

  private Snake snake;
  private Player player;

  @BeforeEach
  void setUp() {
    snake = new Snake(7, 14);
    player = new SnLPlayer("TestPlayer", "CAR");
  }

  @Test
  @DisplayName("Player position is updated correctly when landing on a snake")
  void playerPositionUpdatedCorrectlyWhenLandingOnSnake() {
    player.setPosition(14);
    snake.apply(player);
    assertEquals(7, player.getPosition());
  }

  @Test
  @DisplayName("Exception is thrown when snake end position is invalid")
  void exceptionThrownWhenSnakeEndPositionIsInvalid() {
    assertThrows(IllegalArgumentException.class, () -> new Snake(10, 5));
  }

  @Test
  @DisplayName("Exception is thrown when player position does not match snake start position")
  void exceptionThrownWhenPlayerPositionDoesNotMatchSnakeStartPosition() {
    player.setPosition(10);
    assertThrows(NullPointerException.class, () -> snake.apply(player));
  }
}