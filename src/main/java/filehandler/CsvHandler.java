package filehandler;


import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * The {@code CsvHandler} class handles all writing, and reading to and from the csv files.
 *
 * @author jonastomren
 * @version 15.03.2025
 * @since 15.03.2025
 */
public class CsvHandler {

  private static final Logger LOGGER = Logger.getLogger(CsvHandler.class.getName());
  private String path = "";

  public final void setPath(final String inputPath) throws IOException{
    if (inputPath == null || inputPath.isBlank()) {
      throw new IllegalArgumentException("Path cannot be null");
    }
    File file = new File(inputPath);
    if (file.getParentFile().mkdirs()) {
      LOGGER.log(Level.WARNING, "Directory not found, "
          + "created new directory at: " + file.getParentFile());
    }
    if (file.createNewFile()) {
      LOGGER.log(Level.WARNING, "File not found, "
          + "created new file at: " + file);
    }
    this.path = inputPath;
  }

  public String getPath() {
    return path;
  }


  // TODO: Implement read and write methods for csv files.
}
