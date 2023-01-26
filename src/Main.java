import java.io.FileWriter;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) {
        String text = "{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}";

        String textPars1 = text.replace("фамилия", "Студент").replace("оценка", "Получил оценку").replace("предмет", "По предмету").replace("{", "").replace("}", ".").replace("\"", "");
        StringBuilder sb = new StringBuilder(textPars1);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ',' || sb.charAt(i) == ':') {
                sb.setCharAt(i, ' ');
            }
        }
        logging(sb);

        /*
        int[] bbb = {12, 44, 16, 3, 19, 28, 6, -4};
        sort(bbb);
         */ // вызвать для сорировки (последняя задача)

    }
    static void logging(StringBuilder sb){
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
            writeIn.write(sb.toString());
            logging.log(Level.INFO,"Writing complete");
        } catch (Exception e){
            logging.log(Level.INFO,e.getMessage());
            e.printStackTrace();
        }

    }

    static void sort(int [] array) {
        int temp = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length-i; j++) {
                count++;
                System.out.println(Arrays.toString(array));
                if (array[j] < array[j-1]){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }

            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println(count);
    }


}