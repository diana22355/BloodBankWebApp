package bloodbank;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddBloodDonationServlet  extends HttpServlet 
{
	public void doPost(HttpServletRequest request,
            HttpServletResponse response) 
	{
		try
		{
		
			 HttpSession session = request.getSession(false);
			 float liters=0;
			 int update=0;
			 int update_blood_location;
			 int update_blood_admin;
			 int location_id;
			 String firstname = new String();
			 String lastname = new String();
			 String email = new String();
			 String blood_type = new String();
			 String date= request.getParameter("donation");
			 firstname = request.getParameter("firstname");
			 lastname = request.getParameter("lastname");
			 email = request.getParameter("email");
			 liters = Float.parseFloat(request.getParameter("liters"));
			 location_id = Integer.parseInt(request.getParameter("location"));
			 blood_type = request.getParameter("blood");
			 
			 int user_id = DatabaseSearch.userIDName(firstname, lastname, email);
			 
			 if (user_id==0)
			 {
				 StringBuffer error = new StringBuffer();
					error.append("<strong>The User could not be found with the information specified.<br/>");
					error.append("Please validate User's information.</strong>");
					session.setAttribute("errors", error.toString());
					response.sendRedirect("./AdminBloodDatabase.jsp");
					

			 }
			 else
			 {
	
					update = DatabaseSearch.createBloodEntry(liters, blood_type, date, user_id);
					 if (update==1)
					 {
						 int blood_id = DatabaseSearch.BloodlID(user_id, date);
						 update_blood_location= DatabaseSearch.createBloodEntryLocation(location_id, blood_id );
						 if (update_blood_location==1)
						 	{
							 	Admin admin = (Admin) request.getSession(false).getAttribute("admin");
			
							 	update_blood_admin = DatabaseSearch.createBloodEntryAdmin(admin.getAdmin_id(), blood_id);
							 	if (update_blood_admin==1)
							 	{
							 		session.setAttribute("errors", "");
								 	response.sendRedirect("./EndAdminBloodDatabase.jsp");
							 	}
							 	else
							 	{
							 		StringBuffer error = new StringBuffer();
									error.append("<strong>Admin ID information for Blood entry record could not be updated.<br/>");
									error.append("Please validate database connectivity.</strong>");
									session.setAttribute("errors", error.toString());
									response.sendRedirect("./AdminBloodDatabase.jsp");
							 	}
							 	
						 	}
						 else
						 {
							 StringBuffer error = new StringBuffer();
								error.append("<strong>Location for Blood entry record could not be updated.<br/>");
								error.append("Please validate database connectivity.</strong>");
								session.setAttribute("errors", error.toString());
								response.sendRedirect("./AdminBloodDatabase.jsp");
						 }
						 
					 }
					 else
					 {
						 StringBuffer error = new StringBuffer();
							error.append("<strong>The Blood donation could not be updated within the BloodBank database.<br/>");
							error.append("Please validate database connectivity.</strong>");
							session.setAttribute("errors", error.toString());
							response.sendRedirect("./AdminBloodDatabase.jsp");
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
