package ui;

import constants.UiConstants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ui.exceptions.CssLoaderException;
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

  private final HBox addPlayerLayout = new HBox();

  private Map<String, CheckBox> playerCheckBoxes = new HashMap<>();

  private final Button backBtn = new Button(BACK);

  private final Button saveBtn = new Button("Save");

  private final Button addPlayerBtn = new Button("Add Player");

  private final TextField playerNameField = new TextField();

  // TODO : Implement file handling logic
  private List<String> registeredPlayers = new ArrayList<>();

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
    setupPlayerSelectionMenu();
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

    // TODO : Implement add player logic

    HBox playerCreationBox = new HBox(10, playerNameField, addPlayerBtn);
    playerCreationBox.setAlignment(Pos.CENTER);
    addPlayerLayout.getChildren().add(playerCreationBox);
  }

  void setupPlayerSelectionMenu() {
    playerMenuLayout.getChildren().clear();
    playerMenuLayout.setAlignment(Pos.CENTER);
    playerCheckBoxes.clear();

    Label title = new Label("Select Players for the Game:");
    title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

    playerMenuLayout.getChildren().add(title);

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
      playerMenuLayout.getChildren().add(playerBox);
    }
  }

  void updatePlayers() {
    playerMenuLayout.getChildren().clear();
    playerMenuLayout.setAlignment(Pos.CENTER);
    playerCheckBoxes.clear();

    Label title = new Label("Select Players for the Game:");
    title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

    playerMenuLayout.getChildren().add(title);

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
      playerMenuLayout.getChildren().add(playerBox);
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

  void addPlayer(final String playerName) {
    registeredPlayers.add(playerName);
  }
}

class PlayerMenuController {

  private final PlayerMenuView view;

  PlayerMenuController(final PlayerMenuView playerMenuView) {
    this.view = playerMenuView;
    wireButtons();
  }

  private void wireButtons() {
    view.getBackBtn().setOnAction(event -> {
      // TODO : Implement back button logic
    });

    view.getSaveBtn().setOnAction(event -> {
      // TODO : Implement save button logic
    });

    view.getAddPlayerBtn().setOnAction(event -> {
      String playerName = view.getPlayerNameField().getText();
      if (playerName.isEmpty()) {
        DialogUtil.error("Player name cannot be empty", "Please enter a valid player name.");
        return;
      }
      view.addPlayer(playerName);
      view.getPlayerNameField().clear();
      view.updatePlayers();
    });
  }
}
