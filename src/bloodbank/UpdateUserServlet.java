package bloodbank;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateUserServlet extends HttpServlet
{

	public void doPost(HttpServletRequest request,
            HttpServletResponse response) 
	{
		try
		{
			int update;
			HttpSession session = request.getSession(false);
			User user = (User) request.getSession(false).getAttribute("user");
			String prescription = request.getParameter("prescription");
			String phone_number_u = request.getParameter("phone_n");
			String tattoo = request.getParameter("tattoo");
			String piercing = request.getParameter("piercing");
			String surgery = request.getParameter("surgery");
			String email_u = user.getEmail();
			String password_u = user.getPassword();
			if(user.getGender().equalsIgnoreCase("F"))
			{
				String pregnancy = request.getParameter("pregnancy");
				update = DatabaseSearch.updateUser(prescription,phone_number_u,tattoo,piercing,surgery,email_u, password_u, pregnancy);
					if(update==1)
					{
						session.setAttribute("errors", "");
						user = DatabaseSearch.findUserInfo(user.getEmail(), user.getPassword());
        	 			session.setAttribute("user", user);
						response.sendRedirect("./EndUpdateUser.jsp");
					}
					else
					{
				
						StringBuffer error = new StringBuffer();
						error.append("<strong>Information could not be updated.<br/>");
						error.append("Please try again.</strong>");
						session.setAttribute("errors", error.toString());
						response.sendRedirect("./UpdateInfo.jsp");
					}
				
			}
			else
			{
				String pregnancy = user.getPregnancy();
				update = DatabaseSearch.updateUser(prescription,phone_number_u,tattoo,piercing,surgery,email_u, password_u, pregnancy);
				if(update==1)
				{
					session.setAttribute("errors", "");
					user = DatabaseSearch.findUserInfo(user.getEmail(), user.getPassword());
    	 			session.setAttribute("user", user);
					response.sendRedirect("./EndUpdateUser.jsp");
				}
				else
				{
			
					StringBuffer error = new StringBuffer();
					error.append("<strong>Information could not be updated.<br/>");
					error.append("Please try again.</strong>");
					session.setAttribute("errors", error.toString());
					response.sendRedirect("./UpdateInfo.jsp");
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
