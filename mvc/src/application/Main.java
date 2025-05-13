package application;

import controllers.AuthController;
import controllers.ProductController;

public class Main {

	public static void main(String[] args) {
		
		/*AuthController application = new AuthController();
		
 		application.login();*/
		
		ProductController application = new ProductController();
		
		application.products();
		
	}

}
