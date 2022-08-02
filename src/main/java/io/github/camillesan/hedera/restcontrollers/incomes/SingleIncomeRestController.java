package io.github.camillesan.hedera.restcontrollers.incomes;

import io.github.camillesan.hedera.entities.incomes.SingleIncome;
import io.github.camillesan.hedera.repositories.incomes.SingleIncomeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("single-income")
@Slf4j
public class SingleIncomeRestController {

    @Autowired
    private SingleIncomeRepository singleIncomeRepository;

    @PostMapping
    public SingleIncome addNewSingleIncome(@RequestBody SingleIncome singleIncome) {
        log.info("[REST] Adding new single income: {}", singleIncome);
        return singleIncomeRepository.save(singleIncome);
    }

    @GetMapping(value = "/user/{userId}/all")
    public List<SingleIncome> getAllSingleIncomesFromUser(@PathVariable Long userId) {
        log.info("[REST] Get all single incomes of user: {}", userId);
        return singleIncomeRepository.findAllByUserId(userId);
    }

    @PutMapping
    public SingleIncome updateSingleIncome(@RequestBody SingleIncome singleIncome) {
        log.info("[REST] Updating single income: {}", singleIncome);
        return singleIncomeRepository.save(singleIncome);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteSingleIncome(@PathVariable Long id) {
        log.info("[REST] Deleting single income id: {}", id);
        singleIncomeRepository.deleteById(id);
    }

}
