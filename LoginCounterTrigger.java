package work5;

import java.util.HashMap;
import java.util.Map;

/**
 * A trigger that counts total logins for all users.
 */
public class LoginCounterTrigger implements UserStatusTrigger {
    private final Map<Integer, Integer> userLogins = new HashMap<>();

    @Override
    public void onStatusChange(int userId, String oldStatus, String newStatus) {
        // No action needed for status change
    }

    @Override
    public void onLogin(int userId, int totalLogins) {
        userLogins.put(userId, totalLogins);
        System.out.println("Trigger: Total logins " + userId + ": " + totalLogins);
    }

    /**
     * Gets the total number of logins for all users.
     *
     * @return Sum of all user logins.
     */
    public int getTotalLogins() {
        return userLogins.values().stream().mapToInt(Integer::intValue).sum();
    }
}
