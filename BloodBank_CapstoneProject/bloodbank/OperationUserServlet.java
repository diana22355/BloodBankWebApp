package bloodbank;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OperationUserServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest request,
            HttpServletResponse response) 
	{
		try
		{
			
			 String option = new String();
			 Appointment app;
			 option = request.getParameter( "option" );
			 HttpSession session = request.getSession(false);
			 User user = (User) request.getSession(false).getAttribute("user");
			 Location loc;
			 
			 if(option.equalsIgnoreCase("appointment"))
			 {
				 
				 int age = DatabaseSearch.findAge(user.getPassword(), user.getEmail() );
				 	if (user.getPiercing().equalsIgnoreCase("N") && user.getPregnancy().equalsIgnoreCase("N") && user.getPrescription().equalsIgnoreCase("N") && user.getSurgery().equalsIgnoreCase("N") && user.getTattoo().equalsIgnoreCase("N") && age>=17 )
				 		{
				 			if(DatabaseSearch.findAppointment(user.getUser_id()))
				 					{
				 				StringBuffer error = new StringBuffer();
								error.append("<strong>An appointment is already booked for you.<br/>");
								session.setAttribute("errors", error.toString());
								response.sendRedirect("./MenuUser.jsp");
				 					}
				 				else
				 					{
				 					response.sendRedirect("./MakeAppointment.jsp");
				 					}
				 		}
				 	else
				 	{
				 		response.sendRedirect("./NoRequirements.jsp");
				 	}
				 
			 }
			 else if(option.equalsIgnoreCase("check"))
			 {
				 
				 if(DatabaseSearch.findAppointment(user.getUser_id()))
				 	{
					 	app = DatabaseSearch.AppointmentInfo(user.getUser_id());
					 	loc = DatabaseSearch.LocationInfo(app.getLocation_id());
					 	session.setAttribute("appointment", app);
					 	session.setAttribute("location", loc);
					 	response.sendRedirect("./CheckAppointment.jsp");
				 	}
				 else
				 	{
					 response.sendRedirect("./NoAppointment.jsp");
				 	}
			 }
			 else
			 {
				 response.sendRedirect("./UpdateInfo.jsp");
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