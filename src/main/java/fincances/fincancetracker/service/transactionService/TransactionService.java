package fincances.fincancetracker.service.transactionService;

import fincances.fincancetracker.entity.TransactionEntity;
import fincances.fincancetracker.model.TransactionModel;

import java.util.List;

public interface TransactionService  {
    public TransactionEntity createTransaction(Long userId, TransactionEntity transaction);
    public List<TransactionModel> getAllTransactions(Long userId);
    public TransactionModel getTransactionById(Long transactionId);
    public TransactionEntity updateTransaction(Long transactionId, TransactionEntity transactionToUpdate);
    public void deleteTransaction(Long transactionId);
}
