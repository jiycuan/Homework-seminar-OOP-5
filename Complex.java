import java.io.IOException;

public class Complex {
    
    Double real;
    Double imagine;

    public Complex (Double inputReal, Double inputImagine) {
        this.real = inputReal;
        this.imagine = inputImagine; 
    }
        
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

    public void printComplex(Complex result) throws IOException {
        if (Double.toString(result.imagine).contains("-")) {
            System.out.println(Double.toString(result.real) + Double.toString(result.imagine) + "i");
            Logger dataForFile = new Logger(Double.toString(result.real) + Double.toString(result.imagine) + "i" +"\n");
            dataForFile.logger(dataForFile);
        } else {
            System.out.println(Double.toString(result.real) + "+" + Double.toString(result.imagine) + "i");
            Logger dataForFile = new Logger(Double.toString(result.real) + "+" + Double.toString(result.imagine) + "i" + "\n");
            dataForFile.logger(dataForFile);
        }
        
    }
}