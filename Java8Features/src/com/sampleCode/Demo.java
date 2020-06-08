package com.sampleCode;

import java.io.IOException;
import java.util.List;
import static com.sampleCode.PersonPredicates.*;

//this program includes 
//method ref, read & write to files, stream, predicates, for Each.
//Local date, string to date, lambda expressions, difference between dates,
//comparator
public class Demo {

	public static void main(String[] args) {

		AddPersonDetails addDetails = new AddPersonDetails();
		List<Person> personDetails = addDetails.readDataFromFile();
		
		// display all the data
		display(personDetails);
		
		// filter the details
		List<Person> adultsList = filterPersons(personDetails, isAdult());
		List<Person> malePaintersList = filterPersons(personDetails, isMalePainters());
		
		// write the filtered data to respective files
		try {
			addDetails.writeDataToFile(adultsList, "./././resources/Over18List.txt");
			addDetails.writeDataToFile(malePaintersList, "./././resources/MalePaintersList.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//:: -> method ref
	public static void display(List<Person> personDetails) {
		personDetails.forEach(System.out::print);
	}
}
