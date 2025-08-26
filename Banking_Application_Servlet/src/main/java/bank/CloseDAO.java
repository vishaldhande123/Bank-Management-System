package bank;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;



public class CloseDAO extends HttpServlet
{
	int k=0;
	public int close(long accNo, String uName, String pWord) {
		
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe","system","system");
			
			PreparedStatement ps=con.prepareStatement("delete from apnabank where accountno=? and username=? and password=?");
	

			
			
			ps.setLong(1, accNo);
			ps.setString(2, uName);
			ps.setString(3, pWord);
			
		
			k=ps.executeUpdate();		
//		if(rs.next())
//		{
//			rd=new RegisterBean();
//			
//			rd.setAccNo(rs.getLong(1));
//	        rd.setuName(rs.getString(2));
//	        rd.setPass(rs.getString(3));
//	        rd.setAmt(rs.getLong(4));
//	        rd.setAdd(rs.getString(5));
//	        rd.setPhNo(rs.getLong(6));
//			
//		}
//				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("k="+k);
		return k;
		
	}
	

	
}