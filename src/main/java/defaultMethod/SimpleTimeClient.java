package defaultMethod;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SimpleTimeClient implements TimeClient {
    private LocalDateTime localDateTime;

    public SimpleTimeClient() {
        localDateTime = LocalDateTime.now();
    }

    @Override
    public void setTime(int hour, int minute, int second) {
        LocalDate currentDate = LocalDate.from(localDateTime);
        LocalTime timeToSet = LocalTime.of(hour,minute,second);
        localDateTime = LocalDateTime.of(currentDate,timeToSet);
    }

    @Override
    public void setDate(int day, int month, int year) {
        LocalDate dateToSet = LocalDate.of(year,month,day);
        LocalTime currentTime = LocalTime.from(localDateTime);
        localDateTime = LocalDateTime.of(dateToSet,currentTime);
    }

    @Override
    public void setDateAndTime(int day, int month, int year, int hour, int minute, int second) {
        LocalDate dateToSet = LocalDate.of(day,month,year);
        LocalTime timeToSet = LocalTime.of(hour,minute,second);
        localDateTime = LocalDateTime.of(dateToSet,timeToSet);
    }

    @Override
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    @Override
    public String toString() {
        return localDateTime.toString();
    }

    public static void main(String[] args) {
        TimeClient timeClient = new SimpleTimeClient();
        System.out.println(timeClient.toString());
    }
}
