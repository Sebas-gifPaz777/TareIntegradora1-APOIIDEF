package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.PasswordNotMatchException;
import model.UserNotFoundException;

public class LoginController {
	
	Main main;
	
	@FXML
	private TextField tfUser;

	@FXML
	private PasswordField tpPassword;
	
	 @FXML
	 private Button btLogin;

	 @FXML
	 public void logIn(ActionEvent event) {
		 try {
				main.checkUser(tpPassword.getText(),tfUser.getText());
				main.showMainView();
			} catch (UserNotFoundException | PasswordNotMatchException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Usuario no autorizado");
				if(e instanceof UserNotFoundException) 
					alert.setContentText("Debe ingresar un usuario valido");				
				else  
					alert.setContentText("La contraseña es incorrecta");
				alert.show();
				
			}
		 
	 }
	
	public void setMain(Main main) {
		this.main=main;
	}
}
