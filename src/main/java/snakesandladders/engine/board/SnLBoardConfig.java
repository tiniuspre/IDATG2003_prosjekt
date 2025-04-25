package snakesandladders.engine.board;

import com.fasterxml.jackson.annotation.JsonCreator;
import snakesandladders.engine.board.tile.Jump;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class SnLBoardConfig {


  private final List<Jump> jumps = new ArrayList<>();

  private final List<Jump> snakes = new ArrayList<>();
  private final List<Jump> ladders = new ArrayList<>();
  private final List<Jump> switches = new ArrayList<>();

  /**
   * Constructor for the SnLBoardConfig class.
   */
  @JsonCreator
  public SnLBoardConfig(final List<Jump> inputJumps) {
    setJumps(inputJumps);
  }

  public SnLBoardConfig() {
    // Default constructor
  }


  public void configureJumps(final List<Jump> inputJumps) {
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

  public void setJumps(final List<Jump> inputJumps) {
    this.jumps.clear();
    this.jumps.addAll(inputJumps);
    configureJumps(inputJumps);
  }

  public Stream<Jump> getSnakes() {
    return snakes.stream();
  }

  public Stream<Jump> getLadders() {
    return ladders.stream();
  }

  public Stream<Jump> getSwitches() {
    return switches.stream();
  }

  public Stream<Jump> getJumps() {
    return jumps.stream();
  }
}
