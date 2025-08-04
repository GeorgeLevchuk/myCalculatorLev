package calculator;

public class AdvancedMathOperations {
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static double squareRoot(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Квадратный корень из отрицательного числа невозможен");
        }
        return Math.sqrt(num);
    }

    public static double absolute(double num) {
        return Math.abs(num);
    }

    public static long factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа невозможен");
        }
        if (num > 20) {
            throw new IllegalArgumentException("Факториал чисел больше 20 слишком велик");
        }

        long result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static double sin(double angle, boolean radians) {
        return radians ? Math.sin(angle) : Math.sin(Math.toRadians(angle));
    }

    public static double cos(double angle, boolean radians) {
        return radians ? Math.cos(angle) : Math.cos(Math.toRadians(angle));
    }

    public static double tan(double angle, boolean radians) {
        return radians ? Math.tan(angle) : Math.tan(Math.toRadians(angle));
    }
}