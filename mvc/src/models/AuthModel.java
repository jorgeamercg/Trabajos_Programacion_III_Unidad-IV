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
	
	public void registro(String usuario, String contraseña, String biografía) {
		
		System.out.println("|Usuario|\n" + usuario + "\n");
		System.out.println("|Contraseña|\n" + contraseña + "\n");
		System.out.println("|Biografía|\n" + biografía + "\n");
		
	}
	
}
