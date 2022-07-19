public class Calculator {
    private final String input;
    private String[] inputs;
    private int num1;

    public Calculator(String input) {
        this.input = input;
    }

    // 문장 입력 후 공백단위로 분리
    private void getStrings() {
        inputs = input.split(" ");
        if (inputs.length == 0){
            throw new IllegalArgumentException("문자가 입력되지 않았습니다.");
        }
    }

    // 공백만 입력되었는 지 확인
    private void checkBlank() {
        if (input == null||input.equals(""))
            throw new IllegalArgumentException("문자가 입력되지 않았습니다.");
    }

    // 계산
    private void calculate() {
        num1 = Integer.parseInt(inputs[0]);
        for (int i = 1; i < inputs.length; i += 2) {
            int num2 = Integer.parseInt(inputs[i + 1]);
            num1 = Operator.checkOperation(num1, num2, inputs[i]);
        }
    }

    // 최종 실행
    public int run() {
        checkBlank();
        getStrings();
        calculate();
        return num1;
    }
}
