package bloodbank;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateAppointment  extends HttpServlet
{

	public void doPost(HttpServletRequest request,
            HttpServletResponse response) 
	{
		try
		{
			int create_new_app_id;
			int update;
			int update1;
			int app_date_time_id;
			Appointment app;
			HttpSession session = request.getSession(false);
			User user = (User) request.getSession(false).getAttribute("user");
			String date_ap= request.getParameter( "appointment" );
			String time_ap = request.getParameter("time");
			String location_ap = request.getParameter("location");
			int user_id  = DatabaseSearch.userID(user.getEmail(), user.getPassword());
			int location_id  = DatabaseSearch.locationID(location_ap);
			if(DatabaseSearch.finAppointmentID(date_ap, time_ap))
			{
				app_date_time_id = DatabaseSearch.AppointmentID(date_ap, time_ap);
				update = DatabaseSearch.createAppointment(app_date_time_id, location_id, user_id);
					if(update==1)
					{
						app = DatabaseSearch.AppointmentInfo(user.getUser_id());
						session.setAttribute("appointment", app);
						session.setAttribute("errors", "");
        	 			session.setAttribute("user", user);
						response.sendRedirect("./EndUpdateAppointment.jsp");
					}
					else
					{
				
						StringBuffer error = new StringBuffer();
						error.append("<strong>Appointment could not be booked.<br/>");
						error.append("Please try again.</strong>");
						session.setAttribute("errors", error.toString());
						response.sendRedirect("./MakeAppointment.jsp");
					}
			}
			else
			{
				create_new_app_id= DatabaseSearch.createAppointmentDateTime(date_ap, time_ap);
				if(create_new_app_id==1)
				{
					app_date_time_id = DatabaseSearch.AppointmentID(date_ap, time_ap);
					update1 = DatabaseSearch.createAppointment(app_date_time_id, location_id, user_id);
						if(update1==1)
						{
							app = DatabaseSearch.AppointmentInfo(user.getUser_id());
							session.setAttribute("appointment", app);
							session.setAttribute("errors", "");
	        	 			session.setAttribute("user", user);
							response.sendRedirect("./EndUpdateAppointment.jsp");
						}
						else
						{
					
							StringBuffer error = new StringBuffer();
							error.append("<strong>Appointment could not be booked.<br/>");
							error.append("Please try again.</strong>");
							session.setAttribute("errors", error.toString());
							response.sendRedirect("./MakeAppointment.jsp");
						}
				}
				else
				{
					StringBuffer error = new StringBuffer();
					error.append("<strong>Appointment could not be booked.<br/>");
					error.append("Please try contact administrator.</strong>");
					session.setAttribute("errors", error.toString());
					response.sendRedirect("./MakeAppointment.jsp");
				}
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

