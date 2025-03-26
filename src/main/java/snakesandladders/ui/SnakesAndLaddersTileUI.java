package snakesandladders.ui;

import gameengine.board.Tile;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import renderengine.AbstractTileUI;

/**
 * Concrete tile UI for a single tile in Snakes and Ladders,
 * also showing the tile ID in the top-right corner.
 */
public class SnakesAndLaddersTileUI extends AbstractTileUI {

  private final int tileSize;
  private final Tile tile;
  private final int boardHeight;

  /**
   * Constructs a SnakesAndLaddersTileUI with the given parameters.
   *
   * @param tileSize the size of the tile.
   * @param tile the tile instance.
   * @param boardHeight the height of the board.
   */
  public SnakesAndLaddersTileUI(int tileSize, Tile tile, int boardHeight) {
    this.tileSize = tileSize;
    this.tile = tile;
    this.boardHeight = boardHeight;
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
    if (tile.getNumber() % 2 == 0) {
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
    Text tileNumberText = new Text(String.valueOf(tile.getNumber()));
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
   * Updates the tile node’s state (not used in this implementation).
   *
   * @param state any state or parameter you need to pass in.
   */
  @Override
  public void updateTileState(Object state) {
    // Not used
  }
}
