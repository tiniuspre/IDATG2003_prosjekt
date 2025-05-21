package ui;

import gameengine.scoreboard.ScoreboardRegister;

public class ScoreBoardUi {
  /**
   * The score board instance.
   */
  private ScoreboardRegister scoreBoard;

  /**
   * Constructs a ScoreBoardUi with the specified score board.
   *
   */
  public ScoreBoardUi() {
    setScoreBoard(new ScoreboardRegister());
  }

  private void setScoreBoard(final ScoreboardRegister scoreBoardInst) {
    this.scoreBoard = scoreBoardInst;
  }

  /**
   * Displays the score board.
   */
  public void display() {
    // Implementation for displaying the score board
  }
}
