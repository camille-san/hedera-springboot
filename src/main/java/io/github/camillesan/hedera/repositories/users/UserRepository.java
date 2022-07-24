package io.github.camillesan.hedera.repositories.users;


import io.github.camillesan.hedera.entities.users.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
