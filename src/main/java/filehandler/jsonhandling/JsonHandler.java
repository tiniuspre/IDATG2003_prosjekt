package filehandler.jsonhandling;

import com.fasterxml.jackson.databind.ObjectMapper;
import filehandler.AbstractFileHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The {@code JSONHandler} class handles all writing,
 * and reading to and from the json files. It uses generics to
 * adapt to different objects needed for input.
 *
 * @author jonastomren
 * @version 12.03.2025
 * @since 11.03.2025
 */
public class JsonHandler extends AbstractFileHandler {
  /**
   * The LOGGER object is used to log messages to the console.
   */
  private static final Logger LOGGER = Logger
      .getLogger(JsonHandler.class.getName());
  /**
   * The OBJECT_MAPPER object is used to map objects to and from json.
   */
  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  /**
   * Constructor for the JSONHandler class.
   *
   * @param inputPath the path to the json file.
   */
  public JsonHandler(final String inputPath) throws IOException {
    super(inputPath);
  }


  /**
   * Write an object to a json file.
   *
   * @param obj the object to write to the json file.
   */
  public void writeToFile(final Object obj) throws IOException {
    File jsonFile = new File(getPath());
    if (jsonFile.getParentFile().mkdirs()) {
      LOGGER.log(Level.WARNING, "Directory not found, "
          + "created new directory at: " + jsonFile.getParentFile());
    }
    if (jsonFile.createNewFile()) {
      LOGGER.log(Level.WARNING, "File not found, "
          + "created new file at: " + jsonFile);
    }
    try {
      OBJECT_MAPPER.writeValue(jsonFile, obj);
      LOGGER.log(Level.INFO, "File written to: " + jsonFile);
    } catch (IOException e) {
      throw new JsonHandlerException(e.getMessage(), Level.SEVERE);
    }
  }

  /**
   * Read from a json file.
   *
   * @param type the type of object to read from the json file.
   * @param <T> the type of object to read from the json file.
   * @return a list of objects read from the json file.
   * @throws IOException if an error occurs while reading from the file.
   */
  @Override
  public <T> List<T> readFromFile(final Class<T> type) throws IOException {
    if (type == null) {
      throw new NullPointerException("Type cannot be null");
    }
    File jsonFile = new File(getPath());
    if (jsonFile.getParentFile().mkdirs()) {
      LOGGER.log(Level.WARNING, "Directory not found, "
          + "created new directory at: " + jsonFile.getParentFile());
    }
    if (jsonFile.createNewFile()) {
      LOGGER.log(Level.WARNING, "File not found, "
          + "created new file at: " + jsonFile);
    }
    try {
      return OBJECT_MAPPER.readValue(jsonFile, OBJECT_MAPPER
          .getTypeFactory().constructCollectionType(List.class, type));
    } catch (IOException e) {
      LOGGER.log(Level.SEVERE, "Error reading from file", e);
      return new ArrayList<>();
    }
  }

  /**
   * Delete the json file.
   */
  @Override
  public void deleteFile() {
    File jsonFile = new File(getPath());
    if (jsonFile.delete()) {
      LOGGER.log(Level.WARNING, "File deleted: " + jsonFile);
    } else {
      throw new JsonHandlerException("File not found.", Level.SEVERE);
    }
  }

  /**
   * Checks if a string is a valid CSV file path.
   *
   * @param path The file path to check.
   * @return True if the path is a valid CSV file path, false otherwise.
   */
  public static boolean isValidJsonPath(final String path) {
    return path != null && path.endsWith(".json");
  }
}
