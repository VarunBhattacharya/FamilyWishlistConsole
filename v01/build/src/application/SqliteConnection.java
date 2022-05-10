package application;

import java.sql.*;

public class SqliteConnection {
	public static Connection DbConnector()
	{
		try
		{
			Connection conn = null;
			Class.forName("org.sqlite.JDBC");
			conn =DriverManager.getConnection("jdbc:sqlite:FamilyWish.sqlite");
			return conn;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
}
