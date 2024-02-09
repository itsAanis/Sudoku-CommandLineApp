package org.example.service;

import org.example.factory.GridFactory;
import org.example.model.IGrid;
import org.example.solver.ISolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SudokuService implements IService{

    private final GridFactory gridFactory;
    private ISolver solver;
    private IGrid currentGrid;

    @Autowired
    public SudokuService(GridFactory gridFactory, ISolver solver) {
        this.gridFactory = gridFactory;
        this.solver = solver;
    }

    public String start(String type) {
        GridFactory.GridType grid = GridFactory.GridType.valueOf(type);
        this.currentGrid = gridFactory.createGrid(grid);
        String stringGrid = currentGrid.toString();
        return stringGrid;
    }

    public String solve() {
        if (this.solver == null || this.currentGrid == null) {
            return "Solver or grid has not been created.";
        }
       boolean solved = solver.solve(currentGrid.getGrid());
        if (solved) {
            return currentGrid.toString();}
        else {
            return "Could not solve the puzzle.";
            }

    }



}
