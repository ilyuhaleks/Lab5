package work5;

/**
 * Main class to demonstrate user status changes and login tracking.
 */
public class Main {
    public static void main(String[] args) {
        // Create users
        User user1 = new User(1, "Offline");
        User user2 = new User(2, "Offline");

        // Create and add a trigger
        LoginCounterTrigger loginCounter = new LoginCounterTrigger();
        user1.addTrigger(loginCounter);
        user2.addTrigger(loginCounter);

        // User actions
        user1.login();
        user1.changeStatus("Online");
        user2.login();
        user2.login();
        user2.changeStatus("Busy");

        // Display total logins across all users
        System.out.println("Total logins: " + loginCounter.getTotalLogins());
    }
}
