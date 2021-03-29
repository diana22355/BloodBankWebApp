package bloodbank;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ModifyRequestServlet extends HttpServlet
{

	public void doPost(HttpServletRequest request,
            HttpServletResponse response) 
	{
		try
		{
			int update_admin_request;
			int update_new_status;
			HttpSession session = request.getSession(false);
			
			int modif_request_ID = Integer.parseInt(request.getParameter("value_request_ID"));
			String new_status = request.getParameter("status");
			
			
			if(DatabaseSearch.findRequestID(modif_request_ID))
			{
				update_new_status = DatabaseSearch.updateRequest(modif_request_ID, new_status);
				if(update_new_status==1)
				{
					Admin admin = (Admin) request.getSession(false).getAttribute("admin");
					update_admin_request = DatabaseSearch.createAdminRequest(modif_request_ID, admin.getAdmin_id());
					if (update_admin_request==1)
					{
					session.setAttribute("errors", "");
					session.setAttribute("status", new_status);
					response.sendRedirect("./endRequestNew_Status.jsp");
					}
					else
					{
						StringBuffer error = new StringBuffer();
						error.append("<strong>Administrator-Request information could not be loaded successfully.<br/>");
						session.setAttribute("errors", error.toString());
						response.sendRedirect("./StatusRequest.jsp");
					}
				}
				else
				{
					StringBuffer error = new StringBuffer();
					error.append("<strong>Request could not be modified successfully.<br/>");
					session.setAttribute("errors", error.toString());
					response.sendRedirect("./StatusRequest.jsp");
				}
		
			}
			else
			{
				StringBuffer error = new StringBuffer();
				error.append("<strong>Please specify a valid Request ID.<br/>");
				session.setAttribute("errors", error.toString());
				response.sendRedirect("./StatusRequest.jsp");
				
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
