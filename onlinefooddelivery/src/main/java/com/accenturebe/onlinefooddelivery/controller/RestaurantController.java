package com.accenturebe.onlinefooddelivery.controller;

import com.accenturebe.onlinefooddelivery.dto.RestaurantDTO;
import com.accenturebe.onlinefooddelivery.service.RestaurantService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private static final Logger log = LoggerFactory.getLogger(RestaurantController.class);
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<RestaurantDTO> addRestaurant(@RequestBody @Valid RestaurantDTO restaurantDTO) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String body = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(restaurantDTO);

        log.info( "Received request to add restaurant: {}", body);
        RestaurantDTO addedRestaurant = restaurantService.addRestaurant(restaurantDTO);
        log.info("Added restaurant: {}", addedRestaurant);
        return ResponseEntity.status(201).body(addedRestaurant);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDTO> getRestaurant(@PathVariable Long id) {
        RestaurantDTO restaurant = restaurantService.getRestaurantById(id);
        return ResponseEntity.ok(restaurant);
    }

    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurants() {
        List<RestaurantDTO> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantDTO> updateRestaurant(@PathVariable Long id, @RequestBody @Valid RestaurantDTO restaurantDTO) {
        RestaurantDTO updated = restaurantService.updateRestaurant(id, restaurantDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity
                .ok("Restaurant ID: " + id + "deleted");
    }
}
