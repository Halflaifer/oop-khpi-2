package ua.khpi.oop.lab08;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Path;
import java.nio.file.Paths;
import ua.khpi.oop.lab08.model.ContractDraft;
import ua.khpi.oop.lab08.service.DocumentRegistry;
import ua.khpi.oop.lab08.persistence.DocumentFileManager;

public class DocumentPersistenceTest {
    @Test
    public void testSerializationCycle() throws Exception {
        DocumentRegistry registry = new DocumentRegistry();
        registry.addDocument(new ContractDraft("Тест", "Автор", 100));
        
        DocumentFileManager fm = new DocumentFileManager();
        Path path = Paths.get("test.bin"); // Виправлено на Paths.get
        
        fm.serialize(registry, path);
        DocumentRegistry restored = fm.deserialize(path);
        
        Assert.assertEquals(restored.size(), 1);
        Assert.assertEquals(restored.getDocuments().get(0).getTitle(), "Тест");
    }
}