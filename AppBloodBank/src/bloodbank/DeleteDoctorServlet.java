package bloodbank;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteDoctorServlet extends HttpServlet
{

	public void doPost(HttpServletRequest request,
            HttpServletResponse response) 
	{
		try
		{
			int deleteDoctor;
			HttpSession session = request.getSession(false);
			String certificate_id = request.getParameter("certificate_id");
			
			if(DatabaseSearch.findCertificateID(certificate_id))
			{
				deleteDoctor = DatabaseSearch.DeleteDoctorAccount(certificate_id);
				if(deleteDoctor==1)
				{
					session.setAttribute("errors", "");
					response.sendRedirect("./endDoctorAccountRemoval.jsp");
				}
				else
				{
					StringBuffer error = new StringBuffer();
					error.append("<strong>Doctor account could not be deleted.<br/>");
					session.setAttribute("errors", error.toString());
					response.sendRedirect("./DeleteDoctorAccount.jsp");
				}
		
			}
			else
			{
				StringBuffer error = new StringBuffer();
				error.append("<strong>Please specify a valid Certificate ID.<br/>");
				session.setAttribute("errors", error.toString());
				response.sendRedirect("./DeleteDoctorAccount.jsp");
				
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