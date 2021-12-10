package expression;

import exeption.DataNotFoundException;
import util.DateFinder;
import zodiac.ZodiacByMonth;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ContextTranslatorExpression implements Expression{

    private final DateFinder dateFinder;

    public ContextTranslatorExpression(DateTimeFormatter formatter, String pattern){
        this.dateFinder = new DateFinder(formatter, pattern);
    }
    @Override
    public String interpret(InterpreterContext context) throws DataNotFoundException, DateTimeParseException {
        String[] name = context.getInput().split(" ");

        LocalDate date = dateFinder.findDateInString(context.getInput());
        context.setDate(date);

        String zodiac = ZodiacByMonth.toZodiac(context.getDate()).name();
        context.setOutput(name[0] + " is " + zodiac);

        return context.getOutput();
    }

}
