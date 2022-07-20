public class Calculator {
        public int calculateUser(String input) {
            String[] expression = seperate(input);

            int result = getInt(expression[0]);
            for(int i=0; i<expression.length-2; i+=2){
                result = Operator.calculate(result, getInt(expression[i+2]), expression[i+1]);
            }
            return result;
        }

        public int getInt(String str){
            return Integer.parseInt(str);
        }

        public String[] seperate(String str){
            return str.split(" ");
        }
}
