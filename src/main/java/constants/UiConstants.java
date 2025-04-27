package constants;

/**
 * A utility class that contains constant values used throughout the application.
 * These constants include application settings, UI configurations, and error handling flags.
 *
 * This class is final and cannot be instantiated.
 * All fields are static and designed for global access.
 *
 * @author tiniuspre
 * @version 25.04.2025
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
  public static final Integer APP_WIDTH = 600;

  /**
   * The height of the application window.
   */
  public static final Integer APP_HEIGHT = 400;

  /**
   * The path to the main menu CSS file.
   */
  public static final String MAIN_MENU_CSS = "/style/menu.css";

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
   * The label for the exit button.
   */
  public static final String EXIT = "Exit";

  /**
   * Flag indicating whether stack traces should be printed for exceptions.
   */
  public static boolean PRINT_STACK_TRACE = false;

  /**
   * The vertical spacing between menu buttons in the main menu.
   */
  public static final Integer MENU_VBox_SPACING = 15;

  /**
   * The padding around menu buttons in the main menu.
   */
  public static final Integer MENU_BUTTON_PADDING = 40;

  /**
   * Private constructor to prevent instantiation of this utility class.
   */
  private UiConstants() { }
}
