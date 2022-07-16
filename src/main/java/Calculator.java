import java.util.Scanner;

public class Calculator {
    public int add(int num1, int num2){
        return num1 + num2;
    }

    public int subtract(int num1, int num2){
        return num1 - num2;
    }

    public int multiply(int num1, int num2){
        return num1 * num2;
    }

    public int divide(int num1, int num2){
        try{
            return num1 / num2;
        }catch (ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다.");
        }
        return 0;
    }

    public int calculate(int num1, char operator, int num2){
        switch (operator){
            case '+':
                return add(num1, num2);
            case '-':
                return subtract(num1, num2);
            case '*':
                return multiply(num1, num2);
            case '/':
                return divide(num1, num2);
            default:
                throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
    }

    public String[] split(String formula){
        return formula.split(" ");
    }

    public int toInt(String num){
        if (num.trim().isEmpty())
            throw new IllegalArgumentException();
        return Integer.parseInt(num);
    }

    public int calculateFormula(String[] formulaSplit){
        int result = toInt(formulaSplit[0]);
        for(int index = 0; index < formulaSplit.length - 2; index += 2){
            result = calculate(result, formulaSplit[index + 1].charAt(0), toInt(formulaSplit[index+2]));
        }
        return result;
    }
}