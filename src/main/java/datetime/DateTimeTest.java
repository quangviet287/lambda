package datetime;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateTimeTest {
    public static void main(String[] args) {
        System.out.println(DayOfWeek.MONDAY.plus(3));
        DayOfWeek dow = DayOfWeek.MONDAY;
        Locale locale = Locale.getDefault();
        System.out.println(dow.getDisplayName(TextStyle.FULL, locale));
        System.out.println(dow.getDisplayName(TextStyle.NARROW, locale));
        System.out.println(dow.getDisplayName(TextStyle.SHORT, locale));
    }
}
