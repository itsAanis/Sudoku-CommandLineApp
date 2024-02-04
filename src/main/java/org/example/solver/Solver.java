package org.example.solver;

import org.example.model.IGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Solver implements ISolver {
    private final IGrid grid;
    @Autowired
    public Solver(IGrid grid) {
        this.grid = grid;
    }

    public void solve () {

    }
}
