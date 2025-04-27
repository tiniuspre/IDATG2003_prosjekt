package snakesandladders.engine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import snakesandladders.engine.board.SnLBoardException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SnLGameContextTest {

  private SnLGameContext gameContext;
  private SnLPlayer player1;
  private SnLPlayer player2;

  @BeforeEach
  void setUp() {
    gameContext = SnLGameContext.getInstance();
    player1 = new SnLPlayer("Player1", "HAT");
    player2 = new SnLPlayer("Player2", "CAR");
  }

  @Test
  @DisplayName("Singleton instance is always the same")
  void singletonInstanceIsAlwaysTheSame() {
    SnLGameContext anotherInstance = SnLGameContext.getInstance();
    assertSame(gameContext, anotherInstance);
  }

  @Test
  @DisplayName("Current player is set and retrieved correctly")
  void currentPlayerIsSetAndRetrievedCorrectly() {
    gameContext.setCurrentPlayer(player1);
    assertEquals(player1, gameContext.getCurrentPlayer());
  }

  @Test
  @DisplayName("Exception is thrown when setting null as current player")
  void exceptionThrownWhenSettingNullAsCurrentPlayer() {
    assertThrows(IllegalArgumentException.class, () -> gameContext.setCurrentPlayer(null));
  }

  @Test
  @DisplayName("Players list is set and retrieved correctly")
  void playersListIsSetAndRetrievedCorrectly() {
    gameContext.setPlayers(List.of(player1, player2));
    assertEquals(List.of(player1, player2), gameContext.getPlayers());
  }

  @Test
  @DisplayName("Exception is thrown when setting null as players list")
  void exceptionThrownWhenSettingNullAsPlayersList() {
    assertThrows(IllegalArgumentException.class, () -> gameContext.setPlayers(null));
  }

  @Test
  @DisplayName("Exception is thrown when setting empty players list")
  void exceptionThrownWhenSettingEmptyPlayersList() {
    assertThrows(IllegalArgumentException.class, () -> gameContext.setPlayers(List.of()));
  }


  @Test
  @DisplayName("Exception is thrown when setting null as game board")
  void exceptionThrownWhenSettingNullAsGameBoard() {
    assertThrows(SnLBoardException.class, () -> gameContext.setBoard(null));
  }
}