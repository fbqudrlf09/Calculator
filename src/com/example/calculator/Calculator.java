package com.example.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class Calculator {

    private List<Double> resultList = new ArrayList<>();

    public List<Double> getResultList() {
        return resultList;
    }

    public void setResultList(List<Double> resultList) {
        this.resultList = resultList;
    }

    public double deleteResultList(int index) throws IndexOutOfBoundsException {
        if(index >= resultList.size()) throw new IndexOutOfBoundsException("저장된 결과값 보다 큰 Index로 삭제 하였습니다 (index: " + index + ")");
        return resultList.remove(index);
    }

    public double calculator(int firstNum, int secondNum, char operator) throws RuntimeException{
        double result = 0;

        switch (operator) {
            case '+': {
                result = addOperator(firstNum, secondNum);
                break;
            }
            case '-': {
                result = substractOperator(firstNum, secondNum);
                break;
            }
            case '*': {
                result = multipyOperator(firstNum, secondNum);
                break;
            }
            case '/': {
                result = divideOperator(firstNum, secondNum);
                break;
            }
            default: {
                throw new RuntimeException("잘못된 연산자 입니다");
            }
        }
        resultList.add(result);
        return result;
    }

    private double addOperator(int firstNum, int secondNum){

        return firstNum + secondNum;
    }

    private double substractOperator(int firstNum, int secondNum){
        return firstNum - secondNum;
    }

    private double multipyOperator(int firstNum, int secondNum) {
        return firstNum * secondNum;
    }

    private double divideOperator(int firstNum, int secondNum) throws RuntimeException {
        if(secondNum == 0) throw new ArithmeticException("분모의 값이 0입니다 계산을 실행할수 없습니다");
        return (double)firstNum / secondNum;
    }

}