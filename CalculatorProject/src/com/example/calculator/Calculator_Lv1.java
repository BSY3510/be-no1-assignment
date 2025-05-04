package com.example.calculator;

import java.util.Scanner;

public class Calculator_Lv1 {

    public static class App {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            String cmd = "";
            while (!cmd.equals("exit")) {

                System.out.print("첫 번째 숫자를 입력하세요: ");
                int n1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                int n2 = sc.nextInt();

                System.out.print("사칙연산 기호를 입력하세요: ");
                char op = sc.next().charAt(0);

                int result = 0;
                boolean available = true;

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
                            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                            available = false;
                        } else {
                            result = n1 / n2;
                        }
                        break;
                    default:
                        System.out.println("지원하지 않는 연산자입니다.");
                        available = false;
                        break;
                }

                if (available) {
                    System.out.println("결과: " + result);
                } else {
                    System.out.println("수식이 올바르지 않습니다.");
                }

                System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
                cmd = sc.next();
            }

            sc.close();
        }
    }
}
