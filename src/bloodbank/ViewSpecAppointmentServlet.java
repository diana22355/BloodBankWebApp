package bloodbank;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewSpecAppointmentServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest request,
            HttpServletResponse response) 
	{
		try
		{
			 HttpSession session = request.getSession(false);
			 
			 String firstname = new String();
			 String lastname = new String();
			 String email = new String();
			 firstname = request.getParameter("firstname");
			 lastname = request.getParameter("lastname");
			 email = request.getParameter("email");
			 int user_id = DatabaseSearch.userIDName(firstname, lastname, email);
			 if (user_id==0)
			 {
				 StringBuffer error = new StringBuffer();
					error.append("<strong>The User could not be found with the information specified.<br/>");
					error.append("Please validate User's information.</strong>");
					session.setAttribute("errors", error.toString());
					response.sendRedirect("./SpecUserAppointmentAdmin.jsp");

			 }
			 else
			 {
			session.setAttribute("errors", "");
			 session.setAttribute("userID", user_id);
			 response.sendRedirect("./DisplaySpecificAppointment.jsp");
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

