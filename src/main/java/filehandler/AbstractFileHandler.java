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
 * Provides methods to create, set path, and read from files.
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
   * @throws IOException If an I/O error occurs.
   */
  public AbstractFileHandler(final String inputPath) throws IOException {
    setPath(inputPath);
  }

  /**
   * Creates a new file at the specified inputPath,
   * including any necessary parent directories.
   *
   * @param inputPath The inputPath where the new file should be created.
   * @return The created file.
   * @throws IOException If an I/O error occurs.
   */
  public static File createNewFile(final String inputPath) throws IOException {
    File file = new File(inputPath);
    if (file.getParentFile().mkdirs()) {
      LOGGER.log(Level.WARNING, "Directory not found, "
          + "created new directory at: " + file.getParentFile());
    }
    if (file.createNewFile()) {
      LOGGER.log(Level.WARNING, "File not found, created new file at: " + file);
    }
    return file;
  }

  /**
   * Sets the path for the CSV or JSON file.
   *
   * @param inputPath The path to the file.
   * @throws IOException If an I/O error occurs.
   * @throws IllegalArgumentException If the path is invalid.
   */
  public void setPath(final String inputPath) throws IOException {
    if (inputPath == null || inputPath.isBlank()) {
      throw new IllegalArgumentException("Path cannot be null.");
    }
    if (!CsvUtils.isValidCsvPath(inputPath)
        || !JsonHandler.isValidJsonPath(inputPath)) {
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
