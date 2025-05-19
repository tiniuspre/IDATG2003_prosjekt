package snakesandladders.ui;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import snakesandladders.engine.SnLPlayer;

/**
 * Player UI for Snakes and Ladders: draws a circle for the token.
 *
 * @author tiniuspre
 * @version 25.03.2025
 * @since 25.03.2025
 */
public class SnakesAndLaddersPlayerUI {
  /**
   * The size of a tile in pixels.
   */
  private int tileSize;
  /**
   * The player instance.
   */
  private SnLPlayer player;
  /**
   * The piece node.
   */
  private Circle pieceNode;

  /**
   * Constructs a SnakesAndLaddersPlayerUI with the given parameters.
   *
   * @param tileSizePx the size of the tile.
   * @param playerInstance the player instance.
   * @param boardHeight the height of the board.
   */
  public SnakesAndLaddersPlayerUI(final int tileSizePx,
                                  final SnLPlayer playerInstance,
                                  final int boardHeight) {
    setTileSize(tileSizePx);
    setPlayer(playerInstance);
    setBoardHeight(boardHeight);
  }

  /**
   * Sets the size of the tile.
   *
   * @param tileSizePx the size of the tile.
   */
  private void setTileSize(final int tileSizePx) {
    this.tileSize = tileSizePx;
  }

  /**
   * Sets the player instance.
   *
   * @param playerInstance the player instance.
   */
  private void setPlayer(final SnLPlayer playerInstance) {
    this.player = playerInstance;
  }

  /**
   * Returns the player instance.
   *
   * @return the player instance.
   */
  private SnLPlayer getPlayer() {
    return player;
  }

  /**
   * Sets the height of the board.
   *
   * @param boardHeight the height of the board.
   */
  private void setBoardHeight(final int boardHeight) {
  }

  /**
   * Sets the piece node.
   *
   * @param pieceNodeParam the piece node.
   */
  private void setPieceNode(final Circle pieceNodeParam) {
    this.pieceNode = pieceNodeParam;
  }

  /**
   * Creates and returns the visual representation of the player.
   *
   * @return a Node representing the player's piece.
   */
  public Node createPlayerNode() {
    setPieceNode(new Circle(tileSize * 0.2));

    switch (player.getPiece().toLowerCase()) {
      case "hat":
        this.pieceNode.setFill(Color.RED);
        break;
      case "car":
        this.pieceNode.setFill(Color.BLUE);
        break;
      case "cat":
        this.pieceNode.setFill(Color.YELLOW);
        break;
      default:
        this.pieceNode.setFill(Color.DARKGRAY);
    }

    // Start offscreen; the boardUI will place it properly.
    this.pieceNode.setTranslateX(-999);
    this.pieceNode.setTranslateY(-999);

    return this.pieceNode;
  }

  /**
   * Updates the player's piece position on the board.
   *
   * @param newX the new X coordinate.
   * @param newY the new Y coordinate.
   */
  public void updatePlayerPosition(final double newX, final double newY) {
    if (this.pieceNode != null) {
      this.pieceNode.setTranslateX(newX);
      this.pieceNode.setTranslateY(newY);
    }
  }
}
