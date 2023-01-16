import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        System.out.println("Укажите через пробел два числа для совершения операции. Для комплекных чисел мнимую единицу обозначайте символом i, в таком формате: -3+4i или 5-7i");
        String number = in.nextLine();
        number = number.replace(",", ".");

        System.out.println("Введите номер необходимой операции. 1 - Сложение. 2 - Вычитание. 3 - Деление. 4 - Умножение.");
        int checker = in.nextInt();
        in.close();

        if (number.contains("i")) {
            ArrayList<String> numsOperation = new ArrayList<String>();
            number = number.replace("-", " -");
            number = number.replace("+", " +");
            String[] nums = number.split(" ");
            for (int i = 0; i < nums.length; i++) {
                if (nums[i].isEmpty()) {
                } else {
                    numsOperation.add(nums[i].replace("+",""));
                }
            }
            Complex operationNums1 = new Complex(Double.parseDouble(numsOperation.get(0)), Double.parseDouble(numsOperation.get(1).replace("i", "")));
            Complex operationNums2 = new Complex(Double.parseDouble(numsOperation.get(2)), Double.parseDouble(numsOperation.get(3).replace("i", "")));

            System.out.println(numsOperation);
            Complex result = new Complex(0.0, 0.0);
            
            if (checker == 1) {
                result.addition(operationNums1, operationNums2);
            }
            else if (checker == 2) {
                result.subtraction(operationNums1, operationNums2);
            }
            else if (checker == 3) {
                result.divided(operationNums1, operationNums2);
            }
            else if (checker == 4) {
                result.multiplication(operationNums1, operationNums2);
            } else { 
                System.out.println("Некорректный выбор типа операции");
            }
            result.printComplex(result);
        } else {
            Double realNumber = 0.0;
            String[] numsReal = number.split(" ");
            if (checker == 1) {
                realNumber = Double.parseDouble(numsReal[0]) + Double.parseDouble(numsReal[1]);
            }
            else if (checker == 2) {
                realNumber = Double.parseDouble(numsReal[0]) - Double.parseDouble(numsReal[1]);
            }
            else if (checker == 3) {
                realNumber = Double.parseDouble(numsReal[0]) / Double.parseDouble(numsReal[1]);
            }
            else if (checker == 4) {
                realNumber = Double.parseDouble(numsReal[0]) * Double.parseDouble(numsReal[1]);
            } else { 
                System.out.println("Некорректный выбор типа операции");
            }
            Logger dataForFile = new Logger(Double.toString(realNumber)+"\n");
            dataForFile.logger(dataForFile);
            System.out.println(realNumber);
        }
    }

}
