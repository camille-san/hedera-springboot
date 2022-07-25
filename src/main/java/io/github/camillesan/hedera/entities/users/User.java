package io.github.camillesan.hedera.entities.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.camillesan.hedera.entities.expenses.RegularExpense;
import io.github.camillesan.hedera.entities.expenses.SingleExpense;
import io.github.camillesan.hedera.entities.incomes.RegularIncome;
import io.github.camillesan.hedera.entities.incomes.SingleIncome;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hedera_user")
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

}
