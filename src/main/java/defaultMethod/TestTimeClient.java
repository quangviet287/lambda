package defaultMethod;

public class TestTimeClient {
    public static void main(String[] args) {
        TimeClient timeClient = new SimpleTimeClient();
        System.out.println("Current time: "+timeClient.toString());
        System.out.println("Time in California: "  + timeClient.getZoneDateTime("Blah blah").toString());

    }
}
