package com.example.calculator;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws InterruptedException {

        Calculator calculator = new Calculator();

        Scanner sc = new Scanner(System.in);
        String exitVal = "exit";
        Boolean flag = true;

        while (flag) {
            System.out.println("어떤 작업을 수행하시겠습니까? 계산 결과보기 결과삭제 종료");
            String command = sc.nextLine();

            switch (command) {
                case "계산": {
                    int firstNum = sc.nextInt();
                    int secondNum = sc.nextInt();
                    sc.nextLine();
                    char operator = sc.nextLine().charAt(0);

                    try {
                        double result = calculator.calculator(firstNum, secondNum, operator);
                        System.out.println(firstNum + " " + operator + " " + secondNum + " = " + result);
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                        Thread.sleep(100);
                    }
                    break;
                }
                case "결과보기": {
                    List<Double> resultList = calculator.getResultList();
                    for (Double result : resultList) {
                        System.out.print(result + "  ");
                    }
                    System.out.println();
                    break;
                }
                case "결과삭제": {
                    try {
                        System.out.println("삭제할 인덱스를 적어주세요");
                        int index = sc.nextInt();
                        sc.nextLine();
                        double del = calculator.deleteResultList(index);
                        System.out.println(index + "인덱스 값 " + del + "을 삭제하였습니다");
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                }
                case "종료": {
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("명령어를 잘못 사용하셨습니다 다시 확인하여 주세요!");
                }
            }
        }
    }
}
