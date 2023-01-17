import java.io.IOException;

public class Complex {
    
    // Переменные, необходимые для отделения мнимой части от действительной. 
    Double real;
    Double imagine;

    // Конструктор для класса
    public Complex (Double inputReal, Double inputImagine) {
        this.real = inputReal;
        this.imagine = inputImagine; 
    }
    
    // Методы, в которых мнимая и действительная часть рассчитывается, опираясь на математические формулы. 
    public void addition(Complex operationNums1, Complex operationNums2) {
        this.real = operationNums1.real + operationNums2.real;
        this.imagine = operationNums1.imagine + operationNums2.imagine;
    }

    public void subtraction(Complex operationNums1, Complex operationNums2) {
        this.real = operationNums1.real - operationNums2.real;
        this.imagine = operationNums1.imagine - operationNums2.imagine;        
    }

    public void divided(Complex operationNums1, Complex operationNums2) {
        this.real = (operationNums1.real*operationNums2.real + operationNums1.imagine*operationNums2.imagine)/(operationNums1.real*operationNums2.real + operationNums1.imagine*operationNums2.imagine);
        this.imagine = (operationNums1.real*operationNums2.imagine - operationNums2.real*operationNums1.imagine)/(operationNums1.real*operationNums2.real + operationNums1.imagine*operationNums2.imagine);
    }

    public void multiplication(Complex operationNums1, Complex operationNums2) {
        this.real = operationNums1.real*operationNums2.real - operationNums1.imagine*operationNums2.imagine;
        this.imagine = operationNums1.real*operationNums2.imagine - operationNums2.real*operationNums1.imagine;
    }

    // Мутод записи данных в логи. 
    public void printComplex(Complex result) throws IOException {
        // При выводе данных перевожу их в формат строки. Если мнимая часть отрицательная - дополнительный символ не нужен
        if (Double.toString(result.imagine).contains("-")) { 
            System.out.println(Double.toString(result.real) + Double.toString(result.imagine) + "i");
            Logger dataForFile = new Logger(Double.toString(result.real) + Double.toString(result.imagine) + "i" +"\n");
            dataForFile.logger(dataForFile);
        // Если мнимая часть положительная, то в записи добавляем знак "+" между переменными мнимой и действительной частей 
        } else {
            System.out.println(Double.toString(result.real) + "+" + Double.toString(result.imagine) + "i");
            Logger dataForFile = new Logger(Double.toString(result.real) + "+" + Double.toString(result.imagine) + "i" + "\n");
            dataForFile.logger(dataForFile);
        }
    }
}