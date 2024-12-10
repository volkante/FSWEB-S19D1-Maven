package com.workintech.s18d2.services;

import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService {

    private VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> sortVegetablesInDescendingOrderByPrice() {
        return vegetableRepository.sortVegetablesInDescendingOrderByPrice();
    }

    @Override
    public List<Vegetable> sortVegetablesInAscendingOrderByPrice() {
        return vegetableRepository.sortVegetablesInAscendingOrderByPrice();
    }

    @Override
    public List<Vegetable> search(String text) {
        return vegetableRepository.search(text);
    }

    @Override
    public Vegetable findById(Long id) {
        Optional<Vegetable> vegetableOptional = vegetableRepository.findById(id);
        if(vegetableOptional.isPresent()){
            return vegetableOptional.get();
        }
        throw new PlantException("Vegetable with given Id is not found: " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public List<Vegetable> delete(Long id) {
        vegetableRepository.deleteById(id);
        return vegetableRepository.sortVegetablesInAscendingOrderByPrice();
    }
}
