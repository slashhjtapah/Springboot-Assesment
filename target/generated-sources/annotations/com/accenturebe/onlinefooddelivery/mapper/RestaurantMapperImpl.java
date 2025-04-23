package com.accenturebe.onlinefooddelivery.mapper;

import com.accenturebe.onlinefooddelivery.dto.RestaurantDTO;
import com.accenturebe.onlinefooddelivery.entity.Restaurant;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-23T16:16:50+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class RestaurantMapperImpl implements RestaurantMapper {

    @Override
    public Restaurant toEntity(RestaurantDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Restaurant restaurant = new Restaurant();

        restaurant.setId( dto.getId() );
        restaurant.setName( dto.getName() );
        restaurant.setAddress( dto.getAddress() );
        restaurant.setPhoneNumber( dto.getPhoneNumber() );
        restaurant.setEmail( dto.getEmail() );

        return restaurant;
    }

    @Override
    public RestaurantDTO toDTO(Restaurant entity) {
        if ( entity == null ) {
            return null;
        }

        RestaurantDTO.RestaurantDTOBuilder restaurantDTO = RestaurantDTO.builder();

        restaurantDTO.id( entity.getId() );
        restaurantDTO.name( entity.getName() );
        restaurantDTO.address( entity.getAddress() );
        restaurantDTO.phoneNumber( entity.getPhoneNumber() );
        restaurantDTO.email( entity.getEmail() );

        return restaurantDTO.build();
    }
}
