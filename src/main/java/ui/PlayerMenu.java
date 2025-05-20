package ui;

import constants.UiConstants;
import filehandler.csvhandling.CsvHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
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

public class PlayerMenu implements GameScreen {

  private final PlayerMenuView view = new PlayerMenuView();

  private final PlayerMenuController controller =
      new PlayerMenuController(view);

  @Override
  public Parent getView() {
    return view;
  }
}

class PlayerMenuView extends BorderPane {

  private final Label titleLabel = new Label(UiConstants.PLAYER_MENU_TITLE);

  private final VBox playerMenuLayout = new VBox();

  private final VBox addedPlayers = new VBox();

  private final HBox addPlayerLayout = new HBox();

  private Map<String, CheckBox> playerCheckBoxes = new HashMap<>();

  private final Button backBtn = new Button(BACK);

  private final Button saveBtn = new Button("Save");

  private final Button addPlayerBtn = new Button("Add Player");

  private final TextField playerNameField = new TextField();

  private final List<String> registeredPlayers = new ArrayList<>();

  PlayerMenuView() {
    buildUI();
  }

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
    playerMenuLayout.getChildren().addAll(addPlayerLayout ,addedPlayers);
    populatePlayerMenu();
    setupPlayerCreation();
    addPlayerLayout.setAlignment(Pos.CENTER);
    try {
      getStylesheets().add(CssLoader.getCssPath(UiConstants.PLAYER_MENU_CSS));
    } catch (CssLoaderException e) {
      DialogUtil.exception("CSS file not found: ", e);
    }
  }

  private void setupPlayerCreation() {
    playerNameField.setPromptText("Enter player name");
    Label playerNameLabel = new Label("Player Name:");

    HBox playerCreationBox = new HBox(10, playerNameLabel, playerNameField, addPlayerBtn);
    playerCreationBox.setAlignment(Pos.CENTER);
    addPlayerLayout.getChildren().add(playerCreationBox);
  }


  void populatePlayerMenu() {
    addedPlayers.getChildren().clear();
    addedPlayers.setAlignment(Pos.CENTER);
    playerCheckBoxes.clear();

    for (String player : registeredPlayers) {
      HBox playerBox = new HBox();
      playerBox.setAlignment(Pos.CENTER);
      playerBox.setSpacing(10);
      playerBox.setPadding(new Insets(5));

      CheckBox checkBox = new CheckBox(player);
      checkBox.setStyle("-fx-font-size: 20px;");
      checkBox.setPadding(new Insets(5));

      playerCheckBoxes.put(player, checkBox);
      playerBox.getChildren().addAll(checkBox);
      addedPlayers.getChildren().add(playerBox);
    }
  }

  VBox getPlayerMenuLayout() {
    return playerMenuLayout;
  }

  Button getBackBtn() {
    return backBtn;
  }

  Button getSaveBtn() {
    return saveBtn;
  }

  Button getAddPlayerBtn() {
    return addPlayerBtn;
  }

  TextField getPlayerNameField() {
    return playerNameField;
  }

  Map<String, CheckBox> getPlayerCheckBoxes() {
    return playerCheckBoxes;
  }
  List<String> getRegisteredPlayers() {
    return new ArrayList<>(registeredPlayers);
  }

  void addPlayer(final String playerName) {
    registeredPlayers.add(playerName);
  }

  void setRegisteredPlayers(final List<SnLPlayer> players) {
    registeredPlayers.clear();
    for (SnLPlayer player : players) {
      registeredPlayers.add(player.getName());
    }
    populatePlayerMenu();
  }
}

class PlayerMenuController {

  private final PlayerMenuView view;

  PlayerMenuController(final PlayerMenuView playerMenuView) {
    this.view = playerMenuView;
    view.setRegisteredPlayers(loadPlayers());
    wireButtons();
  }

  private void wireButtons() {
    view.getBackBtn().setOnAction(event -> Router.launch(GameId.MAIN_MENU));

    view.getSaveBtn().setOnAction(event -> {
      CsvHandler csvHandlerSelected = new CsvHandler("player/selected_players.csv");
      CsvHandler csvHandler = new CsvHandler("player/all_players.csv");

      List<SnLPlayer> selectedPlayers = new ArrayList<>();
      List<SnLPlayer> allPlayers = new ArrayList<>();
      for (Map.Entry<String, CheckBox> entry : view.getPlayerCheckBoxes().entrySet()) {
        if (entry.getValue().isSelected()) {
          selectedPlayers.add(new SnLPlayer(entry.getKey(), "DEFAULT"));
        }
      }
      if (selectedPlayers.isEmpty()) {
        DialogUtil.error("No selectedPlayers selected", "Please select at least one player.");
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
        DialogUtil.error("Player name cannot be empty", "Please enter a valid player name.");
        return;
      }
      view.addPlayer(playerName);
      view.getPlayerNameField().clear();
      view.populatePlayerMenu();
    });
  }

  List<SnLPlayer> loadPlayers() {
    List<SnLPlayer> players;
    CsvHandler csvHandler = new CsvHandler("player/all_players.csv");
    try {
      players = csvHandler.readFromFile(SnLPlayer.class);
    } catch (Exception e) {
      DialogUtil.error("Error loading players", "Could not load players from file.");
      return new ArrayList<>();
    }
    return players;
  }
}
