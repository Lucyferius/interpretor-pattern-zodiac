package util;

import exeption.DataNotFoundException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateFinder {
    private final DateTimeFormatter formatter;
    private final Pattern pattern;

    public DateFinder(DateTimeFormatter formatter,  String patternOfDate){
        this.formatter = formatter;
        pattern = Pattern.compile(patternOfDate);
    }
    public LocalDate findDateInString(String input) throws DateTimeParseException, DataNotFoundException {
        Matcher matcher= pattern.matcher(input);
        if(!matcher.find()) {
            throw new DataNotFoundException("Date Not Found!");
        }
        String dateString = input.substring(matcher.start(),matcher.end());

        return LocalDate.parse(dateString, formatter);
    }
}
