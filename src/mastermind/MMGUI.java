package mastermind;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.geometry.Insets;

import java.awt.*;

import static javafx.scene.layout.AnchorPane.setLeftAnchor;
import static javafx.scene.layout.AnchorPane.setTopAnchor;

public class MMGUI {

    Color[] colors = {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PURPLE, Color.ORANGE};
    final int numCols = 4;
    final int numRows = 10;

    public void start() {
        // set title for the stage
        Stage stage = new Stage();
        stage.setTitle("Welcome to Mastermind Game");

        // create a Stack pane
        AnchorPane pane = new AnchorPane();
        pane.setStyle("-fx-background-color: white;");

        // create a scene
        Scene scene = new Scene(pane, 900, 650);

        // create a label for rules
        Label rules = new Label();
        setTopAnchor(rules, 20.0);
        setLeftAnchor(rules, 85.0);

        rules.setText(
                " Welcome to Mastermind.\n" + "\n" +
                        "The object of Mastermind is to guess a secret code consisting\n" +
                        "of a series of 4 colored pegs.\n\n" +
                        "Each peg will be of one of 6 colors: \n\n" +
                        " – Red \n" +
                        " – Yellow \n" +
                        " – Green \n" +
                        " – Blue \n" +
                        " – Purple \n" +
                        " – Orange \n\n" +
                        "More than one peg in the secret code could be of the same color.\n" +
                        "You must guess the correct color " +
                        "and order of the code. \n" +
                        "You have only 10 shots to guess the code.\n\n" +
                        "After every guess, the computer will provide you feedback in the form of \n" +
                        "0 to 4 colored pegs:\n\n" +
                        "– A black peg indicates that a peg in your guess is of the correct color and is in the correct position.\n" +
                        "– A white peg indicates that a peg in your guess is of the correct color but is not in the correct position.\n\n" +
                        "NOTE: The order of the feedback pegs does not correspond to either the pegs in the code or the pegs in your guess.\n\n " +
                        "Please click OK if you are ready!"
        );
        rules.setWrapText(true);

        //Add rules to the pane
        pane.getChildren().add(rules);
        rules.setFont(new Font("Arial", 15));

        //button to start the game
        Button button = new Button("OK");
        setTopAnchor(button, 525.0);
        setLeftAnchor(button, 420.0);
        button.setPrefHeight(80.0);
        button.setPrefWidth(80.0);

        //create an event that opens the game board when clicking OK

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
                GameBoard();
            }
        });

        pane.getChildren().addAll(button);

        // set the scene
        stage.setScene(scene);
        stage.show();

    }

    /*
        Create the board
     */
    public void GameBoard() {

        //Stage for the scene
        Stage gameStage = new Stage();
        gameStage.setTitle("Mastermind");

        /**
         *The Scene it self can only have one root Pane. So if we want 2 panes in the Scene we will need 3.
         */
        StackPane rootPane = new StackPane();
        Scene gameScene = new Scene(rootPane, 1000, 650);

        /**
         * AnchorPane is the first "sub-pane" of the root pane.
         * It contains color options for users and "submit" button.
         * For color options Hbox is used. Hbox is more useful to keep aligned colorful circles.
         * The reason to use AnchorPane is because it is easier to change the coordination of colors and the "submit" button next to it.
         */
        AnchorPane anchorPane = new AnchorPane();

        HBox colorOptions = new HBox();
        colorOptions.setSpacing(20);
        for (int i = 0; i < 6; i++) {
            Circle circle = new Circle(20);
            circle.setFill(colors[i]);
            colorOptions.getChildren().add(circle);
        }
        setTopAnchor(colorOptions, 570.0);
        setLeftAnchor(colorOptions, 270.0);

        Button submitButton = new Button();
        submitButton.setText("Submit");
        submitButton.setPrefWidth(100);
        submitButton.setPrefHeight(50);
        setTopAnchor(submitButton, 565.0);
        setLeftAnchor(submitButton, 640.0);

        anchorPane.getChildren().addAll(colorOptions, submitButton);

        /**
         * GridPane
         */
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints columnConst = new ColumnConstraints();
            columnConst.setPrefWidth(40);
            gridPane.getColumnConstraints().add(columnConst);
        }

        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPrefHeight(40);
            gridPane.getRowConstraints().add(rowConst);
        }

        //Add the panes to the root pane and set the scene for the panes
        rootPane.getChildren().addAll(anchorPane, gridPane);
        gameStage.setScene(gameScene);
        gameStage.show();

    }


}






