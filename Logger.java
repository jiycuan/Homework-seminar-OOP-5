import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    String dataForLog;

    public Logger (String data) {
        this.dataForLog = data;
    }
    
    public void logger(Logger data) throws IOException {
        FileWriter log = new FileWriter("log.txt", true);
        log.write(data.dataForLog);
        log.flush();
        log.close();
    }
}
