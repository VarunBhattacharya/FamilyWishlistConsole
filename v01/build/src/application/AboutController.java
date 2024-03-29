package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AboutController {
	@FXML
	private Circle btn_close_4;
	@FXML
	private Label nmetransfer;
	
	public void myFunction(String ss) {nmetransfer.setText(ss);}
	
	// Event Listener on Circle[#btn_close_2].onMouseClicked
	@FXML
	public void btn_close_win_4(MouseEvent event) {
		// TODO Autogenerated
		System.exit(0);
		System.out.println("Invoked Close Window Button");
	}
	// Event Listener on Rectangle.onMouseClicked
	@FXML
	public void btn_Dashboard(MouseEvent event) {
		// TODO Autogenerated
		System.out.println("Invoked Dashboard Button");
		
		try
		{
			//Close the first page
		    Stage stage1 = (Stage) btn_close_4.getScene().getWindow();
		    stage1.close();
		    //Load the next page
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
		    Parent root = (Parent) loader.load();
		    DashboardController dc = loader.getController();
		    dc.myFunction(nmetransfer.getText());
		    Stage stage = new Stage();
		    stage.setScene(new Scene(root));
		    stage.setTitle("Dashboard");
		    stage.initStyle(StageStyle.UNDECORATED);
		    stage.show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	// Event Listener on Rectangle.onMouseClicked
	@FXML
	public void btn_Wishlist(MouseEvent event) {
		// TODO Autogenerated
		System.out.println("Invoked Wishlist Button");
		
		try
		{
			//Close the first page
		    Stage stage1 = (Stage) btn_close_4.getScene().getWindow();
		    stage1.close();
		    //Load the next page
		    /*
	        FXMLLoader fxmlLoader = new FXMLLoader();
	        fxmlLoader.setLocation(getClass().getResource("Wishlist.fxml"));
	        Scene scene = new Scene(fxmlLoader.load());
	        Stage stage = new Stage();
	        stage.setScene(scene);
	        stage.setTitle("Wishlist");
	        //stage.initStyle(StageStyle.UNDECORATED);
	        stage.show();
	        */
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("Wishlist.fxml"));
		    Parent root = (Parent) loader.load();
		    WishlistController dc = loader.getController();
		    dc.myFunction(nmetransfer.getText());
		    Stage stage = new Stage();
		    stage.setScene(new Scene(root));
		    stage.setTitle("Wishlist");
		    stage.initStyle(StageStyle.UNDECORATED);
		    stage.show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	// Event Listener on Rectangle.onMouseClicked
	@FXML
	public void btn_SwitchUser(MouseEvent event) {
		// TODO Autogenerated
		System.out.println("Invoked SwitchUser Button");
		
		try
		{
			//Close the first page
		    Stage stage1 = (Stage) btn_close_4.getScene().getWindow();
		    stage1.close();
		    //Load the next page
	        FXMLLoader fxmlLoader = new FXMLLoader();
	        fxmlLoader.setLocation(getClass().getResource("LoginPage.fxml"));
	        Scene scene = new Scene(fxmlLoader.load());
	        Stage stage = new Stage();
	        stage.setScene(scene);
	        stage.setTitle("LoginPage");
	        stage.initStyle(StageStyle.UNDECORATED);
	        stage.show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	// Event Listener on Rectangle.onMouseClicked
	@FXML
	public void btn_Exit(MouseEvent event) {
		// TODO Autogenerated
		System.out.println("Invoked Exit Button");
		System.out.println("Thank You for using this Application!!!");
		System.exit(0);
	}
}
