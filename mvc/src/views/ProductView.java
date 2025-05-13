package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import models.ProductModel;

public class ProductView {

	private JFrame win;
	private ProductModel functions;
	private JTable table;

	public ProductView() {
		functions = new ProductModel();
	}
	
	public void products(JSONArray data) {

		//VENTANA

		win = new JFrame();
		win.setTitle("Productos");
		win.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/saturno.png")));//Ícono de ventana personalizado
		win.setSize(1200, 484);
		win.setResizable(false);
		win.setLocationRelativeTo(null);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);
		win.getContentPane().setLayout(new BorderLayout(0, 0));

		//PANEL PARA TÍTULO

		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(192, 192, 192));
		win.getContentPane().add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new FlowLayout());

		JLabel title = new JLabel("Productos");
		title.setFont(new Font("Tahoma", Font.BOLD, 20));
		title.setOpaque(false);
		titlePanel.add(title);

		//PANEL PARA TABLA

		JPanel tablePanel = new JPanel();
		tablePanel.setBackground(Color.WHITE);
		win.getContentPane().add(tablePanel, BorderLayout.CENTER);
		tablePanel.setLayout(new FlowLayout());

		String[] columnNames = { "ID", "Nombre", "Precio", "Stock", "Acción" };
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

		table = new JTable(model);//Tabla de productos
		table.setPreferredScrollableViewportSize(new Dimension(1160, 350));
		table.setFillsViewportHeight(true);
		table.getColumn("Acción").setCellRenderer(new ButtonRenderer());
		table.getColumn("Acción").setCellEditor(new ButtonRenderer());
		JScrollPane scrollPane = new JScrollPane(table);
		tablePanel.add(scrollPane);
		
		for (Object obj : data) {
		    functions.addTableRow((JSONObject) obj, model, table, functions);
		}

		//PANEL PARA BOTONES

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(new Color(192, 192, 192));
		win.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
		buttonsPanel.setLayout(new FlowLayout());

		JButton refresh = new JButton("Actualizar Tabla");//Botón: Actualizar
		refresh.setPreferredSize(new Dimension(130, 20));
		refresh.setBackground(Color.BLUE);
		refresh.setForeground(Color.WHITE); 
		refresh.setFont(new Font("Tahoma", Font.BOLD, 10));
		buttonsPanel.add(refresh);
		refresh.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		refresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				model.setRowCount(0);
				JSONArray newData = functions.get();
				for (Object obj : newData) {
		            functions.addTableRow((JSONObject) obj, model, table, functions);
		        }
				scrollPane.repaint();
			}
		});
	}
	
	//Renderizador y editor para que los botones se vean y funcionen en la tabla
	class ButtonRenderer extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

		private JButton button;

		public ButtonRenderer() {
			button = new JButton();
			button.setFocusPainted(false);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
				boolean hasFocus, int row, int column) {
			if (value instanceof JButton) {
				return (JButton) value;
			}
			return button;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
				int row, int column) {
			if (value instanceof JButton) {
				return (JButton) value;
			}
			return button;
		}

		@Override
		public Object getCellEditorValue() {
			return button;
		}
	}

}
