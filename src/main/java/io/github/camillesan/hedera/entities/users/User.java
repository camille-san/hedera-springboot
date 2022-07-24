package io.github.camillesan.hedera.entities.users;

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

    @OneToMany(mappedBy = "user")
    private List<RegularIncome> regularIncomes;

    @OneToMany(mappedBy = "user")
    private List<SingleIncome> singleIncomes;

    @OneToMany(mappedBy = "user")
    private List<RegularExpense> regularExpenses;

    @OneToMany(mappedBy = "user")
    private List<SingleExpense> singleExpenses;

}
