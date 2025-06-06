package snakesandladders;

import filehandler.csvhandling.CsvHandler;
import gameengine.Observer;
import gameengine.Subject;
import gameengine.dice.Dice;
import gameengine.player.Player;
import java.util.ArrayList;
import java.util.List;

import snakesandladders.engine.SnLGameContext;
import snakesandladders.engine.board.SnLBoard;
import snakesandladders.engine.SnLPlayer;
import snakesandladders.engine.board.SnLBoardException;
import snakesandladders.engine.board.SnLTileChecker;


/**
 * The {@code SnakesAndLadders} class represents the snakes and ladders game.
 *
 * <p>The game is played on a board with snakes and ladders.
 * The players take turns to roll dice
 * and move their pieces on the board. If a player lands on a snake tile,
 * the player moves back to the tail of the snake.
 * If a player lands on a ladder tile, the player climbs the ladder to the top.
 * The game is won by the player who reaches the end of the board first.</p>
 *
 * @author jonastomren
 * @version 25.04.2025
 * @since 26.02.2025
 * @see SnLBoard
 * @see SnLPlayer
 * @see Dice
 */
public class SnakesAndLadders implements Subject {
  /**
   * The game board for the Snakes and Ladders game.
   */
  private SnLBoard board;

  /**
   * The list of players in the game.
   */
  private final List<SnLPlayer> players = new ArrayList<>(addPlayers());
  /**
   * The current player in the game.
   */
  private SnLPlayer currentPlayer;
  /**
   * The dice used in the game.
   */
  private final Dice dice = new Dice(2);
  /**
   * The list of observers for the game.
   */
  private final List<Observer> observers = new ArrayList<>();

  /**
   * Default constructor for the {@code SnakesAndLadders} class.
   */
  public SnakesAndLadders() {
    // Default constructor
  }

  /**
   * Sets up the game board with snakes and ladders.
   */
  public void setBoard() {
    board = SnLGameContext.getInstance().getBoard();
    if (board == null) {
      throw new SnLBoardException("Failed to load board");
    }
    registerObserver(new SnLTileChecker());
  }

  /**
   * Plays one turn of the game.
   *
   * @param player the player to play the turn.
   * @return the number of spaces moved.
   */
  public int playOneTurn(final SnLPlayer player) {
    SnLGameContext context = SnLGameContext.getInstance();
    if (player.getPosition() >= board.getBoardSize()) {
      return 0;
    }
    int roll = dice.rollDice();
    int newPos = player.getPosition() + roll;
    if (newPos >= board.getBoardSize()) {
      player.setPosition(board.getBoardSize());
      return roll;
    }
    player.move(roll);
    context.setCurrentPlayer(player);
    setCurrentPlayer(player);
    notifyObservers();
    return roll;
  }

  /**
   * Returns the winner of the game.
   *
   * @return the winner of the game.
   */
  public Player getWinner() {
    Player winner = players.getFirst();
    for (Player player : players) {
      if (player.getPosition() > winner.getPosition()) {
        winner = player;
      }
    }
    return winner;
  }

  /**
   * Returns true if the game is not finished.
   *
   * @return true if the game is not finished.
   */
  public boolean isNotFinished() {
    for (Player player : players) {
      if (player.getPosition() >= board.getBoardSize()) {
        return false;
      }
    }
    return true;
  }

  /**
   * Returns the players in the game.
   *
   * @return the players in the game.
   */
  public List<SnLPlayer> getPlayers() {
    return new ArrayList<>(players);
  }

  /**
   * Returns the board.
   *
   * @return the board.
   */
  public SnLBoard getBoard() {
    return board;
  }

  /**
   * Sets the current player.
   *
   * @param player the current player.
   */
  public void setCurrentPlayer(final SnLPlayer player) {
    if (player == null) {
      throw new SnLBoardException("Current player cannot be null");
    }
    this.currentPlayer = player;
  }

  /**
   * Adds selected players to the game from a CSV file.
   *
   * @return a list of selected players.
   */
  private List<SnLPlayer> addPlayers() {
    CsvHandler csvHandler = new CsvHandler("player/selected_players.csv");
    return new ArrayList<>(csvHandler.readFromFile(SnLPlayer.class));
  }

  /**
   * Register an observer to the game.
   *
   * @param observer the observer to register.
   */
  @Override
  public void registerObserver(final Observer observer) {
    observers.add(observer);
  }

  /**
   * Unregister an observer from the game.
   *
   * @param observer the observer to unregister.
   */
  @Override
  public void removeObserver(final Observer observer) {
    observers.remove(observer);
  }

  /**
   * Notifies all observers.
   */
  @Override
  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update(currentPlayer);
    }
  }
}
