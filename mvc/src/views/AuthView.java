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
			            
			            //System.out.println("Acceso permitido: Bienvenido");
			            
			            JOptionPane.showMessageDialog(frame,
			                "Acceso permitido: Bienvenido",
			                "Acceso",
			                JOptionPane.PLAIN_MESSAGE);
			            
			        }
			        else {
			            
			            if (email.getText().equals("admin")) {
			                
			                //System.out.println("Contraseña incorrecta: Intente una vez más");
			                
			                JOptionPane.showMessageDialog(frame,
			                    "Contraseña incorrecta: Intente una vez más",
			                    "Contraseña",
			                    JOptionPane.ERROR_MESSAGE);
			                
			            }
			            else {
			                
			                //System.out.println("Email incorrecto: Escriba uno válido");
			                
			                JOptionPane.showMessageDialog(frame,
			                    "Email incorrecto: Escriba uno válido",
			                    "Email",
			                    JOptionPane.ERROR_MESSAGE);
			                
			            }
			            
			        }   
			    }
			    else {
			        
			        if (validación_email) {
			            
			            if (email.getText().equals("admin")) {
			                
			                //System.out.println("Información faltante: Ingrese una contraseña");
			                
			                JOptionPane.showMessageDialog(frame,
			                    "Información faltante: Ingrese una contraseña",
			                    "Información",
			                    JOptionPane.ERROR_MESSAGE);
			                
			            }
			            else {
			                
			                //System.out.println("Email incorrecto: Escriba uno válido");
			                
			                JOptionPane.showMessageDialog(frame,
			                    "Email incorrecto: Escriba uno válido",
			                    "Email",
			                    JOptionPane.ERROR_MESSAGE);
			                
			            }
			            
			        }
			        else {
			            
			            //System.out.println("Información faltante: Ingrese un email");
			            
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

}
