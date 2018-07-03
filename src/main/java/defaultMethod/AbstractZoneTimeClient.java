package defaultMethod;

import java.time.ZonedDateTime;

public interface AbstractZoneTimeClient extends TimeClient{
    public ZonedDateTime getZoneDateTime(String zoneString);
}
