package org.example.solver;

import org.example.model.IGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.concurrent.*;
import static java.util.concurrent.Executors.newFixedThreadPool;

@Component
public class Solver implements ISolver {

    private final int gridSize = 9;

    public Solver() {

    }

    //recursive back tracking algorithm
    public boolean solve (int[][] grid) {
       for (int row=0; row< gridSize; row++) {
           for (int column = 0; column < gridSize; column++) {
               if (grid[row][column] == 0){
                   for (int attempt = 1; attempt <= gridSize; attempt++ ) {
                       if (isPlacementValid(grid, row, column, attempt)){
                           grid[row][column] = attempt;

                           if(solve(grid)){
                               return true;
                           }
                           else {
                               grid[row][column]=0;
                           }
                       }
                   }
                   return false;
               }
           }
       }
        return true;
    }
    //creates threads to check if its valid to place concurrently
    private boolean isPlacementValid(int[][] board, int row, int col, int num) {
            ExecutorService executor = null;
        try {
        executor = newFixedThreadPool(3);
        Future<Boolean> rowCheck = executor.submit(() -> isRowValid(board, row, num));
            Future<Boolean> colCheck = executor.submit(() -> isColValid(board, col, num));
            Future<Boolean> boxCheck = executor.submit(() -> isBoxValid(board, row, col, num));

            boolean isValid = rowCheck.get() && colCheck.get() && boxCheck.get();
            executor.shutdown();
            return isValid;
        }
                catch (ExecutionException | InterruptedException | CancellationException e) {
                    assert executor != null;
                        executor.shutdown();
                     return false;
            }
    }


    // checks each space in row
    private boolean isRowValid(int[][] board, int row, int number) {
        for(int col=0; col < gridSize; col++){
            if (board[row][col]==number) return false;
        }
        return true;
    }
    // checks each space in column
    // for each column we go down the row.
    private boolean isColValid(int[][] board, int col, int number) {
        for (int row=0; row < gridSize; row++) {
            if (board[row][col] == number) return false;
        }
        return true;
    }
    // each space in the 3x3
    private boolean isBoxValid(int[][] board, int row, int col, int number) {
    int boxRow = row - (row % 3);
    int boxColumn = col - (col % 3);
    for(int i = boxRow; i< boxRow+3; i++) {
        for (int j = boxColumn; j < boxColumn + 3; j++) {
            if(board[i][j] == number){
                return  false;
            }
        }
    }
        return true;
    }



}
