package calculator;

public enum Operation {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    POWER("^"),
    SQRT("√"),
    ABS("| |"),
    FACTORIAL("!"),
    SIN("sin"),
    COS("cos"),
    TAN("tan");

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Operation fromSymbol(String symbol) {
        for (Operation op : values()) {
            if (op.symbol.equals(symbol) ||
                    (symbol.equals("sqrt") && op == SQRT) ||
                    (symbol.equals("abs") && op == ABS) ||
                    (symbol.equals("fact") && op == FACTORIAL)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Неизвестная операция: " + symbol);
    }

    public boolean isUnaryOperation() {
        return this == SQRT || this == ABS || this == FACTORIAL ||
                this == SIN || this == COS || this == TAN;
    }
}