package expression;

import zodiac.ZodiacByMonth;

public class ZodiacTerminalExpression implements Expression{

    @Override
    public String interpret(InterpreterContext context) {
        String zodiac = ZodiacByMonth.toZodiac((context).getDate()).name();
        context.setOutput(zodiac);
        return zodiac;
    }

}
