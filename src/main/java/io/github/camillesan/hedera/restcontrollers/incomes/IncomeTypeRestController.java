package io.github.camillesan.hedera.restcontrollers.incomes;

import io.github.camillesan.hedera.entities.incomes.IncomeType;
import io.github.camillesan.hedera.repositories.incomes.IncomeTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("income-type")
@Slf4j
public class IncomeTypeRestController {

    @Autowired
    private IncomeTypeRepository incomeTypeRepository;

    @PostMapping
    public IncomeType addNewIncomeType(@RequestBody IncomeType incomeType) {
        log.info("[REST] Adding new income type: {}", incomeType);
        return incomeTypeRepository.save(incomeType);
    }

    @GetMapping(value = "/user/{userId}/all")
    public List<IncomeType> getAllIncomeTypesFromUser(@PathVariable Long userId) {
        log.info("[REST] Get all income types of user: {}", userId);
        return incomeTypeRepository.findAllByUserId(userId);
    }

    @PutMapping
    public IncomeType updateIncomeType(@RequestBody IncomeType incomeType) {
        log.info("[REST] Updating income type: {}", incomeType);
        return incomeTypeRepository.save(incomeType);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteIncomeType(@PathVariable Long id) {
        log.info("[REST] Deleting income type id: {}", id);
        incomeTypeRepository.deleteById(id);
    }

}
