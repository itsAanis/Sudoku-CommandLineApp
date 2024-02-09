package org.example.manager;


import org.example.service.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class SudokuManager {

    private final IService service;
    @Autowired
    public SudokuManager(IService service) {
        this.service = service;
    }

    @ShellMethod("Selects and prints a Sudoku grid.")
    public String printGrid(@ShellOption(defaultValue = "Physical") String type) {
        if ("Physical".equalsIgnoreCase(type)) {
          return "\n" + service.start(type);
        }
        else {
            return "Currently, only 'Physical' grid type is supported.";
        }
    }

    @ShellMethod("solves the Sudoku grid selected")
    public String Solve() {
    return "\n" + service.solve();
    }

}
