package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Transaction {
	
	private int custPIN;
	
	private int barcode;
	
	private double price;
	
	private int transactionCode;
	
	private Date Due;
	
	private Date Rent;
	
	public Date getRent() {
		return Rent;
	}

	public void setRent(Date rent) {
		Rent = rent;
	}

	public Transaction(){
		
	}

	public int getCustPIN() {
		return custPIN;
	}

	public void setCustPIN(int custPIN) {
		this.custPIN = custPIN;
	}

	public int getBarcode() {
		return barcode;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(int transactionCode) {
		this.transactionCode = transactionCode;
	}

	public Date getDue() {
		return Due;
	}

	public void setDue(Date due) {
		Due = due;
	}
	
	public static void addTransaction(TextField barcode, TextField PIN,
			TextField Price, Label tCode, DatePicker Rent, DatePicker Due) {
		try {
			Connection con = Database.getConnection();		
			PreparedStatement posted = con.prepareStatement("INSERT INTO transaction(code, pin, barcode, price, rent_date, return_date) VALUES "
					+ "('" + tCode.getText()
					+"', '"+ PIN.getText()      
					+"', '"+ barcode.getText()
					+"', '"+ Price.getText()
					+"', '"+ Rent
					+"', '"+ Due
					+"')");
			posted.executeUpdate();
		}catch (Exception ex) {System.out.println(ex);}
		
	}
	
	public static ResultSet getLastCode(){
		try{
			Connection con = Database.getConnection();		
			String query = "SELECT max(code) as code FROM transaction";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			return rs;
		} catch (Exception e){System.out.println(e);
		return null;}
	}
	
	
	
}