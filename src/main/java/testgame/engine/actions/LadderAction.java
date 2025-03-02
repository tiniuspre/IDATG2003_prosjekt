package testgame.engine.actions;

import gameengine.board.TileAction;

public class LadderAction implements TileAction {
  private int ladderBottom;
  private int ladderTop;

  public LadderAction(int ladderBottom, int ladderTop) {
    setLadderBottom(ladderBottom);
    setLadderTop(ladderTop);
  }

  public void setLadderBottom(int ladderBottom) {
    if (ladderBottom < 0) {
      throw new IllegalArgumentException("Ladder bottom must be greater than 0.");
    }
    this.ladderBottom = ladderBottom;
  }

  public void setLadderTop(int ladderTop) {
    if (ladderTop < 0 || ladderTop <= ladderBottom) {
      throw new IllegalArgumentException("Ladder top must be greater than 0 and greater than ladder bottom.");
    }
    this.ladderTop = ladderTop;
  }

  @Override
  public void landAction() {
    System.out.println("You landed on a ladder! Climb up to tile " + ladderTop + ".");
  }
}
