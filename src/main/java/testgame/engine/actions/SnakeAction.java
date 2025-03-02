package testgame.engine.actions;

import gameengine.board.TileAction;

public class SnakeAction implements TileAction {
  private int snakeHead;
  private int snakeTail;

  public SnakeAction(int snakeHead, int snakeTail) {
    setSnakeHead(snakeHead);
    setSnakeTail(snakeTail);
  }

  public void setSnakeHead(int snakeHead) {
    if (snakeHead < 0) {
      throw new IllegalArgumentException("Snake head must be greater than 0.");
    }
    this.snakeHead = snakeHead;
  }

  public void setSnakeTail(int snakeTail) {
    if (snakeTail < 0 || snakeTail >= snakeHead) {
      throw new IllegalArgumentException("Snake tail must be greater than 0 and less than snake head.");
    }
    this.snakeTail = snakeTail;
  }

  @Override
  public int landAction(int position) {
    return snakeTail;
  }
}

