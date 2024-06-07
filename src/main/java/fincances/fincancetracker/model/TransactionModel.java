package fincances.fincancetracker.model;

import fincances.fincancetracker.entity.TransactionEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TransactionModel {
    private Long id;
    private Long price;
    private String description;

    public static TransactionModel toModel(TransactionEntity transaction) {
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setId(transaction.getId());
        transactionModel.setPrice(transaction.getPrice());
        transactionModel.setDescription(transaction.getDescription());
        return transactionModel;
    }
}
