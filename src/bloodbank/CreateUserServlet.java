package bloodbank;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateUserServlet extends HttpServlet
{

	public void doPost(HttpServletRequest request,
            HttpServletResponse response) 
	{
		try
		{
			int createUser;
			HttpSession session = request.getSession(false);
			String firstname_u = request.getParameter("firstname");
			String lastname_u = request.getParameter("lastname");
			String password_u = request.getParameter("password");
			String gender = request.getParameter("gender");
			String prescription = request.getParameter("prescription");
			String piercing = request.getParameter("piercing");
			String tattoo = request.getParameter("tattoo");
			String surgery = request.getParameter("surgery");
			String pregnancy = request.getParameter("pregnancy");
			String dob = request.getParameter("dob");
			String phone_number_u = request.getParameter("phone_n");
			String email = request.getParameter("email");
			
			if(DatabaseSearch.findUser(email, password_u))
			{
				StringBuffer error = new StringBuffer();
				error.append("<strong>A user with the provided email account information already exists.<br/>");
				session.setAttribute("errors", error.toString());
				response.sendRedirect("./UserRegister.jsp");
			}
			else
			{
				createUser = DatabaseSearch.createUser(firstname_u, lastname_u,password_u, gender, prescription, piercing, tattoo, surgery, pregnancy, dob,phone_number_u, email );
				if(createUser==1)
				 {
					session.setAttribute("errors", "");
					 response.sendRedirect("./endUserRegister.jsp");
				 }
				 else
				 {
					 StringBuffer error = new StringBuffer();
						error.append("<strong>The User account could not be created.<br/>");
						error.append("Please contact administrator.</strong>");
						session.setAttribute("errors", error.toString());
						response.sendRedirect("./UserRegister.jsp");
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
