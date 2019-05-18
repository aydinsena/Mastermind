package mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static javafx.scene.layout.AnchorPane.setLeftAnchor;
import static javafx.scene.layout.AnchorPane.setTopAnchor;

public class MMGUI {

    //Color[] colors = {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PURPLE, Color.ORANGE};
    final int numCols = 4;
    final int numRows = 10;
    final int feedbackCols = 2;
    final int feedbackRows = 20;

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
                "Welcome to Mastermind.\n" + "\n" +
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
         *The Scene itself can only have one root Pane. So if we want 2 panes in the Scene we will need 3 panes
         */
        StackPane rootPane = new StackPane();
        Scene gameScene = new Scene(rootPane, 1000, 750);

        /**
         * AnchorPane is the first "sub-pane" of the root pane.
         * It contains color options for users and "submit" button.
         * For color options Hbox is used. Hbox is more useful to keep aligned colorful circles.
         * The reason to use AnchorPane is because it is easier to change the coordination of colors and the "submit" button next to it.
         */
        AnchorPane anchorPane = new AnchorPane();

        HBox colorOptions = new HBox();
        colorOptions.setSpacing(15);
        
        Button red = new Button();
        Button yellow = new Button();
        Button green = new Button();
        Button blue = new Button();
        Button purple = new Button();
        Button orange = new Button();

        red.setStyle(
                "-fx-background-radius: 40em; " +
                        "-fx-min-width: 50px; " +
                        "-fx-min-height: 50px; " +
                        "-fx-max-width: 50px; " +
                        "-fx-max-height: 50px;" +
                        "-fx-background-color: Red"
        );
        yellow.setStyle(
                "-fx-background-radius: 40em; " +
                        "-fx-min-width: 50px; " +
                        "-fx-min-height: 50px; " +
                        "-fx-max-width: 50px; " +
                        "-fx-max-height: 50px;" +
                        "-fx-background-color: Gold"
        );
        green.setStyle(
                "-fx-background-radius: 40em; " +
                        "-fx-min-width: 50px; " +
                        "-fx-min-height: 50px; " +
                        "-fx-max-width: 50px; " +
                        "-fx-max-height: 50px;" +
                        "-fx-background-color: Green"
        );
        blue.setStyle(
                "-fx-background-radius: 40em; " +
                        "-fx-min-width: 50px; " +
                        "-fx-min-height: 50px; " +
                        "-fx-max-width: 50px; " +
                        "-fx-max-height: 50px;" +
                        "-fx-background-color: Blue"
        );
        purple.setStyle(
                "-fx-background-radius: 40em; " +
                        "-fx-min-width: 50px; " +
                        "-fx-min-height: 50px; " +
                        "-fx-max-width: 50px; " +
                        "-fx-max-height: 50px;" +
                        "-fx-background-color: Purple"
        );
        orange.setStyle(
                "-fx-background-radius: 40em; " +
                        "-fx-min-width: 50px; " +
                        "-fx-min-height: 50px; " +
                        "-fx-max-width: 50px; " +
                        "-fx-max-height: 50px;" +
                        "-fx-background-color: Orange"
        );

        colorOptions.getChildren().addAll(red, yellow, green, blue, purple, orange);



        setTopAnchor(colorOptions, 650.0);
        setLeftAnchor(colorOptions, 260.0);

        Button submitButton = new Button();
        submitButton.setText("Submit");
        submitButton.setPrefWidth(90);
        submitButton.setPrefHeight(50);
        setTopAnchor(submitButton, 650.0);
        setLeftAnchor(submitButton, 650.0);

        anchorPane.getChildren().addAll(colorOptions, submitButton);

        /**
         * GridPane
         */
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        gridPane.setPadding(new Insets(60, 300, 150, 280));
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints columnConst = new ColumnConstraints();
            columnConst.setPrefWidth(85);
            gridPane.getColumnConstraints().add(columnConst);
        }

        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPrefHeight(120);
            gridPane.getRowConstraints().add(rowConst);
        }

        /**
         * This pane for feedback is created separetely beacause the size of the cells will be different from the size of
         * @param gridpane.
         */

        GridPane feedbackPane = new GridPane();
        feedbackPane.setGridLinesVisible(true);
        feedbackPane.setPadding(new Insets(60, 270, 150, 650));
        for (int i = 0; i < feedbackCols; i++) {
            ColumnConstraints feedbackColumnConst = new ColumnConstraints();
            feedbackColumnConst.setPrefWidth(45);
            feedbackPane.getColumnConstraints().add(feedbackColumnConst);
        }

        for (int i = 0; i < feedbackRows; i++) {
            RowConstraints feedbackRowConst = new RowConstraints();
            feedbackRowConst.setPrefHeight(60);
            feedbackPane.getRowConstraints().add(feedbackRowConst);
        }

        //Add the panes to the root pane and set the scene for the panes
        rootPane.getChildren().addAll(anchorPane, gridPane, feedbackPane);
        gameStage.setScene(gameScene);
        gameStage.show();

    }


}






