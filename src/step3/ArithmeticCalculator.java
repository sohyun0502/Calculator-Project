package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {

    private List<Double> list = new ArrayList<>(); // 연산 결과를 저장하는 컬렉션 타입 필드

    // 제네릭 타입의 숫자 2개와 enum으로 만든 OperatorType타입 연산자 1개를 매개변수로 받는 계산 함수
    public double calculate(T number1, T number2, OperatorType operatorType) {

        // T타입의 숫자 2개를 double타입으로 변경
        double num1 = number1.doubleValue();
        double num2 = number2.doubleValue();
        double result = 0;

        switch (operatorType) {
            case ADD:
                result = num1 + num2;
                break;
            case SUB:
                result = num1 - num2;
                break;
            case  MUL:
                result = num1 * num2;
                break;
            case  DIV:
                if(num2 == 0.0) {
                    // 예외처리 - 수학적 연산 오류이므로 ArithmeticException 사용
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                result = num1 / num2;
                break;
            default:
                // 예외처리 - 잘못된 인자를 입력했으므로 IllegalArgumentException 사용
                throw new IllegalArgumentException("잘못된 연산 기호입니다.");
        }
        // ArrayList에 연산 결과 저장
        list.add(result);
        return result;
    }

    // getter - 컬렉션에 담긴 결과 값들을 반환하는 메서드
    public List<Double> getList() {
        return list;
    }

    // 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값들을 출력하는 메서드
    public void printMaxList(T num) {
        double n = num.doubleValue();

        List<Double> maxList = list.stream()            // 1. stream()으로 데이터 흐름 생성
                .filter(number -> number > n)   // 2. filter()를 통해 입력받은 값보다 큰 저장값들만 반환하는 조건 작성
                .collect(Collectors.toList());          // 3. 반환하는 값들을 리스트 형태로 만듬
        System.out.println("연산결과 리스트 : " + getList());
        System.out.println("입력받은 값보다 큰 연산결과는 " + maxList + "입니다.");

    }
}
