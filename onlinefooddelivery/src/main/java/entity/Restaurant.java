package entity;

import jakarta.persistence.*;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private double rating;
    private String cuisineType;

    // Constructors
    public Restaurant(String name, String location, double rating, String cuisineType) {
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.cuisineType = cuisineType;
    }
}
