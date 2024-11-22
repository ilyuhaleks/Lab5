package work5;

/**
 * Interface for triggers reacting to user status changes or logins.
 */
public interface UserStatusTrigger {
    /**
     * Trigger action when the user's status changes.
     *
     * @param userId ID of the user whose status has changed.
     * @param oldStatus The previous status of the user.
     * @param newStatus The new status of the user.
     */
    void onStatusChange(int userId, String oldStatus, String newStatus);

    /**
     * Trigger action when the user logs in.
     *
     * @param userId ID of the user who logged in.
     * @param totalLogins Total number of logins by this user.
     */
    void onLogin(int userId, int totalLogins);
}
