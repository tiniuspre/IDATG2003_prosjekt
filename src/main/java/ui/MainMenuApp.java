package ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import ui.exceptions.CssLoaderException;
import ui.launcher.GameRouter;
import ui.util.CssLoader;
import ui.util.DialogUtil;

import static constants.UiConstants.APP_NAME;
import static constants.UiConstants.APP_HEIGHT;
import static constants.UiConstants.APP_WIDTH;
import static constants.UiConstants.CONNECT_FOUR;
import static constants.UiConstants.EXIT;
import static constants.UiConstants.MAIN_MENU;
import static constants.UiConstants.MAIN_MENU_CSS;
import static constants.UiConstants.MENU_BUTTON_PADDING;
import static constants.UiConstants.MENU_VBox_SPACING;
import static constants.UiConstants.SNAKES_LADDERS;
import static constants.UiConstants.TIC_TAC_TOE;

/**
 * Main application class for the Main Menu.
 * Sets up the primary stage and initializes the main menu view and controller.
 *
 * @author tiniuspre
 * @version 25.04.2025
 * @since 25.03.2025
 */
public class MainMenuApp extends Application {

  /**
   * The view component of the main menu.
   */
  private final MainMenuView view = new MainMenuView();

  /**
   * The controller component of the main menu.
   */
  private final MainMenuController ctrl = new MainMenuController(view);

  /**
   * Starts the JavaFX application by setting up the primary stage.
   *
   * @param primaryStage the primary stage for this application.
   */
  @Override
  public void start(final Stage primaryStage) {
    primaryStage.setTitle(APP_NAME);
    primaryStage.setScene(new Scene(view, APP_WIDTH, APP_HEIGHT));
    primaryStage.show();
  }

  /**
   * The main entry point for the application.
   *
   * @param args the command-line arguments.
   */
  public static void main(final String[] args) {
    launch(args);
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
        MENU_VBox_SPACING,
        snakesBtn,
        tttBtn,
        connectBtn,
        exitBtn
    );
    buttons.setAlignment(Pos.CENTER);
    buttons.setPadding(new Insets(MENU_BUTTON_PADDING));

    setTop(titleLabel);
    BorderPane.setAlignment(titleLabel, Pos.CENTER);
    setCenter(buttons);
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
    view.getSnakesBtn().setOnAction(
        e -> GameRouter.launch(GameId.SNAKES_AND_LADDERS)
    );
    view.getTttBtn().setOnAction(
        e -> GameRouter.launch(GameId.TIC_TAC_TOE)
    );
    view.getConnectBtn().setOnAction(
        e -> GameRouter.launch(GameId.CONNECT_FOUR)
    );
    view.getExitBtn().setOnAction(
        e -> Platform.exit()
    );
  }
}
