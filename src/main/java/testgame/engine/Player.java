package testgame.engine;

public class Player {
  private String name;
  private int position = 0;

  public Player(String name) {
    setName(name);
  }

  public void setName(String inputName) {
    if (inputName == null || inputName.isEmpty() || inputName.isBlank()) {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
    this.name = inputName;
  }

  public String getName() {
    return name;
  }

  public void setPosition(int position) {
    if (position < 0) {
      throw new IllegalArgumentException("Invalid position");
    }
    this.position = position;
  }

  public int getPosition() {
    return position;
  }

  public void move(int steps) {
    if (steps < 0) {
      throw new IllegalArgumentException("Invalid steps");
    }
    position += steps;
  }

  public void moveBack(int tileNumber) {
    setPosition(tileNumber);
  }
}
