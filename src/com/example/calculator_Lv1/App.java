package com.example.calculator_Lv1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String cmd;
        while (true) {

            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int n1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                int n2 = sc.nextInt();

                System.out.print("사칙연산 기호를 입력하세요: ");
                char op = sc.next().charAt(0);

                int result = 0;

                switch (op) {
                    case '+':
                        result = n1 + n2;
                        break;
                    case '-':
                        result = n1 - n2;
                        break;
                    case '*':
                        result = n1 * n2;
                        break;
                    case '/':
                        if (n2 == 0) {
                            throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        } else {
                            result = n1 / n2;
                        }
                        break;
                    default:
                        throw new UnsupportedOperationException("지원하지 않는 연산자입니다.");
                }

                System.out.println("결과: " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            cmd = sc.next();

            if (cmd.equals("exit")) {
                break;
            }
        }

        sc.close();
    }
}
