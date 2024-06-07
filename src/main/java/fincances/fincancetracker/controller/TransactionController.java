package fincances.fincancetracker.controller;

import fincances.fincancetracker.entity.TransactionEntity;
import fincances.fincancetracker.service.transactionService.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/transaction")
public class TransactionController {
    private TransactionService transactionService;

    @GetMapping("/get/all")
    public ResponseEntity getAllTransactionsByUserId(@RequestParam("id") Long userId) {
        try {
            return ResponseEntity.ok().body(this.transactionService.getAllTransactions(userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity getTransaction(@RequestParam("id") Long transactionId) {
        try {
            return ResponseEntity.ok().body(this.transactionService.getTransactionById(transactionId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity createTransaction(@RequestParam("id") Long userId, @RequestBody TransactionEntity transaction) {
        try {
            return ResponseEntity.ok().body(this.transactionService.createTransaction(userId, transaction));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateTransaction(@RequestParam("id") Long transactionId, @RequestBody TransactionEntity updatedTransaction) {
        try {
            return ResponseEntity.ok().body(this.transactionService.updateTransaction(transactionId, updatedTransaction));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteTransaction(@RequestParam("id") Long transactionId) {
        try {
            this.transactionService.deleteTransaction(transactionId);
            return ResponseEntity.ok().body("Transaction successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
