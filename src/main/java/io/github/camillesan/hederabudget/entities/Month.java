package io.github.camillesan.hederabudget.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Month {

    @Id
    @GeneratedValue
    private UUID uuid;

    private String name;

    @Transient
    private List<RegularIncome> regularIncomes = new ArrayList<>();

    @Transient
    private List<RegularExpense> regularExpenses = new ArrayList<>();

    @Transient
    private BigDecimal result = new BigDecimal(0);

    public void addToResult(BigDecimal amountToAdd) {
        BigDecimal newTotal = this.result.add(amountToAdd);
        setResult(newTotal);
    }

    public void removeFromResult(BigDecimal amountToRemove) {
        BigDecimal newTotal = this.result.subtract(amountToRemove);
        setResult(newTotal);
    }

}
