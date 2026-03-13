package com.stefan.Countries;
import com.stefan.Countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByCountry(String country);
    boolean existsByCountry(String country);
}