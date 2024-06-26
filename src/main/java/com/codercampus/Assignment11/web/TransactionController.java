package com.codercampus.Assignment11.web;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public String getTransactions(ModelMap model) {
        List<Transaction> transactions = transactionService.getAllTransactions();
        model.put("transactions", transactions);
        return "transactions";
    }

    @GetMapping("/transactions/{transactionId}")
    public String getTransaction(ModelMap model, @PathVariable Long transactionId) {
        Transaction transaction = transactionService.getTransactionById(transactionId);
        model.put("transaction", transaction);
        return "transaction";
    }

}
