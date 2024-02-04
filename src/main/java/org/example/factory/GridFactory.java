package org.example.factory;

import org.example.model.IGrid;
import org.example.model.PhysicalGrid;

public class GridFactory {
    public static IGrid createGrid(GridType type) {
        switch (type) {
            case Physical:
                return new PhysicalGrid();
            default:
                throw new IllegalArgumentException("Unsupported grid type: " + type);
        }
    }
public enum GridType {
        Physical
}
}
