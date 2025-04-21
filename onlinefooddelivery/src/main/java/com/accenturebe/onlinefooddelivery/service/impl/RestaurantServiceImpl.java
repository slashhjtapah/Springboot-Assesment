package com.accenturebe.onlinefooddelivery.service.impl;

import com.accenturebe.onlinefooddelivery.entity.Restaurant;

import org.springframework.stereotype.Service;
import com.accenturebe.onlinefooddelivery.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl {
    private final RestaurantRepository restaurantRepository;

    // Constructor injection
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}
