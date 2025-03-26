package constants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstantsTest {

  @Test
  void testConstants() {
    assertThrows(IllegalStateException.class, () -> new Constants());
  }

}