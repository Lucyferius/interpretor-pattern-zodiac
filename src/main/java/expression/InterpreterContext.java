package expression;

import java.time.LocalDate;

public class InterpreterContext {
    private String input = "";
    private LocalDate date;
    private String output;

    public InterpreterContext(String input, LocalDate date)
    {
        this.input = input;
        this.date = date;
    }
    public InterpreterContext(LocalDate date)
    {
        this.date = date;
    }
    public InterpreterContext(String input)
    {
        this.input = input;
    }

    public String getInput()
    {
        return input;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }
    public LocalDate getDate()
    {
        return date;
    }

    public void setInput(String input)
    {
        this.input = input;
    }

    public String getOutput()
    {
        return output;
    }

    public void setOutput(String output)
    {
        this.output = output;
    }

    public String toString(){
        if(input.equals(""))
            return  "{"+ date.toString() + " -> " + output + "}";
        else return  "{"+ input + " -> " + output + "}";
    }
}
