package snakesandladders.engine.actions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;
import gameengine.player.Player;
import snakesandladders.engine.SnakesAndLaddersPlayer;

class SnakeTest {

  private Snake snake;
  private Player player;

  @BeforeEach
  void setUp() {
    snake = new Snake(Map.of(14, 7, 22, 5));
    player = new SnakesAndLaddersPlayer("TestPlayer","hat");
  }

  @Test
  @DisplayName("Player moves to the correct position when landing on a snake")
  void playerMovesToSnakeEndPosition() {
    player.setPosition(14);
    snake.apply(player);
    assertEquals(7, player.getPosition());
  }

  @Test
  @DisplayName("Exception is thrown when snake end position is invalid")
  void exceptionThrownForInvalidSnakePosition() {
    Snake invalidSnake = new Snake(Map.of(10, 15));
    player.setPosition(10);
    assertThrows(IllegalArgumentException.class, () -> invalidSnake.apply(player));
  }

  @Test
  @DisplayName("No action is taken when player is not on a snake start position")
  void noActionWhenPlayerNotOnSnakeStart() {
    player.setPosition(12);
    assertThrows(NullPointerException.class, () -> snake.apply(player));
  }
}