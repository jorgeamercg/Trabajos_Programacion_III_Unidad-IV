package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import models.AuthModel;

public class AuthView {
	
	private JFrame frame;
	
	private AuthModel functions;

	public AuthView() {
		
		functions = new AuthModel();
		
	}
	
	public void login() {
		
		//VENTANA
		
		frame = new JFrame();
		frame.setTitle("mvc");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/saturno.png")));//Ícono de ventana personalizado
		frame.setSize(500, 537);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//PANEL
		
		JPanel login = new JPanel();
		login.setLocation(0, 0);
		login.setSize(500, 500);
		login.setOpaque(true);
		login.setBackground(new Color(0, 128, 128));
		login.setVisible(true);
		login.setLayout(null);
		
		//ETIQUETAS
		
		Font etiquetas = new Font("Romana", Font.ROMAN_BASELINE, 22);
		Font etiquetas2 = new Font("Romana 2", Font.ROMAN_BASELINE, 10);
		
		JLabel etiqueta1 = new JLabel("Iniciar Sesión");
		etiqueta1.setSize(160, 40);
		etiqueta1.setLocation(160, 35);
		etiqueta1.setFont(etiquetas);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		etiqueta1.setBackground(Color.YELLOW);
		etiqueta1.setOpaque(true);
		etiqueta1.setBorder(BorderFactory.createLineBorder(Color.black));
		login.add(etiqueta1);
		
		JLabel etiqueta2 = new JLabel("Email");
		etiqueta2.setBounds(190, 170, 100, 30);
		etiqueta2.setFont(etiquetas);
		etiqueta2.setHorizontalAlignment(JLabel.CENTER);
		etiqueta2.setBackground(Color.WHITE);
		etiqueta2.setOpaque(true);
		login.add(etiqueta2);
		
		JLabel etiqueta3 = new JLabel("Contraseña");
		etiqueta3.setBounds(160, 270, 160, 30);
		etiqueta3.setFont(etiquetas);
		etiqueta3.setHorizontalAlignment(JLabel.CENTER);
		etiqueta3.setBackground(Color.WHITE);
		etiqueta3.setOpaque(true);
		login.add(etiqueta3);
		
		JLabel usuario = new JLabel(new ImageIcon(getClass().getResource("/images/usuario.png")));//Tipo imagen
		usuario.setBounds(192, 75, 96, 96);
		login.add(usuario);
		
		JLabel correo = new JLabel(new ImageIcon(getClass().getResource("/images/correo.png")));//Tipo imagen
		correo.setBounds(375, 224, 24, 24);
		login.add(correo);
		
		JLabel pass = new JLabel(new ImageIcon(getClass().getResource("/images/contraseña.png")));//Tipo imagen
		pass.setBounds(375, 324, 24, 24);
		login.add(pass);
		
		//CAJA DE TEXTO
		
		JTextField email = new JTextField();
		email.setBounds(110, 220, 260, 30);
		email.setFont(etiquetas2);
		email.setBackground(Color.cyan);
		email.setOpaque(true);
		login.add(email);
		
		//CAJA DE CONTRASEÑA
		
		JPasswordField contraseña = new JPasswordField();
		contraseña.setBounds(110, 320, 260, 30);
		contraseña.setFont(etiquetas);
		contraseña.setBackground(Color.cyan);
		contraseña.setOpaque(true);
		login.add(contraseña);
		
		//BOTONES
		
		JButton acceder = new JButton("Acceder");
		acceder.setBounds(165, 390, 150, 40);
		acceder.setFont(etiquetas);
		acceder.setHorizontalAlignment(JLabel.CENTER);
		acceder.setBackground(Color.ORANGE);
		acceder.setOpaque(true);
		login.add(acceder);
		acceder.addMouseListener(new java.awt.event.MouseAdapter() {//Cambio de color al pasar el mouse (hover)
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        acceder.setBackground(Color.GREEN);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        acceder.setBackground(Color.ORANGE);
		    }
		});
		//ActionListener
		acceder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Boolean validación_email = false, validación_contraseña = false;
				    
			    //System.out.println("Correcto");
			    
			    if (email.getText().equals("")) {//validación de llenado de casilla de email
			        
			        email.setBorder(BorderFactory.createLineBorder(Color.red, 5));
			        
			    }
			    else {
			        
			        email.setBorder(BorderFactory.createLineBorder(Color.green, 5));
			        
			        validación_email = true;
			        
			    }
			    
			    String passText = new String(contraseña.getPassword());//validación de llenado de casilla de contraseña
			    
			    if (passText.equals("")) {
			        
			        contraseña.setBorder(BorderFactory.createLineBorder(Color.red, 5));
			        
			    }
			    else {
			        
			        contraseña.setBorder(BorderFactory.createLineBorder(Color.green, 5));
			        
			        validación_contraseña = true;
			        
			    }
			    
			    if (validación_email && validación_contraseña) {//Mensajes de alerta
			    	
			    	if (functions.autenticar(email.getText(), passText)) {//Ejecución del método autenticar de AuthModel
			    	    /*JOptionPane.showMessageDialog(frame,
			    	        "Acceso permitido: Bienvenido",
			    	        "Acceso",
			    	        JOptionPane.PLAIN_MESSAGE);*/
			    		
			    		frame.dispose();
						
						home();
			    		
			    	} else {
			    	    JOptionPane.showMessageDialog(frame,
			    	        "Acceso denegado: Email o contraseña incorrectos",
			    	        "Acceso",
			    	        JOptionPane.ERROR_MESSAGE);
			    	}
					
				} else {
					if (validación_email) {
		                JOptionPane.showMessageDialog(frame,
		                    "Información faltante: Ingrese una contraseña",
		                    "Información",
		                    JOptionPane.ERROR_MESSAGE);    
			    	} else {
			            JOptionPane.showMessageDialog(frame,
			                "Información faltante: Ingrese un email",
			                "Información",
			                JOptionPane.ERROR_MESSAGE);
			    	}
				}
				
			}
			
		});
		
		JButton c_olvidada = new JButton("¿Olvidó su contraseña?");
		c_olvidada.setBounds(227, 360, 143, 20);
		c_olvidada.setFont(etiquetas2);
		c_olvidada.setHorizontalAlignment(JLabel.CENTER);
		c_olvidada.setBackground(new Color(0, 128, 128));
		c_olvidada.setOpaque(true);
		login.add(c_olvidada);
		
		JButton registrarse = new JButton("Registrarse");
		registrarse.setBounds(190, 450, 100, 20);
		registrarse.setFont(etiquetas2);
		registrarse.setHorizontalAlignment(JLabel.CENTER);
		registrarse.setBackground(new Color(0, 128, 128));
		registrarse.setOpaque(true);
		login.add(registrarse);
		registrarse.addActionListener(new ActionListener() {//ActionListener
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				
				register();
				
			}
			
		});
		
		//CASILLA DE VERIFICACIÓN
		
		JCheckBox recordar;
		recordar = new JCheckBox("Recordarme");
		recordar.setBounds(75, 360, 143, 20);
		recordar.setFont(etiquetas2);
		recordar.setHorizontalAlignment(JLabel.CENTER);
		recordar.setBackground(new Color(0, 128, 128));
		recordar.setOpaque(true);
		login.add(recordar);
		
		frame.add(login);
		frame.repaint();
		
 		login.repaint();
		
	}
	
	public void register() {
		
		//VENTANA
		
		frame = new JFrame();
		frame.setTitle("mvc");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/saturno.png")));//Ícono de ventana personalizado
		frame.setSize(500, 537);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//PANEL
		
		JPanel registro = new JPanel();
		registro.setLocation(0, 0);
		registro.setSize(500, 500);
		registro.setOpaque(true);
		registro.setBackground(Color.WHITE);
		registro.setVisible(true);
		registro.setLayout(null);
		
		//ETIQUETAS
		
		Font etiquetas = new Font("Romana", Font.ROMAN_BASELINE, 22);
		Font etiquetas2 = new Font("Romana 2", Font.ROMAN_BASELINE, 10);
		Font etiquetas3 = new Font("Romana 3", Font.ROMAN_BASELINE, 17);
		
		JLabel etiqueta1 = new JLabel("Registrarse");
		etiqueta1.setSize(160, 30);
		etiqueta1.setLocation(160, 20);
		etiqueta1.setFont(etiquetas);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		etiqueta1.setBackground(Color.GREEN);
		etiqueta1.setOpaque(true);
		etiqueta1.setBorder(BorderFactory.createLineBorder(Color.black));
		registro.add(etiqueta1);
		
		JLabel etiqueta2 = new JLabel("Email");
		etiqueta2.setBounds(190, 65, 100, 30);
		etiqueta2.setFont(etiquetas);
		etiqueta2.setHorizontalAlignment(JLabel.CENTER);
		etiqueta2.setBackground(Color.YELLOW);
		etiqueta2.setOpaque(true);
		etiqueta2.setBorder(BorderFactory.createLineBorder(Color.black));
		registro.add(etiqueta2);
		
		JLabel etiqueta3 = new JLabel("Biografía");
		etiqueta3.setBounds(160, 200, 160, 30);
		etiqueta3.setFont(etiquetas);
		etiqueta3.setHorizontalAlignment(JLabel.CENTER);
		etiqueta3.setBackground(Color.WHITE);
		etiqueta3.setOpaque(true);
		registro.add(etiqueta3);
		
		JLabel etiqueta4 = new JLabel("Preferencias");
		etiqueta4.setBounds(160, 320, 160, 30);
		etiqueta4.setFont(etiquetas);
		etiqueta4.setHorizontalAlignment(JLabel.CENTER);
		etiqueta4.setBackground(Color.WHITE);
		etiqueta4.setOpaque(true);
		registro.add(etiqueta4);
		
		JLabel etiqueta5 = new JLabel("Términos");
		etiqueta5.setBounds(160, 360, 160, 30);
		etiqueta5.setFont(etiquetas);
		etiqueta5.setHorizontalAlignment(JLabel.CENTER);
		etiqueta5.setBackground(Color.YELLOW);
		etiqueta5.setOpaque(true);
		etiqueta5.setBorder(BorderFactory.createLineBorder(Color.black));
		registro.add(etiqueta5);
		
		JLabel etiqueta6 = new JLabel("Contraseña");
		etiqueta6.setBounds(175, 135, 130, 30);
		etiqueta6.setFont(etiquetas);
		etiqueta6.setHorizontalAlignment(JLabel.CENTER);
		etiqueta6.setBackground(Color.YELLOW);
		etiqueta6.setOpaque(true);
		etiqueta6.setBorder(BorderFactory.createLineBorder(Color.black));
		registro.add(etiqueta6);
		
		//CAJAS DE TEXTO
		
		JTextField email = new JTextField();
		email.setBounds(110, 100, 260, 30);
		email.setFont(etiquetas2);
		email.setBackground(Color.cyan);
		email.setOpaque(true);
		registro.add(email);
		
		JTextField contraseña = new JTextField();
		contraseña.setBounds(110, 170, 260, 30);
		contraseña.setFont(etiquetas2);
		contraseña.setBackground(Color.cyan);
		contraseña.setOpaque(true);
		registro.add(contraseña);
		
		//ÁREA DE TEXTO
		
		JTextArea biografía = new JTextArea();
		biografía.setBounds(110, 230, 260, 80);
		biografía.setFont(etiquetas2);
		biografía.setBackground(Color.cyan);
		biografía.setOpaque(true);
		registro.add(biografía);
		
		//BOTONES
		
		JButton access = new JButton("Crear cuenta");
		access.setBounds(140, 400, 200, 30);
		access.setFont(etiquetas);
		access.setHorizontalAlignment(JLabel.CENTER);
		access.setBackground(Color.ORANGE);
		access.setOpaque(true);
		registro.add(access);
		//ActionListener
		access.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (email.getText().equals("")) {//validación de llenado de casilla de email
					email.setBorder(BorderFactory.createLineBorder(Color.red, 5));
				} else {
					email.setBorder(BorderFactory.createLineBorder(Color.green, 5));
				}
				if (contraseña.getText().equals("")) {//validación de llenado de casilla de email
					contraseña.setBorder(BorderFactory.createLineBorder(Color.red, 5));
				} else {
					contraseña.setBorder(BorderFactory.createLineBorder(Color.green, 5));
				}
				if (biografía.getText().equals("")) {//validación de llenado de área de texto: biografía
					biografía.setBorder(BorderFactory.createLineBorder(Color.red, 5));
				} else {
					biografía.setBorder(BorderFactory.createLineBorder(Color.green, 5));
				}
			
				functions.registro(email.getText(), contraseña.getText(), biografía.getText());//Ejecución del método registro de AuthModel
				
			}
			
		});
		
		JButton Iniciar_Sesión = new JButton("Iniciar Sesión");
		Iniciar_Sesión.setBounds(190, 435, 100, 20);
		Iniciar_Sesión.setFont(etiquetas2);
		Iniciar_Sesión.setHorizontalAlignment(JLabel.CENTER);
		Iniciar_Sesión.setBackground(Color.WHITE);
		Iniciar_Sesión.setOpaque(true);
		registro.add(Iniciar_Sesión);
		
		JButton volver = new JButton("Volver");
		volver.setBounds(190, 460, 100, 30);
		volver.setFont(etiquetas3);
		volver.setHorizontalAlignment(JLabel.CENTER);
		volver.setBackground(Color.ORANGE);
		registro.add(volver);
		
		frame.add(registro);
		frame.repaint();
		
 		registro.repaint();
		
	}
	
	public void home() {
		
		//VENTANA
		
		frame = new JFrame();
		frame.setTitle("mvc");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/saturno.png")));//Ícono de ventana personalizado
		frame.setSize(500, 537);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//PANEL
		
		JPanel ventanaPrincipal = new JPanel();
		ventanaPrincipal.setLocation(0, 0);
		ventanaPrincipal.setSize(500, 500);
		ventanaPrincipal.setOpaque(true);
		ventanaPrincipal.setBackground(Color.WHITE);
		ventanaPrincipal.setVisible(true);
		ventanaPrincipal.setLayout(null);
		
		//ETIQUETAS
		
		Font etiquetas = new Font("Romana", Font.ROMAN_BASELINE, 22);
		Font etiquetas2 = new Font("Romana 2", Font.ROMAN_BASELINE, 10);
		
		JLabel etiqueta1 = new JLabel("Bienvenido");
		etiqueta1.setSize(150, 30);
		etiqueta1.setLocation(170, 20);
		etiqueta1.setFont(etiquetas);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		etiqueta1.setBackground(Color.lightGray);
		etiqueta1.setOpaque(true);
		etiqueta1.setBorder(BorderFactory.createLineBorder(Color.black));
		ventanaPrincipal.add(etiqueta1);
		
		//ÁREA DE TEXTO
		
		JTextArea biografia = new JTextArea("Esta es la ventana de inicio");
		biografia.setBounds(115, 80, 260, 300);
		biografia.setFont(etiquetas2);
		biografia.setBackground(Color.cyan);
		biografia.setOpaque(true);
		ventanaPrincipal.add(biografia);
		
		frame.add(ventanaPrincipal);
		frame.repaint();
		
 		ventanaPrincipal.repaint();
 		
	}
	
}
