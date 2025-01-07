import java.text.SimpleDateFormat;
import java.util.Date;

public class AlfredQuotes {

    // Basic greeting
    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }

    // Guest greeting
    public String guestGreeting(String name) {
        return String.format("Hello, %s. Lovely to see you.", name);
    }

    // Date announcement
    public String dateAnnouncement() {
        Date date = new Date();
        return String.format("It is currently %s.", date.toString());
    }

    // Respond before Alexis
    public String respondBeforeAlexis(String conversation) {
        if (conversation.contains("Alexis")) {
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        } else if (conversation.contains("Alfred")) {
            return "At your service. As you wish, naturally.";
        } else {
            return "Right. And with that I shall retire.";
        }
    }

    // Ninja Bonus: Overloaded guestGreeting with day period
    public String guestGreeting(String name, String dayPeriod) {
        return String.format("Good %s, %s. Lovely to see you.", dayPeriod, name);
    }

    // Sensei Bonus: Overloaded guestGreeting without parameters, determines day period
    public String guestGreeting() {
        Date date = new Date();
        SimpleDateFormat hourFormat = new SimpleDateFormat("H");
        int hour = Integer.parseInt(hourFormat.format(date));

        String dayPeriod;
        if (hour < 12) {
            dayPeriod = "morning";
        } else if (hour < 18) {
            dayPeriod = "afternoon";
        } else {
            dayPeriod = "evening";
        }
        return String.format("Good %s. Lovely to see you.", dayPeriod);
    }

    // Sensei Bonus: Custom method for fun responses
    public String alfredYell(String statement) {
        return statement.toUpperCase() + "!!!";
    }
}