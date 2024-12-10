package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("")
    public List<Fruit> getFruitsInAscendingOrderByPrice(){
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Fruit getById(@Validated @PathVariable Long id){
        return fruitService.getById(id);
    }

    @GetMapping("/desc")
    public List<Fruit> getFruitsInDescendingOrderByPrice(){
        return fruitService.getByPriceDesc();
    }

    @PostMapping("")
    public Fruit save(@RequestBody @Validated Fruit fruit){
        return fruitService.save(fruit);
    }

    @PostMapping("/name/{name}")
    public List<Fruit> searchByName(@PathVariable String name){
        return fruitService.searchByName(name.toLowerCase());
    }

    @DeleteMapping("/{id}")
    public Fruit deleteById(@PathVariable @Validated Long id){
        return fruitService.delete(id);
    }


}
