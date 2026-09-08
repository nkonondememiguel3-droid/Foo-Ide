package e.dream.learn;

import atlantafx.base.theme.PrimerLight;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class Sandbox extends Application {

  @Override
  public void start( Stage stage ) throws IOException {

    Application.setUserAgentStylesheet( new PrimerLight().getUserAgentStylesheet() );

    FXMLLoader fxmlLoader = new FXMLLoader( Sandbox.class.getResource("sandbox-main-view.fxml") );
    Scene scene = new Scene(fxmlLoader.load());

    stage.setTitle("Sandbox");
    stage.setScene(scene);
    stage.show();

  }

}

