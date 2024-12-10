package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;

import java.util.List;

public interface FruitService {

    List<Fruit> getByPriceDesc ();

    List<Fruit> getByPriceAsc ();

    List<Fruit> searchByName(String text);

    Fruit getById(Long id);

    Fruit save(Fruit fruit);

    Fruit delete(Long id);

}
