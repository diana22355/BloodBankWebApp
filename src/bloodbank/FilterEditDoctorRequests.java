package bloodbank;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FilterEditDoctorRequests  extends HttpServlet 
{
	public void doPost(HttpServletRequest request,
            HttpServletResponse response) 
	{
		try
		{
			 HttpSession session = request.getSession(false);
			 String status = new String();
			 status = request.getParameter("status");
			
				 session.setAttribute("errors", "");
				 session.setAttribute("status", status);
				 response.sendRedirect("./StatusRequest.jsp");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void doGet(HttpServletRequest request,
            HttpServletResponse response)
	{
		doPost(request, response);
	}
}