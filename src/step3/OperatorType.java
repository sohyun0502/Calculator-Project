package step3;

public enum OperatorType {
    ADD('+'),
    SUB('-'),
    MUL('*'),
    DIV('/');

    private final char operator;

    OperatorType (char operator) {
        this.operator = operator;
    }

    public char getOperator() {
        return operator;
    }

    // char → enum 변환
    public static OperatorType from(char operator) {
        for (OperatorType type : values()) {
            if (type.operator == operator) {
                return type;
            }
        }
        throw new IllegalArgumentException("잘못된 연산자입니다: " + operator);
    }
}
