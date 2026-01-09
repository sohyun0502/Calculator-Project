package step1;

import java.util.Scanner;

/*
 * STEP 1
 * 계산기는 2개의 숫자를 받을 수 있고 사칙연산 될 문자를 받을 수 있다.
 * 계산기는 exit을 입력할 때까지 계속해서 값을 받고 연산 결과를 반환한다.
 */

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.print("첫 번째 숫자를 입력하세요: ");
            int number1 = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int number2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            // charAt에 대해 몰라 찾아봄
            // String으로 저장된 문자열 중에서 한 글자만 선택해서 char타입으로 변환해주는 녀석
            // charAt(0)은 문자열에서 0번째에 있는 문자를 char타입으로 변환한다는 의미
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
                    // 연산 오류가 발생할 경우 해당 오류에 대한 내용을 정제하여 출력 (0으로 나누기)
                    if(number2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue;
                    } else {
                        result = number1 / number2;
                        break;
                    }
                default:
                    // +, -, *, / 외의 연산기호나 문자 입력시 아래 내용 출력
                    System.out.println("잘못된 연산 기호입니다.");
            }

            System.out.println("결과: " + result);

            // 'exit'를 입력하지 않으면 무한반복
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
            String exit = sc.next();

            // 'exit' 입력시 반복문을 빠져나옴
            if ("exit".equalsIgnoreCase(exit)) {
                System.out.println("======계산기가 종료됩니다======");
                break;
            }
        }

    }
}
