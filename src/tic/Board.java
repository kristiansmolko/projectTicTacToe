package tic;


import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Board {
    private int player = 1;
    Matrix mat = new Matrix();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public BorderPane createBoard(int[][] matrix){
        var board = new BorderPane();

        var stack = new StackPane();

        var grid = new GridPane();
        for (var i = 0; i < matrix.length; i++){
            for (var j = 0; j < matrix[0].length; j++) {
                var btn = createButton(j, i);
                grid.addRow(j, btn);
            }
        }

        stack.getChildren().addAll(grid);

        board.setCenter(stack);
        return board;
    }

    private Button createButton(int row, int col){
        var button = new Button(" ");
        button.setPrefWidth(25);
        button.setPrefHeight(25);
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (button.getText().equals(" ")){
                if (player == 1){
                    button.setText("X");
                    mat.setMatrix(row, col, player++);
                    checkWinner();
                } else if (player == 2){
                    button.setText("O");
                    mat.setMatrix(row, col, player);
                    player = 1;
                    checkWinner();
                }
            }
        });
        return button;
    }

    private void checkWinner(){
        if (mat.checkMatrix() != 0){
            if (player == 2) player--;
            else if (player == 1) player++;
            result();
            player = 0;
        }
    }

    private void result(){
        alert.setHeaderText("Winner is Player " + player);
        alert.setContentText("Try our game again please!");
        alert.setTitle("Result");
        alert.showAndWait();
    }

}
