package step3;

public enum OperatorType {
    ADD('+'),
    SUB('-'),
    MUL('*'),
    DIV('/');

    // 생성자가 호출될때 각 상수에 값을 셋팅해주는 역할
    private final char operator;

    // 생성자 - 각 상수를 객체화 시켜주는 역할
    OperatorType (char operator) {
        this.operator = operator;
    }

    // char → enum 변환
    public static OperatorType change(char op) {
        // 반복문을 통해 각 enum에 담긴 operator변수를 하나씩 가져와 매개변수 op와 비교
        for (OperatorType type : values()) {
            if (type.operator == op) {
                return type;
            }
        }
        // enum타입과 일치하는게 하나도 없으면 예외처리
        throw new IllegalArgumentException("잘못된 연산자입니다: " + op);
    }
}
