package constants;

/**
 * A utility class that contains constant
 * values used throughout the application.
 * These constants include application settings,
 * UI configurations, and error handling flags.
 * <p>This class is final and cannot be instantiated.
 * All fields are static and designed for global access.</p>
 *
 * @author tiniuspre, jonastom
 * @version 29.05.2025
 * @since 25.03.2025
 */
public final class UiConstants {

  /**
   * The name of the application.
   */
  public static final String APP_NAME = "IDATG2001";

  /**
   * The width of the application window.
   */
  public static final Integer APP_WIDTH = 900;

  /**
   * The height of the application window.
   */
  public static final Integer APP_HEIGHT = 650;

  /**
   * The path to the main menu CSS file.
   */
  public static final String MAIN_MENU_CSS = "/style/menu.css";

  /**
   * The path to the settings menu CSS file.
   */
  public static final String SETTINGS_MENU_CSS = "/style/settings.css";

  /**
   * The path to the player menu CSS file.
   */
  public static final String PLAYER_MENU_CSS = "/style/playermenu.css";

  /**
   * The label for the Snakes and Ladders game button.
   */
  public static final String SNAKES_LADDERS = "Snakes & Ladders";

  /**
   * The label for the Tic-Tac-Toe game button.
   */
  public static final String TIC_TAC_TOE = "Tic-Tac-Toe";

  /**
   * The label for the Connect Four game button.
   */
  public static final String CONNECT_FOUR = "Connect Four";

  /**
   * The title of the main menu.
   */
  public static final String MAIN_MENU = "Main Menu";

  /**
   * Settings button id for css.
   */
  public static final String SETTINGS_BUTTON_ID = "settings-button";

  /**
   * Player menu button id for css.
   */
  public static final String PLAYER_MENU_BUTTON_ID = "player-menu-button";

  /**
   * Settings title id for css.
   */
  public static final String SETTINGS_TITLE_ID = "settings-title";

  /**
   * The title of the settings menu.
   */
  public static final String SETTINGS = "Settings";

  /**
   * The icon of the settings button.
   */
  public static final String SETTINGS_ICON = "⚙";

  /**
   * The label for the exit button.
   */
  public static final String EXIT = "Exit";

  /**
   * The label for the back button.
   */
  public static final String BACK = "Back";

  /**
   * The label for the settings button.
   */
  public static final String CHANGE_NAME = "Change Name";

  /**
   * The label for the change theme button.
   */
  public static final String CHANGE_THEME = "Change Theme";

  /**
   * The vertical spacing between menu buttons in the main menu.
   */
  public static final Integer MENU_V_BOX_SPACING = 15;

  /**
   * The padding around menu buttons in the main menu.
   */
  public static final Integer MENU_BUTTON_PADDING = 40;
  /* TTT constants */
  /**
   * Spacing between buttons in the Tic Tac Toe grid.
   */
  public static final Integer TTT_SPACING = 10;
  /**
   * The size of the Tic Tac Toe board.
   */
  public static final Integer TTT_H_V_GAP = 5;
  /**
   * Btn min size for Tic Tac Toe.
   */
  public static final Integer TTT_BTN_MIN_SIZE = 60;
  /* SNL constants */
  /**
   * The size of the Snakes and Ladders game board tiles.
   */
  public static final Integer SNL_TILE_SIZE = 50;

  /**
   * The size of the Snakes and Ladders arrows.
   */
  public static final Integer SNL_ARROW_SIZE = 6;

  /**
   * The size of the Snakes and Ladders arrow heads.
   */
  public static final Integer SNL_ARROW_HEAD_SIZE = 3;

  /**
   * The width of the Snakes and Ladders side panel.
   */
  public static final Integer SNL_SIDE_PANEL_WIDTH = 10;

  /**
   * The preferred width of the Snakes and Ladders side panel.
   */
  public static final Integer SNL_SIDE_PANEL_PREF_WIDTH = 240;

  /**
   * The offset of the Snakes and Ladders game from the left.
   */
  public static final Integer SNL_GAME_OFFSET = 100;

  /**
   * The width of the line connectors for the Snakes and Ladders game.
   */
  public static final double SNL_LINE_WIDTH = 3.0;

  /**
   * The radius of the Snakes and Ladders player icons.
   */
  public static final double SNL_PLAYER_ICON_RADIUS = 0.2;

  /**
   * The initial offscreen placement value for Snakes and Ladders players.
   */
  public static final Integer SNL_PLAYER_OFFSCREEN_PLACEMENT = -999;

  /**
   * The font size for the Snakes and Ladders game text.
   */
  public static final Integer SNL_FONT_SIZE = 10;

  /**
   * The X offset for the text on Snakes and Ladders tiles.
   */
  public static final Integer SNL_TILE_TEXT_OFFSET_X = 15;
  /**
   * The Y offset for the text on Snakes and Ladders tiles.
   */
  public static final Integer SNL_TILE_TEXT_OFFSET_Y = 12;

  /**
   * The title of the player menu.
   */
  public static final String PLAYER_MENU_TITLE = "Player Menu";

  /**
   * The invalid player amount error message.
   */
  public static final String INVALID_PLAYER_AMOUNT = "Invalid player amount";
  /**
   * Private constructor to prevent instantiation of this utility class.
   */
  private UiConstants() { }
}
