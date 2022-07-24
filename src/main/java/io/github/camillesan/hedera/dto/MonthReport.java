package io.github.camillesan.hedera.dto;

import io.github.camillesan.hedera.entities.expenses.ExpenseType;
import io.github.camillesan.hedera.entities.incomes.IncomeType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class MonthReport {

    private int month;
    private int year;

    private List<Income> incomes = new ArrayList<>();

    private List<Expense> expenses = new ArrayList<>();

    private Map<IncomeType, BigDecimal> incomesReport;
    private Map<ExpenseType, BigDecimal> expensesReport;

    private BigDecimal result;

    public MonthReport(int month, int year) {
        this.month = month;
        this.year = year;

        result = new BigDecimal(0);
        expensesReport = new HashMap<>();
        for (ExpenseType type : ExpenseType.values()) {
            expensesReport.put(type, new BigDecimal(0));
        }
        incomesReport = new HashMap<>();
        for (IncomeType type : IncomeType.values()) {
            incomesReport.put(type, new BigDecimal(0));
        }
    }

    public void addToResult(BigDecimal amountToAdd) {
        BigDecimal newTotal = this.result.add(amountToAdd);
        setResult(newTotal);
    }

    public void addToIncomeTypeReport(IncomeType type, BigDecimal amountToAdd) {
        BigDecimal newTotal = this.incomesReport.get(type).add(amountToAdd);
        this.incomesReport.put(type, newTotal);
    }

    public void addToExpenseTypeReport(ExpenseType type, BigDecimal amountToAdd) {
        BigDecimal newTotal = this.expensesReport.get(type).add(amountToAdd);
        this.expensesReport.put(type, newTotal);
    }

    public void removeFromResult(BigDecimal amountToRemove) {
        BigDecimal newTotal = this.result.subtract(amountToRemove);
        setResult(newTotal);
    }

}
