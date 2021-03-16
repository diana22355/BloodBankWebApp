package bloodbank;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAdminServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
        { 
          
            HttpSession session = request.getSession(true);
            String email_a = new String();
            String password_a = new String();
            email_a = request.getParameter( "email" ); 
            password_a = request.getParameter( "password" ); 

             if(DatabaseSearch.findAdmin(email_a,password_a))
              			{
            	 			Admin admin = DatabaseSearch.findAdminInfo(email_a, password_a);
            	 			Location loc = DatabaseSearch.LocationInfo(admin.getlocationID());
            	 			session.setAttribute("admin", admin);
            	 			session.setAttribute("location", loc);
            	 			session.setAttribute("errors", "");
            	 			session.setAttribute("email", "");
            	 			session.setAttribute("password", "");
                			response.sendRedirect("./MenuAdmin.jsp");
              			}
              else
                		{
            	  			StringBuffer error = new StringBuffer();
            	  			error.append("<strong>Email or password is incorrect.<br/>");
            	  			error.append("Please try again.</strong>");
            	  			session.setAttribute("errors", error.toString());
            	  			session.setAttribute("email", "");
            	  			session.setAttribute("password", "");
            	  			response.sendRedirect("./loginAdmin.jsp");
                		}
   
        }    
   	 catch (Exception e) 
        {
			System.out.println(e);
            
        }
}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}
}
