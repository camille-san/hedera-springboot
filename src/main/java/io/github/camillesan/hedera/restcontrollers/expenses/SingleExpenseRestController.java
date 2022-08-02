package io.github.camillesan.hedera.restcontrollers.expenses;

import io.github.camillesan.hedera.entities.expenses.SingleExpense;
import io.github.camillesan.hedera.repositories.expenses.SingleExpenseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("single-expense")
@Slf4j
public class SingleExpenseRestController {

    @Autowired
    private SingleExpenseRepository singleExpenseRepository;

    @PostMapping
    public SingleExpense addNewSingleExpense(@RequestBody SingleExpense singleExpense) {
        log.info("[REST] Adding new single expense: {}", singleExpense);
        return singleExpenseRepository.save(singleExpense);
    }

    @GetMapping(value = "/user/{userId}/all")
    public List<SingleExpense> getAllSingleExpensesFromUser(@PathVariable Long userId) {
        log.info("[REST] Get all single expenses of user: {}", userId);
        return singleExpenseRepository.findAllByUserId(userId);
    }

    @PutMapping
    public SingleExpense updateSingleExpense(@RequestBody SingleExpense singleExpense) {
        log.info("[REST] Updating single expense: {}", singleExpense);
        return singleExpenseRepository.save(singleExpense);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteSingleExpense(@PathVariable Long id) {
        log.info("[REST] Deleting single expense id: {}", id);
        singleExpenseRepository.deleteById(id);
    }

}
