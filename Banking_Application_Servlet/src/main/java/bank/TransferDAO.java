package bank;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpSession;

	@SuppressWarnings({ "serial", "unused" })
    
	public class TransferDAO extends HttpServlet
	{
		RegisterBean rd=null;
		public RegisterBean transfer(HttpServletRequest req ) {
			 int accNo=Integer.parseInt(req.getParameter("accno"));
				String uName=req.getParameter("username");
				String pWord=req.getParameter("password");
				long taccNo=(Long.parseLong(req.getParameter("taccno")));
				long amt=(Long.parseLong(req.getParameter("amount")));
			int k=0,k2=0;
			try 
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe","system","system");
				PreparedStatement ta=con.prepareStatement("select * from apnabank where accountno=?");
				PreparedStatement ps=con.prepareStatement("select * from apnabank where accountno=? and username=? and password=? ");
				PreparedStatement add=con.prepareStatement("update apnabank set amount=amount-? where accountno=? ");
				PreparedStatement ad=con.prepareStatement("update apnabank set amount=amount+? where accountno=? ");
				
				
				ps.setInt(1, accNo);
				ps.setString(2, uName);
				ps.setString(3, pWord);
				
				ta.setLong(1, taccNo);
				ResultSet rs1 = ta.executeQuery();
				
			ResultSet rs=ps.executeQuery();
			
	       if(rs.next())
	       {
	    	   long amount = rs.getLong(4);
	    	   if(amount>=amt)
	    	   {
	    		   add.setLong(1, amt);
	    		   add.setLong(2, accNo);
	    		  
	    		   ad.setLong(1, amt);
	    		   ad.setLong(2, taccNo);
				k=add.executeUpdate();	
				k2=ad.executeUpdate();
				System.out.println(k);
      
				if(k>0 && k2>0)
				{
					System.out.println("Amount transfered Successfully.....");

				
	       }	
	       }
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return rd;
		
	}
}
	