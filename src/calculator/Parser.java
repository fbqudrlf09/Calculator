package calculator;

import javax.management.OperationsException;

public class Parser {

    final static String OPERATORS = "[+\\-*/]";
    final static String NUMBERS = "[0-9]+";

    public static int parseInputValue(String input)throws RuntimeException{
        if(input.matches(NUMBERS)){
            return Integer.parseInt(input);
        }else{
            throw new RuntimeException("잘못된 숫자를 입력하였습니다.");
        }
    }

    public static char parseOperator(String input) throws RuntimeException{
        if(input.matches(OPERATORS)){
            return input.charAt(0);
        }else{
            throw new RuntimeException("잘못된 연사자를 입력하였습니다");
        }
    }
}
