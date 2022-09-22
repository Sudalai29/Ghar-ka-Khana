package com.example.arjun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.arjun.entity.Food;
import com.example.arjun.repository.IFoodRepository;


@Service
public class IFoodService {
@Autowired
private IFoodRepository IFoodRepository;

	public List<Food> getFoodList(){
        List<Food> food;
        food = IFoodRepository.findAll();
        return food;
    }

    public Food validateFoodInfo(String productId){
        Food food = null;
        food = IFoodRepository.findById(productId).get();
        return food;
    }
}
