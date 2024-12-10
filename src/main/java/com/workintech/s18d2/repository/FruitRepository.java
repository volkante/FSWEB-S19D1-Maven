package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit,Long> {
    @Query("Select f from Fruit f order by f.price desc")
    List<Fruit> getByPriceDesc ();

    @Query("Select f from Fruit f order by f.price")
    List<Fruit> getByPriceAsc ();

    @Query("Select f from Fruit f where f.name ilike %:text% ")
    List<Fruit> searchByName(String text);

    void deleteById(Long id);

}
