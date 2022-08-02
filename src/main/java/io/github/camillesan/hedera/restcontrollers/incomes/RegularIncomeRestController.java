package io.github.camillesan.hedera.restcontrollers.incomes;

import io.github.camillesan.hedera.entities.incomes.RegularIncome;
import io.github.camillesan.hedera.repositories.incomes.RegularIncomeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("regular-income")
@Slf4j
public class RegularIncomeRestController {

    @Autowired
    private RegularIncomeRepository regularIncomeRepository;

    @PostMapping
    public RegularIncome addNewRegularIncome(@RequestBody RegularIncome regularIncome) {
        log.info("[REST] Adding new regular income: {}", regularIncome);
        return regularIncomeRepository.save(regularIncome);
    }

    @GetMapping(value = "/user/{userId}/all")
    public List<RegularIncome> getAllRegularIncomesFromUser(@PathVariable Long userId) {
        log.info("[REST] Get all regular incomes of user: {}", userId);
        return regularIncomeRepository.findAllByUserId(userId);
    }

    @PutMapping
    public RegularIncome updateRegularIncome(@RequestBody RegularIncome regularIncome) {
        log.info("[REST] Updating regular income: {}", regularIncome);
        return regularIncomeRepository.save(regularIncome);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteRegularIncome(@PathVariable Long id) {
        log.info("[REST] Deleting regular income id: {}", id);
        regularIncomeRepository.deleteById(id);
    }

}
