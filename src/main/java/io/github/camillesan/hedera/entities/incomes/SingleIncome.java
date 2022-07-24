package io.github.camillesan.hedera.entities.incomes;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.camillesan.hedera.entities.users.User;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class SingleIncome {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    @Column(nullable = false)
    private String label;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IncomeType type;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private BigDecimal amount;

}
