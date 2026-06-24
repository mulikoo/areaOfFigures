package enums;

import java.util.HashMap;
import java.util.Map;

public enum FigureType {
    SQUARE("квадрат"),
    CIRCLE("круг"),
    RECTANGLE("прямоугольник")
    ;

    private final String description;

    FigureType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    private static final Map<String, FigureType> mapFigureType = new HashMap<>();
    static {
        for (FigureType figureType : FigureType.values()) {
            mapFigureType.put(figureType.getDescription(), figureType);
        }
    }

    public static FigureType getFigureType(String name) {
        return mapFigureType.get(name.toLowerCase());
    }
}