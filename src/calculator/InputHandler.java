package calculator;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public double getNumber() {
        while (true) {
            try {
                System.out.print("Введите число: ");
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите корректное число");
            }
        }
    }

    public Operation getOperation() {
        while (true) {
            try {
                System.out.print("Введите операцию (+,-,*,/,^,√,| |,!,sin,cos,tan): ");
                String input = scanner.nextLine().trim();
                return Operation.fromSymbol(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    public boolean askToContinue() {
        System.out.print("Продолжить вычисления? (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y") || input.equals("yes");
    }

    public boolean useRadians() {
        System.out.print("Использовать радианы? (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y") || input.equals("yes");
    }

    public String getMenuChoice() {
        return scanner.nextLine().trim();
    }

    public void close() {
        scanner.close();
    }
}