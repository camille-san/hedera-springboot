package io.github.camillesan.hederabudget.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class RegularExpense {

    @Id
    @GeneratedValue
    private Long id;

    private Integer dayOfMonth;

    private String label;

    private BigDecimal amount;

}
