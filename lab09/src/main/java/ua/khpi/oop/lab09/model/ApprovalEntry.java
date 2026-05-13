package ua.khpi.oop.lab09.model;

/**
 * Узагальнений клас для пов'язування документа з його метаданими (погодженням).
 * @param <TDoc> тип документа
 * @param <TMeta> тип метаданих (наприклад, Employee або String статус)
 */
public class ApprovalEntry<TDoc, TMeta> {
    private final TDoc document;
    private final TMeta approvalData;

    public ApprovalEntry(TDoc document, TMeta approvalData) {
        this.document = document;
        this.approvalData = approvalData;
    }

    public TDoc getDocument() { return document; }
    public TMeta getApprovalData() { return approvalData; }

    @Override
    public String toString() {
        return "ЗаписПогодження{документ=" + document + ", дані=" + approvalData + "}";
    }
}