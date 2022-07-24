package io.github.camillesan.hedera.restcontrollers;

import io.github.camillesan.hedera.entities.Periodicity;
import io.github.camillesan.hedera.entities.expenses.ExpenseType;
import io.github.camillesan.hedera.entities.incomes.IncomeType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("utils")
@Slf4j
public class UtilsRestController {

    @GetMapping("/incomes-types")
    @CrossOrigin(origins = "*")
    public IncomeType[] getIncomesTypes() {
        return IncomeType.values();
    }

    @GetMapping("/expenses-types")
    @CrossOrigin(origins = "*")
    public ExpenseType[] getExpensesTypes() {
        return ExpenseType.values();
    }

    @GetMapping("/periodicities")
    @CrossOrigin(origins = "*")
    public Periodicity[] getPeriodicities() {
        return Periodicity.values();
    }

}
