module e.dream {
  requires javafx.controls;
  requires javafx.fxml;
  requires atlantafx.base;

  opens e.dream to javafx.fxml;

  exports e.dream;
}

