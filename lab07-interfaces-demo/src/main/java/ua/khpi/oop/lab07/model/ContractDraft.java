package ua.khpi.oop.lab07.model;

import ua.khpi.oop.lab07.contracts.Approvable;
import ua.khpi.oop.lab07.contracts.Signable;

public class ContractDraft implements Approvable, Signable {
    private final String title;
    private boolean isApproved = false;

    public ContractDraft(String title) {
        this.title = title;
    }

    @Override
    public String approve(String approverName) {
        this.isApproved = true;
        return "Контракт \"" + title + "\" затверджено: " + approverName;
    }

    @Override
    public String sign(String signerName) {
        if (!isApproved) {
            return "ПОМИЛКА: Контракт \"" + title + "\" ще не затверджено!";
        }
        return "Контракт \"" + title + "\" підписано стороною: " + signerName;
    }
}