package br.com.rcdomingos.evaccineapi.resources;

import br.com.rcdomingos.evaccineapi.domain.PriorityGroups;
import br.com.rcdomingos.evaccineapi.repository.PriorityGroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("priority-groups")
public class PriorityGroupsResource {
    @Autowired
    private PriorityGroupsRepository priorityGroupsRepository;

    @PostMapping
    public PriorityGroups createPriorityGroup(@RequestBody PriorityGroups priorityGroups) {
        return priorityGroupsRepository.save(priorityGroups);
    }

    @GetMapping
    public List<PriorityGroups> listAllPriorityGroups() {
        return priorityGroupsRepository.findAll();
    }

    @PutMapping("/{code}")
    public PriorityGroups updatePriorityGroup(@PathVariable Long code,
                                              @RequestBody PriorityGroups priorityGroups) {
        return priorityGroupsRepository.findById(code).map(
                recordGroup -> {
                    recordGroup.setName(priorityGroups.getName());
                    recordGroup.setDescription((priorityGroups.getDescription()));

                    return priorityGroupsRepository.save(recordGroup);
                }).orElse(null);
    }

    @GetMapping("/{code}")
    public PriorityGroups listGroupsByCode(@PathVariable Long code){
        return  priorityGroupsRepository.findById(code).orElse(null);
    }

}
