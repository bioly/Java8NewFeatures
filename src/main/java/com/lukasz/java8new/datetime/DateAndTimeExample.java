package com.lukasz.java8new.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Set;
import java.util.function.Predicate;

public class DateAndTimeExample {

    public static void main(String[] args) throws InterruptedException {

        Instant start = Instant.now();
        System.out.println(start);

        Thread.sleep(1000);

        Instant end = Instant.now();
        System.out.println(end);


        Duration duration = Duration.between(start, end);

        System.out.println("Time elapsed: " + duration.toMillis() + " [milliseconds]");

        System.out.println("**************************");

        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);

        LocalDate specificDate = LocalDate.of(2000, 1, 1);
        System.out.println(specificDate);

        System.out.println("**************************");
        LocalTime currentTime = LocalTime.now();
        System.out.println(currentDate);

        LocalTime specificTime = LocalTime.of(14, 0, 5);
        System.out.println(specificTime);

        System.out.println("*************************");
        LocalDateTime currentDT = LocalDateTime.now();
        System.out.println(currentDT);

        System.out.println("*************************");
        LocalDateTime specificDT = LocalDateTime.of(specificDate, specificTime);
        System.out.println(specificDT);

        System.out.println("**************formatter**");
        DateTimeFormatter df = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println(df.format(LocalDateTime.now()));

        DateTimeFormatter f_long = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        System.out.println(f_long.format(currentDT));

        DateTimeFormatter f_short = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(f_short.format(currentDT));

        String fr_short = f_short.withLocale(Locale.FRENCH).format(currentDate);
        String us_short = f_short.withLocale(Locale.US).format(currentDate);
        String fr_long = f_long.withLocale(Locale.FRENCH ).format(currentDate);
        System.out.println("In French format: " + fr_short);
        System.out.println("In French format (long): " + fr_long);
        System.out.println("In US format: " + us_short);

        DateTimeFormatterBuilder b = new DateTimeFormatterBuilder()
                .appendValue(ChronoField.MONTH_OF_YEAR)
                .appendLiteral("---")
                .appendValue((ChronoField.DAY_OF_MONTH))
                .appendLiteral("---")
                .appendValue(ChronoField.YEAR);

        DateTimeFormatter f = b.toFormatter();

        System.out.println(f.format(currentDate));

        System.out.println("*************************");

        Set<String> zones = ZoneId.getAvailableZoneIds();

        Predicate<String> conditions = str -> str.contains("New_York");

        zones.forEach(z -> {
            if(conditions.test(z)) {
                System.out.println(z);
            }
        });

        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("America/Chicago"));
        System.out.println(zdt);
    }
}
