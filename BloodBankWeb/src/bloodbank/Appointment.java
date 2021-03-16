package bloodbank;


public class Appointment 
{
	private String date="";
	private String time="";
	private int appointment_id;
	private int location_id;
	private int user_id;
	
	public Appointment(String date, String time, int appointment_id, int location_id, int user_id) {
		this.date = date;
		this.time = time;
		this.appointment_id = appointment_id;
		this.location_id = location_id;
		this.user_id = user_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}
