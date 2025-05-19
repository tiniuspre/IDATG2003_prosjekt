package filehandler;

import filehandler.csvhandling.CsvUtils;
import filehandler.jsonhandling.JsonHandler;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Abstract class for handling file operations.
 *
 * <p>Provides methods to create, set path, and read from files. Writing
 * is handled in individual concrete classes due to differences.</p>
 *
 * @author jonastomren
 * @version 27.04.2025
 * @since 31.03.2025
 */
public abstract class AbstractFileHandler {
  /**
   * The path of the file.
   */
  private String path = "";
  /**
   * The logger of the File Handler.
   */
  private static final Logger LOGGER =
      Logger.getLogger(AbstractFileHandler.class.getName());

  /**
   * Constructor to initialize the file handler with the given path.
   *
   * @param inputPath The path to the file.
   */
  public AbstractFileHandler(final String inputPath) {
    setPath(inputPath);
  }

  /**
   * Creates a new file at the specified inputPath,
   * including any necessary parent directories.
   *
   * @param inputPath The inputPath where the new file should be created.
   * @return The created file.
   */
  public static File createNewFile(final String inputPath) {
    try {
      File file = new File(inputPath);
      if (file.getParentFile().mkdirs()) {
        LOGGER.log(Level.WARNING, "Directory not found, "
            + "created new directory at: " + file.getParentFile());
      }
      if (file.createNewFile()) {
        LOGGER.log(Level.WARNING,
            "File not found, created new file at: " + file);
      }
      return file;
    } catch (IOException e) {
      throw new FileHandlerException("I/O error when creating file:"
          + e.getMessage());
    }
  }

  /**
   * Sets the path for the CSV or JSON file.
   *
   * @param inputPath The path to the file.
   * @throws IllegalArgumentException If the path is invalid.
   */
  public void setPath(final String inputPath) {
    if (inputPath == null || inputPath.isBlank()) {
      throw new IllegalArgumentException("Path cannot be null.");
    }
    if (!CsvUtils.isValidCsvPath(inputPath)
        && !JsonHandler.isValidJsonPath(inputPath)) {
      throw new FileHandlerException(
          "Not valid json or csv path.", Level.SEVERE);
    }
    File file = createNewFile(inputPath);
    this.path = inputPath;
  }

  /**
   * Gets the current path of the file.
   *
   * @return The path of the file.
   */
  public String getPath() {
    return this.path;
  }

  /**
   * Reads data from the file and returns it as a list of the specified type.
   *
   * @param <T> The type of the data to be read.
   * @param type The class of the type.
   * @return A list of data read from the file.
   * @throws IOException If an I/O error occurs.
   */
  public <T> List<T> readFromFile(final Class<T> type) throws IOException {
    throw new IllegalStateException();
  }

  /**
   * Deletes the file.
   */
  public void deleteFile() {
  }
}
