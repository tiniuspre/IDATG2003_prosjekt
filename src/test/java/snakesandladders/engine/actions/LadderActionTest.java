package snakesandladders.engine.actions;

import org.junit.jupiter.api.Test;
import snakesandladders.engine.SnakesAndLaddersPlayer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderActionTest {

  @Test
  void setLadderBottom_validValue_setsBottom() {
    LadderAction ladderAction = new LadderAction(1, 2);
    ladderAction.setLadderBottom(3);
    assertEquals(3, ladderAction.getLadderBottom());
  }

  @Test
  void setLadderBottom_negativeValue_throwsException() {
    LadderAction ladderAction = new LadderAction(1, 2);
    assertThrows(IllegalArgumentException.class, () -> ladderAction.setLadderBottom(-1));
  }

  @Test
  void setLadderTop_validValue_setsTop() {
    LadderAction ladderAction = new LadderAction(1, 2);
    ladderAction.setLadderTop(4);
    assertEquals(4, ladderAction.getLadderTop());
  }

  @Test
  void setLadderTop_negativeValue_throwsException() {
    LadderAction ladderAction = new LadderAction(1, 2);
    assertThrows(IllegalArgumentException.class, () -> ladderAction.setLadderTop(-1));
  }

  @Test
  void setLadderTop_lessThanBottom_throwsException() {
    LadderAction ladderAction = new LadderAction(1, 2);
    assertThrows(IllegalArgumentException.class, () -> ladderAction.setLadderTop(0));
  }

  @Test
  void landAction_movesPlayerToTop() {
    SnakesAndLaddersPlayer player = new SnakesAndLaddersPlayer();
    player.setPosition(1);
    LadderAction ladderAction = new LadderAction(1, 2);
    List<SnakesAndLaddersPlayer> playerList = new ArrayList<>();
    ladderAction.landAction(player, playerList);
    assertEquals(2, player.getPosition());
  }
}