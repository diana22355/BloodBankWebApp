package bloodbank;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OperationAdminServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest request,
            HttpServletResponse response) 
	{
		try
		{
			
			 String option = new String();
			 option = request.getParameter("option");
			 HttpSession session = request.getSession(false);
			 
			 if(option.equalsIgnoreCase("account"))
			 {
				 response.sendRedirect("./createDoctorAccount.jsp");
			 }
			 else if(option.equalsIgnoreCase("appointment"))
			 {
				 response.sendRedirect("./AdminAppointments.jsp");
			 }
			 else if(option.equalsIgnoreCase("view_account"))
			 {
				 response.sendRedirect("./ViewDoctorAccount.jsp");
			 }
			 else if(option.equalsIgnoreCase("delete_account"))
			 {
				 response.sendRedirect("./DeleteDoctorAccount.jsp");
			 }
			 else if(option.equalsIgnoreCase("request"))
			 { 
				 response.sendRedirect("./AdminRequests.jsp");
			 }
			 else
			 {
				 response.sendRedirect("./AdminBloodDatabase.jsp");
			 }
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