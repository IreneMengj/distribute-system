package Reminder;

import java.time.LocalDateTime;

public class TimeReminder {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime reminderTime = LocalDateTime.of(2023, 4, 15, 8, 0, 0); // Set the time when the prompt is triggered
        if (now.isAfter(reminderTime)) {
            System.out.println("It's time to do something!"); // The operation performed after the trigger point
        } else {
            System.out.println("Not yet."); // The operation performed before the trigger point
        }
    }
}