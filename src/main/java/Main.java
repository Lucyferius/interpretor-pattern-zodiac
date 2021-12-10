import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        String pattern="\\d{4}\\.\\d{1,2}\\.\\d{1,2}";

        LogicDriver logicDriver = new LogicDriver(formatter, pattern);
        logicDriver.runZodiacExpression();
        logicDriver.runZodiacChineseExpression();
        logicDriver.runContextTranslator();
    }
}
