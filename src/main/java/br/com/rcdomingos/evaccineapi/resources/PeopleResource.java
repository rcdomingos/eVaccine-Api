package br.com.rcdomingos.evaccineapi.resources;

import br.com.rcdomingos.evaccineapi.domain.People;
import br.com.rcdomingos.evaccineapi.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleResource {
    @Autowired
    private PeopleRepository peopleRepository;

    @GetMapping
    public List<People> listAllPeople(){
        return peopleRepository.findAll();
    }

    @PostMapping
    public People registerPeople(@RequestBody People people ){
        return peopleRepository.save(people);
    }

    @PutMapping("/{code}")
    public People updatePeople(
            @PathVariable("code") Long code,
            @RequestBody People people ){

        return peopleRepository.findById(code).map(
                recordPeople->{
                    recordPeople.setName(people.getName());
                    recordPeople.setCpf(people.getCpf());
                    recordPeople.setAge(people.getAge());
                    recordPeople.setBirthDate(people.getBirthDate());
                    recordPeople.setEmail(people.getEmail());
                    recordPeople.setPhone(people.getPhone());

                    return peopleRepository.save(recordPeople);
                }
        ).orElse(null);

    }

    @GetMapping("/{code}")
    public People listPeopleByCode(@PathVariable Long code){
        return peopleRepository.findById(code).orElse(null);
    }

}
