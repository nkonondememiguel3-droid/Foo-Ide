module e.dream {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.kordamp.ikonli.core;
  requires org.kordamp.ikonli.javafx;
  requires org.kordamp.ikonli.fontawesome5;

  requires atlantafx.base;
  requires org.fxmisc.richtext;

  opens e.dream to javafx.fxml;
  exports e.dream;
}

