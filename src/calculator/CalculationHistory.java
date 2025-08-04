package calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculationHistory {
    private final List<String> history = new ArrayList<>();

    public void addRecord(double num1, double num2, Operation operation, double result) {
        String record = String.format("%.2f %s %.2f = %.2f",
                num1, operation.getSymbol(), num2, result);
        history.add(record);
    }

    public void addRecord(double num, Operation operation, double result) {
        String record = String.format("%s(%.2f) = %.2f",
                operation.getSymbol(), num, result);
        history.add(record);
    }

    public void printHistory() {
        if (history.isEmpty()) {
            System.out.println("История вычислений пуста");
            return;
        }

        System.out.println("\nИстория вычислений:");
        for (int i = 0; i < history.size(); i++) {
            System.out.println((i + 1) + ". " + history.get(i));
        }
        System.out.println();
    }

    public void clearHistory() {
        history.clear();
        System.out.println("История вычислений очищена");
    }
}