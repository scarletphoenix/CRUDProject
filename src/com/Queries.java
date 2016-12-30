package com;

import static com.Connector.con;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Queries {
	
	public int insertQuery(String id,String name,float salary){
		String r=null;
		int s=0;;
		try {
			PreparedStatement pst = con.prepareStatement("insert into employee values(?,?,?)");
			pst.setString(1, id);
			pst.setString(2,name);
			pst.setFloat(3, salary);
			
			r = checkIfEntryExists(id);
			if(r.equals("NOT FOUND"))
				{
				s=pst.executeUpdate();
			
				}
			else
				s=0;
	
	}
		catch(Exception e){}
		return s;
	}
	
	public int updateQuery(String id,String name,float salary){
		
		String r= null;
		int s = 0;
		try {
			PreparedStatement pst = con.prepareStatement("update employee set name=?,salary=? where id=?");
			
			pst.setString(1,name);
			pst.setFloat(2, salary);
			pst.setString(3, id);
			r = checkIfEntryExists(id);
			if(r.equals("NOT FOUND"))
				{
				s=0;	
				}
			else
				{
					s=pst.executeUpdate();
				}
	}
		catch(Exception e){}
		return s;
	}
	

	public int deleteQuery(String id){
		String r=null;
		int s=0;
		try {
			PreparedStatement pst = con.prepareStatement("delete from employee where id=?");
			pst.setString(1, id);
			r = checkIfEntryExists(id);
			if(r.equals("NOT FOUND"))
			{
				s=0;
			}
			else
			{
				s=pst.executeUpdate();
				
				}

			
	}
		catch(Exception e){}

	return s;
	}
	
	public String[] checkQuery(String id) {
		String x[]=new String[3];
		try {
			PreparedStatement pst = con.prepareStatement("select * from employee where id=?");
			pst.setString(1, id);
			
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				
				x[0]=rs.getString(1);
				x[1]=rs.getString(2);
				x[2]=rs.getString(3);	
			}
			else {
			
				x[0]="NOT FOUND";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}
	public String checkIfEntryExists(String id) {
		String x=null;
		try {
			PreparedStatement pst = con.prepareStatement("select * from employee where id=?");
			pst.setString(1, id);
			
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				
				x=rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3);	
			}
			else {
			
				x="NOT FOUND";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}

	public String[][] viewAll() {
		
		String[][] x = null;
		try {
			int c = 0;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select count(*) from employee");
			rs.next();
			c=rs.getInt(1);
			x=new String[c][3];
			rs = st.executeQuery("select * from employee");
			int i=0,j=0;
			while(rs.next()){
				x[i][j++]=rs.getString(1);
				x[i][j++]=rs.getString(2);
				x[i][j++]=rs.getString(3);
				i++;
				j=0;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}
	
	
	
public boolean insert(String user,String password){
		
		try {
			PreparedStatement pst = con.prepareStatement("insert into login values(?,?)");
			pst.setString(1, user);
			pst.setString(2,password);
			
			boolean flag = check(user,password);
			if(flag)
				{
				return false;
				}
			else if(!flag)
			{
				pst.executeUpdate();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	
	}
	
	public boolean check(String user, String password) {
		try {
			PreparedStatement pst = con.prepareStatement("select * from login where user=? AND password=?");
			pst.setString(1, user);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				return true;
				
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
