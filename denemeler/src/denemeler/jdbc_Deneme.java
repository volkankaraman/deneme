package denemeler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

public class jdbc_Deneme {
	
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public void baglantiBaslangici() {
		
		String connectionUrl = "jdbc:mysql://localhost:3306/aprendiendojsf";
		String connectionUser = "root";
		String connectionPassword = "123456";
		
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM aprendiendojsf.rol");
			while (rs.next()) {
				String id = rs.getString("id");
				String firstName = rs.getString("nombre");
				String lastName = rs.getString("descripcion");
				System.out.println("ID: " + id + ", First Name: " + firstName
						+ ", Last Name: " + lastName);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}
	public static void main(String[] args) {
		jdbc_Deneme dnm = new jdbc_Deneme();
		dnm.baglantiBaslangici();
		
	}

}
