//Author Name: Kevin Montero
//Date: 11/24/2019
//Program Name: kmontero_module11_database

//Purpose: This program is to compare values from a MySQL database to a text file and print out the words that do not match


 

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;

public class main {

	public static void main(String[] args) throws Exception {
		readfile r = new readfile();
		r.openFile();
		r.readFile();
		r.closeFile();
		
//----- Connect to the Database ---------------------//
		getConnection();
		
//----- Get info from Database ----------------------//
		get();
	}
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.jdbc.Driver";
			
//--------- Selecting "word_occurrences" DataBase from MySQL ------------//
			String url = "jdbc:mysql://127.0.0.1:3306/word_occurrences";
			
//---------	Info to get into MySQL ------------------//
			String username = "root";
			String password = "kwmh1997";
			
			Class.forName(driver);
			
//--------- Making connection to the DB ------------//
			Connection conn = DriverManager.getConnection(url, username , password);
			System.out.println("Connected"); //Making sure that I am connected
			return conn;
			
		} catch(Exception e) {System.out.println(e);}
		
		return null;
	}
	
	public static ArrayList<String> get() throws Exception{
		try {
			Connection con= getConnection();
			// Grab all Info from words table Words
			PreparedStatement statement = con.prepareStatement("SELECT * FROM  words ");
			
			ResultSet result= statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				System.out.println(result.getString("words"));
				
				array.add(result.getString("words"));
			}
			System.out.println("All records have been selected");
			return array;
		} catch(Exception e){System.out.println(e);}
		
		return null;
		
	}
	
}
