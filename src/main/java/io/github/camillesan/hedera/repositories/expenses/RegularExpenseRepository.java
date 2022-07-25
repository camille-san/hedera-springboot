package io.github.camillesan.hedera.repositories.expenses;

import io.github.camillesan.hedera.entities.expenses.RegularExpense;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegularExpenseRepository extends CrudRepository<RegularExpense, Long> {

    List<RegularExpense> findAllByUserId(Long userId);

}
