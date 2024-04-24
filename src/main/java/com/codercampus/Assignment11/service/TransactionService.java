package com.codercampus.Assignment11.service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepo;

    @Autowired
    TransactionService(TransactionRepository transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = transactionRepo.findAll();
        transactions.sort(Comparator.comparing(Transaction::getDate));
        return transactions;
    }

}
