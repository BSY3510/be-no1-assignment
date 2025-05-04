package com.example.calculator_Lv3;

import java.util.ArrayList;

public class ArithmeticCalculator<T extends Number> {

    private ArrayList<Double> resultList = new ArrayList<>();

    public double calculate(T n1, T n2, char op) {

        try {
            double num1 = n1.doubleValue();
            double num2 = n2.doubleValue();
            OperatorType ot = OperatorType.distinct_op(op);

            double result = ot.calculate(num1, num2);
            resultList.add(result);

            return result;
        }
        catch (Exception e) {
            throw e;
        }
    }

    // Getter
    public ArrayList<Double> getResultList() {
        return this.resultList;
    }

    // Setter
    public void setResultList(int idx, double num) {
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
