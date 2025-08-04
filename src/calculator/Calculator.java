package calculator;

public class Calculator {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final CalculatorEngine engine;
    private final CalculationHistory history;
    private boolean useRadians = false;

    public Calculator() {
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
        this.engine = new CalculatorEngine();
        this.history = new CalculationHistory();
    }

    public void run() {
        outputHandler.printWelcomeMessage();
        this.useRadians = inputHandler.useRadians();

        do {
            try {
                System.out.println("\nВыберите действие:");
                System.out.println("1. Новое вычисление");
                System.out.println("2. Показать историю");
                System.out.println("3. Очистить историю");
                System.out.println("4. Переключить режим углов (градусы/радианы)");
                System.out.println("5. Выход");
                System.out.print("Ваш выбор: ");

                String choice = inputHandler.getMenuChoice();

                switch (choice) {
                    case "1":
                        performCalculation();
                        break;
                    case "2":
                        history.printHistory();
                        break;
                    case "3":
                        history.clearHistory();
                        break;
                    case "4":
                        toggleAngleMode();
                        break;
                    case "5":
                        outputHandler.printExitMessage();
                        return;
                    default:
                        System.out.println("Неверный выбор, попробуйте снова");
                }
            } catch (Exception e) {
                outputHandler.printError(e.getMessage());
            }
        } while (true);
    }

    private void toggleAngleMode() {
        useRadians = !useRadians;
        System.out.println("Режим углов изменен на: " +
                (useRadians ? "радианы" : "градусы"));
    }

    private void performCalculation() {
        Operation operation = inputHandler.getOperation();

        if (operation.isUnaryOperation()) {
            double num = inputHandler.getNumber();
            double result = engine.calculate(num, operation, useRadians);
            outputHandler.printResult(num, operation, result);
            history.addRecord(num, operation, result);
        } else {
            double num1 = inputHandler.getNumber();
            double num2 =  inputHandler.getNumber();
            double result = engine.calculate(num1, num2, operation);
            outputHandler.printResult(num1, num2, operation, result);
            history.addRecord(num1, num2, operation, result);
        }
    }
}