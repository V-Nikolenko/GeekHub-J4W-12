package org.example.hw;

import java.util.Map;
import java.util.stream.Collectors;

public class Exercises {
    private static final Cities citiesRepo = new Cities();

    public Map<String, Long> getCountryCitiesCount() {
        // Find the number of cities of each country (use grouping)
        var cities = citiesRepo.getAllCities();
        return cities.values().stream()
                .collect(Collectors.groupingBy(City::getCountryCode,
                                Collectors.counting()
                        )
                );
    }

    public City mostPopulatedCity() {
        // Find the most populated city
    }

    public City minPopulatedCity() {
        // Find the min populated city
    }

    public String mostPopulatedCountry() {
        // Find the most populated city
    }

    public String minPopulatedCountry() {
        // Find the most populated city
    }

    public Long totalPopulation() {
        // Find the most populated city
    }

    public Map<String,Integer> populationOfEachCountry() {
        // Find the most populated city
    }

    public Integer populationOfSpecificCountry(String countryCode) {
        // Find the most populated city
    }

    public City specificCy(String city) {
        // Find the most populated city
    }


}
