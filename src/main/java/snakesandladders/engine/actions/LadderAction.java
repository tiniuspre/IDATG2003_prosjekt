package snakesandladders.engine.actions;

import gameengine.board.TileAction;
import snakesandladders.engine.SnakesAndLaddersPlayer;

/**
 * The {@code LadderAction} class represents the action,
 * of a ladder in the test snakes and ladders game.
 *
 * @author jonastomren
 * @version 13.02.2025
 * @since 13.02.2025
 * @see TileAction
 */
public class LadderAction implements TileAction<SnakesAndLaddersPlayer, Void> {
  /**
   * The bottom of the ladder.
   */
  private int ladderBottom;
  /**
   * The top of the ladder.
   */
  private int ladderTop;

  /**
   * Constructor for the LadderAction class.
   *
   * @param inputLadderBottom the bottom of the ladder.
   * @param inputLadderTop the top of the ladder.
   */
  public LadderAction(final int inputLadderBottom, final int inputLadderTop) {
    setLadderBottom(inputLadderBottom);
    setLadderTop(inputLadderTop);
  }

  /**
   * Sets the bottom of the ladder.
   *
   * @param inputLadderBottom the bottom of the ladder.
   * @throws IllegalArgumentException if the ladder bottom is less than 0.
   */
  public void setLadderBottom(final int inputLadderBottom)
      throws IllegalArgumentException {
    if (inputLadderBottom < 0) {
      throw new IllegalArgumentException("Ladder "
          + "bottom must be greater than 0.");
    }
    this.ladderBottom = inputLadderBottom;
  }

  public int getLadderBottom() {
    return this.ladderBottom;
  }

  public int getLadderTop() {
    return this.ladderTop;
  }

  /**
   * Sets the top of the ladder.
   *
   * @param inputLadderTop the top of the ladder.
   * @throws IllegalArgumentException if the ladder top is less than 0,
   *        or less than ladder bottom.
   */
  public void setLadderTop(final int inputLadderTop)
      throws IllegalArgumentException {
    if (inputLadderTop < 0 || inputLadderTop <= ladderBottom) {
      throw new IllegalArgumentException("Ladder top must "
          + "be greater than 0 and greater than ladder bottom.");
    }
    this.ladderTop = inputLadderTop;
  }

  /**
   * The action that should be performed when a player lands on the tile.
   *
   * @param player the player to be moved.
   */
  @Override
  public void landAction(SnakesAndLaddersPlayer player) {
    player.setPosition(getLadderTop());
  }
}
