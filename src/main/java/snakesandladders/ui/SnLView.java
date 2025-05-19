package snakesandladders.ui;

import constants.Constants;
import constants.UiConstants;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import snakesandladders.SnakesAndLadders;
import snakesandladders.engine.SnLPlayer;
import snakesandladders.engine.board.SnLBoard;
import snakesandladders.engine.board.tile.SnLTile;

import java.util.HashMap;
import java.util.Map;

public class SnLView extends VBox {

  private final Pane boardRoot = new Pane();
  /**
   * The Snakes and Ladders game instance.
   */
  private final SnakesAndLadders game;
  /**
   * The game board.
   */
  private final SnLBoard board;
  /**
   * Map of player -> player UI.
   */
  private final Map<SnLPlayer, SnakesAndLaddersPlayerUI> playerUIs
      = new HashMap<>();
  /**
   * The size of a tile in pixels.
   */
  private final int tileSize = UiConstants.SNL_TILE_SIZE;
  /**
   * The status label.
   */
  private Label statusLabel;
  /**
   * The current player label.
   */
  private Label currentPlayerLabel;

  private Button nextTurnBtn;


  public SnLView(final SnakesAndLadders gameInstance) {
    this.game = gameInstance;
    this.board = game.getBoard();
    initializeUI();
  }

  /**
   * Initializes the UI components and sets up the game.
   */
  public void initializeUI() {
    game.setBoard(); // build the board with snakes/ladders

    // Draw the board
    renderBoard();

    // Side panel with current player + status
    VBox sidePanel = new VBox(10);
    sidePanel.setPrefWidth(240);

    currentPlayerLabel = new Label("Player: ");
    sidePanel.getChildren().add(currentPlayerLabel);

    statusLabel = new Label("Snakes and Ladders!");
    sidePanel.getChildren().add(statusLabel);

    nextTurnBtn = new Button("Next Turn");
    sidePanel.getChildren().add(nextTurnBtn);

    // Layout
    BorderPane root = new BorderPane();
    root.setCenter(getBoardRoot());
    root.setRight(sidePanel);
    getChildren().addAll(boardRoot, sidePanel);
  }

  public Button getNextTurnBtn() {
    return nextTurnBtn;
  }

  public Label getStatusLabel() {
    return statusLabel;
  }

  public Label getCurrentPlayerLabel() {
    return currentPlayerLabel;
  }

  /**
   * Returns the root pane of the board UI.
   * This method provides access to the root Pane
   * that contains the board's visual elements.
   *
   * @return the root Pane of the board UI
   */
  public Pane getBoardRoot() {
    return boardRoot;
  }

  /**
   * Renders the game board, including tiles,
   * arrows, snakes, ladders, and player pieces.
   */
  public void renderBoard() {
    getBoardRoot().getChildren().clear();
    getBoardRoot().setTranslateX(100);

    // 1) Draw each tile (with ID text)
    board.getTiles().forEach(tile -> {
      SnakesAndLaddersTileUI tileUI =
          new SnakesAndLaddersTileUI(tileSize, tile, board.getHeight());
      // The tileUI returns a Group containing the rectangle + tile number text
      getBoardRoot().getChildren().add(tileUI.createTileNode());
    });

    // 2) Draw tile->tile arrows
    drawTileArrows();

    // 3) Draw lines for snakes & ladders
    drawSnakesAndLadders();

    // 4) Create and add player pieces
    for (SnLPlayer p : game.getPlayers()) {
      SnakesAndLaddersPlayerUI playerUI
          = new SnakesAndLaddersPlayerUI(tileSize, p, board.getHeight());
      playerUIs.put(p, playerUI);

      getBoardRoot().getChildren().add(playerUI.createPlayerNode());
      updatePlayerPosition(p);
    }
  }

  /**
   * Draws small arrows from tile n to tile (n+1).
   */
  private void drawTileArrows() {
    int size = board.getBoardSize();
    // For each tile from 1 to (last-1), draw an arrow to the next tile
    for (int i = 1; i < size-1; i++) {
      SnLTile startTile = board.getTile(i);
      SnLTile endTile = board.getTile(i + 1);

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
      getBoardRoot().getChildren().add(arrowGroup);
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
  private Polygon createArrowHead(final double startX, final double startY,
                                  final double endX, final double endY) {
    // A small triangle polygon around (0,0)
    int arrowSize = UiConstants.SNL_ARROW_SIZE;
    int arrowHeadSize = UiConstants.SNL_ARROW_HEAD_SIZE;
    Polygon arrowHead = new Polygon(
        0, 0,
        -arrowSize, -arrowHeadSize,
        -arrowSize, arrowSize
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
    for (SnLTile tile : board.getTiles()) {
      if (tile.getType().equals(Constants.SNAKE)) {
        int head = tile.getPosition();
        int tail = tile.getNext();
        if (head > tail) {
          drawLine(head, tail, Color.RED);
        }
      } else if (tile.getType().equals(Constants.LADDER)) {
        int bottom = tile.getPosition();
        int top = tile.getNext();
        if (bottom < top) {
          drawLine(bottom, top, Color.GREEN);
        }
      }
    }
  }

  /**
   * Draws a thicker line from tile startNum to endNum,
   * used for snakes & ladders.
   *
   * @param startNum the starting tile number.
   * @param endNum the ending tile number.
   * @param color the color of the line.
   */
  private void drawLine(
      final int startNum,
      final int endNum, final Color color) {
    SnLTile startTile = board.getTile(startNum);
    SnLTile endTile = board.getTile(endNum);

    double startX = (startTile.getPosX() - 1) * tileSize + tileSize / 2.0;
    double startY = (board.getHeight() - startTile.getPosY()) * tileSize
        + tileSize / 2.0;

    double endX = (endTile.getPosX() - 1) * tileSize + tileSize / 2.0;
    double endY = (board.getHeight() - endTile.getPosY()) * tileSize
        + tileSize / 2.0;

    Line line = new Line(startX, startY, endX, endY);
    line.setStroke(color);
    line.setStrokeWidth(3.0);

    getBoardRoot().getChildren().add(line);
  }

  /**
   * Called after a turn, repositions every player's piece.
   */
  public void updatePlayers() {
    for (SnLPlayer p : game.getPlayers()) {
      updatePlayerPosition(p);
    }
  }

  /**
   * Updates the position of a player's piece on the board.
   *
   * @param player the player whose position is to be updated.
   */
  private void updatePlayerPosition(final SnLPlayer player) {
    SnakesAndLaddersPlayerUI ui = playerUIs.get(player);
    if (ui == null) {
      return;
    }

    int tileNum = player.getPosition();
    SnLTile tile = board.getTile(tileNum);

    double xPos = (tile.getPosX() - 1) * tileSize + tileSize * 0.2;
    double yPos = (board.getHeight() - tile.getPosY()) * tileSize
        + tileSize * 0.2;

    ui.updatePlayerPosition(xPos, yPos);
  }
}
