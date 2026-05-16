package ua.khpi.oop.lab13.service;

import ua.khpi.oop.lab13.model.ActivityType;
import ua.khpi.oop.lab13.model.StudentActivity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class AnalyticsProcessor {
    private static final Pattern LOG_PATTERN = Pattern.compile(
        "^(\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2});\\s*(ST-\\d{3});\\s*(\\w+);\\s*(\\d+)\\s*$"
    );

    public Optional<StudentActivity> parseLine(String line) {

        if (line == null || line.trim().isEmpty()) {
            return Optional.empty();
        }

        String normalized = line.trim();
        Matcher matcher = LOG_PATTERN.matcher(normalized);

        if (matcher.matches()) {
            LocalDateTime time = LocalDateTime.parse(matcher.group(1));
            String id = matcher.group(2);
            ActivityType type = ActivityType.valueOf(matcher.group(3));
            int score = Integer.parseInt(matcher.group(4));

            return Optional.of(new StudentActivity(time, id, type, score));
        }
        return Optional.empty();
    }

    public String buildReport(List<StudentActivity> activities) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ЗВІТ НАВЧАЛЬНОЇ АНАЛІТИКИ ===\n");
        
        int totalScore = 0;
        for (StudentActivity act : activities) {
            sb.append(act).append("\n");
            totalScore += act.getScore();
        }

        sb.append("---------------------------------\n");
        sb.append("Загальна кількість записів: ").append(activities.size()).append("\n");
        if (!activities.isEmpty()) {
            double avg = (double) totalScore / activities.size();
            sb.append("Середній бал: ").append(String.format("%.2f", avg)).append("\n");
        }
        return sb.toString();
    }
}