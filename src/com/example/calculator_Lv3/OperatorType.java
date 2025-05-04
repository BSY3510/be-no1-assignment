package com.example.calculator_Lv3;

import java.util.function.BiFunction;

public enum OperatorType {

    ADD ('+', (n1, n2) -> (n1 + n2)),
    SUB ('-', (n1, n2) -> (n1 - n2)),
    MUL ('*', (n1, n2) -> (n1 * n2)),
    DIV ('/', (n1, n2) -> {
        if (n2 == 0) {
            throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        }
        return (n1 / n2);
    });

    private char op;
    private BiFunction<Double, Double, Double> function;    // 람다식을 받기 위함

    OperatorType(char op, BiFunction<Double, Double, Double> function) {
        this.op = op;
        this.function = function;
    }

    public Double calculate(double n1, double n2) {
        return this.function.apply(n1, n2);
    }

    public static OperatorType distinct_op(char op) {
        for (OperatorType type : values()) {
            if (type.op == op) {
                return type;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
    }
}
