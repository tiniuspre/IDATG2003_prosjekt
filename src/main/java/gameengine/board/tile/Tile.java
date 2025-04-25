package gameengine.board.tile;

public abstract class Tile {

  private int position;

  public Tile(final int inputPosition) {
    setPosition(inputPosition);
  }

  public void setPosition(final int inputPosition)
      throws IllegalArgumentException {
    if (inputPosition < 0) {
      throw new IllegalArgumentException("Invalid tile position.");
    }
    this.position = inputPosition;
  }

  public int getPosition() {
    return position;
  }
}
