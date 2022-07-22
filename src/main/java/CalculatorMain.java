import java.util.Scanner;

public class CalculatorMain {
    private String formula;

    public void setFormula(){
        Scanner scan = new Scanner(System.in);

        System.out.print("계산할 식 : ");

        formula = scan.nextLine();
    }

    public String getFormula(){
        return formula;
    }
}

