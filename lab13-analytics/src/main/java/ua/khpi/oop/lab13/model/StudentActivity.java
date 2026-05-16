package ua.khpi.oop.lab13.model;

import java.time.LocalDateTime;

public class StudentActivity {
    private final LocalDateTime timestamp;
    private final String studentId;
    private final ActivityType type;
    private final int score;

    public StudentActivity(LocalDateTime timestamp, String studentId, ActivityType type, int score) {
        this.timestamp = timestamp;
        this.studentId = studentId;
        this.type = type;
        this.score = score;
    }

    public LocalDateTime getTimestamp() { return timestamp; }
    public String getStudentId() { return studentId; }
    public ActivityType getType() { return type; }
    public int getScore() { return score; }

    @Override
    public String toString() {
        return String.format("[%s] %s | %s | Бали: %d", timestamp, studentId, type, score);
    }
}