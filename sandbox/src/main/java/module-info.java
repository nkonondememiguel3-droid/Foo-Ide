module e.dream.learn {

  requires javafx.controls;
  requires javafx.fxml;
  requires atlantafx.base;

  opens e.dream.learn to javafx.fxml;

  exports e.dream.learn;

}

