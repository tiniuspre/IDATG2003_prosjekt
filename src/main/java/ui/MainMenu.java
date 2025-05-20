package ui;

import gameengine.player.PlayerUtil;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import ui.exceptions.CssLoaderException;
import ui.exceptions.UILoaderException;
import ui.launcher.Router;
import ui.util.CssLoader;
import ui.util.DialogUtil;
import ui.util.GameScreen;

import static constants.UiConstants.MENU_V_BOX_SPACING;
import static constants.UiConstants.SETTINGS_ICON;
import static constants.UiConstants.MAIN_MENU;
import static constants.UiConstants.SNAKES_LADDERS;
import static constants.UiConstants.TIC_TAC_TOE;
import static constants.UiConstants.CONNECT_FOUR;
import static constants.UiConstants.EXIT;
import static constants.UiConstants.MAIN_MENU_CSS;
import static constants.UiConstants.MENU_BUTTON_PADDING;
import static constants.UiConstants.APP_NAME;
import static constants.UiConstants.APP_WIDTH;
import static constants.UiConstants.APP_HEIGHT;
import static constants.UiConstants.SETTINGS_BUTTON_ID;
import static constants.UiConstants.PLAYER_MENU_BUTTON_ID;


/**
 * Main application class for the Main Menu.
 * Sets up the primary stage and initializes the main menu view and controller.
 *
 * @author tiniuspre, jonastom
 * @version 20.05.2025
 * @since 25.03.2025
 */
public class MainMenu implements GameScreen {

  /**
   * The view component of the main menu.
   */
  private final MainMenuView view = new MainMenuView();
  /**
   * The primary stage for the JavaFX application.
   */
  private Stage primaryAppStage;
  /**
   * The controller component of the main menu.
   */
  private final MainMenuController ctrl = new MainMenuController(view);

  /**
   * Starts the main menu application.
   *
   * @param primaryStage the primary stage for this application.
   */
  public void startMain(final Stage primaryStage) {
    setPrimaryAppStage(primaryStage);
    Router.init(this);
    primaryStage.setTitle(APP_NAME);
    primaryStage.setScene(new Scene(view, APP_WIDTH, APP_HEIGHT));
    primaryStage.show();
  }

  /**
   * Switches the current view to the specified game screen.
   *
   * @param screen the game screen to switch to.
   * @throws UILoaderException if the game view is null.
   */
  public void switchTo(final GameScreen screen) {
    Parent gameView = screen.getView();
    if (gameView != null && primaryAppStage != null) {
      primaryAppStage.getScene().setRoot(gameView);
    } else {
      DialogUtil.error("Could not load game", "No gameView found");
      throw new UILoaderException("No gameView found");
    }
    primaryAppStage.show();
  }

  /**
   * Sets the primary stage of the application.
   *
   * <p>Only to be called at the start() method of the app.</p>
   *
   * @param stage the primary stage of the application.
   */
  public void setPrimaryAppStage(final Stage stage) {
    if (stage == null) {
      throw new UILoaderException("Stage is null");
    }
    this.primaryAppStage = stage;
  }

  /**
   * Gets the view of the main menu.
   *
   * @return the view component of the main menu.
   */
  @Override
  public Parent getView() {
    return view;
  }
}

/**
 * Represents the view for the main menu.
 * Builds the user interface components and applies styles.
 *
 * @author tiniuspre
 * @version 25.04.2025
 * @since 25.03.2025
 */
class MainMenuView extends BorderPane {

  /**
   * Label for the main menu title.
   */
  private final Label titleLabel = new Label(MAIN_MENU);

  /**
   * Button to launch the Snakes and Ladders game.
   */
  private final Button snakesBtn = new Button(SNAKES_LADDERS);

  /**
   * Button to launch the Tic Tac Toe game.
   */
  private final Button tttBtn = new Button(TIC_TAC_TOE);

  /**
   * Button to launch the Connect Four game.
   */
  private final Button connectBtn = new Button(CONNECT_FOUR);

  /**
   * Button to exit the application.
   */
  private final Button exitBtn = new Button(EXIT);

  /**
   * Button to launch the settings menu.
   */
  private final Button settingsBtn = new Button(SETTINGS_ICON);

  /**
   * Button to launch the player menu.
   */
  // TODO : Add icon
  private final Button playerMenuBtn = new Button("temp");

  /**
   * Constructs the main menu view and builds the user interface.
   */
  MainMenuView() {
    buildUi();
  }

  /**
   * Builds the user interface components and applies styles.
   */
  private void buildUi() {
    titleLabel.getStyleClass().add("title-label");

    VBox buttons = new VBox(
        MENU_V_BOX_SPACING,
        snakesBtn,
        tttBtn,
        connectBtn,
        exitBtn
    );
    buttons.setAlignment(Pos.CENTER);
    buttons.setPadding(new Insets(MENU_BUTTON_PADDING));
    setCenter(buttons);

    getSettingsBtn().setId(SETTINGS_BUTTON_ID);
    getPlayerMenuBtn().setId(PLAYER_MENU_BUTTON_ID);

    HBox topRight = new HBox(
        settingsBtn
    );
    HBox topLeft = new HBox(
        playerMenuBtn
    );

    BorderPane top = new BorderPane();
    top.setLeft(topLeft);
    top.setRight(topRight);
    top.setCenter(titleLabel);
    setTop(top);

    try {
      getStylesheets().add(CssLoader.getCssPath(MAIN_MENU_CSS));
    } catch (CssLoaderException e) {
      DialogUtil.exception("CSS file not found: ", e);
    }
  }

  /**
   * Gets the button for launching the Snakes and Ladders game.
   *
   * @return the Snakes and Ladders button.
   */
  Button getSnakesBtn() {
    return snakesBtn;
  }

  /**
   * Gets the button for launching the Tic Tac Toe game.
   *
   * @return the Tic Tac Toe button.
   */
  Button getTttBtn() {
    return tttBtn;
  }

  /**
   * Gets the button for launching the Connect Four game.
   *
   * @return the Connect Four button.
   */
  Button getConnectBtn() {
    return connectBtn;
  }

  /**
   * Gets the button for exiting the application.
   *
   * @return the exit button.
   */
  Button getExitBtn() {
    return exitBtn;
  }

  /**
   * Gets the button for launching the settings menu.
   *
   * @return the settings button.
   */
  Button getSettingsBtn() {
    return settingsBtn; }

  /**
   * Gets the button for launching the player menu.
   *
   * @return the player menu button.
   */
  Button getPlayerMenuBtn() {
    return playerMenuBtn;
  }
}

/**
 * Controller for the main menu.
 * Handles user interactions and routes actions
 * to the appropriate game or functionality.
 *
 * @author tiniuspre
 * @version 25.04.2025
 * @since 25.03.2025
 */
class MainMenuController {

  /**
   * The view component of the main menu.
   */
  private final MainMenuView view;

  /**
   * Constructs the main menu controller and wires actions to the buttons.
   *
   * @param menuView the view component of the main menu.
   */
  MainMenuController(final MainMenuView menuView) {
    this.view = menuView;
    wireActions();
  }

  /**
   * Wires actions to the buttons in the main menu.
   */
  private void wireActions() {
    view.getSnakesBtn().setOnAction(e -> {
      if (PlayerUtil.checkPlayerCount(GameId.SNAKES_AND_LADDERS)) {
        Router.launch(GameId.SNAKES_AND_LADDERS);
      } else {
        DialogUtil.error("Invalid player amount", "2 to 5 players required");
      }
    });
    view.getTttBtn().setOnAction(e -> {
          if (PlayerUtil.checkPlayerCount(GameId.TIC_TAC_TOE)) {
            Router.launch(GameId.TIC_TAC_TOE);
          } else {
            DialogUtil.error("Invalid player amount", "2 players");
          }
    });
    view.getConnectBtn().setOnAction(e -> {
          if (PlayerUtil.checkPlayerCount(GameId.CONNECT_FOUR)) {
            Router.launch(GameId.CONNECT_FOUR);
          } else {
            DialogUtil.error("Invalid player amount", "2 players");
          }
    });
    view.getExitBtn().setOnAction(
        e -> Platform.exit()
    );
    view.getSettingsBtn().setOnAction(
        e -> Router.launch(GameId.SETTINGS)
    );
    view.getPlayerMenuBtn().setOnAction(
        e -> Router.launch(GameId.PLAYER_MENU)
    );
  }
}
