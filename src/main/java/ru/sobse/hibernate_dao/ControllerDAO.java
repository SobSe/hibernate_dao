package ru.sobse.hibernate_dao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sobse.hibernate_dao.Entity.Persons;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class ControllerDAO {
    private ServiceDAO service;

    public ControllerDAO(ServiceDAO service) {
        this.service = service;
    }

    @GetMapping("/by-city")
    public List<Persons> personsByCity(@RequestParam String city) {
        return service.personsByCity(city);
    }
}
