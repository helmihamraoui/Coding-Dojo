public class AlfredTest {
    public static void main(String[] args) {
        AlfredQuotes alfredBot = new AlfredQuotes();

        // Test basic greetings
        String testGreeting = alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting("Beth Kane");
        String testDateAnnouncement = alfredBot.dateAnnouncement();

        // Test conversation responses
        String alexisTest = alfredBot.respondBeforeAlexis("Alexis! Play some low-fi beats.");
        String alfredTest = alfredBot.respondBeforeAlexis("I can't find my yo-yo. Maybe Alfred will know where it is.");
        String notRelevantTest = alfredBot.respondBeforeAlexis("Maybe that's what Batman is about. Not winning. But failing.");

        // Test overloaded guestGreeting
        String morningGreeting = alfredBot.guestGreeting("Bruce", "morning");
        String autoGreeting = alfredBot.guestGreeting();

        // Test custom method
        String yellTest = alfredBot.alfredYell("Master Wayne, the Batmobile is ready");

        // Print test results
        System.out.println(testGreeting);
        System.out.println(testGuestGreeting);
        System.out.println(testDateAnnouncement);
        System.out.println(alexisTest);
        System.out.println(alfredTest);
        System.out.println(notRelevantTest);
        System.out.println(morningGreeting);
        System.out.println(autoGreeting);
        System.out.println(yellTest);
    }
}