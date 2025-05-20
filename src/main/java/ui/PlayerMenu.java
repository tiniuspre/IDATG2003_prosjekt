package ui;

import constants.UiConstants;
import filehandler.csvhandling.CsvHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import snakesandladders.engine.SnLPlayer;
import ui.exceptions.CssLoaderException;
import ui.launcher.Router;
import ui.util.CssLoader;
import ui.util.DialogUtil;
import ui.util.GameScreen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.UiConstants.BACK;
import static constants.UiConstants.SETTINGS_TITLE_ID;
import static constants.UiConstants.TTT_SPACING;
import static constants.UiConstants.TTT_H_V_GAP;

/**
 * PlayerMenu class representing the player menu screen.
 *
 * <p>The Player Menu uses {@link SnLPlayer} objects to
 * store players as these are the player objects with the most
 * arguments needed.</p>
 *
 * @author jonastomren
 * @version 20.05.2025
 * @since 20.05.2025
 *
 * @see ui.util.GameScreen
 */
public class PlayerMenu implements GameScreen {
  /**
   * The view component of the player menu.
   */
  private final PlayerMenuView view = new PlayerMenuView();
  /**
   * The controller component of the player menu.
   */
  private final PlayerMenuController controller =
      new PlayerMenuController(view);

  /**
   * Returns the view of the player menu.
   *
   * @return the view component of the player menu.
   */
  @Override
  public Parent getView() {
    return view;
  }
}

class PlayerMenuView extends BorderPane {
  /**
   * The title label for the player menu.
   */
  private final Label titleLabel = new Label(UiConstants.PLAYER_MENU_TITLE);
  /**
   * The layout for the player menu.
   */
  private final VBox playerMenuLayout = new VBox();
  /**
   * The layout for the added players.
   */
  private final VBox addedPlayers = new VBox();
  /**
   * The layout for adding a new player.
   */
  private final HBox addPlayerLayout = new HBox();
  /**
   * A map to store checkboxes for each player.
   */
  private Map<String, CheckBox> playerCheckBoxes = new HashMap<>();
  /**
   * The button to go back to the main menu.
   */
  private final Button backBtn = new Button(BACK);
  /**
   * The button to save the selected players.
   */
  private final Button saveBtn = new Button("Save");
  /**
   * The button to add a new player.
   */
  private final Button addPlayerBtn = new Button("Add Player");
  /**
   * The text field for entering the player name.
   */
  private final TextField playerNameField = new TextField();
  /**
   * The list of registered players.
   */
  private final List<String> registeredPlayers = new ArrayList<>();

  /**
   * Constructor for the PlayerMenuView.
   */
  PlayerMenuView() {
    buildUI();
  }

  /**
   * Builds the user interface for the player menu.
   */
  private void buildUI() {
    titleLabel.setId(SETTINGS_TITLE_ID);
    VBox title = new VBox(
        titleLabel
    );
    HBox footer = new HBox(
        backBtn,
        saveBtn
    );
    setBottom(footer);
    setTop(title);
    footer.setAlignment(Pos.CENTER);
    title.setAlignment(Pos.CENTER);
    setCenter(playerMenuLayout);
    playerMenuLayout.getChildren().addAll(addPlayerLayout, addedPlayers);
    populatePlayerMenu();
    setupPlayerCreation();
    addPlayerLayout.setAlignment(Pos.CENTER);
    try {
      getStylesheets().add(CssLoader.getCssPath(UiConstants.PLAYER_MENU_CSS));
    } catch (CssLoaderException e) {
      DialogUtil.exception("CSS file not found: ", e);
    }
  }

  /**
   * Sets up the player creation UI components.
   */
  private void setupPlayerCreation() {
    playerNameField.setPromptText("Enter player name");
    Label playerNameLabel = new Label("Player Name:");

    HBox playerCreationBox = new HBox(TTT_SPACING, playerNameLabel,
        playerNameField, addPlayerBtn);
    playerCreationBox.setAlignment(Pos.CENTER);
    addPlayerLayout.getChildren().add(playerCreationBox);
  }

  /**
   * Populates the player menu with registered players.
   */
  void populatePlayerMenu() {
    addedPlayers.getChildren().clear();
    addedPlayers.setAlignment(Pos.CENTER);
    playerCheckBoxes.clear();

    for (String player : registeredPlayers) {
      HBox playerBox = new HBox(TTT_SPACING);
      playerBox.setAlignment(Pos.CENTER);
      playerBox.setPadding(new Insets(TTT_H_V_GAP));

      CheckBox checkBox = new CheckBox(player);
      checkBox.setStyle("-fx-font-size: 20px;");
      checkBox.setPadding(new Insets(TTT_H_V_GAP));

      playerCheckBoxes.put(player, checkBox);
      playerBox.getChildren().addAll(checkBox);
      addedPlayers.getChildren().add(playerBox);
    }
  }

  /**
   * Gets the back button.
   *
   * @return the back button.
   */
  Button getBackBtn() {
    return backBtn;
  }

  /**
   * Gets the save button.
   *
   * @return the save button.
   */
  Button getSaveBtn() {
    return saveBtn;
  }

  /**
   * Gets the add player button.
   *
   * @return the add player button.
   */
  Button getAddPlayerBtn() {
    return addPlayerBtn;
  }

  /**
   * Gets the player name field.
   *
   * @return the player name field.
   */
  TextField getPlayerNameField() {
    return playerNameField;
  }

  /**
   * Gets the player checkboxes.
   *
   * @return the map of player checkboxes.
   */
  Map<String, CheckBox> getPlayerCheckBoxes() {
    return playerCheckBoxes;
  }

  /**
   * Gets the list of registered players.
   *
   * @return the list of registered players.
   */
  List<String> getRegisteredPlayers() {
    return new ArrayList<>(registeredPlayers);
  }

  /**
   * Adds a player to the registered players list.
   *
   * @param playerName the name of the player to add.
   */
  void addPlayer(final String playerName) {
    registeredPlayers.add(playerName);
    populatePlayerMenu();
  }

  /**
   * Sets the registered players list.
   *
   * @param players the list of players to set.
   */
  void setRegisteredPlayers(final List<SnLPlayer> players) {
    registeredPlayers.clear();
    for (SnLPlayer player : players) {
      registeredPlayers.add(player.getName());
    }
    populatePlayerMenu();
  }
}

/**
 * The controller for the player menu.
 */
class PlayerMenuController {
  /**
   * The view component of the player menu.
   */
  private final PlayerMenuView view;

  /**
   * Constructor for the PlayerMenuController.
   *
   * @param playerMenuView the view component of the player menu.
   */
  PlayerMenuController(final PlayerMenuView playerMenuView) {
    this.view = playerMenuView;
    view.setRegisteredPlayers(loadPlayers());
    wireButtons();
  }

  /**
   * Wires the buttons in the player menu to their respective actions.
   */
  private void wireButtons() {
    view.getBackBtn().setOnAction(event -> Router.launch(GameId.MAIN_MENU));

    view.getSaveBtn().setOnAction(event -> {
      CsvHandler csvHandlerSelected = new CsvHandler(
          "player/selected_players.csv");
      CsvHandler csvHandler = new CsvHandler("player/all_players.csv");

      List<SnLPlayer> selectedPlayers = new ArrayList<>();
      List<SnLPlayer> allPlayers = new ArrayList<>();
      for (Map.Entry<String, CheckBox> entry : view.getPlayerCheckBoxes()
          .entrySet()) {
        if (entry.getValue().isSelected()) {
          selectedPlayers.add(new SnLPlayer(entry.getKey(), "DEFAULT"));
        }
      }
      if (selectedPlayers.isEmpty()) {
        DialogUtil.error("No selectedPlayers selected",
            "Please select at least one player.");
      }
      csvHandlerSelected.writeToFile(selectedPlayers);

      for (String playerName : view.getRegisteredPlayers()) {
        allPlayers.add(new SnLPlayer(playerName, "DEFAULT"));
      }
      csvHandler.writeToFile(allPlayers);
    });

    view.getAddPlayerBtn().setOnAction(event -> {
      String playerName = view.getPlayerNameField().getText();
      if (playerName.isEmpty()) {
        DialogUtil.error("Player name cannot be empty",
            "Please enter a valid player name.");
        return;
      }
      view.addPlayer(playerName);
      view.getPlayerNameField().clear();
    });
  }

  /**
   * Loads players from a CSV file.
   *
   * @return a list of SnLPlayer objects.
   */
  List<SnLPlayer> loadPlayers() {
    List<SnLPlayer> players;
    CsvHandler csvHandler = new CsvHandler("player/all_players.csv");
    try {
      players = csvHandler.readFromFile(SnLPlayer.class);
    } catch (Exception e) {
      DialogUtil.error("Error loading players",
          "Could not load players from file.");
      return new ArrayList<>();
    }
    return players;
  }
}
