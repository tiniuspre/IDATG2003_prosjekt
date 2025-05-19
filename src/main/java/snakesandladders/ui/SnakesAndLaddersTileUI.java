package snakesandladders.ui;

import constants.UiConstants;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import snakesandladders.engine.board.tile.SnLTile;

/**
 * Concrete tile UI for a single tile in Snakes and Ladders,
 * also showing the tile ID in the top-right corner.
 *
 * @author tiniuspre
 * @version 25.03.2025
 * @since 25.03.2025
 */
public class SnakesAndLaddersTileUI {
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
  public Node createTileNode() {
    Rectangle rect = new Rectangle(tileSize, tileSize);
    // add tile color
    if (tile.getPosition() % 2 == 0) {
      rect.setFill(Color.LIGHTGRAY);
    } else {
      rect.setFill(Color.WHITE);
    }
    rect.setStroke(Color.BLACK);
    // add tile node
    double xPos = (tile.getPosX() - 1) * tileSize;
    double yPos = (boardHeight - tile.getPosY()) * tileSize;
    rect.setTranslateX(xPos);
    rect.setTranslateY(yPos);
    // add tile number
    Text tileNumberText = new Text(String.valueOf(tile.getPosition()));
    tileNumberText.setFont(Font.font(UiConstants.SNL_FONT_SIZE));
    // add text position
    double textX = xPos + (tileSize - UiConstants.SNL_TILE_TEXT_OFFSET_X);
    double textY = yPos + UiConstants.SNL_TILE_TEXT_OFFSET_Y;
    tileNumberText.setX(textX);
    tileNumberText.setY(textY);
    return new Group(rect, tileNumberText);
  }
}
