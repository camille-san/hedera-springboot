package io.github.camillesan.hedera.restcontrollers.expenses;

import io.github.camillesan.hedera.entities.expenses.RegularExpense;
import io.github.camillesan.hedera.repositories.expenses.RegularExpenseRepository;
import io.github.camillesan.hedera.repositories.expenses.SingleExpenseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("regular-expense")
@Slf4j
public class RegularExpenseRestController {

    @Autowired
    private RegularExpenseRepository regularExpenseRepository;

    @PostMapping
    public RegularExpense addNewRegularExpense(@RequestBody RegularExpense regularExpense) {
        log.info("[REST] Adding new regular expense: {}", regularExpense);
        return regularExpenseRepository.save(regularExpense);
    }

    @GetMapping(value = "/user/{userId}/all")
    public List<RegularExpense> getAllRegularExpensesFromUser(@PathVariable Long userId) {
        log.info("[REST] Get all regular expenses of user: {}", userId);
        return regularExpenseRepository.findAllByUserId(userId);
    }

    @PutMapping
    public RegularExpense updateRegularExpense(@RequestBody RegularExpense regularExpense) {
        log.info("[REST] Updating regular expense: {}", regularExpense);
        return regularExpenseRepository.save(regularExpense);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteRegularExpense(@PathVariable Long id) {
        log.info("[REST] Deleting regular expense id: {}", id);
        regularExpenseRepository.deleteById(id);
    }

}
