package com.util.json;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Demo1 {
//	public static void main(String[] args) throws IOException, ParseException {
//		testing();
//	}
	
	
	@Test
	public static void testing() throws IOException, ParseException {

		size();

	}

	@AfterTest
	public static void size() throws IOException, ParseException {
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader("C:/Users/DHARAJEN/Downloads/sample1.json");
		Object obj = jsonparser.parse(reader);
		JSONObject jfruit = (JSONObject) obj;
		String fruitname = (String) jfruit.get("fruit");
		String fruitsize = (String) jfruit.get("size");
		String fruitcolor = (String) jfruit.get("color");
		System.out.println(fruitsize);
		System.out.println(fruitcolor);
		System.out.println(fruitname);
	}

}
