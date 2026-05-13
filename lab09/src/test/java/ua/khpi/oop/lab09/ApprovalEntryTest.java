package ua.khpi.oop.lab09;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.khpi.oop.lab09.model.*;

public class ApprovalEntryTest {
    @Test
    public void testApprovalEntryCreation() {
        // Перевірка типобезпеки для різних типів [cite: 3369-3371, 3927]
        ApprovalEntry<String, Integer> testEntry = new ApprovalEntry<>("DocName", 200);
        Assert.assertEquals(testEntry.getDocument(), "DocName");
        Assert.assertEquals(testEntry.getApprovalData(), Integer.valueOf(200));
    }

    @Test
    public void testWithDomainObjects() {
        Document doc = new Document("Test", "Type");
        ApprovalEntry<Document, String> entry = new ApprovalEntry<>(doc, "Ok");
        Assert.assertEquals(entry.getDocument().getTitle(), "Test");
    }
}