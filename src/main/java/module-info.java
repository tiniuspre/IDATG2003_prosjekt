module IDATG2003.prosjekt {
  requires javafx.controls;
  requires javafx.graphics;
  requires org.jetbrains.annotations;
  requires java.logging;
  requires com.fasterxml.jackson.databind;
  requires com.opencsv;
  opens filehandler to com.fasterxml.jackson.databind;
  opens filehandler.csvhandling to com.fasterxml.jackson.databind;
  opens filehandler.jsonhandling to com.fasterxml.jackson.databind;
}
