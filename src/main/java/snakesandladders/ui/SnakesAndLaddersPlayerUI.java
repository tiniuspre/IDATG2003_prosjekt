package snakesandladders.ui;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import renderengine.AbstractPlayerUI;
import snakesandladders.engine.SnakesAndLaddersPlayer;

/**
 * Player UI for Snakes and Ladders: draws a circle for the token.
 *
 * @author tiniuspre
 * @version 25.03.2025
 * @since 25.03.2025
 */
public class SnakesAndLaddersPlayerUI extends AbstractPlayerUI {

  private int tileSize;
  private SnakesAndLaddersPlayer player;
  private Circle pieceNode;

  /**
   * Constructs a SnakesAndLaddersPlayerUI with the given parameters.
   *
   * @param tileSize the size of the tile.
   * @param player the player instance.
   * @param boardHeight the height of the board.
   */
  public SnakesAndLaddersPlayerUI(int tileSize,
                                  SnakesAndLaddersPlayer player,
                                  int boardHeight) {
    setTileSize(tileSize);
    setPlayer(player);
    setBoardHeight(boardHeight);
  }

  private void setTileSize(int tileSize) {
    this.tileSize = tileSize;
  }

  private void setPlayer(SnakesAndLaddersPlayer player) {
    this.player = player;
  }

  private SnakesAndLaddersPlayer getPlayer() {
    return player;
  }

  private void setBoardHeight(int boardHeight) {
  }

  private void setPieceNode(Circle pieceNode) {
    this.pieceNode = pieceNode;
  }


  /**
   * Creates and returns the visual representation of the player.
   *
   * @return a Node representing the player's piece.
   *
   * TODO: Change with file handling
   */
  @Override
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
  @Override
  public void updatePlayerPosition(double newX, double newY) {
    if (this.pieceNode != null) {
      this.pieceNode.setTranslateX(newX);
      this.pieceNode.setTranslateY(newY);
    }
  }

  /**
   * Updates the player info (not used in this implementation).
   *
   * @param info some player info to display.
   */
  @Override
  public void updatePlayerInfo(Object info) {
    // Not used
  }
}
