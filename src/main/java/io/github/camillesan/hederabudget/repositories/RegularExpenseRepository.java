package io.github.camillesan.hederabudget.repositories;

import io.github.camillesan.hederabudget.entities.RegularExpense;
import org.springframework.data.repository.CrudRepository;

public interface RegularExpenseRepository extends CrudRepository<RegularExpense, Long> {
}
