package dao;
import java.sql.*;

import connectionManager.ConnectionManager;
import model.Product;


public class ProductDAO {

	public void addProduct(Product product) throws ClassNotFoundException,SQLException
	{
		ConnectionManager conn=new ConnectionManager();
		Connection con=conn.establishConnection();
		
		String sql="insert into products(productId,productName,minsellquantity,price,quantity)values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1,product.getProductId());
		ps.setString(2,product.getProductName());
		ps.setInt(3,product.getMinsellQuantity());
		ps.setInt(4,product.getPrice());
		ps.setInt(5,product.getQuantity());
		
		ps.executeUpdate();
		
		conn.closeConnection();
	}
	
	public void display() throws ClassNotFoundException,SQLException
	{
		ConnectionManager conn=new ConnectionManager();
		Connection con=conn.establishConnection();
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select *from products");
		
		while(rs.next())
		{
			System.out.println("__________________________________________________________");
			System.out.println(rs.getInt("productId")+" | "+(rs.getString("productName")+" | "
					+rs.getInt("minsellquantity")+" | "+rs.getInt("price"))+" | "
					+rs.getInt("quantity"));
		}
		conn.closeConnection();
	}
}


	
