package org.example.model;

import org.springframework.stereotype.Component;

import static java.lang.System.*;
@Component
public class PhysicalGrid implements IGrid{

    public int[][] grid;
    private int gridSize = 9;
    public PhysicalGrid(){
        this.grid = new int[][]{
                { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
                { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
                { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
        };

    }

@Override
 public String toString() {
    StringBuilder str = new StringBuilder();
    for (int[] row : this.grid) {
        for (int num : row) {
            str.append(num != 0 ? num : ".").append(" ");
        }
        str.append("\n");
    }
    return str.toString();
}

   public int[][] getGrid () {
        return this.grid;
   }
}
