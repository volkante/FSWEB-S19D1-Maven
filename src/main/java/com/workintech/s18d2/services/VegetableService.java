package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    List<Vegetable> sortVegetablesInDescendingOrderByPrice ();
    List<Vegetable> sortVegetablesInAscendingOrderByPrice ();
    List<Vegetable> search(String text);

    Vegetable findById(Long id);

    Vegetable save(Vegetable vegetable);

    List<Vegetable> delete(Long id);
}
