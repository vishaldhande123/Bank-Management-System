package bank;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/cls")
public class CloseServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		 PrintWriter pw=res.getWriter();
		 res.setContentType("text/html");
		long accNO=Long.parseLong(req.getParameter("accno"));
		String uName=req.getParameter("username");
		String pWord=req.getParameter("password");
		
		CloseDAO cd=new CloseDAO();
		int rd=cd.close(accNO,uName,pWord);
		if(rd==0) {
		     pw.println("Invalid user-Details Please try again...");
	    		RequestDispatcher rd1=req.getRequestDispatcher("Close.html");
	    		rd1.include(req, res);
			}else {
				//req.setAttribute("rb", rd);
	    		req.setAttribute("msg","Account Closed....");
	    		
	    		RequestDispatcher rd1=req.getRequestDispatcher("Close.jsp");
	    		rd1.forward(req, res);
	    		
			}    
	}
}