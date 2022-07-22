package io.github.camillesan.hederabudget.services;

import io.github.camillesan.hederabudget.entities.Month;
import io.github.camillesan.hederabudget.entities.RegularExpense;
import io.github.camillesan.hederabudget.entities.RegularIncome;
import io.github.camillesan.hederabudget.repositories.MonthRepository;
import io.github.camillesan.hederabudget.repositories.RegularExpenseRepository;
import io.github.camillesan.hederabudget.repositories.RegularIncomeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class MonthService {

    @Autowired
    MonthRepository monthRepository;
    @Autowired
    RegularIncomeRepository regularIncomeRepository;
    @Autowired
    RegularExpenseRepository regularExpenseRepository;

    public Month getMonthByUUID(UUID uuid) {
        Month month = monthRepository.findById(uuid).get();
        calculMonth(month);
        return month;
    }

    public Month requestNewMonth(String name) {
        Month newMonth = new Month();
        newMonth.setName(name);
        newMonth = monthRepository.save(newMonth);
        calculMonth(newMonth);
        return newMonth;
    }

    private void calculMonth(Month month) {
        regularIncomeRepository.findAll().forEach(month.getRegularIncomes()::add);
        regularExpenseRepository.findAll().forEach(month.getRegularExpenses()::add);
        for (RegularIncome income : month.getRegularIncomes()) {
            month.addToResult(income.getAmount());
        }
        for (RegularExpense expense : month.getRegularExpenses()) {
            month.removeFromResult(expense.getAmount());
        }
    }

}
