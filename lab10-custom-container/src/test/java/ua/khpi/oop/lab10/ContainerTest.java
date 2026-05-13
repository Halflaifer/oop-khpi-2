package ua.khpi.oop.lab10;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.khpi.oop.lab10.container.DocumentContainer;
import ua.khpi.oop.lab10.model.Document;

public class ContainerTest {
    @Test
    public void testAddAndSize() {
        DocumentContainer<Document> container = new DocumentContainer<>();
        container.add(new Document("Test"));
        Assert.assertEquals(container.size(), 1);
    }

    @Test
    public void testIterator() {
        DocumentContainer<String> container = new DocumentContainer<>();
        container.add("A");
        container.add("B");
        
        int count = 0;
        for (String s : container) { count++; }
        Assert.assertEquals(count, 2);
    }
}