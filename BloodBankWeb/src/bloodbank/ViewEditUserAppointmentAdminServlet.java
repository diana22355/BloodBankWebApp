package bloodbank;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewEditUserAppointmentAdminServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest request,
            HttpServletResponse response) 
	{
		try
		{
			
			 String appointmentOption = new String();
			 appointmentOption = request.getParameter("appointmentOption");
			 
			 if(appointmentOption.equalsIgnoreCase("view"))
			 {
				 response.sendRedirect("./ViewUserAppointmentAdmin.jsp");
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