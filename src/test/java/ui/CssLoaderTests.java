package ui;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ui.exceptions.CssLoaderException;
import ui.util.CssLoader;

class CssLoaderTest {

  @Test
  void retrievesCssPathForValidFile() {
    String cssPath = CssLoader.getCssPath("/style/menu.css");
    assertNotNull(cssPath);
    assertTrue(cssPath.endsWith("/style/menu.css"));
  }

  @Test
  void throwsExceptionWhenCssFileNameIsNull() {
    CssLoaderException exception = assertThrows(CssLoaderException.class, () -> {
      CssLoader.getCssPath(null);
    });
    assertEquals("CSS file name cannot be null or empty", exception.getMessage());
  }

  @Test
  void throwsExceptionWhenCssFileNameIsEmpty() {
    CssLoaderException exception = assertThrows(CssLoaderException.class, () -> {
      CssLoader.getCssPath("");
    });
    assertEquals("CSS file name cannot be null or empty", exception.getMessage());
  }

  @Test
  void throwsExceptionWhenCssFileNotFound() {
    CssLoaderException exception = assertThrows(CssLoaderException.class, () -> {
      CssLoader.getCssPath("/style/nonexistent.css");
    });
    assertEquals("CSS file not found: /style/nonexistent.css", exception.getMessage());
  }
}
