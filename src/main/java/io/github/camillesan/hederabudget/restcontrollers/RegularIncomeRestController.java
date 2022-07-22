package io.github.camillesan.hederabudget.restcontrollers;

import io.github.camillesan.hederabudget.entities.RegularIncome;
import io.github.camillesan.hederabudget.repositories.RegularIncomeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("regular-income")
@Slf4j
public class RegularIncomeRestController {

    @Autowired
    RegularIncomeRepository regularIncomeRepository;

    @PostMapping(value = "/add")
    public RegularIncome addNew(@RequestBody RegularIncome regularIncome) {
        return regularIncomeRepository.save(regularIncome);
    }

    @GetMapping(value = "/all")
    public Iterable<RegularIncome> getAll() {
        return regularIncomeRepository.findAll();
    }

}
