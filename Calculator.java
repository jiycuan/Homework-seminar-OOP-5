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

        // Проверяем комплексные ли числа
        if (number.contains("i")) { 
            ArrayList<String> numsOperation = new ArrayList<String>();
            // Добавляем пробел к знакам + и - чтобы можно было разбить выражение на составляющие и поместить в массив.
            number = number.replace("-", " -"); 
            number = number.replace("+", " +");
            String[] nums = number.split(" ");
            for (int i = 0; i < nums.length; i++) {
                // Если первое комплексное число в выражении отрицательное, то в массиве первый параметр будет пустой, проверяем так ли это
                if (nums[i].isEmpty()) { 
                } else {
                    // Удаляем лишние знаки, оставшиеся от выражения. 
                    numsOperation.add(nums[i].replace("+","")); 
                }
            }

            // Из полученного массива помещаем данные в новый класс Complex (состоит из двух переменных типа Double), парсим строки в числа.
            Complex operationNums1 = new Complex(Double.parseDouble(numsOperation.get(0)), Double.parseDouble(numsOperation.get(1).replace("i", "")));
            Complex operationNums2 = new Complex(Double.parseDouble(numsOperation.get(2)), Double.parseDouble(numsOperation.get(3).replace("i", "")));
            Complex result = new Complex(0.0, 0.0);
            
            // Вызываем метод, соответствующий типу выбранной операции.
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
            // Вызываем метод для записи в файл лога. 
            result.printComplex(result);
        
        // Блок для операций, если числа не мнимые. Логика такая же как в блоке выше. Опираясь на выбранный тип операции выполняем соответствующие действия.
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
            // У мнимых чисел сложные методы для совершения операций, в них заложена запись в лог. Тут всё проще, поэтому метод для записи в лог вызываем отдельно.
            Logger dataForFile = new Logger(Double.toString(realNumber)+"\n");
            dataForFile.logger(dataForFile);
            System.out.println(realNumber);
        }
    }

}
