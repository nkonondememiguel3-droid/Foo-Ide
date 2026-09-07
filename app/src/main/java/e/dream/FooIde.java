package e.dream;

import atlantafx.base.theme.PrimerLight;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class FooIde extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Application.setUserAgentStylesheet( new PrimerLight().getUserAgentStylesheet() );

        FXMLLoader fxmlLoader =
            new FXMLLoader(FooIde.class.getResource("main-view.fxml"));
        Scene scene = new Scene( fxmlLoader.load() );
        stage.setTitle("foo-ide");
        stage.setScene(scene);

        stage.show();
    }

}

