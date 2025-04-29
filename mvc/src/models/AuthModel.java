package models;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class AuthModel {

	public AuthModel() {
	
		
		
	}
	
	public boolean autenticar(String usuario, String contraseña) {
		
		Charset charset = Charset.forName("UTF-8");//Escribir UTF-8 en lugar de US-ASCII para poder escribir en español con acentos y letra 'ñ'

	    Path url;
	    try {
	        url = Path.of(getClass().getResource("/files/users.txt").toURI());//toURI convierte a Path ya que BufferedReader necesita un Path
	    } catch (Exception e) {
	        System.err.println("No se pudo localizar el archivo: " + e.getMessage());
	        
	        return false;
	    }
	    
	    Path file = url;

	    try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
	        String line = null;

	        while ((line = reader.readLine()) != null) {
	            String[] datos = line.split(",");

                String email = datos[1];
                String clave = datos[2];

                if (usuario.equals(email) && contraseña.equals(clave)) {
                    return true;//Acceso permitido
                }
	        }
	        
	        reader.close();     
	    } catch (Exception x) {
	        System.err.format("IOException: %s%n", x);
	    }
	    
		return false;//Acceso denegado
 	}
	
	public void registro(String usuario, String contraseña, String biografía) {
		
		System.out.println("|Usuario|\n" + usuario + "\n");
		System.out.println("|Contraseña|\n" + contraseña + "\n");
		System.out.println("|Biografía|\n" + biografía + "\n");
		
	}
	
}
