package bank;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/bal")
public class BalanceServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
	    int accNo=Integer.parseInt(req.getParameter("accno"));
		String uName=req.getParameter("username");
		String pWord=req.getParameter("password");
		BalanceDAO bd=new BalanceDAO();
		RegisterBean rd=bd.balance(accNo,uName,pWord);
			
	
		 PrintWriter pw=res.getWriter();
		 res.setContentType("text/html");
		if(rd==null) {
		     pw.println("Invalid user-Details Please try again...");
	    		RequestDispatcher rd1=req.getRequestDispatcher("Balance.html");
	    		rd1.include(req, res);
			}else {
				req.setAttribute("rb", rd);
	    		req.setAttribute("msg","See your Balance");
	    		
	    		RequestDispatcher rd1=req.getRequestDispatcher("Balance.jsp");
	    		rd1.forward(req, res);
	    		
			}    
	}
}