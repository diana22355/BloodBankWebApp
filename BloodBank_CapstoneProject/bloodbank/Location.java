package bloodbank;



public class Location 
{
	private String address_b="";
	private String phone_b="";
	private String city="";
	private String province="";
	private String country="";
	private String zip_c_b;
	private int location_id;
	
	public Location(String address_b, String phone_b, String city, String province, String country, String zip_c_b,
			int location_id) 
	{
	
		this.address_b = address_b;
		this.phone_b = phone_b;
		this.city = city;
		this.province = province;
		this.country = country;
		this.zip_c_b = zip_c_b;
		this.location_id = location_id;
	}

	public String getAddress_b() {
		return address_b;
	}

	public void setAddress_b(String address_b) {
		this.address_b = address_b;
	}

	public String getPhone_b() {
		return phone_b;
	}

	public void setPhone_b(String phone_b) {
		this.phone_b = phone_b;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip_c_b() {
		return zip_c_b;
	}

	public void setZip_c_b(String zip_c_b) {
		this.zip_c_b = zip_c_b;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	
}
