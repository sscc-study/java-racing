import java.util.Scanner;

public class CalculatorMain {

    private static String formula;
    private static Calculator calculator;
    private static int result;

    private static void setFormula(){
        Scanner scan = new Scanner(System.in);

        System.out.print("계산할 식 : ");

        formula = scan.nextLine();
    }

    public static void setCalculator(Calculator calculator) {
        CalculatorMain.calculator = calculator;
    }

    private static void printResult(){
        System.out.println(result);
    }

    public static void main(String[] args){
        calculator = new Calculator();
        String[] formulaSplit;
        setFormula();

        formulaSplit = calculator.split(formula);
        result = calculator.calculateFormula(formulaSplit);
        printResult();
    }
}
