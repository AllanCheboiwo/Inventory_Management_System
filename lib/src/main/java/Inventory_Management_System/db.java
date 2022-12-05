package Inventory_Management_System;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

import javax.swing.JOptionPane;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class db {
    private Connection con;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
	Preferences preferences = Preferences.userNodeForPackage(db.class);

	public void setCredentials(String username, String password) {
		    preferences.put("db_username", username);
		    preferences.put("db_password", password);
		  }

	public String getUsername() {
		    return preferences.get("db_username", null);
		  }

	public String getPassword() {
		    return preferences.get("db_password", null);
		  }
	
	/**
	 * Creates a connection to the database
	 * @return
	 * the connection
	 * @throws SQLException
	 */
    public Connection connect() throws SQLException
	{
		String url = "jdbc:mysql://localhost/inventorySystem"; 
		String uid = getUsername();        
		String pw = getPassword();

		System.out.println("Connecting to database.");
		con = DriverManager.getConnection(url, uid, pw);
		return con;		                       
	}
	/**
	 * Closes the connection to the database
	 */
	public void close()
	{
		System.out.println("Closing database connection.");
		try
		{
			if (con != null)
	            con.close();
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	/**
	 * Adds a product to the product table in the inventorySystem database
	 * @param p
	 * Takes a product object as an argument
	 */
	public void addProduct(Product p){

		try{
			String sql = "INSERT INTO product VALUES (?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,p.getName());
			pstmt.setDate(2,new Date(sdf.parse(p.getExpDate()).getTime()));
			pstmt.setInt(3,p.getQuant());
			pstmt.setDouble(4, p.getValue());
			pstmt.executeUpdate();
			pstmt.close();


		}
		catch(Exception e){
			System.out.println(e);
		}

	}
	/**
	 * Adds a user to the user table in the inventorySystem database
	 * @param u
	 * Takes in a user object as an argument
	 */
	public void addUser(User u){

		try{
			String sql = "INSERT INTO user VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,u.getUsername());
			pstmt.setString(2,u.getPassword());
			pstmt.setString(3,u.getEmail());
			pstmt.executeUpdate();
			pstmt.close();


		}
		catch(Exception e){
			System.out.println(e);
		}

	}
	/**
	 * Adds a supplier to the supplier table in the database
	 * @param s
	 * Takes a Supplier object as an argument
	 */
	public void addSupplier(Supplier s){
		try{
			String sql = "INSERT INTO supplier VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,s.getSupplierName());
			pstmt.setString(2,s.getSupplierEmail());
			pstmt.setString(3,s.getProduct());
			pstmt.executeUpdate();
			pstmt.close();


		}
		catch(Exception e){
			System.out.println(e);
		}

	}
	/**
	 * Removes a product from the database
	 * @param productName
	 * Takes a string representing productName as an argument 
	 */	
	public void removeProduct(String productName){
		try{
			String sql = "DELETE FROM product WHERE productName=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,productName);
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch(Exception e){
			System.out.println(e);
		}

	}
	/**
	 * Removes a user from the database
	 * @param productName
	 * Takes a string representing username as an argument 
	 */	
	
	public void removeUser(String userName){
		try{
			String sql = "DELETE FROM user WHERE username=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,userName);
			pstmt.executeUpdate();
			pstmt.close();
			
		}
		catch(Exception e){
			System.out.println(e);
		}

	}
	/**
	 * Removes a supplierfrom the database
	 * @param productName
	 * Takes a string representing supplierName as an argument 
	 */	
	public void removeSupplier(String supplierName){
		try{
			String sql = "DELETE FROM supplier WHERE supplierName=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,supplierName);
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch(Exception e){
			System.out.println(e);
		}

	}
	
	/**
	 * Returns a list of products in the database
	 * @return
	 * Returns a string representing products in the Product table
	 * 			Format
	 * productName,Expiry Date, Quantity, Value
	 */
	public Object[][] listProducts(){
		Object[][] data= new Object[1000][4];
		int count=0;
		
		try{
			String sql="SELECT * FROM product";
			Statement stmt= con.createStatement();
			ResultSet rst = stmt.executeQuery(sql);
			System.out.println("Product Name,	Expiry Date,	Quantity,	Value");
			
			while(rst.next()){
				
				data[count][0]=rst.getString("productName");
				data[count][1]=rst.getDate("expiryDate");
				data[count][2]=rst.getInt("quantity");
				data[count][3]=rst.getDouble("productValue");
				count++;
			}
		
			stmt.close();
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		Object result[][]= new Object[count][4];
		for(int i=0;i<count;i++)
			for(int j =0;j<4;j++)
				result[i][j]=data[i][j];
		return data;
	}
	/**
	 * Returns a list of products low in quanitity in the database
	 * @return
	 * Returns a string representing products in the Product table
	 * 			Format
	 * productName,Expiry Date, Quantity, Value
	 */
	public Object[][] listLowInventryProducts(){
		Object[][] data= new Object[1000][4];
		try{
			String sql="SELECT * FROM product WHERE quantity<100";
			Statement stmt= con.createStatement();
			ResultSet rst = stmt.executeQuery(sql);
			System.out.println("Product Name,	Expiry Date,	Quantity,	Value");
			int count=0;
			while(rst.next()){
				data[count][0]=rst.getString("productName");
				data[count][1]=rst.getDate("expiryDate");
				data[count][2]=rst.getInt("quantity");
				data[count][3]=rst.getDouble("productValue");
				count++;
			}
				
			stmt.close();
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		return data;

	}
	/**
	 * Modiifies the quantity of the product stored in the database
	 * @param productName
	 * takes a string as an argument representing productName of the product you want to modify quantity
	 * @param quantity
	 * takes an integer representing new quantity
	 * 
	 */
	public void modifyQuantity(String productName,int quantity){
		try{
			String sql = "UPDATE product SET quantity=? WHERE productName=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,quantity);
			pstmt.setString(2, productName);
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch(Exception e){
			System.out.println(e);
		}

	}
	public Object[][] ListUsers(){
		Object[][] data= new Object[1000][2];
		try{
			String sql="SELECT * FROM user";
			Statement stmt= con.createStatement();
			ResultSet rst = stmt.executeQuery(sql);
			int count=0;
			while(rst.next()){
				data[count][0]=rst.getString("username");
				data[count][1]=rst.getString("email");
				count++;
			}
				
			stmt.close();
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		return data;

	}
	public Object[][] listSuppliers(){
		Object[][] data= new Object[1000][3];
		try{
			String sql="SELECT * FROM supplier";
			Statement stmt= con.createStatement();
			ResultSet rst = stmt.executeQuery(sql);
			int count=0;
			while(rst.next()){
				data[count][0]=rst.getString("supplierName");
				data[count][1]=rst.getString("supplierEmail");
				data[count][2]=rst.getString("product");
				count++;
			}
				
			stmt.close();
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		return data;

	}
	
	public String lowInventoryMessage(){
		StringBuilder products = new StringBuilder();
		try{
			String sql="SELECT productName FROM product WHERE quantity<100";
			Statement stmt= con.createStatement();
			ResultSet rst = stmt.executeQuery(sql);
			products.append("LOW INVENTORY PRODUCTS!!!"+"\n");
			while(rst.next()){
				products.append(rst.getString("productName")+"stock is running low. More should be ordered."+"\n");
			}
				
			stmt.close();
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		return products.toString();

	}
	
	
	public void sendAlert(String username) {
		String sql="SELECT email FROM user WHERE username=?";
		String userEmail;
		try {
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rst=pstmt.executeQuery();
			rst.next();
			userEmail=rst.getString("email");
			Email email= new SimpleEmail();
			
			// Set the hostname of the outgoing mail server 
				email.setHostName("smtp.googlemail.com");
			
			
			// Set the non-SSL port number of the outgoing mail server
			email.setSmtpPort(465);
			// Set the Authenticator to the default when authentication is requested from the mail server.
			//**Not sure if needed so commented out
			email.setAuthenticator(new DefaultAuthenticator(userEmail, "kumberel16"));
				
			// Set whether SSL/TLS encryption should be enabled for the SMTP transport upon connection (SMTPS/POPS).
			//**Not sure if needed so commented out
				email.setSSLOnConnect(true);



			// Set FROM field of email
				email.setFrom(userEmail);
				
			// Set email subject
				email.setSubject("Low Inventory Warning");

			// Set the content of the email
				email.setMsg(lowInventoryMessage());

			// Set TO field/recipient of the email
				email.addTo(userEmail);
				
			// Set condition to send alert
			if(lowInventoryMessage().equals("")){
				
				JOptionPane.showMessageDialog(null, "No product is low for an alert");
			}
			else{
				email.send();
				
			}
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		
	}	
	public void addTransaction(Transaction t) {

		try{
			String sql = "INSERT INTO Transaction VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,t.getName());
			pstmt.setDate(2,new Date(sdf.parse(t.getDate()).getTime()));
			pstmt.setInt(3,t.getQuant());
			pstmt.executeUpdate();
			pstmt.close();

		}
		catch(Exception e){
			System.out.println(e);
		}

	}
	public void deleteTransaction(String product,String transDate,int quantity){
		String sql = "DELETE FROM Transaction WHERE product=? AND transDate=? AND transQuantity=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product);
			pstmt.setDate(2, new Date(sdf.parse(transDate).getTime()));
			pstmt.setInt(1, quantity);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public Object[][] listOfTransactions(){

		Object[][] data= new Object[1000][3];
		try{
			String sql="SELECT * FROM Transaction";
			Statement stmt= con.createStatement();
			ResultSet rst = stmt.executeQuery(sql);
			int count=0;
			while(rst.next()){
				data[count][0]=rst.getString("product");
				data[count][1]=rst.getString("transDate");
				data[count][2]=rst.getString("transQuantity");
				count++;
			}
				
			stmt.close();
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		return data;

	}

	public double calTime(String productName, String startDate, String endDate) {

		List<Transaction> transactionList = new ArrayList<Transaction>();
		try{
			String sql="SELECT * FROM Transaction WHERE productName=? AND transDate BETWEEN ? and ?";
			PreparedStatement pstmt= con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery(sql);
			while(rst.next()){
				pstmt.setString(1,productName);
				pstmt.setString(2,startDate);
				pstmt.setString(3,endDate);
				
				String name = rst.getString("product");
				String date = rst.getDate("transDate").toString();
				int quantity = rst.getInt("transQuantity");
				transactionList.add(new Transaction(name, date, quantity));
			}
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
			LocalDate date1 = LocalDate.parse(startDate, dtf);
    		LocalDate date2 = LocalDate.parse(endDate, dtf);
    		//long numDays = Duration.between(date1, date2).toDays();
			
			double totalQuant = 0;
			for (Transaction t : transactionList) { 
    			totalQuant = totalQuant + t.getQuant();
			}
				
			pstmt.close();
			
			double rate = totalQuant/10;
			return rate;
		}
		catch(Exception e){
			System.out.println(e);
		}
		return 0;

	}


}
