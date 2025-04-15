package snakesandladders.engine.actions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;
import snakesandladders.engine.SnakesAndLaddersBoard;
import snakesandladders.engine.SnakesAndLaddersPlayer;

class SpecialActionFactoryTest {

  private SpecialActionFactory factory;

  @BeforeEach
  void setUp() {
    SnakesAndLaddersBoard board = new SnakesAndLaddersBoard(10, 9);
    SnakesAndLaddersPlayer currentPlayer = new SnakesAndLaddersPlayer("CurrentPlayer", "hat");
    SnakesAndLaddersPlayer otherPlayer = new SnakesAndLaddersPlayer("OtherPlayer", "car");
    List<SnakesAndLaddersPlayer> players = List.of(currentPlayer, otherPlayer);
    factory = new SpecialActionFactory(board, players, currentPlayer);
  }

  @Test
  @DisplayName("Ladder action is created when action type is Ladder")
  void ladderActionCreatedForLadderType() {
    Optional<SpecialAction> action = factory.createSpecialAction("Ladder");
    assertTrue(action.isPresent());
    assertInstanceOf(Ladder.class, action.get());
  }

  @Test
  @DisplayName("Snake action is created when action type is Snake")
  void snakeActionCreatedForSnakeType() {
    Optional<SpecialAction> action = factory.createSpecialAction("Snake");
    assertTrue(action.isPresent());
    assertInstanceOf(Snake.class, action.get());
  }

  @Test
  @DisplayName("Switch action is created when action type is Switch")
  void switchActionCreatedForSwitchType() {
    Optional<SpecialAction> action = factory.createSpecialAction("Switch");
    assertTrue(action.isPresent());
    assertInstanceOf(Switch.class, action.get());
  }

  @Test
  @DisplayName("Empty optional is returned for invalid action type")
  void emptyOptionalReturnedForInvalidActionType() {
    Optional<SpecialAction> action = factory.createSpecialAction("InvalidType");
    assertTrue(action.isEmpty());
  }
}