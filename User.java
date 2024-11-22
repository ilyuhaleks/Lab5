package work5;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int userId;
    private String status;
    private int loginCount;
    private final List<UserStatusTrigger> triggers = new ArrayList<>();

    /**
     * Constructor to initialize the user.
     *
     * @param userId Unique ID of the user.
     * @param initialStatus Initial status of the user.
     */
    public User(int userId, String initialStatus) {
        this.userId = userId;
        this.status = initialStatus;
        this.loginCount = 0;
    }

    /**
     * Changes the user's status and notifies triggers.
     *
     * @param newStatus The new status to set.
     */
    public void changeStatus(String newStatus) {
        String oldStatus = this.status;
        this.status = newStatus;
        System.out.println("User " + userId + " status changed from '" + oldStatus + "' to '" + newStatus + "'");
        notifyStatusChange(oldStatus, newStatus);
    }

    /**
     * Increments the login count and notifies triggers.
     */
    public void login() {
        loginCount++;
        System.out.println("User " + userId + " logged in. Total logins: " + loginCount);
        notifyLogin();
    }

    /**
     * Adds a trigger for this user.
     *
     * @param trigger Trigger to add.
     */
    public void addTrigger(UserStatusTrigger trigger) {
        triggers.add(trigger);
    }

    /**
     * Removes a trigger for this user.
     *
     * @param trigger Trigger to remove.
     */
    public void removeTrigger(UserStatusTrigger trigger) {
        triggers.remove(trigger);
    }

    private void notifyStatusChange(String oldStatus, String newStatus) {
        for (UserStatusTrigger trigger : triggers) {
            trigger.onStatusChange(userId, oldStatus, newStatus);
        }
    }

    private void notifyLogin() {
        for (UserStatusTrigger trigger : triggers) {
            trigger.onLogin(userId, loginCount);
        }
    }
}

