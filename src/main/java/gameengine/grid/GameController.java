package gameengine.grid;

import java.util.Objects;
import gameengine.Observer;

/**
 * Simple controller wiring a GridGame to UI observers.
 */
public class GameController implements Observer {
  private final GridGame game;

  /**
   * Constructs a GameController for a grid game and registers it.
   * @param game the GridGame to control
   */
  public GameController(GridGame game) {
    this.game = Objects.requireNonNull(game);
    game.registerObserver(this);
  }

  @Override
  public void update(gameengine.player.Player player) {
    // Default: simply log or forward to UI
    System.out.println("Move made by: " + player.getName());
  }

  /**
   * @param row target row
   * @param col target column
   * @return true if move applied
   */
  public boolean play(int row, int col) {
    return game.makeMove(row, col);
  }
}
