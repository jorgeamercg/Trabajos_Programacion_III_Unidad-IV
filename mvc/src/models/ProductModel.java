package models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ProductModel {
	
	public ProductModel() {
		
		
		
	}
	
	public JSONArray get()
 	{
 		
 		JSONParser jsonParser = new JSONParser();
 		String url = "src/files/products.json";
         
         try (FileReader reader = new FileReader(url)) {
             //Read JSON file
             Object obj = jsonParser.parse(reader);
             
             JSONArray productList = (JSONArray) obj;
             
             System.out.println(productList);
               
             return productList;
             
             //Iterate over array
             //productList.forEach( emp -> parseTestData( (JSONObject) emp ) );
   
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         } catch (ParseException e) {
             e.printStackTrace();
         }
         
         return null;
 		
 	}
	
	public Object[] parseTestData(JSONObject product) {
 		
 		//Obtener valores directamente del objeto producto
 	    Long id = (Long) product.get("id");  
 	    String name = (String) product.get("nombre");   
 	    Double price = (Double) product.get("precio"); 
 	    Long stock = (Long) product.get("stock"); 
	    
	    return new Object[] {id, name, price, stock};
	    
	}
 	
}
