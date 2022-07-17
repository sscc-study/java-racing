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
    private void getStrings(String input){
        inputs = input.split(" ");
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

    // 공백만 입력되었는 지 확인
    private void checkBlank(String input){
        if(input.equals(""))
            throw new IllegalArgumentException("문자가 입력되지 않았습니다.");
    }

    // 입력값이 없는 지 확인
    private void checkEmpty(){
        if(inputs.length==0)
            throw new IllegalArgumentException("문자가 입력되지 않았습니다.");
    }

    // 입력된 값이 null인 지 검사
    private void checkNull(String input){
        if(input==null)
            throw new IllegalArgumentException("null이 입력되었습니다.");
    }

    // 문자 검사
    private void calculate(){
        num1 = Integer.parseInt(inputs[0]);
        for(int i=1; i< inputs.length; i+=2){
            num2 = Integer.parseInt(inputs[i+1]);
            num1 = checkOperation(inputs[i]);
        }
    }

    // 결과값 출력
    private void printResult(){
        System.out.println(num1);
    }

    // 결과값 리턴
    public int getResult(){
        return num1;
    }

    // 최종 실행
    public int run(String input){
        checkNull(input);
        checkBlank(input);
        getStrings(input);
        checkEmpty();
        calculate();
        return getResult();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String test = "";
        Calculator calculator = new Calculator();
        int result = calculator.run(sc.nextLine());
        System.out.println(result);
        sc.close();
    }
}
