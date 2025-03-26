package snakesandladders.ui;

import java.util.HashMap;
import java.util.Map;

import gameengine.board.Tile;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import renderengine.AbstractBoardUI;
import snakesandladders.SnakesAndLadders;
import snakesandladders.engine.SnakesAndLaddersBoard;
import snakesandladders.engine.SnakesAndLaddersPlayer;
import snakesandladders.engine.actions.LadderAction;
import snakesandladders.engine.actions.SnakeAction;
import snakesandladders.engine.tiles.LadderTile;
import snakesandladders.engine.tiles.SnakeTile;

/**
 * Board UI for Snakes and Ladders (JavaFX).
 * - Inverts Y so row=1 is the bottom row.
 * - Draws lines for snakes (red) and ladders (green).
 * - Draws arrows from tile n to tile (n+1).
 *
 * @author tiniuspre
 * @version 25.03.2025
 * @since 25.03.2025
 */
public class SnakesAndLaddersBoardUI extends AbstractBoardUI {

  private final SnakesAndLadders game;
  private final SnakesAndLaddersBoard board;

  private final Map<SnakesAndLaddersPlayer, SnakesAndLaddersPlayerUI> playerUIs
      = new HashMap<>();

  // TODO: Change with file handling
  private final int tileSize = 50;

  /**
   * Constructs a SnakesAndLaddersBoardUI with the given game.
   *
   * @param game the Snakes and Ladders game instance.
   */
  public SnakesAndLaddersBoardUI(SnakesAndLadders game) {
    this.game = game;
    this.board = game.getBoard();
  }

  /**
   * Renders the game board, including tiles, arrows, snakes, ladders, and player pieces.
   *
   * TODO: Change with file handling
   */
  @Override
  public void renderBoard() {
    boardRoot.getChildren().clear();

    // 1) Draw each tile (with ID text)
    board.getTiles().values().forEach(tile -> {
      SnakesAndLaddersTileUI tileUI =
          new SnakesAndLaddersTileUI(tileSize, tile, board.getHeight());
      // The tileUI returns a Group containing the rectangle + tile number text
      boardRoot.getChildren().add(tileUI.createTileNode());
    });

    // 2) Draw tile->tile arrows
    drawTileArrows();

    // 3) Draw lines for snakes & ladders
    drawSnakesAndLadders();

    // 4) Create and add player pieces
    for (SnakesAndLaddersPlayer p : game.getPlayers()) {
      SnakesAndLaddersPlayerUI playerUI
          = new SnakesAndLaddersPlayerUI(tileSize, p, board.getHeight());
      playerUIs.put(p, playerUI);

      boardRoot.getChildren().add(playerUI.createPlayerNode());
      updatePlayerPosition(p);
    }
  }

  /**
   * Draws small arrows from tile n to tile (n+1).
   */
  private void drawTileArrows() {
    int size = board.getBoardSize();
    // For each tile from 1 to (last-1), draw an arrow to the next tile
    for (int i = 1; i < size; i++) {
      Tile startTile = board.getTile(i);
      Tile endTile = board.getTile(i + 1);

      double startX = (startTile.getPosX() - 1) * tileSize + tileSize / 2.0;
      double startY = (board.getHeight() - startTile.getPosY()) * tileSize
          + tileSize / 2.0;

      double endX = (endTile.getPosX() - 1) * tileSize + tileSize / 2.0;
      double endY = (board.getHeight() - endTile.getPosY()) * tileSize
          + tileSize / 2.0;

      // Draw the line
      Line line = new Line(startX, startY, endX, endY);
      line.setStroke(Color.DARKGRAY);
      line.setStrokeWidth(1.0);

      // Create a small arrowhead polygon
      Polygon arrowHead = createArrowHead(startX, startY, endX, endY);

      // Group them so we can add to the Pane
      Group arrowGroup = new Group(line, arrowHead);
      boardRoot.getChildren().add(arrowGroup);
    }
  }

  /**
   * Helper to create a small arrowhead near (endX, endY) pointing from
   * (startX, startY) -> (endX, endY).
   *
   * @param startX the starting X coordinate.
   * @param startY the starting Y coordinate.
   * @param endX the ending X coordinate.
   * @param endY the ending Y coordinate.
   * @return a Polygon representing the arrowhead.
   */
  private Polygon createArrowHead(double startX, double startY,
                                  double endX, double endY) {
    // A small triangle polygon around (0,0)
    Polygon arrowHead = new Polygon(
        0, 0,
        -6, -3,
        -6, 3
    );
    arrowHead.setFill(Color.DARKGRAY);

    // Angle of the line
    double angle = Math.atan2(endY - startY, endX - startX);

    // Move the arrowhead to (endX, endY)
    arrowHead.setTranslateX(endX);
    arrowHead.setTranslateY(endY);

    // Rotate to point in direction of the line
    arrowHead.setRotate(Math.toDegrees(angle));

    return arrowHead;
  }

  /**
   * Draws lines for snakes (red) and ladders (green).
   */
  private void drawSnakesAndLadders() {
    for (Tile tile : board.getTiles().values()) {
      if (tile instanceof SnakeTile) {
        SnakeAction snakeAction = (SnakeAction) tile.getAction();
        int head = tile.getNumber();
        int tail = snakeAction.landAction(head);
        if (head > tail) {
          drawLine(head, tail, Color.RED);
        }
      } else if (tile instanceof LadderTile) {
        LadderAction ladderAction = (LadderAction) tile.getAction();
        int bottom = tile.getNumber();
        int top = ladderAction.landAction(bottom);
        if (bottom < top) {
          drawLine(bottom, top, Color.GREEN);
        }
      }
    }
  }

  /**
   * Draws a thicker line from tile startNum to endNum, used for snakes & ladders.
   *
   * @param startNum the starting tile number.
   * @param endNum the ending tile number.
   * @param color the color of the line.
   */
  private void drawLine(int startNum, int endNum, Color color) {
    Tile startTile = board.getTile(startNum);
    Tile endTile = board.getTile(endNum);

    double startX = (startTile.getPosX() - 1) * tileSize + tileSize / 2.0;
    double startY = (board.getHeight() - startTile.getPosY()) * tileSize
        + tileSize / 2.0;

    double endX = (endTile.getPosX() - 1) * tileSize + tileSize / 2.0;
    double endY = (board.getHeight() - endTile.getPosY()) * tileSize
        + tileSize / 2.0;

    Line line = new Line(startX, startY, endX, endY);
    line.setStroke(color);
    line.setStrokeWidth(3.0);

    boardRoot.getChildren().add(line);
  }

  /**
   * Called after a turn, repositions every player's piece.
   */
  public void updatePlayers() {
    for (SnakesAndLaddersPlayer p : game.getPlayers()) {
      updatePlayerPosition(p);
    }
  }

  /**
   * Updates the position of a player's piece on the board.
   *
   * @param p the player whose position is to be updated.
   */
  private void updatePlayerPosition(SnakesAndLaddersPlayer p) {
    SnakesAndLaddersPlayerUI ui = playerUIs.get(p);
    if (ui == null) return;

    int tileNum = p.getPosition();
    Tile tile = board.getTile(tileNum);

    double xPos = (tile.getPosX() - 1) * tileSize + tileSize * 0.2;
    double yPos = (board.getHeight() - tile.getPosY()) * tileSize
        + tileSize * 0.2;

    ui.updatePlayerPosition(xPos, yPos);
  }
}