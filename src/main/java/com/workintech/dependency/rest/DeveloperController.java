package com.workintech.dependency.rest;

import com.workintech.dependency.model.Developer;
import com.workintech.dependency.model.DeveloperFactory;
import com.workintech.dependency.model.JuniorDeveloper;
import com.workintech.dependency.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/developers")
public class DeveloperController {
    private Map<Integer, Developer> developers;
    private Taxable taxable;
    @PostConstruct
    public void init(){
        developers = new HashMap<>();
    }

    @Autowired
    public DeveloperController(@Qualifier("developerTax") Taxable taxable){
        this.taxable = taxable;
    }

    @GetMapping("/")
    public List<Developer> get(){
        return developers.values().stream().toList();
    }
    @GetMapping("/{id}")
    public Developer get(@PathVariable int id){
        return developers.get(id);
    }
    @PostMapping("/")
    public Developer save(@RequestBody Developer developer){
        Developer savedDev = DeveloperFactory.checkExperience(developer,taxable);
        developers.put(developer.getId(), savedDev);
        return savedDev;
    }
    @PutMapping("/{id}")
    public Developer update(@PathVariable int id, @RequestBody Developer developer){
        developers.put(id, developer);
        return developers.get(id);
    }
    @DeleteMapping("/{id}")
    public Developer delete(@PathVariable int id){
        Developer deletedDev = developers.get(id);
        developers.remove(developers.remove(id));
        return deletedDev;
    }
}
