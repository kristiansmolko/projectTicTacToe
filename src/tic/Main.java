package tic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    Board board = new Board();
    private static int[][] matrix = new int[][] {
            {0,0,2,0,0,0,0,0,0,0,1,1,1,1,1},
            {0,0,2,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,2,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,2,0,0,0,0,0,0,0,0,1,0,0,0},
            {0,0,2,0,0,0,0,0,0,0,1,0,0,0,0},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    };

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        root.setCenter(board.createBoard(matrix));
        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}