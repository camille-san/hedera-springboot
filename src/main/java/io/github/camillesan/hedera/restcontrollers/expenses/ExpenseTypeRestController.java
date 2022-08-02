package io.github.camillesan.hedera.restcontrollers.expenses;

import io.github.camillesan.hedera.entities.expenses.ExpenseType;
import io.github.camillesan.hedera.repositories.expenses.ExpenseTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("expense-type")
@Slf4j
public class ExpenseTypeRestController {

    @Autowired
    private ExpenseTypeRepository expenseTypeRepository;

    @PostMapping
    public ExpenseType addNewExpenseType(@RequestBody ExpenseType expenseType) {
        log.info("[REST] Adding new expense type: {}", expenseType);
        return expenseTypeRepository.save(expenseType);
    }

    @GetMapping(value = "/user/{userId}/all")
    public List<ExpenseType> getAllExpenseTypesFromUser(@PathVariable Long userId) {
        log.info("[REST] Get all expense types of user: {}", userId);
        return expenseTypeRepository.findAllByUserId(userId);
    }

    @PutMapping
    public ExpenseType updateExpenseType(@RequestBody ExpenseType expenseType) {
        log.info("[REST] Updating expense type: {}", expenseType);
        return expenseTypeRepository.save(expenseType);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteExpenseType(@PathVariable Long id) {
        log.info("[REST] Deleting expense type id: {}", id);
        expenseTypeRepository.deleteById(id);
    }

}
