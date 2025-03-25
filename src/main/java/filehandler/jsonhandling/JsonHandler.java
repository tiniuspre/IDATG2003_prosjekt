package filehandler.jsonhandling;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class JsonHandler {
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
   * The path to the json file.
   */
  private String path = "";

  /**
   * Constructor for the JSONHandler class.
   *
   * @param inputPath the path to the json file.
   */
  public JsonHandler(final String inputPath) {
    setPath(inputPath);
  }

  /**
   * Set the path to the json file.
   *
   * @param inputPath the path to the json file.
   * @throws IllegalArgumentException if the path is null´or empty.
   */
  public void setPath(final String inputPath) throws IllegalArgumentException {
    if (inputPath == null || inputPath.isBlank()) {
      throw new IllegalArgumentException("Path cannot be null");
    }
    this.path = inputPath;
  }

  /**
   * Get the path to the json file.
   *
   * @return the path to the json file.
   */
  public String getPath() {
    return this.path;
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
      LOGGER.log(Level.SEVERE, "Error writing to file", e);
      throw new JsonHandlerException(e.getMessage());
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
  public void deleteFile() {
    File jsonFile = new File(getPath());
    if (jsonFile.delete()) {
      LOGGER.log(Level.WARNING, "File deleted: " + jsonFile);
    } else {
      throw new JsonHandlerException("File not found.");
    }
  }

}
