package snakesandladders.engine.actions;

import org.junit.jupiter.api.Test;
import snakesandladders.engine.SnakesAndLaddersPlayer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SnakeActionTest {

  @Test
  void setSnakeHead_validValue_setsHead() {
    SnakeAction snakeAction = new SnakeAction(5, 2);
    snakeAction.setSnakeHead(6);
    assertEquals(6, snakeAction.getSnakeHead());
  }

  @Test
  void setSnakeHead_negativeValue_throwsException() {
    SnakeAction snakeAction = new SnakeAction(5, 2);
    assertThrows(IllegalArgumentException.class, () -> snakeAction.setSnakeHead(-1));
  }

  @Test
  void setSnakeTail_validValue_setsTail() {
    SnakeAction snakeAction = new SnakeAction(5, 2);
    snakeAction.setSnakeTail(3);
    assertEquals(3, snakeAction.getSnakeTail());
  }

  @Test
  void setSnakeTail_negativeValue_throwsException() {
    SnakeAction snakeAction = new SnakeAction(5, 2);
    assertThrows(IllegalArgumentException.class, () -> snakeAction.setSnakeTail(-1));
  }

  @Test
  void setSnakeTail_greaterThanOrEqualToHead_throwsException() {
    SnakeAction snakeAction = new SnakeAction(5, 2);
    assertThrows(IllegalArgumentException.class, () -> snakeAction.setSnakeTail(5));
    assertThrows(IllegalArgumentException.class, () -> snakeAction.setSnakeTail(6));
  }

  @Test
  void landAction_movesPlayerToTail() {
    SnakesAndLaddersPlayer player = new SnakesAndLaddersPlayer();
    player.setPosition(5);
    SnakeAction snakeAction = new SnakeAction(5, 2);
    List<SnakesAndLaddersPlayer> playerList = new ArrayList<>();
    snakeAction.landAction(player, playerList);
    assertEquals(2, player.getPosition());
  }
}