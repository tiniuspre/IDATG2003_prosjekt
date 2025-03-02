package testgame.engine.tiles;

public class SnakeTile extends TestGameTile {

  private int destinationX;
  private int destinationY;

  public SnakeTile(final int number, final int posX, final int posY) {
    super(number, posX, posY);
  }

  public void setDestination(final int positionX, final int positionY) {
    this.destinationX = positionX;
    this.destinationY = positionY;
  }

  public int[] getDestination() {
    return new int[] {destinationX, destinationY};
  }
}
