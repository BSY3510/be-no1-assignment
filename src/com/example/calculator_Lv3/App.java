package com.example.calculator_Lv3;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArithmeticCalculator<Double> cal = new ArithmeticCalculator<>();
        Scanner sc = new Scanner(System.in);

        String cmd = "";
        while (!cmd.equals("exit")) {

            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double n1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                double n2 = sc.nextInt();

                System.out.print("사칙연산 기호를 입력하세요: ");
                char op = sc.next().charAt(0);

                double result = cal.calculate(n1, n2, op);

                System.out.println("결과: " + result);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }

            while (true) {
                System.out.print("무엇을 하시겠습니까?=============\nexit: 종료\nset: 입력된 인덱스의 값 수정\nget: 저장된 데이터 출력\nrm: 가장 먼저 저장된 데이터 삭제\n그 외: 이어서 계산\n==============================\n입력: ");
                cmd = sc.next();

                if (cmd.equals("exit")) {
                    break;
                }
                else if (cmd.equals("set")) {
                    try {
                        System.out.print("수정할 인덱스를 입력하세요: ");
                        int idx = sc.nextInt();
                        System.out.print("수정할 값을 입력하세요: ");
                        int num = sc.nextInt();

                        cal.setResultList(idx, num);
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                        sc.nextLine();
                    }
                }
                else if (cmd.equals("get")) {
                    ArrayList<Double> tmp = cal.getResultList();
                    System.out.println("저장된 데이터: " + tmp);
                }
                else if (cmd.equals("rm")) {
                    try {
                        cal.removeResult();
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                        sc.nextLine();
                    }
                }
                else {
                    break;
                }
            }
        }

        sc.close();
    }
}
