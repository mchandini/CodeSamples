package com.sampleCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;


public class AddPersonDetails {	
	
	List<Person> personDetails = new ArrayList<Person>();
	Path filePath = Paths.get("./././resources", "data.csv");
			
	// read data from file using lines method and streams
	public List<Person> readDataFromFile() {
		
		try (Stream<String> lines = Files.lines( filePath )) {
		    lines.forEach(addData);
		} 
		catch (IOException e) 
		{
		    e.printStackTrace();
		}

		return personDetails;
	}
	
	//customized consumer action to add person objects from file
	Consumer<String>addData = new Consumer<String>() {
		@Override
		public void accept(String tempLine) {
			String[] details = tempLine.split(",");
			
			String[] hobbies = details[4].isEmpty() ? null : details[4].split(";");
			Person tempPerson = new Person(details[0], details[1], details[2], details[3], hobbies, details[5], new Date());
			
			personDetails.add(tempPerson);
			
		}
	};
	
	public void writeDataToFile(List<Person> personsData, String filePath) throws IOException {
		String content = personsData.toString();
		Files.write(Paths.get(filePath), content.getBytes());
	}
}
