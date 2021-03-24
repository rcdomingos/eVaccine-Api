package br.com.rcdomingos.evaccineapi.repository;

import br.com.rcdomingos.evaccineapi.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Long> {
}
