package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.FruitService;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/vegetables")
public class VegetableController {
    private VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping("")
    public List<Vegetable> getVegetablesInAscendingOrderByPrice(){
        return vegetableService.sortVegetablesInAscendingOrderByPrice();
    }

    @GetMapping("/{id}")
    public Vegetable getVegetableById(@Validated @PathVariable Long id){
        return vegetableService.findById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> getVegetablesInDescendingOrderByPrice(){
        return vegetableService.sortVegetablesInDescendingOrderByPrice();
    }

    @PostMapping("")
    public Vegetable save(@RequestBody @Validated Vegetable vegetable){
        return vegetableService.save(vegetable);
    }

    @PostMapping("/{name}")
    public List<Vegetable> searchByName(@PathVariable String name){
        return vegetableService.search(name);
    }

    @DeleteMapping("/{id}")
    public List<Vegetable> deleteById(@PathVariable @Validated Long id){
        return vegetableService.delete(id);
    }
}
