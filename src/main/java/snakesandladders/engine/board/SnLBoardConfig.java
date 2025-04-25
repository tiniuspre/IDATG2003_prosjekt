package snakesandladders.engine.board;

import snakesandladders.engine.board.tile.Jump;

import java.util.List;

public final class SnLBoardConfig {
  private List<Jump> snakes;
  private List<Jump> ladders;
  private List<Jump> switches;

  /**
   * Constructor for the SnLBoardConfig class.
   *
   * @param inputSnakes the list of snakes.
   * @param inputLadders the list of ladders.
   */
  public SnLBoardConfig(final List<Jump> inputSnakes,
                        final List<Jump> inputLadders,
                        final List<Jump> inputSwitches) {
    setSnakes(inputSnakes);
    setLadders(inputLadders);
    setSwitches(inputSwitches);
  }

  /**
   * Gets the list of snakes.
   *
   * @return the list of snakes.
   */
  public List<Jump> getSnakes() {
    return snakes;
  }

  /**
   * Sets the list of snakes.
   *
   * @param inputSnakes the list of snakes.
   */
  public void setSnakes(final List<Jump> inputSnakes) {
    this.snakes = inputSnakes;
  }

  /**
   * Gets the list of ladders.
   *
   * @return the list of ladders.
   */
  public List<Jump> getLadders() {
    return ladders;
  }

  /**
   * Sets the list of ladders.
   *
   * @param inputLadders the list of ladders.
   */
  public void setLadders(final List<Jump> inputLadders) {
    this.ladders = inputLadders;
  }

  /**
   * Gets the list of switches.
   *
   * @return the list of switches.
   */
  public List<Jump> getSwitches() {
    return switches;
  }

  /**
   * Sets the list of switches.
   *
   * @param inputSwitches the list of switches.
   */
  public void setSwitches(final List<Jump> inputSwitches) {
    this.switches = inputSwitches;
  }
}
