package com.example.demo;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;


import org.springframework.stereotype.Component;

import com.webservice.mine.Country;
import com.webservice.mine.Currency;

//repository in order to provide data to web service
@Component
public class CountryRepository {
	private static final Map<String, Country> countries = new HashMap<>();
	 
    @PostConstruct
    public void initData() {
        // initialize countries map
    	Country country = new Country();
    	country.setName("Spain");
    	country.setPopulation(46704314);
    	country.setCapital("Madrid");
    	country.setCurrency(Currency.GBP);
    	countries.put(country.getName(), country);
    	
    	country = new Country();
    	country.setName("Europe");
    	country.setPopulation(46704313);
    	country.setCapital("Madrid2");
    	country.setCurrency(Currency.EUR);
    	countries.put(country.getName(), country);
    }
 
    public Country findCountry(String name) {
        return countries.get(name);
    }
    
    public Currency getCurrency(String name) {
    	return countries.get(name).getCurrency();
    }
}
