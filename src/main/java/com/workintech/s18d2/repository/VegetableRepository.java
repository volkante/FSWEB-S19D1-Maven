package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable,Long> {

    @Query("Select v from Vegetable v order by v.price desc")
    List<Vegetable> sortVegetablesInDescendingOrderByPrice ();

    @Query("Select v from Vegetable v order by v.price")
    List<Vegetable> sortVegetablesInAscendingOrderByPrice ();

    @Query("Select v from Vegetable v where v.name ilike %:text% ")
    List<Vegetable> search(String text);

}
