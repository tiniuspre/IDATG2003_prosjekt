package snakesandladders.ui;

import constants.Constants;
import constants.UiConstants;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import snakesandladders.SnakesAndLadders;
import snakesandladders.engine.SnLPiece;
import snakesandladders.engine.SnLPlayer;
import snakesandladders.engine.board.SnLBoard;
import snakesandladders.engine.board.tile.SnLTile;
import ui.GameId;
import ui.launcher.Router;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;
import java.util.Arrays;

/**
 * The {@code SnLView} class is responsible
 * for initializing and managing the Snakes and Ladders game UI.
 * Together with the {@link SnLController} class,
 * it handles all changes to the UI.
 *
 * @author jonastomren
 * @version 19.05.2025
 * @since 19.05.2025
 *
 * @see SnLController
 */
public class SnLView extends VBox {
  /**
   * The root pane for the game board UI.
   */
  private final Pane boardRoot = new Pane();
  /**
   * The Snakes and Ladders game instance.
   */
  private final SnakesAndLadders game;
  /**
   * The game board.
   */
  private SnLBoard board;
  /**
   * Map of player -> player UI.
   */
  private final Map<SnLPlayer, SnakesAndLaddersPlayerUI> playerUIs
      = new HashMap<>();
  /**
   * The size of a tile in pixels.
   */
  private static final int TILE_SIZE = UiConstants.SNL_TILE_SIZE;
  /**
   * The status label.
   */
  private Label statusLabel;
  /**
   * The current player label.
   */
  private Label currentPlayerLabel;
  /**
   * The button to proceed to the next turn.
   */
  private Button nextTurnBtn;

  /**
   * The flag to check if the UI is initialized.
   */
  private boolean isInitialized = false;

  /**
   * Constructs a SnLView with the given game instance.
   * And then initializes the UI components.
   *
   * @param gameInstance the Snakes and Ladders game instance.
   */
  public SnLView(final SnakesAndLadders gameInstance) {
    this.game = gameInstance;
    if (showPieceSelectionPopup(game.getPlayers())
        && showBoardSelectionPopup()) {
      game.setBoard();
      this.board = game.getBoard();
      initializeUI();
      isInitialized = true;
    } else {
      Router.launch(GameId.MAIN_MENU);
    }
  }

  /**
   * Initializes the UI components and sets up the game.
   */
  public void initializeUI() {
    game.setBoard();

    renderBoard();

    VBox sidePanel = new VBox(UiConstants.SNL_SIDE_PANEL_WIDTH);
    sidePanel.setPrefWidth(UiConstants.SNL_SIDE_PANEL_PREF_WIDTH);

    currentPlayerLabel = new Label("Player: ");
    sidePanel.getChildren().add(currentPlayerLabel);

    statusLabel = new Label("Snakes and Ladders!");
    sidePanel.getChildren().add(statusLabel);

    nextTurnBtn = new Button("Next Turn");
    sidePanel.getChildren().add(nextTurnBtn);

    sidePanel.setAlignment(Pos.CENTER);
    getChildren().addAll(boardRoot, sidePanel);
  }

  /**
   * Returns the button for the next turn.
   *
   * @return the button for the next turn.
   */
  public Button getNextTurnBtn() {
    return nextTurnBtn;
  }

  /**
   * Returns the status label.
   *
   * @return the status label.
   */
  public Label getStatusLabel() {
    return statusLabel;
  }

  /**
   * Returns the current player label.
   *
   * @return the current player label.
   */
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
    getBoardRoot().setTranslateX(UiConstants.SNL_GAME_OFFSET);

    board.getTiles().forEach(tile -> {
      SnakesAndLaddersTileUI tileUI =
          new SnakesAndLaddersTileUI(TILE_SIZE, tile, board.getHeight());
      getBoardRoot().getChildren().add(tileUI.createTileNode());
    });

    drawTileArrows();

    drawSnakesAndLadders();

    for (SnLPlayer p : game.getPlayers()) {
      SnakesAndLaddersPlayerUI playerUI
          = new SnakesAndLaddersPlayerUI(TILE_SIZE, p, board.getHeight());
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
    for (int i = 1; i < size - 1; i++) {
      SnLTile startTile = board.getTile(i);
      SnLTile endTile = board.getTile(i + 1);

      double startX = (startTile.getPosX() - 1) * TILE_SIZE + TILE_SIZE / 2.0;
      double startY = (board.getHeight() - startTile.getPosY()) * TILE_SIZE
          + TILE_SIZE / 2.0;

      double endX = (endTile.getPosX() - 1) * TILE_SIZE + TILE_SIZE / 2.0;
      double endY = (board.getHeight() - endTile.getPosY()) * TILE_SIZE
          + TILE_SIZE / 2.0;

      Line line = new Line(startX, startY, endX, endY);
      line.setStroke(Color.DARKGRAY);
      line.setStrokeWidth(1.0);

      Polygon arrowHead = createArrowHead(startX, startY, endX, endY);

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
    int arrowSize = UiConstants.SNL_ARROW_SIZE;
    int arrowHeadSize = UiConstants.SNL_ARROW_HEAD_SIZE;
    Polygon arrowHead = new Polygon(
        0, 0,
        -arrowSize, -arrowHeadSize,
        -arrowSize, arrowSize
    );
    arrowHead.setFill(Color.DARKGRAY);

    double angle = Math.atan2(endY - startY, endX - startX);

    arrowHead.setTranslateX(endX);
    arrowHead.setTranslateY(endY);

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

    double startX = (startTile.getPosX() - 1) * TILE_SIZE + TILE_SIZE / 2.0;
    double startY = (board.getHeight() - startTile.getPosY()) * TILE_SIZE
        + TILE_SIZE / 2.0;

    double endX = (endTile.getPosX() - 1) * TILE_SIZE + TILE_SIZE / 2.0;
    double endY = (board.getHeight() - endTile.getPosY()) * TILE_SIZE
        + TILE_SIZE / 2.0;

    Line line = new Line(startX, startY, endX, endY);
    line.setStroke(color);
    line.setStrokeWidth(UiConstants.SNL_LINE_WIDTH);

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

    double xPos = (tile.getPosX() - 1) * TILE_SIZE + TILE_SIZE
        * UiConstants.SNL_PLAYER_ICON_RADIUS;
    double yPos = (board.getHeight() - tile.getPosY()) * TILE_SIZE
        + TILE_SIZE * UiConstants.SNL_PLAYER_ICON_RADIUS;

    ui.updatePlayerPosition(xPos, yPos);
  }

  /**
   * Displays a popup dialog for selecting pieces for each player.
   *
   * @param players the list of players to select pieces for.
   * @return true if the user confirmed the selection, false otherwise.
   */
  private boolean showPieceSelectionPopup(final List<SnLPlayer> players) {
    Dialog<Map<SnLPlayer, String>> dialog = new Dialog<>();
    dialog.setTitle("Select Player Pieces");
    dialog.setHeaderText("Select pieces for each player:");

    ButtonType okButtonType = new ButtonType("OK",
        ButtonBar.ButtonData.OK_DONE);
    dialog.getDialogPane().getButtonTypes().addAll(okButtonType,
        ButtonType.CANCEL);

    VBox content = new VBox(UiConstants.TTT_SPACING);
    Map<SnLPlayer, ComboBox<String>> playerPieceSelectors = new HashMap<>();
    List<String> availablePieces = Arrays.stream(SnLPiece.values())
        .map(SnLPiece::name)
        .toList();

    for (SnLPlayer player : players) {
      Label playerLabel = new Label(player.getName());
      ComboBox<String> pieceSelector = new ComboBox<>();
      pieceSelector.getItems().addAll(availablePieces);
      pieceSelector.setValue(player.getPiece());
      playerPieceSelectors.put(player, pieceSelector);

      content.getChildren().addAll(playerLabel, pieceSelector);
    }

    dialog.getDialogPane().setContent(content);

    dialog.setResultConverter(dialogButton -> {
      if (dialogButton == okButtonType) {
        Map<SnLPlayer, String> selectedPieces = new HashMap<>();
        for (Map.Entry<SnLPlayer, ComboBox<String>>
            entry : playerPieceSelectors.entrySet()) {
          selectedPieces.put(entry.getKey(), entry.getValue().getValue());
        }
        return selectedPieces;
      }
      return null;
    });

    Optional<Map<SnLPlayer, String>> result = dialog.showAndWait();
    return SnLController.handlePieceSelection(result);
  }

  /**
   * Displays a popup dialog for selecting the game board.
   *
   * @return true if the user confirmed the selection, false otherwise.
   */
  private boolean showBoardSelectionPopup() {
    Dialog<String> dialog = new Dialog<>();
    dialog.setTitle("Select Board");
    dialog.setHeaderText("Select a board:");

    ButtonType okButtonType = new ButtonType("OK",
        ButtonBar.ButtonData.OK_DONE);
    dialog.getDialogPane().getButtonTypes().addAll(okButtonType,
        ButtonType.CANCEL);

    VBox content = new VBox(UiConstants.TTT_SPACING);
    ComboBox<String> boardSelector = new ComboBox<>();
    boardSelector.getItems().addAll(Constants.BOARD_NAMES);
    content.getChildren().addAll(boardSelector);

    dialog.getDialogPane().setContent(content);

    dialog.setResultConverter(dialogButton -> {
      if (dialogButton == okButtonType) {
        return boardSelector.getValue();
      }
      return null;
    });

    Optional<String> result = dialog.showAndWait();
    return SnLController.handleBoardSelection(result);
  }

  /**
   * Returns whether the UI is initialized.
   *
   * @return true if the UI is initialized, false otherwise.
   */
  public boolean isInitialized() {
    return isInitialized;
  }
}
