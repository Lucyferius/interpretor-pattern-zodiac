package expression;

import zodiac.ZodiacChinese;

public class ZodiacChineseTerminalExpression implements Expression{
    @Override
    public String interpret(InterpreterContext context) {
        String zodiac =  ZodiacChinese.toChineseZodiac((context).getDate()).name();
        context.setOutput(zodiac);
        return zodiac;
    }
}
