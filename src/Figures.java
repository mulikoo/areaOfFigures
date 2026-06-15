import java.util.Scanner;

public class Figures {
    private final Scanner sc = new Scanner(System.in);

    public void square() {
        System.out.println("Выберите фигуру: квадрат, круг, прямоугольник");
        String figureType = sc.nextLine().toLowerCase();
        double squareFigure = 0;
        switch (figureType) {
            case "квадрат":
                System.out.println("Введите длину стороны квадрата:");
                double x = sc.nextDouble();
                squareFigure = x * x;
                System.out.println("Площадь квадрата = " + squareFigure);
                break;

            case "круг":
                System.out.println("Введите радиус круга");
                double y = sc.nextDouble();
                squareFigure = Math.PI * y * y;
                System.out.println("Площадь круга = " + squareFigure);
                break;

            case "прямоугольник":
                System.out.println("Введите длину прямоугольника");
                double z = sc.nextDouble();
                System.out.println("Введите ширину прямоугольника");
                double r = sc.nextDouble();
                squareFigure = z * r;
                System.out.println("Площадь прямоугольника = " + squareFigure);
                break;

            default:
                System.out.println("Был введен не известный тип фигуры. Попробуйте еще раз. " +
                        "Доступны: квадрат, круг, прямоугольник");
        }
    }
}

