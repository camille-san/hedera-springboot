package io.github.camillesan.hedera.repositories.incomes;


import io.github.camillesan.hedera.entities.incomes.RegularIncome;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegularIncomeRepository extends CrudRepository<RegularIncome, Long> {

    List<RegularIncome> findAllByUserId(Long userId);

}
