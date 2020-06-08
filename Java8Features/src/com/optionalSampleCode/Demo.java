package com.optionalSampleCode;

import java.util.Optional;

public class Demo {

	public static void main(String[] args) {
		
		//below will not accept null values 
		//it will give null pointer exception for null values
		Optional <String> stringVal = Optional.of("string");
		Optional <String> emptyString = Optional.empty();
		
		//accepts null value
		Optional <String> nullableString = Optional.ofNullable("nullable String");
		
		//prints the value only if value presents
		stringVal.ifPresent(System.out::println);
		emptyString.ifPresent(System.out::println);
		nullableString.ifPresent(System.out::println);

		//prints the value provided in orElse method if value is not present
		Optional <String> nullableString2 = Optional.ofNullable(null);
		System.out.println("stringVal: "+stringVal.orElse("alt string"));
		System.out.println("emptyString: "+emptyString.orElse("alt string"));
		System.out.println("nullableString2: "+nullableString2.orElse("alt string"));
		
		//throw error if value is not present
		System.out.println("stringVal:" +stringVal.orElseThrow());
		System.out.println("nullableString2: "+nullableString2.orElseThrow());
		System.out.println("emptyString: "+emptyString.orElseThrow());
		
	}

}
