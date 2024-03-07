package com.util.json;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Demo2 {

	public static void main(String[] args) throws IOException, ParseException {
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader("C:/Users/DHARAJEN/Downloads/sample2.json");
		Object obj = jsonparser.parse(reader);
		JSONObject employee = (JSONObject) obj;
		String fName=(String)employee.get("firstName");
		String lName=(String)employee.get("lastName");
		String gEnder=(String)employee.get("gender");
		//int aGe=employee.get("age");
		
		
		System.out.println("First Name:"+fName);
		System.out.println("Last Name:"+lName);
		System.out.println("Gender:"+gEnder);
	//	System.out.println("Age:"+aGe);
		
		JSONArray array=(JSONArray) employee.get("phoneNumbers");
		for(int i=0;i<array.size();i++) {
			JSONObject phoneNumbers = (JSONObject) array.get(i);
			String typE=(String)phoneNumbers.get("type");
			String numBer=(String)phoneNumbers.get("number");
			
			
			System.out.println("type:"+typE);
			System.out.println("number:"+numBer);
			
		}
		
		
		

	}

	
}

//{
//	   "firstName": "Joe",
//	   "lastName": "Jackson",
//	   "gender": "male",
//	   "age": 28,
//	   "address": {
//	       "streetAddress": "101",
//	       "city": "San Diego",
//	       "state": "CA"
//	   },
//	   "phoneNumbers": [
//	       { "type": "home", "number": "7349282382" }
//	   ]
//	}
