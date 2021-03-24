package br.com.rcdomingos.evaccineapi.repository;

import br.com.rcdomingos.evaccineapi.domain.PriorityGroups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriorityGroupsRepository extends JpaRepository<PriorityGroups,Long> {
}
