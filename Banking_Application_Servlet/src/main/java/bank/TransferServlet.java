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
	@WebServlet("/trf")

	public class TransferServlet extends HttpServlet {

		
			protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
			{
				TransferDAO td=new TransferDAO();
				
				RegisterBean rb= td.transfer(req);
					
				req.setAttribute("rb", rb);
	
				 PrintWriter pw=res.getWriter();
				 res.setContentType("text/html");
				 
				 if(rb==null) 
				 {
					 req.setAttribute("msg", "see your balance.. Balance is Trasfered successfully...");
					 
					 RequestDispatcher rd1=req.getRequestDispatcher("Transfer.jsp");
					 rd1.forward(req, res);
				 }
				 else {
				     pw.println("Transaction Failed....");
			    		RequestDispatcher rd1=req.getRequestDispatcher("Transfer.html");
			    		rd1.include(req, res);
					
					}    
			}
		}

