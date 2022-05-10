package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbFunctions 
{
	Connection conn = SqliteConnection.DbConnector();
	public boolean signuptab(String name, String username, String password, String email) throws SQLException
	{
		if(conn == null)
		{
			System.out.println("Connection is not established with the Db");
			System.exit(0);
			return false;
		}
		PreparedStatement preparedStatement = null;
		int resultSet = 0;
		String query = "insert into UserList (Name, Username, Password, EmailId) values (?,?,?,?)";
		try 
		{
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, email);
			resultSet = preparedStatement.executeUpdate();
			if(resultSet == 1) {return true;}
			else {return false;}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Insertion Failed");
			e.printStackTrace();
			return false;
		}
		finally
		{
			preparedStatement.close();
			//resultSet.close();
		}
	}
	
	public boolean signintab(String user, String pass) throws SQLException
	{
		if(conn == null)
		{
			System.out.println("Connection is not established with the Db");
			System.exit(0);
			return false;
		}
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		String query = "select count(*) from UserList where Username = (?) and Password = (?)";
		try 
		{
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {return true;}
			else {return false;}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Insertion Failed");
			e.printStackTrace();
			return false;
		}
		finally
		{
			preparedStatement.close();
			//resultSet.close();
		}
		
	}
}
