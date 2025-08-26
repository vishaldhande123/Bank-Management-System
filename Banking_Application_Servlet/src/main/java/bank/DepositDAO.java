package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings({ "serial", "unused" })

public class DepositDAO extends HttpServlet
{
	RegisterBean rd=null;
	public RegisterBean deposit(int accNo, String uName, String pWord,long amt, HttpServletRequest req ) {
		int k=0;
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe","system","system");
			
			PreparedStatement ps=con.prepareStatement("select * from apnabank where accountno=? and username=? and password=? ");
			PreparedStatement add=con.prepareStatement("update apnabank set amount=amount+? where accountno=? ");
			
			
			ps.setInt(1, accNo);
			ps.setString(2, uName);
			ps.setString(3, pWord);
		
			
		ResultSet rs=ps.executeQuery();
		
       if(rs.next())
       {
    	 //rd.setRepass(rs.getString(6));
			add.setLong(1, amt);
			add.setInt(2, accNo);
			k=add.executeUpdate();	
			System.out.println(k);
			ps.setInt(1, accNo);
			ps.setString(2, uName);
			ps.setString(3, pWord);
			rs=ps.executeQuery();
			if(rs.next())
			{
			rd=new RegisterBean();
			rd.setAccNo(rs.getInt(1));
	        rd.setuName(rs.getString(2));
	        rd.setPass(rs.getString(3));
	        rd.setAmt(rs.getInt(4));
			rd.setAdd(rs.getString(5));
		   
			rd.setPhNo(rs.getLong(6));
			HttpSession session = req.getSession();
			session.setAttribute("rd", rd);
			return rd;
       }
       }	
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rd;
	}
}
