package fincances.fincancetracker.service.transactionService;

import fincances.fincancetracker.entity.TransactionEntity;
import fincances.fincancetracker.model.TransactionModel;
import fincances.fincancetracker.repository.TransactionRepository;
import fincances.fincancetracker.entity.UserEntity;
import fincances.fincancetracker.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private TransactionRepository transactionRepository;
    private UserRepository userRepository;

    public TransactionEntity createTransaction(Long userId, TransactionEntity transaction) {
        UserEntity user = userRepository.findById(userId).get();
        transaction.setUser(user);
        return this.transactionRepository.save(transaction);
    }

    public List<TransactionModel> getAllTransactions(Long userId) {
        List<TransactionEntity> transactions = this.transactionRepository.findAllTransactionsByUserId(userId);
        List<TransactionModel> transactionModels = transactions
                .stream()
                .map(transaction -> TransactionModel.toModel(transaction))
                .collect(Collectors.toCollection(ArrayList::new));
        return transactionModels;
    }

    public TransactionModel getTransactionById(Long transactionId) {
        return TransactionModel.toModel(this.transactionRepository.findById(transactionId).get());
    }

    public TransactionEntity updateTransaction(Long transactionId, TransactionEntity transactionToUpdate) {
        TransactionEntity transactionEntity = this.transactionRepository.findById(transactionId).get();
        transactionEntity.setName(transactionToUpdate.getName());
        transactionEntity.setDescription(transactionToUpdate.getDescription());
        transactionEntity.setPrice(transactionToUpdate.getPrice());
        return this.transactionRepository.save(transactionEntity);
    }

    public void deleteTransaction(Long transactionId) {
        this.transactionRepository.deleteById(transactionId);
    }
}
