package ru.ChernomortsevEgor.NauJava.task7;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "report")
public interface ReportRepository extends CrudRepository<Report, Long> {
}
