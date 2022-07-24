package io.github.camillesan.hedera.repositories.expenses;

import io.github.camillesan.hedera.entities.expenses.SingleExpense;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SingleExpenseRepository extends CrudRepository<SingleExpense, Long> {

    List<SingleExpense> findAllByUserId(Long userId);

}
