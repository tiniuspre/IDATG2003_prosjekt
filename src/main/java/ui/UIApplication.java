package ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class UIApplication extends Application {

  @Override
  public void start(final Stage stage) throws Exception {
    MainMenuApp mainMenuApp = new MainMenuApp();
    mainMenuApp.startMain(stage);
  }

  public static void main(final String[] args) {
    launch(args);
  }
}
