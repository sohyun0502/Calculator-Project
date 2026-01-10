package step3;

public enum OperatorType {
    ADD('+'),
    SUB('-'),
    MUL('*'),
    DIV('/');

    private final char operator;

    // 생성자
    OperatorType (char operator) {
        this.operator = operator;
    }

    // char → enum 변환
    public static OperatorType change(char op) {
        for (OperatorType type : values()) {
            if (type.operator == op) {
                return type;
            }
        }
        throw new IllegalArgumentException("잘못된 연산자입니다: " + op);
    }
}
