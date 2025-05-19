package filehandler.csvhandling;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * The {@code CsvIgnore} annotation indicates that a field should be ignored
 * by the CsvHandler when writing to or reading from a CSV file.
 *
 * @author jonastomren
 * @version 15.04.2025
 * @since 15.04.2025
 * @see CsvHandler
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CsvIgnore {
}
