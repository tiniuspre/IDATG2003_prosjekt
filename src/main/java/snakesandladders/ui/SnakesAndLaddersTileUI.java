package snakesandladders.ui;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import renderengine.AbstractTileUI;
import snakesandladders.engine.board.tile.SnLTile;

/**
 * Concrete tile UI for a single tile in Snakes and Ladders,
 * also showing the tile ID in the top-right corner.
 *
 * @author tiniuspre
 * @version 25.03.2025
 * @since 25.03.2025
 */
public class SnakesAndLaddersTileUI extends AbstractTileUI {
  /**
   * The size of a tile in pixels.
   */
  private int tileSize;
  /**
   * The tile instance.
   */
  private SnLTile tile;
  /**
   * The height of the board.
   */
  private int boardHeight;

  /**
   * Constructs a SnakesAndLaddersTileUI with the given parameters.
   *
   * @param tileSizePx the size of the tile.
   * @param tileParam the tile instance.
   * @param boardHeightParam the height of the board.
   */
  public SnakesAndLaddersTileUI(
      final int tileSizePx,
      final SnLTile tileParam,
      final int boardHeightParam
  ) {
    setTileSize(tileSizePx);
    setTile(tileParam);
    setBoardHeight(boardHeightParam);
  }

  /**
   * Sets the size of the tile.
   *
   * @param tileSizePx the size of the tile in pixels.
   */
  private void setTileSize(final int tileSizePx) {
    this.tileSize = tileSizePx;
  }

  /**
   * Sets the tile instance.
   *
   * @param tileInstance the tile instance.
   */
  private void setTile(final SnLTile tileInstance) {
    this.tile = tileInstance;
  }

  /**
   * Sets the height of the board.
   *
   * @param boardHeightParam the height of the board.
   */
  private void setBoardHeight(final int boardHeightParam) {
    this.boardHeight = boardHeightParam;
  }

  /**
   * Creates and returns the visual representation of the tile.
   *
   * @return a Node representing the tile.
   */
  @Override
  public Node createTileNode() {
    // 1) Make the background rectangle
    Rectangle rect = new Rectangle(tileSize, tileSize);

    // Simple color alternation
    if (tile.getPosition() % 2 == 0) {
      rect.setFill(Color.LIGHTGRAY);
    } else {
      rect.setFill(Color.WHITE);
    }
    rect.setStroke(Color.BLACK);

    // Invert Y so row=1 is at bottom
    double xPos = (tile.getPosX() - 1) * tileSize;
    double yPos = (boardHeight - tile.getPosY()) * tileSize;

    rect.setTranslateX(xPos);
    rect.setTranslateY(yPos);

    // 2) Add the tile number text in the top-right corner
    Text tileNumberText = new Text(String.valueOf(tile.getPosition()));
    tileNumberText.setFont(Font.font(10));

    // Position offset: near top-right corner
    // We'll pad 2 px from top and 5 px from right
    double textX = xPos + (tileSize - 15);
    double textY = yPos + 12;
    // '12' so the text is near the top (font size ~10)

    tileNumberText.setX(textX);
    tileNumberText.setY(textY);

    // 3) Return a Group containing both the rectangle + the text
    Group group = new Group(rect, tileNumberText);
    return group;
  }

  /**
   * Updates the tile node\’s state (not used in this implementation).
   *
   * @param state any state or parameter you need to pass in.
   */
  @Override
  public void updateTileState(final Object state) {
    // Not used
  }
}
