package io.github.camillesan.hedera.repositories.expenses;

import io.github.camillesan.hedera.entities.expenses.ExpenseType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExpenseTypeRepository extends CrudRepository<ExpenseType, Long> {

    List<ExpenseType> findAllByUserId(Long userId);

}
