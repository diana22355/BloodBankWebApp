package bloodbank;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewEditRequests extends HttpServlet 
{
	public void doPost(HttpServletRequest request,
            HttpServletResponse response) 
	{
		try
		{
			
			 String requestOption = new String();
			 requestOption = request.getParameter("RequestOption");
			 
			 if(requestOption.equalsIgnoreCase("view"))
			 {
				 response.sendRedirect("./ViewDoctorRequest.jsp");
			 }
			 else
			 {
				 response.sendRedirect("./EditDoctorRequest.jsp");
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
