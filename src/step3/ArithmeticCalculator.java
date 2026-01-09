package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    private T number1;
    private T number2;
    private char operator;
    private List<Double> list = new ArrayList<>(); // 연산 결과를 저장하는 컬렉션 타입 필드

    // 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산 수행하는 메서드
    public double calculate(T number1, T number2, char operator) {
        double num1 = number1.doubleValue();
        double num2 = number2.doubleValue();
        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case  '*':
                result = num1 * num2;
                break;
            case  '/':
                if(num2 == 0.0) {
                    // 예외처리 - 수학적 연산 오류이므로 ArithmeticException 사용
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                } else {
                    result = num1 / num2;
                }
                break;
            default:
                // 예외처리 - 잘못된 인자를 입력했으므로 IllegalArgumentException 사용
                throw new IllegalArgumentException("잘못된 연산 기호입니다: " + operator);
        }
        list.add(result);
        return result;
    }

    // getter - 컬렉션에 담긴 결과 값들을 반환하는 메서드
    public List<Double> getList() {
        return list;
    }

    // setter
    public void setList(List<Double> list) {
        this.list = list;
    }

    // 컬렉션에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 메서드
    public void removeResult(char c) {
        if (Character.toLowerCase(c) == 'y') {
            list.remove(0);
            System.out.println("데이터를 삭제했습니다.");
            System.out.println("연산결과 리스트 : " + getList());
        } else if (Character.toLowerCase(c) == 'n') {
            System.out.println("삭제하지 않았습니다.");
            System.out.println("연산결과 리스트 : " + getList());
        } else {
            System.out.println("y 또는 n을 입력해주세요.");
        }
    }

    // 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값들을 출력하는 메서드
    public void printMaxList(T num) {
        double n = num.doubleValue();

        List<Double> maxList = list.stream()
                .filter(number -> number > n)
                .toList();
        System.out.println("연산결과 리스트 : " + getList());
        System.out.println("입력받은 값보다 큰값 리스트 : " + maxList);

    }
}
