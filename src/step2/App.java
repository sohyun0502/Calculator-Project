package step2;

import java.util.Scanner;
/*
 * STEP 2
 * 계산된 결과 값들을 기록하는 컬렉션을 만든다.
 * 컬렉션의 가장 먼저 저장된 데이터를 삭제하는 기능을 만든다.
 */

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator(); // Calculator 객체 생성

        while (true) {

            // 양의 정수(0 포함)만 입력되도록 반복문과 조건 걸어줌
            int number1;
            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요 (0 이상): ");
                number1 = sc.nextInt();
                if (number1 >= 0) break;
                System.out.println("0 이상의 정수만 입력할 수 있습니다.");
            }

            int number2;
            while (true) {
                System.out.print("두 번째 숫자를 입력하세요 (0 이상): ");
                number2 = sc.nextInt();
                if (number2 >= 0) break;
                System.out.println("0 이상의 정수만 입력할 수 있습니다.");
            }

            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            char operator = sc.next().charAt(0);

            // 0으로 나눌때와 연산기호를 잘못 입력했을때 예외처리
            try {
                int result = calculator.calculate(number1, number2, operator);
                System.out.println("결과: " + result);

                // 연산결과 저장한 리스트 출력
                System.out.println("연산결과 리스트 : " + calculator.getList());

                // 가장 먼저 저장된 연산결과 삭제
                if (!calculator.getList().isEmpty()) {
                    System.out.print("가장 먼저 저장된 데이터를 삭제하겠습니까 (y/n) : ");
                    char c = sc.next().charAt(0);
                    calculator.removeResult(c);
                }
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            // 'exit'를 입력하지 않으면 무한반복
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
            String exit = sc.next();

            // 'exit' 입력시 반복문을 빠져나옴
            if ("exit".equalsIgnoreCase(exit)) {
                System.out.println("======계산기가 종료됩니다======");
                break;
            }
        }

        sc.close();
    }
}
