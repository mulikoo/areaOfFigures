import enums.FigureType;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FigureAreaRunner {
    private final Scanner sc = new Scanner(System.in);
    private Map<String, FigureType> figureTypeMap = new HashMap<>();

    public FigureAreaRunner() {
        figureTypeMap = new HashMap<>();
        for (FigureType type : FigureType.values()) {
            figureTypeMap.put(type.getDescription(), type);
        }
    }

    public void run() {
        System.out.println("Поиск площади для фигур");
        FigureType type = readTheFigure();
        if (type == null) {
            System.out.println("Неизвестный тип фигуры. Попробуйте снова.");
            return;
        }
        double area = switch (type) {
            case SQUARE -> {
                System.out.println("Введите длину стороны квадрата:");
                double  side = promptPositiveDouble();
                yield FigureAreaCalculator.calculateSquareArea(side);
            }
            case CIRCLE -> {
                System.out.println("Введите радиус круга:");
                double radius = promptPositiveDouble();
                yield FigureAreaCalculator.calculateCircleArea(radius);
            }
            case RECTANGLE -> {
                System.out.println("Введите длину прямоугольника:");
                double length = promptPositiveDouble();
                System.out.println("Введите ширину прямоугольника:");
                double width = promptPositiveDouble();
                yield FigureAreaCalculator.calculateRectangleArea(length, width);
            }
        };
        System.out.printf("Площадь = %.2f%n", area);
    }

    private FigureType readTheFigure() {
        System.out.print("Выберите фигуру (квадрат, круг, прямоугольник): ");
        String input = sc.nextLine().trim().toLowerCase();
        return figureTypeMap.get(input);
    }

    private double promptPositiveDouble() {
        while (true) {
            if (sc.hasNextDouble()) {
                double value = sc.nextDouble();
                sc.nextLine();
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Ошибка: число должно быть положительным.");
                }
            } else {
                sc.nextLine();
                System.out.println("Ошибка: введите корректное число.");
            }
        }
    }
}

