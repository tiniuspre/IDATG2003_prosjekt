package gameengine.grid;

import gameengine.player.Player;
import java.util.Objects;

/**
 * Represents a player in a grid-based game, with a specific marker.
 */
public class GridPlayer extends Player {
  /**
   * Serial version UID for serialization.
   */
  private Marker marker;

  /**
   * Constructs a GridPlayer with name and marker.
   * @param name player name
   * @param markInst the Marker assigned
   */
  public GridPlayer(final String name, final Marker markInst) {
    super(name);
    setMarker(Objects.requireNonNull(markInst));
  }

  private void setMarker(final Marker markInst) {
    this.marker = markInst;
  }

  /**
   * @return marker for this player
   */
  public Marker getMarker() {
    return marker;
  }
}
