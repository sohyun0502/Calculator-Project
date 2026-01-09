package step2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Integer> list = new ArrayList<>(); // 연산 결과를 저장하는 컬렉션 타입 필드

    // 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산 수행하는 메서드
    public int calculate(int number1, int number2, char operator) {
        int result = 0;

        switch (operator) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case  '*':
                result = number1 * number2;
                break;
            case  '/':
                if(number2 == 0) {
                    // 예외처리 - 수학적 연산 오류이므로 ArithmeticException 사용
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                } else {
                    result = number1 / number2;
                }
                break;
            default:
                // 예외처리 - 잘못된 인자를 입력했으므로 IllegalArgumentException 사용
                throw new IllegalArgumentException("잘못된 연산 기호입니다.");
        }
        list.add(result);
        return result;
    }

    // getter - 컬렉션에 담긴 결과 값들을 반환하는 메서드
    public List<Integer> getList() {
        return list;
    }

    // setter
    public void setList(List<Integer> list) {
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
}
