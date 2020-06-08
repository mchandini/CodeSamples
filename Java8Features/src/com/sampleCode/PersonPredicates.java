package com.sampleCode;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonPredicates {
	
	//predicate and lambda expression
	public static Predicate<Person> isMalePainters() {
		return p -> p.getSex().equalsIgnoreCase("M") && Arrays.asList(p.getHobbies()).contains("painting");
	}

	//get age byusing string to date convertor, LocalDate and period
	public static Predicate<Person> isAdult() {
		return p -> {
			LocalDate dob = LocalDate.parse(p.getDob());
			Period diff = Period.between(dob, LocalDate.now());
			return diff.getYears() > 18;
		};
	}
	
	//filter data using stream, filters
	//sort data using comparator
	//collect results to a list
	public static List<Person> filterPersons (List<Person> personsData, Predicate<Person> predicate) {
		return personsData.stream().filter(predicate).sorted(Comparator.comparing(Person::getFirstName)).collect(Collectors.<Person>toList());
	}
}
