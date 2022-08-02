package io.github.camillesan.hedera.entities.expenses;

import io.github.camillesan.hedera.entities.users.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ExpenseType {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    @Column(nullable = false)
    private String label;

    @Column
    private String color;

}
