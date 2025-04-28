package gameengine.grid;

import gameengine.player.Player;
import java.util.Objects;

/**
 * Represents a player in a grid-based game, with a specific marker.
 */
public class GridPlayer extends Player {
  private final Marker marker;

  /**
   * Constructs a GridPlayer with name and marker.
   * @param name player name
   * @param marker the Marker assigned
   */
  public GridPlayer(String name, Marker marker) {
    super(name);
    this.marker = Objects.requireNonNull(marker);
  }

  /**
   * @return marker for this player
   */
  public Marker getMarker() {
    return marker;
  }
}
