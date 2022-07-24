public class Calculator {

    public String[] split(String formula){
        return formula.split(" ");
    }

    int toInt(String num){
        if (num.trim().isEmpty())
            throw new IllegalArgumentException();
        return Integer.parseInt(num);
    }

    public int calculateFormula(String[] formulaSplit){
        int result = toInt(formulaSplit[0]);
        for(int index = 0; index < formulaSplit.length - 2; index += 2){
            result = calculate(result, formulaSplit[index + 1], toInt(formulaSplit[index+2]));
        }
        return result;
    }
    public int calculate(int num1, String operator, int num2){
        return Operator.calculate(operator, num1, num2);
    }
}