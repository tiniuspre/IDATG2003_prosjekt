package gameengine;

/**
 * Subject interface for the Observer design pattern.
 *
 * @author jonastomren
 * @version 25.04.2025
 * @since 25.04.2025
 */
public interface Subject {
  /**
   * Registers an observer to be notified of changes.
   *
   * @param observer the observer to register.
   */
  void registerObserver(Observer observer);

  /**
   * Unregisters an observer from receiving notifications.
   *
   * @param observer the observer to unregister.
   */
  void removeObserver(Observer observer);
  /**
   * Notifies all registered observers of changes.
   */
  void notifyObservers();
}
