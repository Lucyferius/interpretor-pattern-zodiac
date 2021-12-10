import exeption.DataNotFoundException;
import expression.ContextTranslatorExpression;
import expression.InterpreterContext;
import expression.ZodiacChineseTerminalExpression;
import expression.ZodiacTerminalExpression;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class LogicDriver {
    private final ZodiacTerminalExpression zodiacTranslateExpression;
    private final ZodiacChineseTerminalExpression zodiacChineseTranslateExpression;
    private final ContextTranslatorExpression contextTranslatorExpression;

    public LogicDriver(DateTimeFormatter formatter, String pattern){
        this.zodiacChineseTranslateExpression = new ZodiacChineseTerminalExpression();
        this.zodiacTranslateExpression = new ZodiacTerminalExpression();
        this.contextTranslatorExpression = new ContextTranslatorExpression(formatter, pattern );

    }
    private List<InterpreterContext> createContext(){
        LocalDate firstBirthday = LocalDate.of(2001, 11, 26);
        LocalDate secondBirthday = LocalDate.of(1987, 1, 12);
        LocalDate thirdBirthday = LocalDate.of(1878, 5, 19);
        LocalDate fourthBirthday = LocalDate.of(1998, 12, 12);
        LocalDate fifthBirthday = LocalDate.of(1876, 8, 6);

        return  List.of(new InterpreterContext(firstBirthday),
                new InterpreterContext(secondBirthday),
                new InterpreterContext(thirdBirthday),
                new InterpreterContext(fourthBirthday),
                new InterpreterContext(fifthBirthday));
    }

    public void runZodiacExpression(){
        List<InterpreterContext> interpreterContextList  = createContext();
        System.out.println("\nZodiac by month and day from date\n");
        interpreterContextList.forEach( birthday -> {
            String zodiac = zodiacTranslateExpression.interpret(birthday);
            birthday.setOutput(zodiac);
        });
        interpreterContextList.forEach(System.out::println);
    }

    public void runZodiacChineseExpression(){
        List<InterpreterContext> interpreterContextList  = createContext();
        System.out.println("\nChinese zodiac from date \n");
        interpreterContextList.forEach( birthday -> {
            String zodiac = zodiacChineseTranslateExpression.interpret(birthday);
            birthday.setOutput(zodiac);
        });
        interpreterContextList.forEach(System.out::println);
    }

    public void runContextTranslator(){
        System.out.println("\nFrom context\n");
        InterpreterContext firstContext = new InterpreterContext("Mary was born in 2001.11.26");
        InterpreterContext secondContext = new InterpreterContext("Ann was born in 1987.01.12");
        InterpreterContext thirdContext = new InterpreterContext("Nikita was born in 1878.05.19");
        List<InterpreterContext> list = List.of(firstContext, secondContext , thirdContext);

            list.forEach(context -> {
                try {
                    contextTranslatorExpression.interpret(context);
                } catch (DataNotFoundException e) {
                    e.printStackTrace();
                }
            });

        list.forEach(context -> System.out.println(context.getOutput()));
    }
}
