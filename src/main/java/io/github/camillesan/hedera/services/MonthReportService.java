package io.github.camillesan.hedera.services;

import io.github.camillesan.hedera.dto.Expense;
import io.github.camillesan.hedera.dto.Income;
import io.github.camillesan.hedera.dto.MonthReport;
import io.github.camillesan.hedera.entities.expenses.RegularExpense;
import io.github.camillesan.hedera.entities.expenses.SingleExpense;
import io.github.camillesan.hedera.entities.incomes.RegularIncome;
import io.github.camillesan.hedera.entities.incomes.SingleIncome;
import io.github.camillesan.hedera.repositories.expenses.RegularExpenseRepository;
import io.github.camillesan.hedera.repositories.expenses.SingleExpenseRepository;
import io.github.camillesan.hedera.repositories.incomes.RegularIncomeRepository;
import io.github.camillesan.hedera.repositories.incomes.SingleIncomeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MonthReportService {

    @Autowired
    private RegularIncomeRepository regularIncomeRepository;
    @Autowired
    private SingleIncomeRepository singleIncomeRepository;
    @Autowired
    private RegularExpenseRepository regularExpenseRepository;
    @Autowired
    private SingleExpenseRepository singleExpenseRepository;

    public MonthReport calculateMonth(Long userId, int month, int year) {
        MonthReport report = new MonthReport(month, year);
        List<Income> incomes = new ArrayList<>();
        List<Expense> expenses = new ArrayList<>();

        List<RegularIncome> regularIncomes = regularIncomeRepository.findAllByUserId(userId);
        regularIncomes.forEach(income -> {
            incomes.add(Income.builder()
                    .label(income.getLabel())
                    .type(income.getType().name())
                    .amount(income.getAmount())
                    .build());
            report.addToIncomeTypeReport(income.getType(), income.getAmount());
        });
        List<SingleIncome> singleIncomes = singleIncomeRepository.findAllByUserId(userId);
        singleIncomes.forEach(income -> {
            if (isDateRelevant(month, year, income.getDate())) {
                incomes.add(Income.builder()
                        .label(income.getLabel())
                        .type(income.getType().name())
                        .amount(income.getAmount())
                        .build());
                report.addToIncomeTypeReport(income.getType(), income.getAmount());
            }
        });

        List<RegularExpense> regularExpenses = regularExpenseRepository.findAllByUserId(userId);
        regularExpenses.forEach(expense -> {
            expenses.add(Expense.builder()
                    .label(expense.getLabel())
                    .type(expense.getType().name())
                    .amount(expense.getAmount())
                    .build());
            report.addToExpenseTypeReport(expense.getType(), expense.getAmount());
        });
        List<SingleExpense> singleExpenses = singleExpenseRepository.findAllByUserId(userId);
        singleExpenses.forEach(expense -> {
            if (isDateRelevant(month, year, expense.getDate())) {
                expenses.add(Expense.builder()
                        .label(expense.getLabel())
                        .type(expense.getType().name())
                        .amount(expense.getAmount())
                        .build());
                report.addToExpenseTypeReport(expense.getType(), expense.getAmount());
            }
        });

        report.setIncomes(incomes);
        report.setExpenses(expenses);

        for (Income income : incomes) {
            report.addToResult(income.getAmount());
        }

        for (Expense expense : expenses) {
            report.removeFromResult(expense.getAmount());
        }

        return report;
    }

    public boolean isDateRelevant(int month, int year, LocalDate date) {
        return date.getMonthValue() == month && date.getYear() == year;
    }

}
