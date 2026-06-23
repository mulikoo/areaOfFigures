public final class FigureCalculator {

    private FigureCalculator() {

    }

    public static double calculateSquareArea(double side) {
        return side * side;
    }

    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static double calculateRectangleArea(double length, double width) {
        return length * width;
    }
}
