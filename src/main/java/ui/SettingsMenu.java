package ui;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import ui.util.GameScreen;

import static constants.UiConstants.*;

public class SettingsMenu implements GameScreen {


  @Override
  public Parent getView() {
    SettingsMenuView settingsMenuView = new SettingsMenuView();
    settingsMenuView.getStylesheets().add(MAIN_MENU_CSS);
    return settingsMenuView;
  }
}

class SettingsMenuView extends BorderPane {

  private final Label titleLabel = new Label(SETTINGS_TITLE);

  private final Button changeNameButton = new Button(CHANGE_NAME);

  SettingsMenuView() {
    buildUi();
  }

  private void buildUi() {
    VBox settingsMenu = new VBox(
        MENU_V_BOX_SPACING,
        changeNameButton
    );
    setTop(titleLabel);
    settingsMenu.setAlignment(Pos.CENTER);
    settingsMenu.setPadding(new Insets(MENU_BUTTON_PADDING));


  }
}

class SettingsMenuController {
  private final SettingsMenu view;

  SettingsMenuController(final SettingsMenu view) {
    this.view = view;
  }

  // Add methods to handle settings logic here
}


