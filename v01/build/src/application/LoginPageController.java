package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.control.PasswordField;

import javafx.scene.input.MouseEvent;

import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginPageController {
	public DbFunctions dbf = new DbFunctions();
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Circle btn_close_1;
	@FXML
	private Label wrongmessage;
	
	// Event Listener on Button.onAction
	@FXML
	public void btnSignUp(ActionEvent event) throws IOException 
	{
		// TODO Autogenerated
		String user = username.getText();
		String pass = password.getText();
		System.out.println("Invoked SignUp Button");
		
		try
		{
			//Close the first page
		    Stage stage1 = (Stage) btn_close_1.getScene().getWindow();
		    stage1.close();
		    //Load the next page
	        FXMLLoader fxmlLoader = new FXMLLoader();
	        fxmlLoader.setLocation(getClass().getResource("SignUpPage.fxml"));
	        Scene scene = new Scene(fxmlLoader.load());
	        Stage stage = new Stage();
	        stage.setScene(scene);
	        stage.setTitle("SignUpPage");
	        stage.initStyle(StageStyle.UNDECORATED);
	        stage.show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}	
	}
	
	
	
	// Event Listener on Button.onAction
	@FXML
	public void btnSignIn(ActionEvent event) throws IOException, SQLException {
		// TODO Autogenerated
		String user = username.getText();
		String pass = password.getText();
		System.out.println("Invoked SignIn Button");
		/*
		try
		{
			if(dbf.signintab(user, pass))
			{
				//Close the first page
			    Stage stage1 = (Stage) btn_close_1.getScene().getWindow();
			    stage1.close();
			    //Load the next page
			    FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
			    Parent root = (Parent) loader.load();
			    DashboardController dc = loader.getController();
			    dc.myFunction(user);
			    Stage stage = new Stage();
			    stage.setScene(new Scene(root));
			    stage.setTitle("Dashboard");
			    //stage.initStyle(StageStyle.UNDECORATED);
			    stage.show();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}*/
		
		int cnt;
		Connection conn = SqliteConnection.DbConnector();
		if(conn == null)
		{
			System.out.println("Connection is not established with the Db");
			System.exit(0);
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
			if(resultSet.next()) 
			{
				cnt = resultSet.getInt(1);
				if(cnt == 1)
				{
					//Close the first page
				    Stage stage1 = (Stage) btn_close_1.getScene().getWindow();
				    stage1.close();
				    //Load the next page
				    FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
				    Parent root = (Parent) loader.load();
				    DashboardController dc = loader.getController();
				    dc.myFunction(user);
				    Stage stage = new Stage();
				    stage.setScene(new Scene(root));
				    stage.setTitle("Dashboard");
				    stage.initStyle(StageStyle.UNDECORATED);
				    stage.show();
				}
				else 
				{
					wrongmessage.setText("*Wrong Credentials");
					username.setText("");
					password.setText("");
					System.out.println("No Value is there.");
				}
			}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Insertion Failed");
			e.printStackTrace();
		}
		finally
		{
			preparedStatement.close();
			//resultSet.close();
		}
		
		
	}
	// Event Listener on Circle[#btn_close_1].onMouseClicked
	@FXML
	public void btn_close_win_1(MouseEvent event) {
		// TODO Autogenerated
		System.exit(0);
		System.out.println("Invoked Close Window Button");
	}
}