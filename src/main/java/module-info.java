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
  opens gameengine.board to com.fasterxml.jackson.databind;
  opens snakesandladders.engine to com.fasterxml.jackson.databind;
  opens snakesandladders.engine.board to com.fasterxml.jackson.databind;
  opens snakesandladders.engine.board.tile to com.fasterxml.jackson.databind;
  exports ui;
  exports snakesandladders;
  exports snakesandladders.ui;
  exports ui.util;
  exports gameengine;
  exports snakesandladders.engine;
  exports snakesandladders.engine.board;
  exports snakesandladders.engine.board.tile;
  exports gameengine.player;
  exports gameengine.grid;
}
