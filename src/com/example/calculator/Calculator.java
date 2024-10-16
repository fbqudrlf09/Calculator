package com.example.calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int firstNum = sc.nextInt();
        int secondNum = sc.nextInt();

        sc.nextLine();
        char operator = sc.nextLine().charAt(0);
        int result = 0;
        boolean flag = true;

        switch (operator) {
            case '+':{
                result = firstNum + secondNum;
                break;
            }
            case '-':{
                result = firstNum - secondNum;
                break;
            }
            case '*':{
                result = firstNum * secondNum;
                break;
            }
            case '/':{
                if(secondNum == 0){
                    System.out.println("분모가 0입니다 나누기 계산이 되지 않습니다.");
                    flag = false;
                    break;
                }
                result = firstNum / secondNum;
                break;
            }
        }

        if(flag == true)
            System.out.println("result = " + result);
    }

}
