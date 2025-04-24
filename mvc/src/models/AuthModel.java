package models;

public class AuthModel {

	public AuthModel() {
	
		
		
	}
	
	public boolean autenticar(String usuario, String contraseña) {
 		
 		if(usuario.equals("admin")) {
 			if(contraseña.equals("1234")) {
 				return true; 
 			}else {
 				return false;
 			}
 		}else {
 			return false; 
 		}
 		 
 	}
	
}
