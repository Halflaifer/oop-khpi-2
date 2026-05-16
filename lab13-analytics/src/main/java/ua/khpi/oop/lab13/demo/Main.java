package ua.khpi.oop.lab13.demo;

import ua.khpi.oop.lab13.model.StudentActivity;
import ua.khpi.oop.lab13.service.AnalyticsProcessor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class Main {
    public static void main(String[] args) {
        AnalyticsProcessor processor = new AnalyticsProcessor();
        List<StudentActivity> activities = new ArrayList<StudentActivity>();

        try {
            Path path = Paths.get("src/main/resources/activity-log.txt");
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {
                processor.parseLine(line).ifPresent(activities::add);
            }

            System.out.println(processor.buildReport(activities));

        } catch (Exception e) {
            System.err.println("Помилка обробки файлу: " + e.getMessage());
        }
    }
}