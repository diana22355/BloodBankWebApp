package bloodbank;


public class User 
{
	
	private String password="";
	private String gender="";
	private String prescription="";
	private String piercing="";
	private String tattoo="";
	private String surgery="";
	private String pregnancy="";
	private String dob="";
 	private String email="";
 	private String phone="";
	private String firstname="";
	private String lastname="";
	private int user_id;
	
public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
public User(String lastname, String password, String gender, String prescription, String piercingn, String tattoo,
			String surgery, String pregnancy, String dob, String email, String phone, String firstname, int user_id) 
	{
		super();
		this.lastname = lastname;
		this.password = password;
		this.gender = gender;
		this.prescription = prescription;
		this.piercing = piercingn;
		this.tattoo = tattoo;
		this.surgery = surgery;
		this.pregnancy = pregnancy;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.firstname = firstname;
		this.user_id=user_id;
	}	
public String getFirstname() 
	{
		return firstname;
	}
public void setFirstname(String firstname) 
	{
		this.firstname = firstname;
	}
public String getLastname()
	{
		return lastname;
	}
public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}
public String getPassword() 
	{
		return password;
	}
public void setPassword(String password)
	{
		this.password = password;
	}
public String getGender() 
	{
		return gender;
	}
public void setGender(String gender) 
	{
		this.gender = gender;
	}
public String getPrescription()
	{
		return prescription;
	}
public void setPrescription(String prescription)
	{
		this.prescription = prescription;
	}
public String getPiercing() 
	{
		return piercing;
	}
public void setPiercing(String piercing)
	{
		this.piercing = piercing;
	}
public String getTattoo()
	{
		return tattoo;
	}
public void setTattoo(String tattoo)
	{
		this.tattoo = tattoo;
	}
public String getSurgery()
	{
		return surgery;
	}
public void setSurgery(String surgery) 
	{
		this.surgery = surgery;
	}
public String getPregnancy() 
	{
		return pregnancy;
	}
public void setPregnancy(String pregnancy) 
	{
		this.pregnancy = pregnancy;
	}
public String getDob()
	{
		return dob;
	}
public void setDob(String dob)
	{
		this.dob = dob;
	}
public String getEmail()
	{
		return email;
	}
public void setEmail(String email)
	{
		this.email = email;
	}
public String getPhone()
	{
		return phone;
	}
public void setPhone(String phone)
	{
		this.phone = phone;
	}
		
}
