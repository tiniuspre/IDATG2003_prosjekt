package ui.util;

import ui.exceptions.CssLoaderException;

import java.net.URL;

public final class CssLoader {
  private CssLoader() { }

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
