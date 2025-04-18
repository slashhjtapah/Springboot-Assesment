package service.impl;

import entity.Restaurant;
import org.springframework.stereotype.Service;
import repository.RestaurantRepository;
import service.RestaurantService;

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
