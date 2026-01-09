package step3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

        while (true) {

            System.out.print("첫 번째 숫자를 입력하세요: ");
            double number1 = sc.nextDouble();

            System.out.print("두 번째 숫자를 입력하세요: ");
            double number2 = sc.nextDouble();

            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            char operator = sc.next().charAt(0);

            // 0으로 나눌때와 연산기호를 잘못 입력했을때 예외처리
            try {
                double result = calculator.calculate(number1, number2, operator);
                System.out.println("결과: " + result);
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            // 'exit'를 입력하지 않으면 무한반복
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
            String exit = sc.next();

            // 'exit' 입력시 반복문을 빠져나옴
            if (exit.equals("exit")) {
                System.out.println("======계산기가 종료됩니다======");
                break;
            }
        }
        System.out.print("값을 입력하세요 : ");
        double num = sc.nextDouble();
        calculator.printMaxList(num);
    }
}
