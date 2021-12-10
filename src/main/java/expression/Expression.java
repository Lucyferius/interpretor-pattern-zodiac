package expression;

import exeption.DataNotFoundException;

import java.text.ParseException;
import java.time.LocalDate;

public interface Expression {
    String interpret(InterpreterContext context) throws ParseException, DataNotFoundException;
}
