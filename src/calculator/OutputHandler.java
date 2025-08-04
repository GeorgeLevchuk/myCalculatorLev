package calculator;

public class OutputHandler {
    public void printResult(double num1, double num2, Operation operation, double result) {
        System.out.printf("Результат: %.2f %s %.2f = %.2f%n",
                num1, operation.getSymbol(), num2, result);
    }

    public void printResult(double num, Operation operation, double result) {
        System.out.printf("Результат: %s(%.2f) = %.2f%n",
                operation.getSymbol(), num, result);
    }

    public void printError(String message) {
        System.out.println("Ошибка: " + message);
    }

    public void printWelcomeMessage() {
        System.out.println("Консольный калькулятор с расширенными функциями");
        System.out.println("Поддерживаемые операции:");
        System.out.println("Базовые: +, -, *, /, ^ (степень)");
        System.out.println("Унарные: √ (корень), | | (модуль), ! (факториал)");
        System.out.println("Тригонометрические: sin, cos, tan\n");
    }

    public void printExitMessage() {
        System.out.println("Работа калькулятора завершена");
    }
}