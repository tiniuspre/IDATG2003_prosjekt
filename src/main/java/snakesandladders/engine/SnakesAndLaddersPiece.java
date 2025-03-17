package snakesandladders.engine;

/**
 * The {@code SnakesAndLaddersPiece} enum represents the pieces
 * that can be used in the snakes and ladders game.
 *
 * @author jonastomren
 * @version 17.03.2025
 * @since 17.03.2025
 */
public enum SnakesAndLaddersPiece {
  /**
   * The hat piece.
   */
  HAT("hat"),
  /**
   * The boot piece.
   */
  BOOT("boot"),
  /**
   * The cat piece.
   */
  CAT("cat"),
  /**
   * The dog piece.
   */
  DOG("dog"),
  /**
   * The car piece.
   */
  CAR("car");

  /**
   * The value of the piece.
   */
  private String value;

  /**
   * Constructor for the SnakesAndLaddersPiece enum.
   *
   * @param inputValue the value of the piece.
   */
  SnakesAndLaddersPiece(String inputValue) {
    setValue(inputValue);
  }

  /**
   * Returns the value of the piece.
   *
   * @return the value of the piece.
   */
  public String getValue() {
    return value;
  }

  /**
   * Sets the value of the piece.
   *
   * @param inputValue the value of the piece.
   */
  public void setValue(String inputValue) {
    this.value = inputValue;
  }

  /**
   * Returns the piece as a string.
   *
   * @param text the text to convert to a piece.
   * @return the piece as a string.
   */
  public static SnakesAndLaddersPiece fromString(String text) {
    for (SnakesAndLaddersPiece b : SnakesAndLaddersPiece.values()) {
      if (b.value.equalsIgnoreCase(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("No constant with text " + text + " found.");
  }
}
