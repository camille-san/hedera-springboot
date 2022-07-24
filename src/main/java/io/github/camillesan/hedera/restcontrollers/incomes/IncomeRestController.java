package io.github.camillesan.hedera.restcontrollers.incomes;

import io.github.camillesan.hedera.entities.incomes.RegularIncome;
import io.github.camillesan.hedera.entities.incomes.SingleIncome;
import io.github.camillesan.hedera.repositories.incomes.RegularIncomeRepository;
import io.github.camillesan.hedera.repositories.incomes.SingleIncomeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("incomes")
@Slf4j
public class IncomeRestController {

    @Autowired
    private RegularIncomeRepository regularIncomeRepository;
    @Autowired
    private SingleIncomeRepository singleIncomeRepository;

    @PostMapping(value = "/regular")
    @CrossOrigin(origins = "*")
    public RegularIncome addNewRegularIncome(@RequestBody RegularIncome regularIncome) {
        log.info("[REST] Adding new regular income: {}", regularIncome);
        return regularIncomeRepository.save(regularIncome);
    }

    @GetMapping(value = "/regulars")
    @CrossOrigin(origins = "*")
    public List<RegularIncome> getAllRegularIncomesFromUser(@RequestParam Long userId) {
        log.info("[REST] Get all regular incomes of user: {}", userId);
        return regularIncomeRepository.findAllByUserId(userId);
    }

    @PutMapping(value = "/regular")
    @CrossOrigin(origins = "*")
    public RegularIncome updateRegularIncome(@RequestBody RegularIncome regularIncome) {
        log.info("[REST] Updating regular income: {}", regularIncome);
        return regularIncomeRepository.save(regularIncome);
    }

    @DeleteMapping(value = "/regular/{id}")
    @CrossOrigin(origins = "*")
    public void deleteRegularIncome(@PathVariable Long id) {
        log.info("[REST] Deleting regular income id: {}", id);
        regularIncomeRepository.deleteById(id);
    }

//    ===================================================================

    @PostMapping(value = "/single")
    @CrossOrigin(origins = "*")
    public SingleIncome addNewSingleIncome(@RequestBody SingleIncome singleIncome) {
        log.info("[REST] Adding new single income: {}", singleIncome);
        return singleIncomeRepository.save(singleIncome);
    }

    @GetMapping(value = "/singles")
    @CrossOrigin(origins = "*")
    public List<SingleIncome> getAllSingleIncomesFromUser(@RequestParam Long userId) {
        log.info("[REST] Get all single incomes of user: {}", userId);
        return singleIncomeRepository.findAllByUserId(userId);
    }

    @PutMapping(value = "/single")
    @CrossOrigin(origins = "*")
    public SingleIncome updateSingleIncome(@RequestBody SingleIncome singleIncome) {
        log.info("[REST] Updating single income: {}", singleIncome);
        return singleIncomeRepository.save(singleIncome);
    }

    @DeleteMapping(value = "/single/{id}")
    @CrossOrigin(origins = "*")
    public void deleteSingleIncome(@PathVariable Long id) {
        log.info("[REST] Deleting single income id: {}", id);
        regularIncomeRepository.deleteById(id);
    }

}
