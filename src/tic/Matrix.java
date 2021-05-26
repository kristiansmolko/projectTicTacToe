package tic;

public class Matrix {
    private int[][] matrix = new int[][] {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    };
    private int winner = 0;

    private int checkRow(int j){
        for (var i = 0; i <= 10; i++){
            var result = 1;
            for (var next = i; next < i+5; next++)
                result *= matrix[j][next];
            if (checkWinner(result) != 0) {
                winner = checkWinner(result);
                break;
            }
        }
        return winner;
    }

    private int checkCol(int i){
        for (var j = 0; j <= 10; j++){
            var result = 1;
            for (var next = j; next < j+5; next++)
                result *= matrix[next][i];
            if (checkWinner(result) != 0) {
                winner = checkWinner(result);
                break;
            }
        }
        return winner;
    }

    private int checkDiagonaleX(int i){
        for (var j = 0; j <= 10; j++){
            var result = 1;
            var temp = i;
            for (var next = j; next < j+5; next++)
                result *= matrix[temp++][next];
            if (checkWinner(result) != 0) {
                winner = checkWinner(result);
                break;
            }
        }
        return winner;
    }

    private int checkDiagonaleY(int i){
        i = i - 1;
        for (var j = 0; j <= 10; j++){
            var result = 1;
            var temp = i;
            for (var next = j; next < j+5; next++)
                result *= matrix[next][temp--];
            if (checkWinner(result) != 0) {
                winner = checkWinner(result);
                break;
            }
        }
        return winner;
    }

    private int checkWinner(int result){
        var winner = 0;
        if (result == 1) {
            winner = 1;
        } else if (result == 32){
            winner = 2;
        }
        return winner;
    }

    private int checkRows(){
        for (var row = 0; row <= 10; row++)
            if (checkRow(row) != 0) break;
        return winner;
    }

    private int checkCols(){
        for (var col = 0; col <= 10; col++)
            if (checkCol(col) != 0) break;
        return winner;
    }

    private int checkDiagonals(){
        for (var row = 0; row <= 10; row++)
            if (checkDiagonaleX(row) != 0) break;
        if (winner != 0)
            for (var row = 14; row >= 4; row--)
                if (checkDiagonaleY(row) != 0) break;
        return winner;
    }

    public int checkMatrix(){
        if (checkRows() != 0 || checkCols() != 0 || checkDiagonals() != 0){
            System.out.println("And winner is Player " + winner);
            return winner;
        } else if (!isFull())
            System.out.println("Unfortunately, noone is winner");

        return winner;
    }

    public void setMatrix(int row, int col, int player){
        matrix[row][col] = player;
    }

    private boolean isFull(){
        var full = false;
        for (int[] ints : matrix)
            for (var j = 0; j < matrix[0].length; j++) {
                full = ints[j] == 0;
                if (full) return full;
            }
        return full;
    }
}
