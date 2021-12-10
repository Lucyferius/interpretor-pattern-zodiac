package zodiac;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

public enum ZodiacChinese {
    MONKEY   (0),
    ROOSTER  (1),
    DOG      (2),
    PIG      (3),
    RAT      (4),
    OX       (5),
    TIGER    (6),
    RABBIT   (7),
    DRAGON   (8),
    SNAKE    (9),
    HORSE    (10),
    c    (11);

    private int divideByYear;

    ZodiacChinese(int divideByYear) {
        this.divideByYear = divideByYear;
    }

    public static ZodiacChinese toChineseZodiac(LocalDate birthday) throws IllegalArgumentException {
        int year = birthday.getYear() % 12;
        Optional<ZodiacChinese> zodiacChinese = Arrays.stream(values()).filter(zodiac -> zodiac.divideByYear == year).findFirst();
        if (zodiacChinese.isPresent())
            return zodiacChinese.get();
        else throw new IllegalArgumentException("Cannot find zodiac sign for date: " + birthday);
    }
}
