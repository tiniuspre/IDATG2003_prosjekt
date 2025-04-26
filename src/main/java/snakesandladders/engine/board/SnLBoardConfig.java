package snakesandladders.engine.board;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSetter;
import snakesandladders.engine.board.tile.Jump;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * The {@code SnLBoardConfig} class represents the configuration
 * of the Snakes and Ladders game board.
 *
 * @author jonastomren
 * @version 25.04.2025
 * @since 25.04.2025
 */
public final class SnLBoardConfig {

  /**
   * The list of jumps on the board.
   */
  private final List<Jump> jumps = new ArrayList<>();
  /**
   * The list of snakes on the board.
   */
  private final List<Jump> snakes = new ArrayList<>();
  /**
   * The list of ladders on the board.
   */
  private final List<Jump> ladders = new ArrayList<>();
  /**
   * The list of switches on the board.
   */
  private final List<Jump> switches = new ArrayList<>();

  /**
   * Constructor for the SnLBoardConfig class.
   *
   * @param inputJumps the list of jumps to configure.
   */
  @JsonCreator
  public SnLBoardConfig(final List<Jump> inputJumps) {
    setJumps(inputJumps);
  }

  /**
   * Default constructor for the SnLBoardConfig class.
   * This constructor is used for JSON deserialization.
   */
  @JsonCreator
  public SnLBoardConfig() {
    // Default constructor
  }

  /**
   * Configures the jumps on the board based on the input list.
   *
   * @param inputJumps the list of jumps to configure.
   */
  public void configureJumps(final List<Jump> inputJumps) {
    if (inputJumps == null || inputJumps.isEmpty()) {
      throw new SnLBoardException("Jumps cannot be null or empty.");
    }
    for (Jump jump : inputJumps) {
      if (jump.getFrom() > jump.getTo()) {
        snakes.add(jump);
      } else if (jump.getFrom() < jump.getTo()) {
        ladders.add(jump);
      } else {
        switches.add(jump);
      }
    }
  }

  /**
   * Sets the jumps on the board.
   *
   * @param inputJumps the list of jumps to set.
   */
  @JsonSetter("jumps")
  public void setJumps(final List<Jump> inputJumps) {
    if (inputJumps == null || inputJumps.isEmpty()) {
      throw new SnLBoardException("Jumps cannot be null or empty.");
    }
    this.jumps.clear();
    this.jumps.addAll(inputJumps);
    configureJumps(inputJumps);
  }

  /**
   * Gets the list of snakes on the board.
   *
   * @return a stream of the list of snakes on the board.
   */
  public Stream<Jump> getSnakes() {
    return snakes.stream();
  }

  /**
   * Gets the list of ladders on the board.
   *
   * @return a stream of the list of ladders on the board.
   */
  public Stream<Jump> getLadders() {
    return ladders.stream();
  }

  /**
   * Gets the list of switches on the board.
   *
   * @return a stream of the list of switches on the board.
   */
  public Stream<Jump> getSwitches() {
    return switches.stream();
  }
}
