package io.github.camillesan.hederabudget.repositories;

import io.github.camillesan.hederabudget.entities.RegularIncome;
import org.springframework.data.repository.CrudRepository;

public interface RegularIncomeRepository extends CrudRepository<RegularIncome, Long> {
}
