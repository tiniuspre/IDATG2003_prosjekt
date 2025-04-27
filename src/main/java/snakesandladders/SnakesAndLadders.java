package snakesandladders;

import constants.Constants;
import gameengine.Observer;
import gameengine.Subject;
import gameengine.board.Board;
import gameengine.board.BoardFactory;
import gameengine.dice.Dice;
import gameengine.player.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
  private final List<SnLPlayer> players = new ArrayList<>();
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
  }

  /**
   * Sets up the game board with snakes and ladders.
   */
  public void setBoard() {
    Optional<Board> loadedBoard = BoardFactory.createBoard(
        Constants.SNL_BOARD, Constants.SNL_BOARD_NAME_CLASSIC);
    if (loadedBoard.isPresent()) {
      board = (SnLBoard) loadedBoard.get();
      SnLGameContext.getInstance().setBoard(board);
    } else {
      throw new SnLBoardException("Failed to load the board.");
    }
    registerObserver(new SnLTileChecker());
  }

  /**
   * Adds a player to the game.
   *
   * @param name the name of the player.
   * @param piece the piece of the player.
   */
  public void addPlayer(final String name, final String piece) {
    players.add(new SnLPlayer(name, piece));
  }

  /**
   * Plays one round of the game.
   */
  public void playOneRound() {
    SnLGameContext context = SnLGameContext.getInstance();
    context.setPlayers(players);
    for (SnLPlayer player : players) {
      context.setCurrentPlayer(player);
      this.currentPlayer = player;
      int roll = dice.rollDice();
      if (player.getPosition() + roll >= board.getBoardSize()) {
        reachedEndOfBoard(player);
      } else {
        player.move(roll);
        System.out.println(player.getName()
            + " rolled a " + roll
            + " and moved to position " + player.getPosition());
        notifyObservers();
      }
    }
  }

  /**
   * Moves the player to the end of the board.
   *
   * @param player the player to move to the end of the board.
   */
  public void reachedEndOfBoard(final Player player) {
    player.setPosition(board.getBoardSize());
    System.out.println(player.getName()
        + " has reached the end of the board.");
  }



  /**
   * Prints the status of the players in the game with their current positions.
   */
  public void printStatus() {
    for (Player player : players) {
      System.out.println(player.getName()
          + " is at position " + player.getPosition());
    }
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
