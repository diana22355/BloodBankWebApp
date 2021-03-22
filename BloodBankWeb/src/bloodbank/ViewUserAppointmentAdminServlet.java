package bloodbank;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewUserAppointmentAdminServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest request,
            HttpServletResponse response) 
	{
		try
		{
			
			 String ViewappointmentOption = new String();
			 ViewappointmentOption = request.getParameter("ViewappointmentOption");
			 
			 if(ViewappointmentOption.equalsIgnoreCase("viewAll"))
			 {
				 response.sendRedirect("./AllUserAppointmentAdmin.jsp");
			 }
			 else
			 {
				 response.sendRedirect("./SpecUserAppointmentAdmin.jsp");
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
