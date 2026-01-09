package step1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.print("첫 번째 숫자를 입력하세요: ");
            int number1 = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int number2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            char operator = sc.next().charAt(0);

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
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        continue;
                    } else {
                        result = number1 / number2;
                        break;
                    }
                default:
                    System.out.println("연산기호를 잘못 입력하였습니다.");
            }

            System.out.println("결과: " + result);

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
            String exit = sc.next();

            if (exit.equals("exit")) {
                System.out.println("계산기가 종료됩니다.");
                break;
            }
        }


    }
}
