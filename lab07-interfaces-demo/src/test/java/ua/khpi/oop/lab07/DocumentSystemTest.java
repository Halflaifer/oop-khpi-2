package ua.khpi.oop.lab07;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.khpi.oop.lab07.model.ContractDraft;
import ua.khpi.oop.lab07.model.PurchaseRequest;
import ua.khpi.oop.lab07.contracts.Approvable;

public class DocumentSystemTest {
    private ContractDraft testContract;

    @BeforeMethod
    public void setUp() {
        // Створюємо свіжий об'єкт перед кожним тестом
        testContract = new ContractDraft("Тестовий контракт");
    }

    @Test(description = "Перевірка, що контракт не можна підписати без затвердження")
    public void testSignWithoutApproval() {
        String result = testContract.sign("Директор");
        Assert.assertTrue(result.contains("ПОМИЛКА"), 
            "Має бути помилка підписання, якщо документ не затверджено");
    }

    @Test(description = "Перевірка успішного циклу: затвердження -> підписання")
    public void testFullCycle() {
        testContract.approve("Менеджер");
        String result = testContract.sign("Директор");
        Assert.assertTrue(result.contains("підписано"), 
            "Документ має успішно підписатися після затвердження");
    }

    @Test(description = "Перевірка роботи через інтерфейсний тип")
    public void testInterfacePolymorphism() {
        // Використовуємо інтерфейс як тип [cite: 88-89]
        Approvable request = new PurchaseRequest(500.0);
        String result = request.approve("Бухгалтер");
        Assert.assertTrue(result.contains("затверджено"), 
            "Метод інтерфейсу має повертати підтвердження");
    }
}