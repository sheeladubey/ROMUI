package com.gsicommerce.romui.selenium.pages.ordermanagement;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.gsicommerce.romui.selenium.testdata.Environment;
import com.gsicommerce.romui.selenium.testdata.OrderCreateData;
import com.gsicommerce.romui.selenium.utilities.Common;
import com.gsicommerce.romui.selenium.utilities.Resource;
import com.gsicommerce.romui.selenium.utilities.ReusableMethods;

import io.restassured.RestAssured;
//import io.restassured.response.Response;
import io.restassured.path.xml.XmlPath;

import io.restassured.response.Response;

public class OrderCreatePage {
//	Properties prop=new Properties();
	private static OrderCreateData orderCreateData;
	//static String testdata = System.getProperty("user.dir")+ "\\src\\main\\java\\com\\gsicommerce\\romui\\selenium\\pages\\orderCreateData.json";
	WebDriver driver;
	Environment env;
	String host;
	String apikey;
	String contentType;
	
	
	public OrderCreatePage(WebDriver driver, Environment env) {

		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
		
	}
	@BeforeTest
	public void getBBWPropertiesData() throws IOException
	{
//		FileInputStream fis=new FileInputStream(System.getProperty("user.dir") +"\\resources\\BBW.properties");
//	  prop.load(fis);
//	  
		host=env.getHost();
		apikey=env.getApikey();
		contentType=env.getContentType();
				
	}
	@Test
	public void BBWOrderCreateSTH() throws IOException {
		
		try {
			orderCreateData=OrderCreateData.get(env.getFileLocation());
		    //Source from https://mkyong.com/java/how-to-modify-xml-file-in-java-dom-parser/
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			String xmlFilePath = (System.getProperty("user.dir") + "\\resources\\BBWOrderCreateISPU.xml");
			Document document = documentBuilder.parse(xmlFilePath);
			Node webOrder = document.getElementsByTagName("WebOrderId").item(0);
			String orderid = orderCreateData.setWebOrderId(orderCreateData.getWebOrderId());
			System.out.println("orderid=" + orderid);
			webOrder.setTextContent(orderid);
			Node sourceId = document.getElementsByTagName("SourceId").item(0);
			System.out.println("SourceId is="+sourceId);
			sourceId.setTextContent(orderCreateData.setSourceId(orderCreateData.getSourceId()));
			
			Node itemId = document.getElementsByTagName("ItemId").item(0);
			String itemid = orderCreateData.setItemId(orderCreateData.getItemId());
			System.out.println("itemid=" + itemid);
			itemId.setTextContent(orderCreateData.setItemId(orderCreateData.getItemId()));
			Node quantity = document.getElementsByTagName("Quantity").item(0);
			String qty= orderCreateData.setQuantity(orderCreateData.getQuantity());
			System.out.println("itemid=" + qty);
			quantity.setTextContent(orderCreateData.setQuantity(orderCreateData.getQuantity()));
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(xmlFilePath));
			transformer.transform(domSource, streamResult);
			System.out.println("Successfully updated XML ");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}
		/*String PayloadOrderCreate=ReusableMethods.getPayLoadXML(System.getProperty("user.dir")+"\\resources\\BBWOrderCreateSTH.xml");
		RestAssured.baseURI=prop.getProperty("HOST");
		System.out.println("-------------------STH order created---------------------------------------------------------");
		Response ordercreateresponse=given().log().all().
		queryParam("apikey", prop.getProperty("apikey")).
		header("content-type",prop.getProperty("content-type")).
		body(PayloadOrderCreate).
		when().
		post(resource.BBWOrderCreate()).
		then().assertThat().statusCode(200).and().log().all().
		extract().response();
		XmlPath xl=ReusableMethods.rawToXML(ordercreateresponse);	
		System.out.println("xmlpath is="+xl);*/
			
	
//	@Test
//	public void BBWOrderCreateISPU() throws IOException {
		String PayloadOrderCreate=ReusableMethods.getPayLoadXML(System.getProperty("user.dir")+"\\resources\\BBWOrderCreateISPU.xml");
		//RestAssured.baseURI=prop.getProperty("HOST");
		RestAssured.baseURI=host;
		System.out.println("-------------------ISPU order created---------------------");
		Response ordercreateresponse=given().log().all().
		queryParam("apikey",apikey).
		header("content-type",contentType).
		body(PayloadOrderCreate).
		when().
		post(Resource.BBWOrderCreate()).
		then().assertThat().statusCode(200).and().log().all().
		extract().response();
		XmlPath xl=ReusableMethods.rawToXML(ordercreateresponse);		
		
	}

	
}


