package controllers;

import org.json.simple.JSONArray;
import models.ProductModel;
import views.ProductView;

public class ProductController {
	
	public ProductView view;

	public ProductController() {
		
		view = new ProductView();
		
	}
	
	public void products() {
 		
 		ProductModel pm = new ProductModel();
 		
 		JSONArray data = pm.get();
 		
 		view.products(data);
 		
 	}

}
