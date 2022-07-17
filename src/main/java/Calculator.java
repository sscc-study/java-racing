import java.util.Scanner;

public class Calculator {
    private String[] inputs;
    private int num1;
    private int num2;

    // 덧셈
    private int addition(){
        return num1+num2;
    }

    // 뺄셈
    private int subtraction(){
        return num1-num2;
    }

    // 나눗셈
    private int division(){
        return num1/num2;
    }

    // 곱하기
    private int multiplication(){
        return num1*num2;
    }

    // 문장 입력 후 공백단위로 분리
    private void getStrings(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        inputs = input.split(" ");
        sc.close();
    }

    // 사칙연산 기호 아닌지 검사 -> 맞을 시 계산된 값 리턴
    private int checkOperation(String operation){
        if(operation.equals("+"))
            return addition();
        if(operation.equals("-"))
            return subtraction();
        if(operation.equals("*"))
            return multiplication();
        if(operation.equals("/"))
            return division();
        throw new IllegalArgumentException("올바르지 않은 연산자입니다.");
    }

    // 공백문자인지 검사
    private void checkNull(){
        if(inputs.length==0)
            throw new IllegalArgumentException("문자가 입력되지 않았습니다.");
    }

    // 문자 검사
    private void calculate(){
        num1 = Integer.parseInt(inputs[0]);
        for(int i=1; i< inputs.length; i+=2){
            num2 = Integer.parseInt(inputs[i+1]);
            num1 = checkOperation(inputs[i]);
        }
    }

    private void printResult(){
        System.out.println(num1);
    }

    // 최종 실행
    public void run(){
        getStrings();
        checkNull();
        calculate();
        printResult();
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.run();
    }
}
