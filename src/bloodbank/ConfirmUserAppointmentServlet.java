package bloodbank;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConfirmUserAppointmentServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest request,
            HttpServletResponse response) 
	{
		try
		{
			 HttpSession session = request.getSession(false);
			 
			 int appointment_id;
			 int update=0;
			 appointment_id = Integer.parseInt(request.getParameter("appointment_id"));
			 update=DatabaseSearch.DeleteAppointment(appointment_id);
			 if(update==1)
			 {
				 session.setAttribute("errors", "");
				response.sendRedirect("./EndDeleteUserAppointment.jsp"); 
			 }
			 else
			 {
				 StringBuffer error = new StringBuffer();
					error.append("<strong>User's appointment could not be confirmed.<br/>");
					error.append("Please database connectivity.</strong>");
					session.setAttribute("errors", error.toString());
					response.sendRedirect("./DeleteSpecificAppointment.jsp");
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