package bloodbank;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateDoctorServlet  extends HttpServlet
{

	public void doPost(HttpServletRequest request,
            HttpServletResponse response) 
	{
		try
		{
			int createDoctor;
			int createHospital;
			int createHospital_zip_code;
			int hospital_ID;
			HttpSession session = request.getSession(false);
			String certificate_id = request.getParameter("certificate_id");
			String firstname_d = request.getParameter("firstname");
			String lastname_d = request.getParameter("lastname");
			String password_d = request.getParameter("password");
			String gender_d = request.getParameter("gender");
			String phone_n_d = request.getParameter("phone_n_d");
			String hospital_name= request.getParameter("hospital_name");
			String hospital_address = request.getParameter("hospital_address");
			String hospital_city = request.getParameter("hospital_city");
			String hospital_z_c = request.getParameter("hospital_z_c");
			String hospital_province = request.getParameter("province_h");
			String hospital_country = request.getParameter("country_h");
			
			if(DatabaseSearch.findDoctor(certificate_id))
			{
				StringBuffer error = new StringBuffer();
				error.append("<strong>A Doctor account with the same Certificate ID already exists.<br/>");
				session.setAttribute("errors", error.toString());
				response.sendRedirect("./createDoctorAccount.jsp");
			}
			else
			{
				if(DatabaseSearch.findHospitalID(hospital_name, hospital_address, hospital_z_c))
				{
					hospital_ID=DatabaseSearch.hospitalID(hospital_name, hospital_address, hospital_z_c);
					createDoctor = DatabaseSearch.createDoctor(certificate_id, firstname_d, lastname_d, password_d, gender_d, phone_n_d, hospital_ID);
					if(createDoctor==1)
					 {
							session.setAttribute("errors", "");
							response.sendRedirect("./endDoctorRegister.jsp");
					 }
					 else
					 {
						 	StringBuffer error = new StringBuffer();
							error.append("<strong>The Doctor account could not be created.<br/>");
							error.append("Please validate again.</strong>");
							session.setAttribute("errors", error.toString());
							response.sendRedirect("./createDoctorAccount.jsp");
					 }
				}
				else
				{
					if (DatabaseSearch.findHospitalZipCode(hospital_z_c))
					{
						createHospital = DatabaseSearch.createHospital(hospital_name, hospital_address,hospital_z_c );
						if (createHospital==1)
						{
							hospital_ID=DatabaseSearch.hospitalID(hospital_name, hospital_address, hospital_z_c);
							createDoctor = DatabaseSearch.createDoctor(certificate_id, firstname_d, lastname_d, password_d, gender_d, phone_n_d, hospital_ID);
							if(createDoctor==1)
							 {
									session.setAttribute("errors", "");
									response.sendRedirect("./endDoctorRegister.jsp");
							 }
							 else
							 {
								 	StringBuffer error = new StringBuffer();
									error.append("<strong>The Doctor account could not be created.<br/>");
									error.append("Please validate again.</strong>");
									session.setAttribute("errors", error.toString());
									response.sendRedirect("./createDoctorAccount.jsp");
							 }
						}
						else
						{
							StringBuffer error = new StringBuffer();
							error.append("<strong>Hospital could not be registered.<br/>");
							error.append("Please validate again.</strong>");
							session.setAttribute("errors", error.toString());
							response.sendRedirect("./createDoctorAccount.jsp");
						}
					}
					else
					{
						createHospital_zip_code = DatabaseSearch.createHospitalZipCode(hospital_z_c, hospital_city, hospital_province, hospital_country);
						if (createHospital_zip_code==1)
						{
							createHospital = DatabaseSearch.createHospital(hospital_name, hospital_address,hospital_z_c );
							if (createHospital==1)
							{
								hospital_ID=DatabaseSearch.hospitalID(hospital_name, hospital_address, hospital_z_c);
								createDoctor = DatabaseSearch.createDoctor(certificate_id, firstname_d, lastname_d, password_d, gender_d, phone_n_d, hospital_ID);
								if(createDoctor==1)
								 {
										session.setAttribute("errors", "");
										response.sendRedirect("./endDoctorRegister.jsp");
								 }
								 else
								 {
									 	StringBuffer error = new StringBuffer();
										error.append("<strong>The Doctor account could not be created.<br/>");
										error.append("Please validate again.</strong>");
										session.setAttribute("errors", error.toString());
										response.sendRedirect("./createDoctorAccount.jsp");
								 }
							}
							else
							{
								StringBuffer error = new StringBuffer();
								error.append("<strong>Hospital could not be registered.<br/>");
								error.append("Please validate again.</strong>");
								session.setAttribute("errors", error.toString());
								response.sendRedirect("./createDoctorAccount.jsp");
							}
						}
						else
						{
							StringBuffer error = new StringBuffer();
							error.append("<strong>Hospital Zip Code could not be registered.<br/>");
							error.append("Please validate again.</strong>");
							session.setAttribute("errors", error.toString());
							response.sendRedirect("./createDoctorAccount.jsp");
						}
					}
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