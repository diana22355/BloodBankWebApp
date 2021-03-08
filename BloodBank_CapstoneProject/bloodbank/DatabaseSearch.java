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
	
}
