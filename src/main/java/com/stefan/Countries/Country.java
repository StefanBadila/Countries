package com.stefan.Countries;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@JsonPropertyOrder({ "id", "country", "capital", "population" })
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Country name is mandatory!")
    @Column(nullable = false)
    private String country;
    @NotBlank(message = "Capital name is mandatory!")
    @Column(nullable = false)
    private String capital;
    private Long population = 0L;

    public Country() {
    }

    public Country(String country, String capital, Long population) {
        this.country = country;
        this.capital = capital;
        this.population = (population == null) ? 0L : population;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }
}
