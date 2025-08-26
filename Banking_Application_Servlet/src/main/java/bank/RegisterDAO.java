package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegisterDAO
{
	int k=0;
	public int reg(RegisterBean rb)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe","system","system");
			
	        PreparedStatement ps=con.prepareStatement("insert into apnabank values(s.nextval,?,?,?,?,?)");
	        
	        ps.setString(1, rb.getuName());
	        ps.setString(2, rb.getPass());
	        ps.setLong(3, rb.getAmt());
	        ps.setString(4, rb.getAdd());
	        ps.setLong(5, rb.getPhNo());
	        
	        k=ps.executeUpdate();
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

	
}
