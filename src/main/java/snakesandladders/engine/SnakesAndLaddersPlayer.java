package snakesandladders.engine;

import gameengine.Player;

/**
 * The {@code SnakesAndLaddersPlayer} class represents a player
 * in the snakes and ladders game.
 *
 * @author jonastomren
 * @version 10.03.2025
 * @since 10.03.2025
 * @see gameengine.Player
 */
public class SnakesAndLaddersPlayer extends Player {
  /**
   * The piece of the player.
   */
  private SnakesAndLaddersPiece piece;
  /**
   * Constructor for the SnakesAndLaddersPlayer class.
   *
   * @param inputName the name of the player.
   * @param inputPiece the piece of the player.
   */
  public SnakesAndLaddersPlayer(final String inputName,
                                final String inputPiece) {
    super(inputName);
    setPiece(inputPiece);
  }

  /**
   * Sets the piece of the player.
   *
   * @param inputPiece the piece of the player.
   * @throws IllegalArgumentException if the piece is null or empty.
   */
  public void setPiece(final String inputPiece)
      throws IllegalArgumentException {
    if (inputPiece == null || inputPiece.isBlank()) {
      throw new IllegalArgumentException("Piece cannot be null or empty");
    }
    this.piece = SnakesAndLaddersPiece.fromString(inputPiece);
  }

  /**
   * Returns the piece of the player.
   *
   * @return the piece of the player.
   */
  public String getPiece() {
    return piece.getValue();
  }

  /**
   * Moves the player forward a number of steps.
   *
   * @param steps the number of steps to move.
   */
  public void move(final int steps) throws IllegalArgumentException {
    if (steps < 0) {
      throw new IllegalArgumentException("Invalid steps");
    }
    setPosition(getPosition() + steps);
  }


  /**
   * Moves the player back to a specific tile.
   *
   * @param tileNumber the number of the tile to move back to.
   */
  public void moveBack(final int tileNumber) throws IllegalArgumentException {
    if (tileNumber < 0 || tileNumber > getPosition()) {
      throw new IllegalArgumentException("Invalid tile to move back to.");
    }
    setPosition(tileNumber);
  }
}
