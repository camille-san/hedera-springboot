package io.github.camillesan.hedera.repositories.expenses;

import io.github.camillesan.hedera.entities.expenses.RegularExpense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "regular-expenses")
public interface RegularExpenseRepository extends CrudRepository<RegularExpense, Long> {

    List<RegularExpense> findAllByUserId(Long userId);

}
