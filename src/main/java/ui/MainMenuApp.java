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

import static constants.UiConstants.*;

public class MainMenuApp extends Application {

  private final MainMenuView view       = new MainMenuView();
  private final MainMenuController ctrl = new MainMenuController(view);

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle(APP_NAME);
    primaryStage.setScene(new Scene(view, APP_WIDTH, APP_HEIGHT));
    primaryStage.show();
  }

  public static void main(String[] args) { launch(args); }
}

class MainMenuView extends BorderPane {

  private final Label  titleLabel  = new Label(MAIN_MENU);
  private final Button snakesBtn   = new Button(SNAKES_LADDERS);
  private final Button tttBtn      = new Button(TIC_TAC_TOE);
  private final Button connectBtn  = new Button(CONNECT_FOUR);
  private final Button exitBtn     = new Button(EXIT);

  MainMenuView() { buildUi(); }

  private void buildUi() {
    titleLabel.getStyleClass().add("title-label");

    VBox buttons = new VBox(MENU_VBox_SPACING, snakesBtn, tttBtn, connectBtn, exitBtn);
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

  Button getSnakesBtn()  { return snakesBtn;  }
  Button getTttBtn()     { return tttBtn;     }
  Button getConnectBtn() { return connectBtn; }
  Button getExitBtn()    { return exitBtn;    }
}


class MainMenuController {
  private final MainMenuView view;

  MainMenuController(MainMenuView view) {
    this.view = view;
    wireActions();
  }

  private void wireActions() {
    view.getSnakesBtn().setOnAction(e -> GameRouter.launch(GameId.SNAKES_AND_LADDERS));
    view.getTttBtn().setOnAction   (e -> GameRouter.launch(GameId.TIC_TAC_TOE));
    view.getConnectBtn().setOnAction(e -> GameRouter.launch(GameId.CONNECT_FOUR));
    view.getExitBtn().setOnAction  (e -> Platform.exit());
  }
}