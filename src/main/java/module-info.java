module IDATG2003.prosjekt {
  requires javafx.controls;
  requires javafx.graphics;
  requires org.jetbrains.annotations;
  requires java.logging;
  requires com.fasterxml.jackson.databind;
  opens filehandler to com.fasterxml.jackson.databind;

}
