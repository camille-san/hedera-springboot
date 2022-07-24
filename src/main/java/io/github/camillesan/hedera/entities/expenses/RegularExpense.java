package io.github.camillesan.hedera.entities.expenses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.camillesan.hedera.entities.Periodicity;
import io.github.camillesan.hedera.entities.users.User;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class RegularExpense {

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
    private ExpenseType type;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Periodicity periodicity = Periodicity.MONTHLY;

    @Column(nullable = false)
    private BigDecimal amount;

}
