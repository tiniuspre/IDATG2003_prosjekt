package ui;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import ui.exceptions.CssLoaderException;
import ui.util.CssLoader;
import ui.util.DialogUtil;
import ui.util.GameScreen;

import static constants.UiConstants.SETTINGS_MENU_CSS;
import static constants.UiConstants.SETTINGS;
import static constants.UiConstants.MENU_V_BOX_SPACING;
import static constants.UiConstants.CHANGE_NAME;
import static constants.UiConstants.SETTINGS_TITLE_ID;
import static constants.UiConstants.MENU_BUTTON_PADDING;

/**
 * SettingsMenu class representing the settings menu screen.
 *
 * <p>This class implements the GameScreen interface
 * to be sent to the GAMES map of the Main menu.</p>
 *
 * @author jonastomren
 * @version 27.04.2025
 * @since 27.04.2025
 * @see ui.util.GameScreen
 */
public class SettingsMenu implements GameScreen {
  /**
   * The view component of the settings menu.
   */
  private final SettingsMenuView view = new SettingsMenuView();
  /**
   * The controller component of the settings menu.
   */
  private final SettingsMenuController controller = new SettingsMenuController(view);

  /**
   * Returns the view of the settings menu.
   *
   * @return the view component of the settings menu
   */
  @Override
  public Parent getView() {
    return view;
  }
}

/**
 * SettingsMenuView class representing the view of the settings menu.
 *
 * @author jonastomren
 * @version 27.04.2025
 * @since 27.04.2025
 */
class SettingsMenuView extends BorderPane {

  private final Label titleLabel = new Label(SETTINGS);

  private final Button changeNameButton = new Button(CHANGE_NAME);

  SettingsMenuView() {
    buildUi();
  }

  private void buildUi() {
    VBox settingsMenu = new VBox(
        MENU_V_BOX_SPACING,
        changeNameButton
    );
    titleLabel.setId(SETTINGS_TITLE_ID);
    VBox title = new VBox(titleLabel);
    setTop(title);
    title.setAlignment(Pos.CENTER);
    settingsMenu.setAlignment(Pos.CENTER);
    settingsMenu.setPadding(new Insets(MENU_BUTTON_PADDING));
    setCenter(settingsMenu);
    try {
      getStylesheets().add(CssLoader.getCssPath(SETTINGS_MENU_CSS));
    } catch (CssLoaderException e) {
      DialogUtil.exception("CSS file not found: ", e);
    }
  }

  Button getChangeNameButton() {return changeNameButton;}
}

/**
 * The controller for the settings menu.
 *
 *
 */
class SettingsMenuController {
  /**
   * The view component of the settings menu.
   */
  private final SettingsMenuView view;

  /**
   * Constructor for the SettingsMenuController.
   *
   * @param view the view component of the settings menu.
   */
  SettingsMenuController(final SettingsMenuView view) {
    this.view = view;
    wireButtons();
  }

  private void wireButtons() {
    // TODO: Add action listeners to buttons
  }
}


