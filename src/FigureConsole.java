import enums.FigureType;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FigureConsole {
    private final Scanner sc = new Scanner(System.in);
    private final Map<String, FigureType> figureTypeMap = new HashMap<>();

    public  FigureConsole() {
        figureTypeMap.put("квадрат", FigureType.SQUARE);
        figureTypeMap.put("круг", FigureType.CIRCLE);
        figureTypeMap.put("прямоугольник", FigureType.RECTANGLE);
    }

    public void run() {
        System.out.println("Поиск площади для фигур");
        FigureType type = promptFigureType();
        if (type == null) {
            System.out.println("Неизвестный тип фигуры. Попробуйте снова.");
            return;
        }
        double area = switch (type) {
            case SQUARE -> {
                double side = promptPositiveDouble("Введите длину стороны квадрата:");
                yield FigureCalculator.calculateSquareArea(side);
            }
            case CIRCLE -> {
                double radius = promptPositiveDouble("Введите радиус круга:");
                yield FigureCalculator.calculateCircleArea(radius);
            }
            case RECTANGLE -> {
                double length = promptPositiveDouble("Введите длину прямоугольника:");
                double width = promptPositiveDouble("Введите ширину прямоугольника:");
                yield FigureCalculator.calculateRectangleArea(length, width);
            }
        };
        System.out.printf("Площадь = %.2f%n", area);
    }

    private FigureType promptFigureType() {
        System.out.print("Выберите фигуру (квадрат, круг, прямоугольник): ");
        String input = sc.nextLine().trim().toLowerCase();
        return figureTypeMap.get(input);
    }

    private double promptPositiveDouble(String message) {
        while (true) {
            System.out.print(message + " ");
            if (sc.hasNextDouble()) {
                double value = sc.nextDouble();
                sc.nextLine();
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Ошибка: число должно быть положительным.");
                }
            } else {
                String invalid = sc.nextLine();
                System.out.println("Ошибка: введите корректное число.");
            }
        }
    }
}

