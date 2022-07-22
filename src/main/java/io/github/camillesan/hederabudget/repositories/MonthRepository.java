package io.github.camillesan.hederabudget.repositories;

import io.github.camillesan.hederabudget.entities.Month;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MonthRepository extends CrudRepository<Month, UUID> {
}
