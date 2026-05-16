package ua.khpi.oop.lab13.service;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab13.model.StudentActivity;
import ua.khpi.oop.lab13.model.ActivityType;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class AnalyticsProcessorTest {
    private final AnalyticsProcessor processor = new AnalyticsProcessor();

    @Test
    void testValidParse() {
        String line = "2026-05-15T10:00; ST-001; LOGIN; 0";
        Optional<StudentActivity> result = processor.parseLine(line);
        
        assertTrue(result.isPresent());
        assertEquals("ST-001", result.get().getStudentId());
        assertEquals(ActivityType.LOGIN, result.get().getType());
    }

    @Test
    void testInvalidIdReject() {
        String badLine = "2026-05-15T10:00; S-1; LOGIN; 0";
        Optional<StudentActivity> result = processor.parseLine(badLine);
        

        assertFalse(result.isPresent());
    }
}