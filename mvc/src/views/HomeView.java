package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeView {
	
	private JFrame frame;
	
	public HomeView() {
		
	}
	
	public void home() {
		
		//VENTANA
		
		frame = new JFrame();
		frame.setTitle("Inicio");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/saturno.png")));//Ícono de ventana personalizado
		frame.setSize(500, 537);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		//PANEL PARA WIDGETS
		
		JPanel widgets = new JPanel();
		widgets.setBackground(Color.WHITE);
		frame.getContentPane().add(widgets, BorderLayout.CENTER);
		widgets.setLayout(new GridLayout(2, 2, 10, 10));
		
		//WIDGET 1: CONTADOR DE USUARIOS REGISTRADOS
		
		//Panel
		
		JPanel wid1 = new JPanel();
		wid1.setBackground(Color.RED);
		widgets.add(wid1);
		wid1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		wid1.setLayout(new GridLayout(1, 1, 0, 0));
		
		//Etiqueta
		
		JLabel lbl1 = new JLabel("|Usuarios Registrados: 107|");
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 15));
		wid1.add(lbl1);
		
		//WIDGET 2: NOTIFICACIONES
		
		JPanel wid2 = new JPanel();
		wid2.setBackground(Color.GREEN);
		widgets.add(wid2);
		wid2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		wid2.setLayout(new GridLayout(1, 1, 0, 0));
		
		//Etiqueta
		
		JLabel lbl2 = new JLabel("|Notificaciones: 3|");
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 15));
		wid2.add(lbl2);
				
		//WIDGET 3: HORA ACTUAL DEL SISTEMA
		
		JPanel wid3 = new JPanel();
		wid3.setBackground(Color.BLUE);
		widgets.add(wid3);
		wid3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		wid3.setLayout(new GridLayout(1, 1, 0, 0));
		
		//Etiqueta
		
		JLabel lbl3 = new JLabel("|Hora Actual: 14:30:15|");
		lbl3.setFont(new Font("Tahoma", Font.BOLD, 15));
		wid3.add(lbl3);
		
		//WIDGET 4: ESTADÍSTICAS
		
		JPanel wid4 = new JPanel();
		wid4.setBackground(Color.YELLOW);
		widgets.add(wid4);
		wid4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		wid4.setLayout(new GridLayout(1, 1, 0, 0));
		
		//Etiqueta
		
		JLabel lbl4 = new JLabel("|Visitas: 30|");
		lbl4.setFont(new Font("Tahoma", Font.BOLD, 15));
		wid4.add(lbl4);
		
		//PANEL PARA BOTONES
		
		JPanel buttons = new JPanel();
		buttons.setBackground(new Color(192, 192, 192));
		frame.getContentPane().add(buttons, BorderLayout.SOUTH);
		buttons.setLayout(new FlowLayout());
		
		//Botones
		
		JButton btn_1 = new JButton("Usuarios");//Botón: Usuarios
		btn_1.setPreferredSize(new Dimension(80, 25));
		btn_1.setBackground(Color.ORANGE);
		btn_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		buttons.add(btn_1);
		btn_1.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
		btn_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				
				users();
				
			}
			
		});
		
		JButton btn_2 = new JButton("Registros");//Botón: Registros
		btn_2.setPreferredSize(new Dimension(80, 25));
		btn_2.setBackground(Color.ORANGE);
		btn_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		buttons.add(btn_2);
		btn_2.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
		btn_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				
				registers();
				
			}
			
		});
		
		JButton btn_3 = new JButton("Configuración");//Botón: Configuración
		btn_3.setPreferredSize(new Dimension(80, 25));
		btn_3.setBackground(Color.ORANGE);
		btn_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		buttons.add(btn_3);
		btn_3.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
		btn_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				
				settings();
				
			}
			
		});
		
	}
	
	public void users() {
		
		//VENTANA
		
		frame = new JFrame();
		frame.setTitle("Usuarios");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/saturno.png")));//Ícono de ventana personalizado
		frame.setSize(500, 537);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(new FlowLayout());
		
		//BOTÓN
		
		JButton btn_4 = new JButton("Volver a Inicio");//Botón: Volver a Inicio
		btn_4.setPreferredSize(new Dimension(100, 25));
		btn_4.setBackground(Color.ORANGE);
		btn_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		frame.add(btn_4);
		btn_4.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
		btn_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				
				home();
				
			}
			
		});
		
	}
	
	public void registers() {
		
		//VENTANA
		
		frame = new JFrame();
		frame.setTitle("Registros");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/saturno.png")));//Ícono de ventana personalizado
		frame.setSize(500, 537);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(new FlowLayout());
		
		//BOTÓN
		
		JButton btn_5 = new JButton("Volver a Inicio");//Botón: Volver a Inicio
		btn_5.setPreferredSize(new Dimension(100, 25));
		btn_5.setBackground(Color.ORANGE);
		btn_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		frame.add(btn_5);
		btn_5.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
		btn_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				
				home();
				
			}
			
		});
		
	}
	
	public void settings() {
		
		//VENTANA
		
		frame = new JFrame();
		frame.setTitle("Configuración");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/saturno.png")));//Ícono de ventana personalizado
		frame.setSize(500, 537);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(new FlowLayout());
		
		//BOTÓN
		
		JButton btn_6 = new JButton("Volver a Inicio");//Botón: Volver a Inicio
		btn_6.setPreferredSize(new Dimension(100, 25));
		btn_6.setBackground(Color.ORANGE);
		btn_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		frame.add(btn_6);
		btn_6.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
		btn_6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				
				home();
				
			}
			
		});
		
	}

}
