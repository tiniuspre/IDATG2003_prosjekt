package ui.util;

import ui.exceptions.CssLoaderException;

import java.net.URL;

/**
 * Utility class for loading CSS files.
 * Provides methods to retrieve the path of a CSS file and handle related exceptions.
 *
 * This class is final and cannot be instantiated.
 *
 * @author tiniuspre
 * @version 25.04.2025
 * @since 25.03.2025
 */
public final class CssLoader {

  /**
   * Private constructor to prevent instantiation of this utility class.
   */
  private CssLoader() { }

  /**
   * Retrieves the external form of the URL path for the specified CSS file.
   * Throws a {@link CssLoaderException} if the file name is null, empty, or not found.
   *
   * @param cssFile the name of the CSS file to load.
   * @return the external form of the URL path for the CSS file.
   * @throws CssLoaderException if the CSS file name is null, empty, or not found.
   */
  public static String getCssPath(String cssFile) {
    if (cssFile == null || cssFile.isEmpty()) {
      throw new CssLoaderException("CSS file name cannot be null or empty");
    }
    URL css = CssLoader.class.getResource(cssFile);
    if (css == null) {
      throw new CssLoaderException("CSS file not found: " + cssFile);
    }
    return css.toExternalForm();
  }
}
