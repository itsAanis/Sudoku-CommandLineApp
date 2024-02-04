package org.example.manager;

import org.example.model.IGrid;
import org.example.solver.ISolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SudokuManager {
    private final IGrid grid;
    private final ISolver solver;
    @Autowired
    public SudokuManager(IGrid grid ,ISolver solver) {
        this.grid = grid;
        this.solver = solver;
    }

   public void start () {
        mytest();
     String result = grid.toString();
     System.out.println(result);
   }

    private void mytest () {
        grid.test("heey");
    }
}
