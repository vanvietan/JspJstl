package cybersoft.javabackend.java14.jsp.jstl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cybersoft.javabackend.java14.jsp.jstl.datasource.MySQLConnection;
import cybersoft.javabackend.java14.jsp.jstl.model.Product;

public class ProductRepository {
	public List<Product> getProducts(){
		List<Product> products = new LinkedList<Product>();
		Connection connection = null;
		try {
			connection = MySQLConnection.getConnection();
			String query = "SELECT id, name, description, price, stock FROM product";
			
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				// lấy product ra từ result set là thêm vào list products
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setStock(rs.getInt("stock"));
				
				products.add(product);
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		} 
		
		return products;
	}
	
	public int addProduct(Product product) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = "INSERT product(id, name, description, price, stock) VALUES(?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, product.getId());
			statement.setString(2, product.getName());
			statement.setString(3, product.getDescription());
			statement.setFloat(4, product.getPrice());
			statement.setInt(5, product.getStock());
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int removeProduct(String productId) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = "DELETE FROM product WHERE id = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, productId);
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		
		return 0;
	}
}
