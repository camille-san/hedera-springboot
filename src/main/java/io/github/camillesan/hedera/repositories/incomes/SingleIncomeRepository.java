package io.github.camillesan.hedera.repositories.incomes;


import io.github.camillesan.hedera.entities.incomes.SingleIncome;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SingleIncomeRepository extends CrudRepository<SingleIncome, Long> {

    List<SingleIncome> findAllByUserId(Long userId);

}
