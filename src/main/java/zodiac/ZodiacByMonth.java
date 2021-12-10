package zodiac;

import java.time.LocalDate;

public enum ZodiacByMonth {
    ARIES        (newDate(3, 21), newDate(4, 20)),
    TAURUS       (newDate(4, 21), newDate(5, 21)),
    GEMINI       (newDate(5, 22), newDate(6, 21)),
    CANCER       (newDate(6, 22), newDate(7, 22)),
    LEO          (newDate(7, 23), newDate(8, 22)),
    VIRGO        (newDate(8, 23), newDate(9, 23)),
    LIBRA        (newDate(9, 24), newDate(10, 23)),
    SCORPIO      (newDate(10, 24), newDate(11, 22)),
    SAGITTARIUS  (newDate(11, 23), newDate(12, 21)),
    CAPRICORN    (newDate(12, 22), newDate(1, 20)),
    AQUARIUS     (newDate(1, 21), newDate(2, 19)),
    PISCES       (newDate(2, 20), newDate(3, 20));

    private final LocalDate from;
    private final LocalDate to;

    private ZodiacByMonth(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }
    private static LocalDate newDate(int monthOfYear, int dayOfMonth) {
        return LocalDate.of(0, monthOfYear, dayOfMonth);
    }

    public static ZodiacByMonth toZodiac(LocalDate birthday) throws IllegalArgumentException {
        for (ZodiacByMonth zodiac : values()) {
            LocalDate fromWithYear = zodiac.from.withYear(birthday.getYear());
            LocalDate toWithYear = zodiac.to.withYear(birthday.getYear());

            if (birthday.getMonthValue() == 12 && ZodiacByMonth.CAPRICORN.equals(zodiac)) {
                toWithYear = toWithYear.plusYears(1);
            } else if (birthday.getMonthValue() == 1 && ZodiacByMonth.CAPRICORN.equals(zodiac)) {
                fromWithYear = fromWithYear.minusYears(1);
            }

            if ((fromWithYear.isBefore(birthday) || fromWithYear.isEqual(birthday))
                    && (toWithYear.isAfter(birthday) || toWithYear.isEqual(birthday))) {
                return zodiac;
            }
        }

        throw new IllegalArgumentException("Cannot find zodiac sign for date: " + birthday);
    }
}
