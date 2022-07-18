public class Calculator {
    String[] stringArray;
    float output;

    public void print(String input) throws Exception {
        check_Null_Or_Empty(input);
        set_String_Array(input);
        Four_Rules_Calculator();
        print_Result();
    }

    // 입력 값이 null이거나 빈 공백 문자일 경우 예외 처리
    public void check_Null_Or_Empty(String input) throws Exception {
        if (input == null || input == "")
            throw new IllegalArgumentException();
    }

    // 입력받은 계산식으로 배열 생성
    public void set_String_Array(String input) {
        stringArray = input.split("");
    }

    public void Four_Rules_Calculator() throws Exception {
        judge_Four_Arithmetic_Operator();
        judge_Length();
        judge_Number();

        // output 변수에 값을 누적시키는 방식으로 입력받은 식을 계산
        output = Float.parseFloat(stringArray[0]);
        for (int i = 0; i < stringArray.length - 1; i += 2) {
            output = calculate(output, stringArray[i + 1], Float.parseFloat(stringArray[i + 2]));
        }
    }

    // 사칙연산 기호가 아닌 경우 예외 처리
    public void judge_Four_Arithmetic_Operator() throws Exception {
        int i = 1;
        if (find_Invalid_Operator(i))
            throw new IllegalArgumentException();
    }

    // 배열의 홀수번째 index가 사칙연산 기호인지 판정
    public boolean find_Invalid_Operator(int i) {
        if (i >= stringArray.length)
            return false;
        if (stringArray[i].matches("[+*-/]"))
            return find_Invalid_Operator(i + 2);
        return true;
    }

    // 배열의 길이가 홀수인지 판정
    public void judge_Length() throws Exception {
        int length = stringArray.length;
        if (length % 2 == 0)
            throw new IllegalArgumentException();
    }

    // 실수가 아닌 경우 예외 처리
    public void judge_Number() throws Exception {
        for (int i = 0; i < stringArray.length; i += 2) {
            find_Invalid_Number(i);
        }
    }

    // 배열의 짝수번째 index가 실수인지 판정
    public void find_Invalid_Number(int i) throws Exception {
        try {
            Float.parseFloat(stringArray[i]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    // 사칙연산 구현
    public float calculate(float number1, String operator, float number2) throws Exception {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                return divide_Function(number1, number2);
            default:
                throw new IllegalArgumentException();
        }
    }

    // 나눗셈 함수를 새롭게 정의(나누는 수가 0인 경우 예외 처리, 나눗셈 결과를 정수로 처리)
    public int divide_Function(float num1, float num2) throws Exception {
        if (num2 == 0.0)
            throw new ArithmeticException();
        return (int) (num1 / num2);
    }

    // 계산식의 결과를 출력
    public void print_Result() {
        System.out.println(output);
    }
}
