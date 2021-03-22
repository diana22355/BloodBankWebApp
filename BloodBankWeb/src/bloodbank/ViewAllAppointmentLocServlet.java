package bloodbank;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewAllAppointmentLocServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest request,
            HttpServletResponse response) 
	{
		try
		{
			HttpSession session = request.getSession(false);
			 String location = new String();
			 int locationID=0;
			 location = request.getParameter("location");
			 if (location.equalsIgnoreCase("all"))
			 {
				 location="*";
				 session.setAttribute("loc", location);
				 session.setAttribute("locID", locationID);
				 response.sendRedirect("./DisplayAppointment.jsp");
			 }
			 else
			 {
				 location = " ";
				 locationID = DatabaseSearch.locationID(location);
				 session.setAttribute("loc", location);
				 session.setAttribute("locID", locationID);
				 response.sendRedirect("./DisplayAppointment.jsp");
				 
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
