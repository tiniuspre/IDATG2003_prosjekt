package snakesandladders;

import gameengine.Player;
import gameengine.dice.Dice;
import java.util.ArrayList;
import java.util.List;
import snakesandladders.engine.SnakesAndLaddersBoard;
import snakesandladders.engine.SnakesAndLaddersPlayer;
import snakesandladders.engine.tiles.LadderTile;
import snakesandladders.engine.tiles.SnakeTile;

/**
 * The {@code TestGame} class represents the test snaked and ladders game.
 *
 * <p>The game is played on a board with snakes and ladders.
 * The players take turns to roll dice
 * and move their pieces on the board. If a player lands on a snake tile,
 * the player moves back to the tail of the snake.
 * If a player lands on a ladder tile, the player climbs the ladder to the top.
 * The game is won by the player who reaches the end of the board first.
 *
 * @author jonastomren, tiniuspre
 * @version 13.02.2025
 * @since 25.02.2025
 * @see SnakesAndLaddersBoard
 * @see SnakesAndLaddersPlayer
 * @see Dice
 */
public class SnakesAndLadders {
  /**
   * The game board with width 10 and height 9.
   */
  private final SnakesAndLaddersBoard board = new SnakesAndLaddersBoard(10, 9);
  /**
   * The list of players in the game.
   */
  private final List<SnakesAndLaddersPlayer> players = new ArrayList<>();
  private final Dice dice = new Dice(2); // 2 six-sided dice

  /**
   * Returns the game board.
   *
   * @return the game board.
   */
  public SnakesAndLaddersBoard getBoard() {
    return board;
  }

  /**
   * Returns the list of players in the game.
   *
   * @return the list of players.
   */
  public List<SnakesAndLaddersPlayer> getPlayers() {
    return players;
  }

  /**
   * Sets up the game board with snakes and ladders.
   */
  public void setBoard() {
    board.createBoard();
  }

  /**
   * Adds a player to the game and places the player on the first tile.
   *
   * @param name the name of the player.
   * @param piece the piece of the player.
   */
  public void addPlayer(final String name, final String piece) {
    SnakesAndLaddersPlayer player = new SnakesAndLaddersPlayer(name, piece);
    player.setPosition(1);
    players.add(player);
  }

  /**
   * Plays one round of the game.
   */
  public int playOneTurn(SnakesAndLaddersPlayer player) {
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

    if (board.getTile(player.getPosition()) instanceof SnakeTile) {
      landOnSnake(player);
    } else if (board.getTile(player.getPosition()) instanceof LadderTile) {
      landOnLadder(player);
    }

    return roll;
  }

  /**
   * Moves the player back to the tail of the snake.
   *
   * @param player the player to move back.
   */
  private void landOnSnake(final SnakesAndLaddersPlayer player) {
    SnakeTile snakeTile = (SnakeTile) board.getTile(player.getPosition());
    int tailPos = snakeTile.getAction().landAction(player.getPosition());

    player.moveBack(tailPos);
    System.out.println(player.getName()
        + " landed on a snake and moved back to position "
        + player.getPosition());
  }

  /**
   * Moves the player to the top of the ladder.
   *
   * @param player the player to move up the ladder.
   */
  public void landOnLadder(final SnakesAndLaddersPlayer player) {
    LadderTile ladderTile = (LadderTile)
        board.getTile(player.getPosition());
    player.move(ladderTile.getAction().landAction(player.getPosition()));
    System.out.println(player.getName()
        + " climbed a ladder to position " + player.getPosition());
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
}
