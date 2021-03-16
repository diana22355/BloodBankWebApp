package bloodbank;

public class Admin 
{

	private int admin_id;
	private String firstname="";
	private String lastname="";
	private String phone="";
	private String email="";
	private String password="";
	private int locationID;
	private String gender;

	public Admin(int admin_id, String firstname, String lastname, String phone, String email, String password,
			int locationID, String gender) 
	{
		this.admin_id = admin_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.locationID = locationID;
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getlocationID() {
		return locationID;
	}

	public void setlocationID(int locationID) {
		this.locationID = locationID;
	}
	
}
