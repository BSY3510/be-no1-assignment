package com.example.calculator_Lv2;

import java.util.ArrayList;

public class Calculator {

    private ArrayList<Integer> resultList = new ArrayList<>();

    public int calculate(int n1, int n2, char op) {
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

        this.resultList.add(result);
        return result;
    }

    // Getter
    public ArrayList<Integer> getResultList() {
        return this.resultList;
    }

    // Setter
    public void setResultList(int idx, int num) {
        if (0 <= idx && idx < this.resultList.size()) {
            this.resultList.set(idx, num);
        }
        else {
            throw new ArrayIndexOutOfBoundsException("인덱스가 올바르지 않습니다.");
        }
    }

    // 가장 먼저 저장된 데이터 삭제
    public void removeResult() {
        if (this.resultList.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("저장된 데이터가 없습니다.");
        }
        else {
            this.resultList.remove(0);
        }
    }
}
