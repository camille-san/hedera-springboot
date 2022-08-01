package io.github.camillesan.hedera.restcontrollers.expenses;

import io.github.camillesan.hedera.entities.expenses.RegularExpense;
import io.github.camillesan.hedera.entities.expenses.SingleExpense;
import io.github.camillesan.hedera.repositories.expenses.RegularExpenseRepository;
import io.github.camillesan.hedera.repositories.expenses.SingleExpenseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("expenses")
@Slf4j
public class ExpenseRestController {

    @Autowired
    private RegularExpenseRepository regularExpenseRepository;
    @Autowired
    private SingleExpenseRepository singleExpenseRepository;

    @PostMapping(value = "/regular")
    public RegularExpense addNewRegularExpense(@RequestBody RegularExpense regularExpense) {
        log.info("[REST] Adding new regular expense: {}", regularExpense);
        return regularExpenseRepository.save(regularExpense);
    }

    @GetMapping(value = "/regulars")
    public List<RegularExpense> getAllRegularExpensesFromUser(@RequestParam Long userId) {
        log.info("[REST] Get all regular expenses of user: {}", userId);
        return regularExpenseRepository.findAllByUserId(userId);
    }

    @PutMapping(value = "/regular")
    public RegularExpense updateRegularExpense(@RequestBody RegularExpense regularExpense) {
        log.info("[REST] Updating regular expense: {}", regularExpense);
        return regularExpenseRepository.save(regularExpense);
    }

    @DeleteMapping(value = "/regular/{id}")
    public void deleteRegularExpense(@PathVariable Long id) {
        log.info("[REST] Deleting regular expense id: {}", id);
        regularExpenseRepository.deleteById(id);
    }

//    ===================================================================

    @PostMapping(value = "/single")
    public SingleExpense addNewSingleExpense(@RequestBody SingleExpense singleExpense) {
        log.info("[REST] Adding new single expense: {}", singleExpense);
        return singleExpenseRepository.save(singleExpense);
    }

    @GetMapping(value = "/singles")
    public List<SingleExpense> getAllSingleExpensesFromUser(@RequestParam Long userId) {
        log.info("[REST] Get all single expenses of user: {}", userId);
        return singleExpenseRepository.findAllByUserId(userId);
    }

    @PutMapping(value = "/single")
    public SingleExpense updateSingleExpense(@RequestBody SingleExpense singleExpense) {
        log.info("[REST] Updating single expense: {}", singleExpense);
        return singleExpenseRepository.save(singleExpense);
    }

    @DeleteMapping(value = "/single/{id}")
    public void deleteSingleExpense(@PathVariable Long id) {
        log.info("[REST] Deleting single expense id: {}", id);
        regularExpenseRepository.deleteById(id);
    }

}
