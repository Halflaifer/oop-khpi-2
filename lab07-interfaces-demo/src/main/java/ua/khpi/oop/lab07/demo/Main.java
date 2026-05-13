package ua.khpi.oop.lab07.demo;

import ua.khpi.oop.lab07.contracts.Approvable;
import ua.khpi.oop.lab07.contracts.Signable;
import ua.khpi.oop.lab07.model.ContractDraft;
import ua.khpi.oop.lab07.model.PurchaseRequest;

public class Main {
    public static void main(String[] args) {
        ContractDraft contract = new ContractDraft("Оренда офісу №101");

        Approvable[] pendingApproval = {
            contract,
            new PurchaseRequest(5000.0)
        };

        System.out.println("--- Процес затвердження ---");
        for (Approvable item : pendingApproval) {
            System.out.println(item.approve("Директор Іванов"));
        }

        System.out.println("\n--- Процес підписання ---");
        Signable signableContract = contract; // Використання через інший тип інтерфейсу
        System.out.println(signableContract.sign("Партнер Петро"));
    }
}