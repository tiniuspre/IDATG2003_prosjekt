package snakesandladders.engine.actions;

import constants.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import snakesandladders.engine.SnLPlayer;
import snakesandladders.engine.board.tile.SnLTile;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SpecialActionFactoryTest {

  private SpecialActionFactory factory;
  private final SnLTile mockSnake = new SnLTile(12, Constants.NORMAL);
  private final SnLTile mockLadder = new SnLTile(0, Constants.NORMAL);

  @BeforeEach
  void setUp() {
    SnLPlayer player1 = new SnLPlayer("Player1", "CAR");
    SnLPlayer player2 = new SnLPlayer("Player2", "DOG");
    List<SnLPlayer> mockPlayerList = List.of(player1, player2);
    factory = new SpecialActionFactory(mockPlayerList, player1);
  }

  @Test
  @DisplayName("Ladder action is created when tile type is Ladder")
  void ladderActionCreatedWhenTileTypeIsLadder() {
    mockLadder.setType(Constants.LADDER);
    mockLadder.setNext(10);
    mockLadder.setPosition(2);

    Optional<SpecialAction> action = factory.createSpecialAction(mockLadder);

    assertTrue(action.isPresent());
    assertInstanceOf(Ladder.class, action.get());
  }

  @Test
  @DisplayName("Snake action is created when tile type is Snake")
  void snakeActionCreatedWhenTileTypeIsSnake() {
    mockSnake.setType(Constants.SNAKE);
    mockSnake.setNext(2);
    mockSnake.setPosition(10);

    Optional<SpecialAction> action = factory.createSpecialAction(mockSnake);

    assertTrue(action.isPresent());
    assertInstanceOf(Snake.class, action.get());
  }

  @Test
  @DisplayName("Switch action is created when tile type is Switch")
  void switchActionCreatedWhenTileTypeIsSwitch() {
    mockLadder.setType(Constants.SWITCH);

    Optional<SpecialAction> action = factory.createSpecialAction(mockLadder);

    assertTrue(action.isPresent());
    assertInstanceOf(Switch.class, action.get());
  }

  @Test
  @DisplayName("Empty optional is returned when tile type is invalid")
  void emptyOptionalReturnedWhenTileTypeIsInvalid() {
    mockLadder.setType("INVALID");

    Optional<SpecialAction> action = factory.createSpecialAction(mockLadder);

    assertTrue(action.isEmpty());
  }
}