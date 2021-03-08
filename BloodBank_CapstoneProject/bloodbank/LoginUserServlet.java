package bloodbank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginUserServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
        { 
          
            HttpSession session = request.getSession(true);
            String email_u = new String();
            String password_u = new String();
            email_u = request.getParameter( "email" ); 
            password_u = request.getParameter( "password" ); 

             if(DatabaseSearch.findUser(email_u,password_u))
              			{
            	 			User user = DatabaseSearch.findUserInfo(email_u, password_u);
            	 			session.setAttribute("user", user);
            	 			session.setAttribute("errors", "");
            	 			session.setAttribute("email", "");
            	 			session.setAttribute("password", "");
                			response.sendRedirect("./MenuUser.jsp");
              			}
              else
                		{
            	  			StringBuffer error = new StringBuffer();
            	  			error.append("<strong>Email or password is incorrect.<br/>");
            	  			error.append("Please try again.</strong>");
            	  			session.setAttribute("errors", error.toString());
            	  			session.setAttribute("email", "");
            	  			session.setAttribute("password", "");
            	  			response.sendRedirect("./UserSignIn.jsp");
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
