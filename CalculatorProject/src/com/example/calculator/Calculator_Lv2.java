package com.example.calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator_Lv2 {

    public static class Calculator {

        private ArrayList<Integer> resultList = new ArrayList<>();

        public int calculate(int n1, int n2, char op) {
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
                this.resultList.add(result);
            }
            else {
                System.out.println("수식이 올바르지 않습니다.");
            }

            return result;
        }

        // Getter
        public ArrayList<Integer> get_resultList() {
            return this.resultList;
        }

        // Setter
        public void set_resultList(int index, int num) {
            if (0 <= index && index < this.resultList.size()) {
                this.resultList.set(index, num);
            }
            else {
                System.out.println("올바른 인덱스를 입력해주세요.");
            }
        }

        public void removeResult() {
            if (!this.resultList.isEmpty()) {
                this.resultList.remove(0);
            }
        }
    }

    public static class App {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Calculator cal = new Calculator();

            String cmd = "";
            while (!cmd.equals("exit")) {

                System.out.print("첫 번째 숫자를 입력하세요: ");
                int n1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                int n2 = sc.nextInt();

                System.out.print("사칙연산 기호를 입력하세요: ");
                char op = sc.next().charAt(0);

                int result = cal.calculate(n1, n2, op);

                while (true) {
                    System.out.print("무엇을 하시겠습니까? (exit: 종료, get: 저장된 결과 확인, set: 저장된 결과 수정, rm: 가장 먼저 저장된 결과 제거, 계산: 이외의 키): ");
                    cmd = sc.next();

                    if (cmd.equals("get")) {
                        ArrayList<Integer> tmp = cal.get_resultList();
                        System.out.print("저장된 결과: ");
                        System.out.println(tmp);
                    } else if (cmd.equals("set")) {
                        System.out.print("수정할 위치를 입력해주세요: ");
                        int indx = sc.nextInt();
                        System.out.print("값을 입력해주세요: ");
                        int number = sc.nextInt();

                        cal.set_resultList(indx, number);
                    } else if (cmd.equals("rm")) {
                        cal.removeResult();
                    }
                    else {
                        break;
                    }
                }

            }

            sc.close();
        }
    }
}
