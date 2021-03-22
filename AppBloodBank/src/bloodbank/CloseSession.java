package bloodbank;


import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.*;

public class CloseSession extends HttpServlet 
{
	public void doPost(HttpServletRequest request,
            HttpServletResponse response) 
	throws ServletException, IOException
{

HttpSession session = request.getSession(false);
session.invalidate();
response.sendRedirect("./index.jsp");

}
public void doGet(HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException 
{
doPost(request, response);
}
}