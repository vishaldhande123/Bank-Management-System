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
	@WebServlet("/wit")

	public class WithdraServlet  extends HttpServlet{

		
			protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
			{
			    int accNo=Integer.parseInt(req.getParameter("accno"));
				String uName=req.getParameter("username");
				String pWord=req.getParameter("password");
				Long amt=(Long.parseLong(req.getParameter("amount")));
				WithdrawDAO wd=new WithdrawDAO();
				RegisterBean rb= wd.withdraw(accNo,uName,pWord,amt,req);
					
				req.setAttribute("rb", rb);
				 PrintWriter pw=res.getWriter();
				 res.setContentType("text/html");
				 
				 if(rb!=null) 
				 {
					 req.setAttribute("msg", "see your balance.. Balance is updated...");
					 
					 RequestDispatcher rd1=req.getRequestDispatcher("Balance.jsp");
					 rd1.forward(req, res);
				 }
				 else {
				     pw.println("Invalid user-Details Please try again...");
			    		RequestDispatcher rd1=req.getRequestDispatcher("Deposit.html");
			    		rd1.include(req, res);
					
					}    
			}
		}

