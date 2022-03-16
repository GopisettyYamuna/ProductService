package com.productservice.jsonread;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JSONReadFromTheFileTest {
	public static void main(String[] args) throws  IOException, ParseException {

		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader("C:/Users/gopis/sample2.json");
		Object obj = jsonparser.parse(reader);
		JSONObject productjsonobj = (JSONObject)obj;

		String name = (String)productjsonobj.get("Name");
		
		System.out.println("Name:"+name);

		JSONArray array = (JSONArray)productjsonobj.get("productService");{

			for(int i=0;i<array.size();i++)  
			{
				JSONObject productService =(JSONObject)array.get(i);
				String productname=(String) productService.get("productname");
				String productcompany=(String)productService.get("productcompany");
				Long productprice = (Long)productService.get("productprice");
				String productdescription=(String) productService.get("productdescription");

				System.out.println("productService of:is.........");
				System.out.println("productname:"+productname);
				System.out.println("productcompany:"+productcompany);
				System.out.println("productprice:"+productprice );
				System.out.println("productdescription:"+productdescription);
				//ProductServicetRepository.saveAll("productService");


		}	

	}
}
}