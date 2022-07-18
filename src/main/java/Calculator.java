public class Calculator {
    private String input;
    private String[] inputs;
    private int num1;
    private int num2;

    public Calculator(String input){
        this.input = input;
    }

    // 문장 입력 후 공백단위로 분리
    private void getStrings(String input) {
        inputs = input.split(" ");
    }

    // 공백만 입력되었는 지 확인
    private void checkBlank(String input) {
        if (input.equals(""))
            throw new IllegalArgumentException("문자가 입력되지 않았습니다.");
    }

    // 입력값이 없는 지 확인
    private void checkEmpty() {
        if (inputs.length == 0)
            throw new IllegalArgumentException("문자가 입력되지 않았습니다.");
    }

    // 입력된 값이 null인 지 검사
    private void checkNull(String input) {
        if (input == null)
            throw new IllegalArgumentException("null이 입력되었습니다.");
    }

    // 계산
    private void calculate() {
        num1 = Integer.parseInt(inputs[0]);
        for (int i = 1; i < inputs.length; i += 2) {
            num2 = Integer.parseInt(inputs[i + 1]);
            num1 = Operator.checkOperation(num1, num2, inputs[i]);
        }
    }

    // 최종 실행
    public int run() {
        checkNull(input);
        checkBlank(input);
        getStrings(input);
        checkEmpty();
        calculate();
        return num1;
    }
}
