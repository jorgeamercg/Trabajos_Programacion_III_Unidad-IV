package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controllers.HomeController;

import models.User;
import models.UserModel;

public class UserView {
	
	private UserModel functions;
	
	private JTable table;

	public UserView() {
		
		functions = new UserModel();
		
	}
	
	public void showUsers(ArrayList<User> data) {
		
		// VENTANA

		JFrame win = new JFrame();
		win.setTitle("Usuarios");
		win.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/saturno.png")));//Ícono de ventana personalizado
		win.setSize(700, 484);
		win.setResizable(false);
		win.setLocationRelativeTo(null);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);
		win.getContentPane().setLayout(new BorderLayout(0, 0));

		// PANEL PARA TÍTULO

		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(192, 192, 192));
		win.getContentPane().add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new FlowLayout());

		JLabel title = new JLabel("Usuarios");
		title.setFont(new Font("Tahoma", Font.BOLD, 20));
		title.setOpaque(false);
		titlePanel.add(title);

		// PANEL PARA TABLA

		JPanel tablePanel = new JPanel();
		tablePanel.setBackground(Color.WHITE);
		win.getContentPane().add(tablePanel, BorderLayout.CENTER);
		tablePanel.setLayout(new FlowLayout());

		String[] columnNames = {"id", "name", "email", "role", "phone"};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				if (columnIndex == 4)
					return JButton.class;
				return Object.class;
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 4;
			}
		};

		table = new JTable(model);//Tabla de usuarios
		table.setPreferredScrollableViewportSize(new Dimension(675, 350));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		tablePanel.add(scrollPane);
		
		for (User user : data) {
		    model.addRow(new Object[] {
		            user.id,
		            user.name,
		            user.email,
		            user.role,
		            user.phone
		        });
		}

		// PANEL PARA BOTONES

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(new Color(192, 192, 192));
		win.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
		buttonsPanel.setLayout(new FlowLayout());
		
		JButton volver = new JButton("Volver a Inicio");//Botón: Volver a Inicio
		volver.setPreferredSize(new Dimension(130, 20));
		volver.setBackground(Color.ORANGE);
		volver.setForeground(Color.BLACK); 
		volver.setFont(new Font("Tahoma", Font.BOLD, 10));
		buttonsPanel.add(volver);
		volver.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		volver.addActionListener(e -> {
			win.dispose();
			
			HomeController hc = new HomeController();
			hc.home();
		});
		
	}

}
