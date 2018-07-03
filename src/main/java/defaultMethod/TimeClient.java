package defaultMethod;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public interface TimeClient {
    void setTime(int hour, int minute, int second);
    void setDate(int day, int month, int year);
    void setDateAndTime(int day, int month, int year, int hour, int minute, int second);
    LocalDateTime getLocalDateTime();

    static ZoneId getZoneId (String zoneString){
        try {
            return ZoneId.of(zoneString);
        } catch (DateTimeException e){
            System.err.println("Invalid time zone: " + zoneString);
            return ZoneId.systemDefault();
        }
    }

    default ZonedDateTime getZoneDateTime(String zoneString){
        return ZonedDateTime.of(getLocalDateTime(), getZoneId(zoneString));
    }
}
