package io.github.camillesan.hederabudget.restcontrollers;

import io.github.camillesan.hederabudget.entities.RegularExpense;
import io.github.camillesan.hederabudget.repositories.RegularExpenseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("regular-expense")
@Slf4j
public class RegularExpenseRestController {

    @Autowired
    RegularExpenseRepository regularExpenseRepository;

    @PostMapping(value = "/add")
    @CrossOrigin(origins = "*")
    public RegularExpense addNew(@RequestBody RegularExpense regularExpense) {
        return regularExpenseRepository.save(regularExpense);
    }

    @GetMapping(value = "/all")
    @CrossOrigin(origins = "*")
    public Iterable<RegularExpense> getAll() {
        return regularExpenseRepository.findAll();
    }

}
