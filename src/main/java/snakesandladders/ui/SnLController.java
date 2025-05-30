package snakesandladders.ui;

import constants.Constants;
import gameengine.board.Board;
import gameengine.board.BoardFactory;
import snakesandladders.SnakesAndLadders;
import snakesandladders.engine.SnLGameContext;
import snakesandladders.engine.SnLPlayer;
import snakesandladders.engine.board.SnLBoard;
import snakesandladders.engine.board.SnLBoardException;
import ui.util.DialogUtil;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static constants.GameConstants.SNL_TITLE;

/**
 * The {@code SnLController} class is responsible for
 * controlling the UI of the Snakes and Ladders Game.
 * It handles all changes to the UI and updates the game state
 * based on user interactions.
 *
 * @author jonastomren
 * @version 19.05.2025
 * @since 19.05.2025
 *
 * @see SnLView
 */
public class SnLController {

  /**
   * The game instance.
   */
  private final SnakesAndLadders game;
  /**
   * The board UI.
   */
  private final SnLView boardUI;
  /**
   * The index of the current player.
   */
  private int currentPlayerIndex = 0;

  /**
   * Constructs a SnLController with the given view and game instance.
   *
   * @param view the SnLView instance.
   * @param gameInstance the SnakesAndLadders game instance.
   */
  public SnLController(final SnLView view,
                       final SnakesAndLadders gameInstance) {
    boardUI = view;
    game = gameInstance;
    init();
  }

  /**
   * Initializes the controller by setting up the next turn button action.
   */
  public void init() {
    boardUI.getNextTurnBtn().setOnAction(e -> handleNextTurn());
    boardUI.getCurrentPlayerLabel().setText("Player: "
        + getCurrentPlayer().getName());
  }

  /**
   * Handles the logic for the next turn, including moving the current player,
   * updating the UI, and checking for game completion.
   */
  private void handleNextTurn() {
    if (!game.isNotFinished()) {
      boardUI.getStatusLabel().setText("Game Over! Winner: "
          + game.getWinner().getName());
      return;
    }

    SnLPlayer current = getCurrentPlayer();
    int roll = game.playOneTurn(current);

    boardUI.getStatusLabel().setText(current.getName()
        + " rolled a " + roll
        + " and is now at tile " + current.getPosition());

    boardUI.updatePlayers();

    if (!game.isNotFinished()) {
      boardUI.getStatusLabel().setText("Game Over! "
          + current.getName() + " wins!");
      DialogUtil.info("Winner", "Winner: " + game.getWinner().getName());
      game.getWinner().registerWin(SNL_TITLE, 1);
      return;
    }

    nextPlayer();
    boardUI.getCurrentPlayerLabel().setText("Player: "
        + getCurrentPlayer().getName());
  }

  /**
   * Advances to the next player in the list.
   */
  private void nextPlayer() {
    currentPlayerIndex++;
    if (currentPlayerIndex >= game.getPlayers().size()) {
      currentPlayerIndex = 0;
    }
  }

  /**
   * Returns the current player.
   *
   * @return the current player.
   */
  private SnLPlayer getCurrentPlayer() {
    List<SnLPlayer> p = game.getPlayers();
    return p.get(currentPlayerIndex);
  }

  /**
   * Handles the selection of pieces for each player.
   *
   * @param result the result of the piece selection dialog.
   * @return true if the selection was successful, false otherwise.
   */
  public static boolean handlePieceSelection(
      final Optional<Map<SnLPlayer, String>> result) {
    if (result.isPresent()) {
      Map<SnLPlayer, String> selectedPieces = result.get();
      for (Map.Entry<SnLPlayer, String> entry : selectedPieces.entrySet()) {
        SnLPlayer player = entry.getKey();
        player.setPiece(entry.getValue());
      }
      return true;
    }
    return false;
  }

  /**
   * Handles the selection of the board.
   *
   * @param result the result of the board selection dialog.
   * @return true if the selection was successful, false otherwise.
   */
  public static boolean handleBoardSelection(final Optional<String> result) {
    if (result.isPresent()) {
      String selectedBoard = result.get();
      SnLGameContext context = SnLGameContext.getInstance();
      Optional<Board> loadedBoard = BoardFactory
          .createBoard(Constants.SNL_BOARD,
          selectedBoard);
      if (loadedBoard.isPresent()) {
        context.setBoard((SnLBoard) loadedBoard.get());
      } else {
        throw new SnLBoardException("Failed to load the board.");
      }
      return true;
    }
    return false;
  }
}
