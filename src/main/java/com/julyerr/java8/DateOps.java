package com.julyerr.java8;

import java.time.*;

public class DateOps {
    public static void main(String[] args) {
//        和时区无关clock
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());

//        date和time
        final LocalDate fromLocalDate = LocalDate.now(clock);
        final LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(fromLocalDate);
        final LocalTime localTime = LocalTime.now();
        final LocalTime fromLocalTime = LocalTime.now(clock);
        System.out.println(localTime);
        System.out.println(fromLocalTime);

//        zone
        final ZonedDateTime zonedDateTime = ZonedDateTime.now();
        final ZonedDateTime zonedDateTime1FromClock = ZonedDateTime.now(clock);
        final ZonedDateTime zonedDateTime1FromZone = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime1FromClock);
        System.out.println(zonedDateTime1FromZone);

//        duration
        final LocalDateTime localDateTimeFrom = LocalDateTime.of(2018, 11, 25, 15, 44);
        final LocalDateTime localDateTimeTo = LocalDateTime.of(2019, 2, 5, 15, 44);
        final Duration duration = Duration.between(localDateTimeFrom, localDateTimeTo);
        System.out.println("hours:" + duration.toHours());
        System.out.println("days:" + duration.toDays());
    }
}
