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

  private SnakesAndLaddersPiece piece;
  /**
   * Constructor for the SnakesAndLaddersPlayer class.
   *
   * @param inputName the name of the player.
   */
  public SnakesAndLaddersPlayer(final String inputName, final String inputPiece) {
    super(inputName);
    setPiece(inputPiece);
  }

  /**
   * Sets the piece of the player.
   *
   * @param inputPiece the piece of the player.
   * @throws IllegalArgumentException if the piece is null or empty.
   */
  public void setPiece(final String inputPiece) throws IllegalArgumentException {
    if (inputPiece == null || inputPiece.isBlank()) {
      throw new IllegalArgumentException("Piece cannot be null or empty");
    }
    piece = SnakesAndLaddersPiece.fromString(inputPiece);
  }

  public String getPiece() {
    return piece.getValue();
  }
}
