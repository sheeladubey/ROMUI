package com.gsicommerce.romui.selenium.utilities;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import com.gsicommerce.romui.selenium.pages.OrderCreate;
import com.gsicommerce.romui.selenium.pages.ordermanagement.OrderCreatePage;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReusableMethods extends OrderCreatePage {
	static Properties prop = new Properties();
	
	public static XmlPath rawToXML(Response r)
	{
	
		// as response is in RAW format,convert to string
		String respon=r.asString();
		System.out.println(respon);
		// convert string response to XML format
		XmlPath x=new XmlPath(respon);
		return x;
		
	}
	
	public static JsonPath rawToJson(Response r)
	{ 
		// as response is in RAW format,convert to string
		String respon=r.asString();
		// convert string response to Json format
		JsonPath x=new JsonPath(respon);
		return x;
	}

	public static String getPayLoadXML(String path) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(path)));
	}
	
		
	public static String getPayLoadJSON(String path) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(path)));
	}


}
