package mastermind;

import javafx.application.Application;
import javafx.stage.Stage;

public class Controller {

    public static class Main extends Application {


        @Override

        public void start(Stage stage) {

            new MMGUI().start();


        }

    }
}
