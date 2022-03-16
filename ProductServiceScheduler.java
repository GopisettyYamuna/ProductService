package com.productservice.scheduler;


import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.productservice.jpa.r.ProductServicetRepository;
@Configuration
@EnableScheduling
public class ProductServiceScheduler {
	public static void main(String[] args) throws  IOException, ParseException {}
	

	@Autowired
	public ProductServicetRepository productServicetRepository;
	
	@Scheduled(cron = "*/2 * * * * *")
	public void ShowDate() {
		System.out.println("Hello World in show Date : " + new Date());
	}
	
	@Scheduled(cron = "*/5 * * * * *")
	public void createProductFromFilePath() throws Exception {
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
				
				//productServicetRepository.save(array);
			}
		
				
		}
		
	}
}

