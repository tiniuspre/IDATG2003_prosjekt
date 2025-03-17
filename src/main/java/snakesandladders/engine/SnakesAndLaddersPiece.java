package snakesandladders.engine;


public enum SnakesAndLaddersPiece {
  HAT("hat"),
  BOOT("boot"),
  CAT("cat"),
  DOG("dog"),
  CAR("car");

  private String value;


  SnakesAndLaddersPiece(String inputValue) {
    setValue(inputValue);
  }

  public String getValue() {
    return value;
  }

  public void setValue(String inputValue) {
    if (value == null || value.isBlank()) {
      throw new IllegalArgumentException("Piece cannot be null or empty");
    }
    this.value = inputValue;
  }

  public static SnakesAndLaddersPiece fromString(String text) {
    for (SnakesAndLaddersPiece b : SnakesAndLaddersPiece.values()) {
      if (b.value.equalsIgnoreCase(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("No constant with text " + text + " found.");
  }
}
