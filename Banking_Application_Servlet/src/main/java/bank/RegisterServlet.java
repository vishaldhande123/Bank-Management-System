package bank;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet
{

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException 
	{
		RegisterBean rb= new RegisterBean();
		
	
		rb.setuName(req.getParameter("username"));
		rb.setPass(req.getParameter("password"));
		rb.setAmt(Long.parseLong (req.getParameter("amount")));
		rb.setAdd(req.getParameter("address"));
		rb.setPhNo(Long.parseLong(req.getParameter("phoneno")));
		
		RegisterDAO dao=new RegisterDAO();
		
		int k=dao.reg(rb);
		
		PrintWriter pw =res.getWriter();
		res.setContentType("text/html");
		if(k>0)
		{
			req.setAttribute("rb", rb);
			req.setAttribute("msg", "User account register Successfully....");
			RequestDispatcher rd= req.getRequestDispatcher("Register.jsp");
			rd.forward(req, res);
		}
		else 
		{
			pw.println("Not Register....");
			RequestDispatcher rd=req.getRequestDispatcher("Register.html");
			rd.include(req, res);
		}
		
	}
}
