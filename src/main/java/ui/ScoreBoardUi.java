package ui;

import gameengine.scoreboard.ScoreboardRegister;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import ui.launcher.Router;
import ui.util.GameScreen;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static constants.UiConstants.SUI_PADDING;
import static constants.UiConstants.SUI_PARTS_LENGTH;
import static constants.UiConstants.SUI_PLAYER_INDEX;
import static constants.UiConstants.SUI_GAME_INDEX;
import static constants.UiConstants.SUI_SCORE_INDEX;
import static constants.UiConstants.SUI_DATE_INDEX;

/**
 * A screen that shows the saved scoreboard in a table.
 *
 * Displays player scores, game names, and timestamps in a JavaFX TableView.
 * Provides a back button to return to the main menu.
 *
 * @author tiniuspre
 * @version 21.05.2025
 * @since 21.05.2025
 */
public class ScoreBoardUi implements GameScreen {

  /** The register that provides scoreboard data. */
  private final ScoreboardRegister scoreBoard;
  /** The root layout pane for this UI. */
  private final BorderPane root;
  /** The table displaying the scoreboard entries. */
  private final TableView<ScoreEntry> table;

  /**
   * Constructs the scoreboard UI, initializing the model, view, and layout.
   */
  public ScoreBoardUi() {
    this.scoreBoard = new ScoreboardRegister();
    this.root = new BorderPane();
    this.table = new TableView<>();

    setupTableColumns();
    loadData();
    setupLayout();
  }

  /**
   * Configures the four columns: Player, Game, Score, Date.
   * Sets up cell value factories for each column and adds them to the table.
   */
  private void setupTableColumns() {
    TableColumn<ScoreEntry, String> playerCol = new TableColumn<>("Player");
    playerCol.setCellValueFactory(new PropertyValueFactory<>("playerName"));

    TableColumn<ScoreEntry, String> gameCol = new TableColumn<>("Game");
    gameCol.setCellValueFactory(new PropertyValueFactory<>("game"));

    TableColumn<ScoreEntry, Integer> scoreCol = new TableColumn<>("Score");
    scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));

    TableColumn<ScoreEntry, String> dateCol = new TableColumn<>("Date");
    dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

    table.getColumns().addAll(playerCol, gameCol, scoreCol, dateCol);
    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
  }

  /**
   * Reads all rows from the CSV via ScoreboardRegister and populates the table.
   * Parses each line, formats the date, and adds entries to the table.
   */
  private void loadData() {
    ObservableList<ScoreEntry> items = FXCollections.observableArrayList();
    List<String> raw = scoreBoard.getScoreboardData();
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    for (String line : raw) {
      String[] parts = line.split(",");
      if (parts.length < SUI_PARTS_LENGTH) {
        continue;
      }
      String player = parts[SUI_PLAYER_INDEX];
      String game   = parts[SUI_GAME_INDEX];
      int score     = Integer.parseInt(parts[SUI_SCORE_INDEX]);
      String ts      = parts[SUI_DATE_INDEX];
      String dateStr;
      try {
        dateStr = LocalDateTime.parse(ts).format(fmt);
      } catch (Exception ex) {
        dateStr = ts;
      }
      items.add(new ScoreEntry(player, game, score, dateStr));
    }
    table.setItems(items);
  }

  /**
   * Arranges the table and Back button in the BorderPane.
   * The table is centered,
   * and the back button is aligned to the right in the footer.
   */
  private void setupLayout() {
    root.setCenter(table);

    Button backBtn = new Button("Back");
    backBtn.setOnAction(e -> Router.launch(GameId.MAIN_MENU));

    Region spacer = new Region();
    HBox.setHgrow(spacer, Priority.ALWAYS);
    HBox footer = new HBox(SUI_PADDING, spacer, backBtn);
    footer.setPadding(new Insets(SUI_PADDING));

    root.setBottom(footer);
  }

  /**
   * Returns the root node for JavaFX.
   *
   * @return the root Parent node of this UI
   */
  @Override
  public Parent getView() {
    return root;
  }

  /**
   * Simple data holder for one score-row.
   */
  public static class ScoreEntry {
    /** The player's name. */
    private final String playerName;
    /** The name of the game played. */
    private final String game;
    /** The score achieved. */
    private final int score;
    /** The date and time of the score, formatted as a string. */
    private final String date;

    /**
     * Constructs a ScoreEntry.
     *
     * @param playerStringName the player's name
     * @param gameName the game name
     * @param playerScore the score value
     * @param gameDate the date/time as a string
     */
    public ScoreEntry(
        final String playerStringName,
        final String gameName,
        final int playerScore,
        final String gameDate
    ) {
      this.playerName = playerStringName;
      this.game       = gameName;
      this.score      = playerScore;
      this.date       = gameDate;
    }

    /** @return the player's name */
    public String getPlayerName() {
      return playerName;
    }
    /** @return the game name */
    public String getGame() {
      return game;
    }
    /** @return the score */
    public int    getScore() {
      return score;
    }
    /** @return the date/time string */
    public String getDate() {
      return date;
    }
  }
}
