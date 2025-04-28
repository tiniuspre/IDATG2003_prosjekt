package ui;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import ui.exceptions.CssLoaderException;
import ui.launcher.Router;
import ui.util.CssLoader;
import ui.util.DialogUtil;
import ui.util.GameScreen;

import static constants.UiConstants.MENU_V_BOX_SPACING;
import static constants.UiConstants.SETTINGS;
import static constants.UiConstants.SETTINGS_MENU_CSS;
import static constants.UiConstants.SETTINGS_TITLE_ID;
import static constants.UiConstants.BACK;
import static constants.UiConstants.CHANGE_NAME;
import static constants.UiConstants.CHANGE_THEME;
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
  private final SettingsMenuController controller =
      new SettingsMenuController(view);

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
  /**
   * The label for the title of the settings menu.
   */
  private final Label titleLabel = new Label(SETTINGS);
  /**
   * The button for changing the name.
   */
  private final Button changeNameButton = new Button(CHANGE_NAME);
  /**
   * The button for changing the theme.
   */
  private final Button changeThemeButton = new Button(CHANGE_THEME);
  /**
   * The button for going back to the main menu.
   */
  private final Button backButton = new Button(BACK);

  /**
   * Constructor for the SettingsMenuView.
   */
  SettingsMenuView() {
    buildUi();
  }

  /**
   * Builds the user interface for the settings menu.
   */
  private void buildUi() {
    VBox settingsMenu = new VBox(
        MENU_V_BOX_SPACING,
        changeNameButton,
        changeThemeButton,
        backButton
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

  /**
   * Gets the button for changing the name.
   *
   * @return the change name button.
   */
  Button getChangeNameButton() {
    return changeNameButton;
  }

  /**
   * Gets the button for going back to the main menu.
   *
   * @return the back button.
   */
  Button getBackButton() {
    return backButton; }
}

/**
 * The controller for the settings menu.
 *
 * @author jonastomren
 * @version 27.04.2025
 * @since 27.04.2025
 */
class SettingsMenuController {
  /**
   * The view component of the settings menu.
   */
  private final SettingsMenuView view;

  /**
   * Constructor for the SettingsMenuController.
   *
   * @param menuView the view component of the settings menu.
   */
  SettingsMenuController(final SettingsMenuView menuView) {
    this.view = menuView;
    wireButtons();
  }

  /**
   * Wires the buttons in the settings menu to their respective actions.
   */
  private void wireButtons() {
    view.getBackButton().setOnAction(
        e -> Router.launch(GameId.MAIN_MENU)
    );
  }
}


