package models;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ProductModel {
	
	public ProductModel() {
		
		
		
	}
	
	public JSONArray get()
 	{
 		
 		JSONParser jsonParser = new JSONParser();
 		String url = "src/files/products.json";
         
         try (FileReader reader = new FileReader(url)) {
             
             Object obj = jsonParser.parse(reader);
             
             JSONArray productList = (JSONArray) obj;
             
             System.out.println(productList);
               
             return productList;
   
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         } catch (ParseException e) {
             e.printStackTrace();
         }
         
         return null;
 		
 	}
	
	public Object[] parseTestData(JSONObject product) {
 		
	    long id = Long.parseLong(product.get("id").toString());
	    String name = product.get("nombre").toString();
	    double price = Double.parseDouble(product.get("precio").toString());
	    long stock = Long.parseLong(product.get("stock").toString());

	    return new Object[] { id, name, price, stock };
	    
	}
	
	public void productRemove(long id) {
		
	    JSONArray productList = get();
	    if (productList == null) return;

	    String url = "src/files/products.json";

	    for (int i = 0; i < productList.size(); i++) {
	        JSONObject product = (JSONObject) productList.get(i);
	        Long productId = (Long) product.get("id");
	        if (productId == id) {
	            productList.remove(i);
	            break;
	        }
	    }

	    try (FileWriter file = new FileWriter(url)) {
	    	
	        String formatted = productList.toJSONString().replace("},", "},\n");
	        file.write(formatted);
	        file.flush();
	        System.out.println("|Producto con ID: " + id + ": eliminado correctamente|");
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	}
	
	public void addTableRow(JSONObject product, DefaultTableModel model, JTable table, ProductModel functions) {

	    Object[] row = functions.parseTestData(product);
	    Long id = (Long) product.get("id");

	    JButton remove = new JButton("Eliminar");
	    remove.setName(id + "");
	    remove.setPreferredSize(new Dimension(90, 20));
	    remove.setBackground(Color.RED);
	    remove.setForeground(Color.WHITE);
	    remove.setFont(new Font("Tahoma", Font.BOLD, 10));
	    remove.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

	    remove.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {

	            if (table.isEditing()) {
	                table.getCellEditor().stopCellEditing();
	            }

	            String idStr = ((JButton) e.getSource()).getName();
	            long id = Long.parseLong(idStr);

	            System.out.println("Eliminar producto con ID: " + idStr);

	            ProductModel pm = new ProductModel();
	            pm.productRemove(id);

	            model.setRowCount(0);
	            JSONArray newData = functions.get();
	            for (Object obj : newData) {
	                pm.addTableRow((JSONObject) obj, model, table, functions);
	            }
	        }
	    });

	    model.addRow(new Object[] {row[0], row[1], row[2], row[3], remove});
	}
	
	@SuppressWarnings("unchecked")
	public boolean productAdd(String id, String name, String price, String stock)
	{
		
	    JSONArray productList = get();
	    JSONObject jsonObject = new JSONObject();

	    String url = "src/files/products.json";

	    jsonObject.put("id", Long.parseLong(id));
	    jsonObject.put("nombre", name);
	    jsonObject.put("precio", Double.parseDouble(price));
	    jsonObject.put("stock", Long.parseLong(stock));

	    productList.add(jsonObject);

	    try (FileWriter file = new FileWriter(url)) {
	        String formatted = productList.toJSONString().replace("},", "},\n");
	        file.write(formatted);
	        file.flush();
	        System.out.println("|Producto añadido con éxito|");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return true;
	    
	}
 	
}
