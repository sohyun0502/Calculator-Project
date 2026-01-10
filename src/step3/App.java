package step3;

import java.util.Scanner;
/*
 * STEP 3
 * 양의 정수만 받을 수 있었지만, 이제부터는 실수도 받을 수 있게 수정한다.
 * 결과가 저장되어 있는 컬렉션을 조회하는 기능을 만든다.
 * 그 때 특정 값보다 큰 결과 값을 출력할 수 있도록 한다.
 */

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

        while (true) {
            try {
                // 숫자
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double number1 = sc.nextDouble();

                System.out.print("두 번째 숫자를 입력하세요: ");
                double number2 = sc.nextDouble();

                // 연산자 입력
                System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");

                String input = sc.next();
                if (input.length() != 1) {
                    throw new IllegalArgumentException("연산자는 한 글자만 입력하세요.");
                }
                char op = input.charAt(0);

                // char → enum 변환
                OperatorType operatorType = OperatorType.change(op);

                // 계산
                double result = calculator.calculate(number1, number2, operatorType);
                System.out.println("결과: " + result);

            } catch (ArithmeticException | IllegalArgumentException e) {
                // 0으로 나누기, 잘된된 연산자 처리
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
        System.out.print("값을 입력하세요 : ");
        double num = sc.nextDouble();
        calculator.printMaxList(num);

        sc.close();
    }
}
