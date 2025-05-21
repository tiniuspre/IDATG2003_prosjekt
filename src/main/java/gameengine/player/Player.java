package gameengine.player;

import com.opencsv.bean.CsvBindByName;
import constants.Constants;
import filehandler.csvhandling.CsvIgnore;
import gameengine.scoreboard.ScoreboardRegister;

/**
 * The {@code Player} class represents a player in the test
 * snakes and ladders game.
 *
 * @author jonastomren, tiniuspre
 * @version 21.05.2025
 * @since 13.02.2025
 */
public abstract class Player {
  /**
   * The name of the player.
   */
  @CsvBindByName(column = Constants.DECLARE_NAME)
  private String name;
  /**
   * The position of the player on the board.
   */
  @CsvIgnore
  private int position;

  /**
   * The scoreboard register for the player.
   */
  @CsvIgnore
  private final ScoreboardRegister scoreboardRegister =
      new ScoreboardRegister();

  /**
   * Constructor for the Player class.
   *
   * @param inputName the name of the player.
   */
  public Player(final String inputName) {
    setName(inputName);
    setPosition(0);
  }

  /**
   * Constructor for the Player class.
   * NOTE: Only for file handling.
   */
  public Player() {
  }

  /**
   * Sets the name of the player.
   *
   * @param inputName the name of the player.
   * @throws IllegalArgumentException if the name is null or empty.
   */
  public void setName(final String inputName) throws IllegalArgumentException {
    if (inputName == null || inputName.isBlank()) {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
    this.name = inputName;
  }

  /**
   * Returns the name of the player.
   *
   * @return the name of the player.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the inputPosition of the player on the board.
   *
   * @param inputPosition the inputPosition of the player.
   */
  public void setPosition(final int inputPosition)
      throws IllegalArgumentException {
    if (inputPosition < 0) {
      throw new IllegalArgumentException("Invalid inputPosition");
    }
    this.position = inputPosition;
  }

  /**
   * Registers a win for the player.
   * @param game the name of the game.
   * @param score the score of the player.
   */
  public void registerWin(final String game, final int score) {
    scoreboardRegister.addPlayerToScoreboard(this, game, score);
  }

  /**
   * Returns the position of the player on the board.
   *
   * @return the position of the player.
   */
  public int getPosition() {
    return position;
  }

}
