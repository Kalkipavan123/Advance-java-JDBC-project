package maven_Demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import maven_Demo.dto.Gadgets;
import maven_Demo.dto.User;

public class CrudData {
	static String s1;
	static double wall;
	Scanner sc=new Scanner(System.in);
	public void createTable(User user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2?createDatabaseIfNotExist=true","root","123");
		Statement s = con.createStatement();
		s.execute("create table If Not Exists userdata (id int primary key,name varchar(45),email varchar(45),phone bigint,pwd varchar(45),gender varchar(45),address varchar(45),wallet int)");
		s.close();
		con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public void userData(User user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2?createDatabaseIfNotExist=true", "root", "123");
			PreparedStatement ps = con.prepareStatement("insert into userdata values(?,?,?,?,?,?,?,?)");
			
				ps.setInt(1, user.getId());
				ps.setString(2, user.getName());
				ps.setString(3, user.getEmail());
				ps.setLong(4, user.getPhone());
				ps.setString(5, user.getPwd());
				ps.setString(6, user.getGender());
				ps.setString(7,user.getAddress());
				ps.setDouble(8, user.getWallet());
				
			ps.execute();
			ps.close();
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public boolean login(User user) throws Throwable {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db2?createDatabaseIfNotExist=true","root","123");
		Statement s=con.createStatement();
		s.execute("create table if not exists userdata(id int primary key,Name varchar(45),email varchar(45),phone bigint,pwd varchar(45),gender varchar(45),address varchar(45),wallet double)");
		
		PreparedStatement ps=con.prepareStatement("select email,pwd,wallet from userdata where email=? and pwd=?;");
		ps.setString(1, user.getEmail());
		ps.setString(2, user.getPwd());
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			s1=rs.getString(1);
			String s2=rs.getString(2);
			wall=rs.getDouble(3);
			if(s1.equals(user.getEmail())&& s2.equals(user.getPwd())) {
				System.out.println("Login Successfull\n");
				return true;
			}
		}
		return false;
	}
public void saveGadget(Gadgets gadget) throws Throwable  {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project?createDatabaseIfNotExist=true","root","123");
	Statement s=con.createStatement();
	s.execute("create table if not exists gadgetdetails(id int primary key,gname varchar(45),gbrand varchar(45),price double,warranty int,colour varchar(45))");
	
	PreparedStatement ps=con.prepareStatement("insert into gadgetdetails values(?,?,?,?,?,?)");
	ps.setInt(1, gadget.getId());
	ps.setString(2, gadget.getGname());
	ps.setString(3, gadget.getgbrand());
	ps.setDouble(4, gadget.getPrice());
	ps.setInt(5, gadget.getWarranty());
	ps.setString(6, gadget.getColour());
	ps.executeUpdate();
	System.out.println("Gadget Details Saved.....");
	
}

public void updateGadget(Gadgets gadget) throws Throwable {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project?createDatabaseIfNotExist=true","root","123");
	Statement s=con.createStatement();
	s.execute("create table if not exists gadgetdetails(id int primary key,gname varchar(45),gbrand varchar(45),price double,warranty int,colour varchar(45))");
	
	PreparedStatement ps=con.prepareStatement("update gadgetdetails set gname=?,gbrand=? where id=?");
	ps.setInt(1, gadget.getId());
	ps.setString(2, gadget.getGname());
	ps.setString(3, gadget.getgbrand());
	
	
	ps.executeUpdate();
	System.out.println("Gadget Details Updated.....");
	
}

public void deleteGadget(Gadgets gadget,String Gname) throws Throwable {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project?createDatabaseIfNotExist=true","root","123");
	Statement s=con.createStatement();
	s.execute("create table if not exists gadgetdetails(id int primary key,gname varchar(45),gbrand varchar(45),price double,warranty int,colour varchar(45))");
	
	PreparedStatement ps=con.prepareStatement("delete from gadgetdetails where id=?");
	ps.setString(1,gadget.getGname());
	ps.executeUpdate();
	System.out.println("Gadget Details Deleted.....");
}

public void fetchGadgets() throws Throwable {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project?createDatabaseIfNotExist=true","root","123");
	Statement s=con.createStatement();
	s.execute("create table if not exists gadgetdetails(id int primary key,gname varchar(45),gbrand varchar(45),price double,warranty int,colour varchar(45))");
	
	PreparedStatement ps=con.prepareStatement("select * from gadgetdetails;");
	ResultSet rs=ps.executeQuery();
	System.out.println("\n-:Gadget Details:-");
	System.out.println("\nid gname gbrand price warranty colour");
	while(rs.next()) {
		int id=rs.getInt(1);
		String gname=rs.getString(2);
		String gbrand=rs.getString(3);
		double price=rs.getDouble(4);
		int warranty=rs.getInt(5);
		String colour=rs.getString(6);
		System.out.println("\n"+id+"  "+gname+"  "+gbrand+"  "+price+"  "+warranty+"  "+colour+" ");
	}

}

public double gadgetWallet(int gadgetid) throws Throwable {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project?createDatabaseIfNotExist=true","root","123");
	Statement s=con.createStatement();
	s.execute("create table if not exists gadgetdetails(id int primary key,gname varchar(45),gbrand varchar(45),price double,warranty int,colour varchar(45))");
	
	PreparedStatement ps=con.prepareStatement("select * from gadgetdetails where id=?;");
	ps.setInt(1, gadgetid);
	ResultSet rs=ps.executeQuery();
	double res=0;
	while(rs.next()) {
		int id=rs.getInt(1);
		String gname=rs.getString(2);
		String gbrand=rs.getString(3);
		double price=rs.getDouble(4);
		int warranty=rs.getInt(5);
		String colour=rs.getString(6);

		System.out.println(gname);
		System.out.println(gbrand);
		System.out.println(price);
		System.out.println(warranty);
		System.out.println(colour);
		
		System.out.println("Your wallet amount: "+wall);
		System.out.println("Your gadget amount: "+"-"+price);
		res=wall-price;
		System.out.println(res);

	}
	return res;
}
    public void updateWallet(double res) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?createDatabaseIfNotExist=true", "root", "123");
	Statement s=con.createStatement();
	s.execute("create table if not exists gadgetdetails(id int primary key,gname varchar(45),gbrand varchar(45),price double,warranty int,colour varchar(45))");
	
	PreparedStatement ps=con.prepareStatement("update gadgetdetils set res=? where s1=?");
	ps.setDouble(1, res);
	ps.setString(2,s1);
	ps.executeUpdate();
}	
}
