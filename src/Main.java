import java.io.FileWriter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) {
        String text = "{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}";


        String textPars1 = text.replace("фамилия", "Студент").replace("оценка", "Получил оценку").replace("предмет", "По предмету").replace("{", "").replace("}", ".").replace(":", " ").replace("\"", "").replace(",", " ");
        logging(textPars1);


    }
    static void logging(String textPars1){
        String resultFile = "////dawd/result.txt"; // так для вызова логов. чтоыб заработала прогрмаа исправить путь к файлу
        Logger logging = Logger.getAnonymousLogger();
        FileHandler logHandler = null;
        SimpleFormatter style = new SimpleFormatter();
        try {
            logHandler = new FileHandler("log.txt");
            logHandler.setFormatter(style);
        } catch (Exception e) {
            e.printStackTrace();
        }

        logging.addHandler(logHandler);
        try (FileWriter writeIn = new FileWriter(resultFile)){
            writeIn.write(textPars1);
            logging.log(Level.INFO,"Writing complete");
        } catch (Exception e){
            logging.log(Level.INFO,e.getMessage());
            e.printStackTrace();
        }

    }

}