package io.github.camillesan.hedera.entities.users;

import lombok.Data;

import javax.persistence.*;

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
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

}
