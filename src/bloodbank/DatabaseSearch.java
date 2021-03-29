package bloodbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DatabaseSearch 
{
	static String firstname_u;
	static String lastname_u;
	static String password_u;
	static String gender;
	static String prescription;
	static String piercing;
	static String tattoo;
	static String surgery;
	static String pregnancy;
	static String dob;
	static String phone_number_u;
	static String email_u;
	static User user;
	static Date date;
	static Time time;
	static int appointment_id;
	static int location_id;
	static int user_id;
	static Appointment app;
	static Location loc;
	static String address_b;
	static String phone_b;
	static String city;
	static String province;
	static String country;
	static String zip_code_b;
	static String email_a;
	static String password_a;
	static int admin_ID;
	static String firstname_a;
	static String lastname_a;
	static String phone_a;
	static int locationID;
	static Admin admin;
	
	public static Boolean findUser(String email, String password)
	{
		boolean value = true;
		try
		{
		email_u=email;
		password_u =password;
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try 
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		Connection con = DriverManager.getConnection(connectionUrl); 
		Statement stm = con.createStatement();
		String query = "SELECT * FROM users WHERE email ='"+email_u+"' AND password_user='"+password_u+"'";
		ResultSet rs = stm.executeQuery(query);
		value = rs.next();
		rs.close();
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		return value;
	}
	
	public static User findUserInfo(String email, String password) throws ClassNotFoundException
	{
		
	try
		{
			password_u = password;
			email_u = email;
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			try 
			{
				Class.forName(driver);
			}
			catch(ClassNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			Connection con = DriverManager.getConnection(connectionUrl); 
			Statement stm = con.createStatement();
			String SQL = "SELECT * FROM users WHERE email ='"+email_u+"' AND password_user='"+password_u+"'";
			ResultSet rs = stm.executeQuery(SQL);
			
			rs.next();
			lastname_u = rs.getString("lastname");
			password_u = rs.getString("password_user");
			gender = rs.getString("gender");
			prescription = rs.getString("prescription");
			piercing = rs.getString("piercing");
			tattoo = rs.getString("tattoo");
			surgery = rs.getString("surgery");
			pregnancy = rs.getString("pregnancy");
			dob = rs.getString("dob");
			email_u = rs.getString("email");
			phone_number_u = rs.getString("phone_number");
			firstname_u = rs.getString("firstname");
			user_id = rs.getInt("user_id");
			user = new User(lastname_u, password_u, gender, prescription, piercing, tattoo, surgery, pregnancy, dob, email_u, phone_number_u, firstname_u, user_id) ;
			rs.close();
		
		}
	catch (SQLException e)
		{
			System.out.println(e);
		}
	
	return user;
}
	public static int updateUser(String prescription,String phone_number_u,String tattoo,String piercing,String surgery, String email, String password, String pregnancy)
	{
		int update=0;
		try
		{
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			try 
			{
				Class.forName(driver);
			}
			catch(ClassNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			Connection con = DriverManager.getConnection(connectionUrl); 
			Statement stm = con.createStatement();
			String query ="UPDATE users SET prescription='"+prescription+"', phone_number='"+phone_number_u+"', tattoo='"+tattoo+"', piercing='"+piercing+"', surgery='"+surgery+"', pregnancy='"+pregnancy+"' WHERE email='"+email+"' AND password_user='"+password+"'";
			update= stm.executeUpdate(query);
		
		}
	catch (SQLException e)
		{
			System.out.println(e);
		}
		return update;
	}
	
	public static int createUser(String firstname_u, String lastname_u,String password_u, String gender, String prescription, String piercing, String tattoo, String surgery, String pregnancy, String dob, String phone_number_u, String email )
	{
		int update=0;
		try
		{
			
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			try 
			{
				Class.forName(driver);
			}
			catch(ClassNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			Connection con = DriverManager.getConnection(connectionUrl); 
			Statement stm = con.createStatement();
			String query ="INSERT INTO users VALUES('"+firstname_u+"','"+lastname_u+"','"+password_u+"','"+gender+"', '"+prescription+"', '"+piercing+"' ,'"+tattoo+"' , '"+surgery+"', '"+pregnancy+"', '"+dob+"', '"+phone_number_u+"', '"+email+"');";
			update= stm.executeUpdate(query);
		
		}
	catch (SQLException e)
		{
			System.out.println(e);
		}
		return update;
	}
	
	public static int findAge(String password, String email )
	{
		int age=0;
		try
		{
			
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			try 
			{
				Class.forName(driver);
			}
			catch(ClassNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			Connection con = DriverManager.getConnection(connectionUrl); 
			Statement stm = con.createStatement();
			String query = "DECLARE @current DATE, @dob DATE SET @current = (select CAST(GETDATE() AS date)) SET @dob = (SELECT dob FROM users where email='"+email+"' AND password_user='"+password+"') "+
					"SELECT DATEDIFF(year, @dob, @current) -  CASE WHEN MONTH(@dob) > MONTH(@current)  OR MONTH(@dob) = MONTH(@current) AND DAY(@dob) > DAY(@current)  THEN 1 ELSE 0 END AS age";
			ResultSet rs = stm.executeQuery(query);
			rs.next();
			age = rs.getInt("age");
		
		}
	catch (SQLException e)
		{
			System.out.println(e);
		}
		return age;
	}
	public static int AppointmentID(String date, String time)
	{
		int appointment_id=0;
		try
		{
			
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			try 
			{
				Class.forName(driver);
			}
			catch(ClassNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			Connection con = DriverManager.getConnection(connectionUrl); 
			Statement stm = con.createStatement();
			String query = "DECLARE @date_a DATE SET @date_a = (SELECT REPLACE(CONVERT(VARCHAR(10), '"+date+"', 111), '/', '-')) SELECT * FROM appointment_date_time WHERE date= @date_a AND time='"+time+"';";
			ResultSet rs = stm.executeQuery(query);
			rs.next();
			appointment_id = rs.getInt("app_date_time_id");
		
		}
	catch (SQLException e)
		{
			System.out.println(e);
		}
		return appointment_id;
	}
	
	public static int userID(String email, String password)
	{
		int user_id=0;
		try
		{
			
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			try 
			{
				Class.forName(driver);
			}
			catch(ClassNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			Connection con = DriverManager.getConnection(connectionUrl); 
			Statement stm = con.createStatement();
			String query = "select user_id from users WHERE email='"+email+"' AND password_user='"+password+"';";
			ResultSet rs = stm.executeQuery(query);
			rs.next();
			user_id = rs.getInt("user_id");
		
		}
	catch (SQLException e)
		{
			System.out.println(e);
		}
		return user_id;
	}
	public static int createAppointment(int app_date_time_id, int location_id, int user_id)
	{
		int update=0;
		try
		{
			
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			try 
			{
				Class.forName(driver);
			}
			catch(ClassNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			Connection con = DriverManager.getConnection(connectionUrl); 
			Statement stm = con.createStatement();
			String query ="INSERT INTO appointment VALUES("+app_date_time_id+","+location_id+","+user_id+");";
			update= stm.executeUpdate(query);
		
		}
	catch (SQLException e)
		{
			System.out.println(e);
		}
		return update;
	}
	public static int locationID(String location_ap)
	{
		int location_id=0;
		try
		{
			
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			try 
			{
				Class.forName(driver);
			}
			catch(ClassNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			Connection con = DriverManager.getConnection(connectionUrl); 
			Statement stm = con.createStatement();
			String query = "select location_id from location_bank WHERE address_b='"+location_ap+"';";
			ResultSet rs = stm.executeQuery(query);
			rs.next();
			location_id = rs.getInt("location_id");
		
		}
	catch (SQLException e)
		{
			System.out.println(e);
		}
		return location_id;
	}
	
	public static Appointment AppointmentInfo(int user)
	{
		try
		{
			
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			try 
			{
				Class.forName(driver);
			}
			catch(ClassNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			Connection con = DriverManager.getConnection(connectionUrl); 
			Statement stm = con.createStatement();
			String query = "select l.date , l.time , a.appointment_id, a.location_id, a.user_id from appointment a inner join appointment_date_time l on l.app_date_time_id=a.app_date_time_id "+
							"where a.user_id="+user+";";
			ResultSet rs = stm.executeQuery(query);
			
	    	while(rs.next())
	    		{	
					date = rs.getDate("date");
					time = rs.getTime("time");
					appointment_id = rs.getInt("appointment_id");
					location_id = rs.getInt("location_id");
					user_id = rs.getInt("user_id");
					
				}
	    	
	    	
			app = new Appointment(date.toString(), time.toString(), appointment_id, location_id, user_id);
			rs.close();
		
		}
	catch (SQLException e)
		{
			System.out.println(e);
		}
		return app;
	}
	public static Location LocationInfo(int loc1)
	{
		try
		{
			
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			try 
			{
				Class.forName(driver);
			}
			catch(ClassNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			Connection con = DriverManager.getConnection(connectionUrl); 
			Statement stm = con.createStatement();
			String query = "select l.location_id , l.address_b , l.phone_b, z.city, z.province, z.country, z.zip_code_b from location_bank l inner join zip_code_bank z on l.zip_code_b=z.zip_code_b "+
							"where l.location_id="+loc1+";";
			ResultSet rs = stm.executeQuery(query);
			
	    	while(rs.next())
	    		{	
					location_id = rs.getInt("location_id");
					address_b = rs.getString("address_b");
					phone_b = rs.getString("phone_b");
					city = rs.getString("city");
					province = rs.getString("province");
					country = rs.getString("country");
					zip_code_b = rs.getString("zip_code_b");
					
				}
	    	
	    	loc = new Location(address_b,phone_b, city, province, country, zip_code_b, location_id);
	    	rs.close();
		
		}
	catch (SQLException e)
		{
			System.out.println(e);
		}
		return loc;
	}
	public static Boolean findAppointment(int user_i)
	{
		boolean value = true;
		try
		{

		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try 
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		Connection con = DriverManager.getConnection(connectionUrl); 
		Statement stm = con.createStatement();
		String query = "SELECT * FROM appointment WHERE user_id ="+user_i+"";
		ResultSet rs = stm.executeQuery(query);
		value = rs.next();
		rs.close();
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		return value;
	}
	public static Boolean finAppointmentID(String date_a, String time_a)
	{
		boolean value = true;
		try
		{

		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try 
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		Connection con = DriverManager.getConnection(connectionUrl); 
		Statement stm = con.createStatement();
		String query = "DECLARE @date_a DATE SET @date_a = (SELECT REPLACE(CONVERT(VARCHAR(10), '"+date_a+"', 111), '/', '-')) SELECT * FROM appointment_date_time WHERE date= @date_a AND time='"+time_a+"';";
		ResultSet rs = stm.executeQuery(query);
		value = rs.next();
		rs.close();
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		return value;
	}
	public static int createAppointmentDateTime(String date_ap, String time_ap)
	{
		int update=0;
		try
		{
			
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			try 
			{
				Class.forName(driver);
			}
			catch(ClassNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			Connection con = DriverManager.getConnection(connectionUrl); 
			Statement stm = con.createStatement();
			String query ="DECLARE @date_a DATE SET @date_a = (SELECT REPLACE(CONVERT(VARCHAR(10), '"+date_ap+"', 111), '/', '-')) INSERT INTO appointment_date_time VALUES(@date_a,'"+time_ap+"');";
			update= stm.executeUpdate(query);
		
		}
	catch (SQLException e)
		{
			System.out.println(e);
		}
		return update;
	}
public static Boolean findAdmin(String email, String password)
	{
		boolean value = true;
		try
		{
		email_a=email;
		password_a =password;
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try 
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		Connection con = DriverManager.getConnection(connectionUrl); 
		Statement stm = con.createStatement();
		String query = "SELECT * FROM admin WHERE email ='"+email_a+"' AND password_admin='"+password_a+"'";
		ResultSet rs = stm.executeQuery(query);
		value = rs.next();
		rs.close();
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		return value;
}

public static Admin findAdminInfo(String email, String password) throws ClassNotFoundException
{
	
try
	{
		password_a = password;
		email_a = email;
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try 
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		Connection con = DriverManager.getConnection(connectionUrl); 
		Statement stm = con.createStatement();
		String SQL = "SELECT * FROM admin WHERE email ='"+email_a+"' AND password_admin='"+password_a+"'";
		ResultSet rs = stm.executeQuery(SQL);
		
		rs.next();
		admin_ID = rs.getInt("admin_id");
		firstname_a = rs.getString("firstname");
		lastname_a = rs.getString("lastname");
		phone_a = rs.getString("phone_number");
		gender = rs.getString("gender");
		email_a = rs.getString("email");
		password_a = rs.getString("password_admin");
		locationID = rs.getInt("location_id");

		admin = new Admin(admin_ID, firstname_a,lastname_a, phone_a,email_a, password_a,locationID, gender);
		rs.close();
	
	}
catch (SQLException e)
	{
		System.out.println(e);
	}

return admin;
}
public static Boolean findDoctor(String certificate_id)
{
	boolean value = true;
	try
	{

	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
	try 
	{
		Class.forName(driver);
	}
	catch(ClassNotFoundException e)
	{
		System.out.println(e.getMessage());
	}
	Connection con = DriverManager.getConnection(connectionUrl); 
	Statement stm = con.createStatement();
	String query = "SELECT * FROM doctor WHERE certificate_id ="+certificate_id+"";
	ResultSet rs = stm.executeQuery(query);
	value = rs.next();
	rs.close();
	}
	catch (SQLException e)
	{
		System.out.println(e);
	}
	
	return value;
}
public static int hospitalID(String name, String address, String zip_c)
{
	int hospital_id=0;
	try
	{
		
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try 
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		Connection con = DriverManager.getConnection(connectionUrl); 
		Statement stm = con.createStatement();
		String query = "select hospital_id from hospital WHERE name_h='"+name+"' AND address_h='"+address+"' AND zip_code_h='"+zip_c+"';";
		ResultSet rs = stm.executeQuery(query);
		rs.next();
		hospital_id = rs.getInt("hospital_id");
	
	}
catch (SQLException e)
	{
		System.out.println(e);
	}
	return hospital_id;
}

public static Boolean findHospitalID(String hospital_name, String hospital_address, String hospital_z_c)
{
	boolean value = true;
	try
	{

	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
	try 
	{
		Class.forName(driver);
	}
	catch(ClassNotFoundException e)
	{
		System.out.println(e.getMessage());
	}
	Connection con = DriverManager.getConnection(connectionUrl); 
	Statement stm = con.createStatement();
	String query = "SELECT * FROM hospital WHERE name_h ='"+hospital_name+"' AND address_h ='"+hospital_address+"' AND zip_code_h ='"+hospital_z_c+"'";
	ResultSet rs = stm.executeQuery(query);
	value = rs.next();
	rs.close();
	}
	catch (SQLException e)
	{
		System.out.println(e);
	}
	
	return value;
}
public static int createDoctor(String cert_id, String firstname_d, String lastname_d, String password, String gender, String phone, int hospital_id)
{
	int update=0;
	try
	{
		
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try 
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		Connection con = DriverManager.getConnection(connectionUrl); 
		Statement stm = con.createStatement();
		String query ="INSERT INTO doctor VALUES('"+cert_id+"','"+firstname_d+"','"+lastname_d+"','"+password+"','"+gender+"','"+phone+"', "+hospital_id+");";
		update= stm.executeUpdate(query);
	
	}
catch (SQLException e)
	{
		System.out.println(e);
	}
	return update;
}
public static Boolean findHospitalZipCode(String hospital_z_c)
{
	boolean value = true;
	try
	{

	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
	try 
	{
		Class.forName(driver);
	}
	catch(ClassNotFoundException e)
	{
		System.out.println(e.getMessage());
	}
	Connection con = DriverManager.getConnection(connectionUrl); 
	Statement stm = con.createStatement();
	String query = "SELECT * FROM zip_code_hospital WHERE zip_code_h ='"+hospital_z_c+"'";
	ResultSet rs = stm.executeQuery(query);
	value = rs.next();
	rs.close();
	}
	catch (SQLException e)
	{
		System.out.println(e);
	}
	
	return value;
}
public static int createHospital(String hospital_name, String hospital_address, String hospital_z_c )
{
	int update=0;
	try
	{
		
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try 
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		Connection con = DriverManager.getConnection(connectionUrl); 
		Statement stm = con.createStatement();
		String query ="INSERT INTO hospital VALUES('"+hospital_name+"','"+hospital_address+"','"+hospital_z_c+"');";
		update= stm.executeUpdate(query);
	
	}
catch (SQLException e)
	{
		System.out.println(e);
	}
	return update;
}
public static int createHospitalZipCode(String hospital_z_c, String hospital_city, String hospital_province, String hospital_country)
{
	int update=0;
	try
	{
		
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try 
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		Connection con = DriverManager.getConnection(connectionUrl); 
		Statement stm = con.createStatement();
		String query ="INSERT INTO zip_code_hospital VALUES('"+hospital_z_c+"','"+hospital_city+"','"+hospital_province+"','"+hospital_country+"');";
		update= stm.executeUpdate(query);
	
	}
catch (SQLException e)
	{
		System.out.println(e);
	}
	return update;
}
public static Boolean findCertificateID(String certificate_id)
{
	boolean value = true;
	try
	{

	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try 
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	Connection con = DriverManager.getConnection(connectionUrl); 
	Statement stm = con.createStatement();
	String query = "SELECT * FROM doctor WHERE certificate_id ='"+certificate_id+"'";
	ResultSet rs = stm.executeQuery(query);
	value = rs.next();
	rs.close();
	}
	catch (SQLException e)
	{
		System.out.println(e);
	}
	
	return value;
}
public static int DeleteDoctorAccount(String certificate_id)
{
	int rows=0;
	try
	{
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			try 
			{
				Class.forName(driver);
			}
			catch(ClassNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			Connection con = DriverManager.getConnection(connectionUrl); 
			Statement stm = con.createStatement();
			String query ="DELETE doctor where certificate_id ='"+certificate_id+"';";
			rows= stm.executeUpdate(query);
		
	}
	catch(SQLException e)
	{
		System.out.println(e);
	}
	return rows;
}
public static int userIDName(String firstname, String lastname, String email)
{
	int user_id=0;
	try
	{
		
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try 
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		Connection con = DriverManager.getConnection(connectionUrl); 
		Statement stm = con.createStatement();
		String query = "select user_id from users WHERE firstname='"+firstname+"' AND lastname='"+lastname+"' AND email='"+email+"';";
		ResultSet rs = stm.executeQuery(query);
		if (rs.next())
			{
			user_id = rs.getInt("user_id");
			}
	
	}
catch (SQLException e)
	{
		System.out.println(e);
	}
	return user_id;
}
public static int DeleteAppointment(int appID)
{
	int rows=0;
	try
	{
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			try 
			{
				Class.forName(driver);
			}
			catch(ClassNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			Connection con = DriverManager.getConnection(connectionUrl); 
			Statement stm = con.createStatement();
			String query ="DELETE appointment where appointment_id ="+appID+";";
			rows= stm.executeUpdate(query);
		
	}
	catch(SQLException e)
	{
		System.out.println(e);
	}
	return rows;
}
public static int createBloodEntry(float liters, String type, String date_d, int user_id)
{
	int update=0;
	try
	{
		
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try 
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		Connection con = DriverManager.getConnection(connectionUrl); 
		Statement stm = con.createStatement();
		String query ="DECLARE @date_d DATE SET @date_d = (SELECT REPLACE(CONVERT(VARCHAR(10), '"+date_d+"', 111), '/', '-')) INSERT INTO blood_type VALUES("+liters+",'"+type+"',@date_d,"+user_id+");";
		update= stm.executeUpdate(query);
	
	}
catch (SQLException e)
	{
		System.out.println(e);
	}
	return update;
}
public static int createBloodEntryLocation(int location_id, int blood_id)
{
	int update=0;
	try
	{
		
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try 
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		Connection con = DriverManager.getConnection(connectionUrl); 
		Statement stm = con.createStatement();
		String query ="INSERT INTO blood_type_location_bank VALUES("+location_id+","+blood_id+");";
		update= stm.executeUpdate(query);
	
	}
catch (SQLException e)
	{
		System.out.println(e);
	}
	return update;
}

public static int createBloodEntryAdmin(int admin_id, int blood_id)
{
	int update=0;
	try
	{
		
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try 
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		Connection con = DriverManager.getConnection(connectionUrl); 
		Statement stm = con.createStatement();
		String query ="INSERT INTO admin_blood_type VALUES("+admin_id+","+blood_id+");";
		update= stm.executeUpdate(query);
	
	}
catch (SQLException e)
	{
		System.out.println(e);
	}
	return update;
}
public static int BloodlID(int user_id, String date)
{
	int blood_id=0;
	try
	{
		
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try 
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		Connection con = DriverManager.getConnection(connectionUrl); 
		Statement stm = con.createStatement();
		String query = "DECLARE @date_d DATE SET @date_d = (SELECT REPLACE(CONVERT(VARCHAR(10), '"+date+"', 111), '/', '-')) select blood_id from blood_type WHERE user_id="+user_id+" AND date_donation=@date_d;";
		ResultSet rs = stm.executeQuery(query);
		rs.next();
		blood_id = rs.getInt("blood_id");
	
	}
catch (SQLException e)
	{
		System.out.println(e);
	}
	return blood_id;
}
public static Boolean findRequestID(int request_id)
{
	boolean value = true;
	try
	{

	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try 
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	Connection con = DriverManager.getConnection(connectionUrl); 
	Statement stm = con.createStatement();
	String query = "SELECT * FROM request WHERE request_id ="+request_id+"";
	ResultSet rs = stm.executeQuery(query);
	value = rs.next();
	rs.close();
	}
	catch (SQLException e)
	{
		System.out.println(e);
	}
	
	return value;
}
public static int updateRequest(int request_id, String new_status)
{
	int update=0;
	try
	{
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try 
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		Connection con = DriverManager.getConnection(connectionUrl); 
		Statement stm = con.createStatement();
		String query ="UPDATE request SET status_r='"+new_status+"' WHERE request_id="+request_id+"";
		update= stm.executeUpdate(query);
	
	}
catch (SQLException e)
	{
		System.out.println(e);
	}
	return update;
}
public static int createAdminRequest(int request_id, int admin_id)
{
	int update=0;
	try
	{
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try 
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		Connection con = DriverManager.getConnection(connectionUrl); 
		Statement stm = con.createStatement();
		String query ="INSERT INTO admin_request VALUES("+admin_id+","+request_id+");";
		update= stm.executeUpdate(query);
	
	}
catch (SQLException e)
	{
		System.out.println(e);
	}
	return update;
}
}
