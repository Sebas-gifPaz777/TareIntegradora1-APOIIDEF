package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import model.EmptyElementsException;

public class PreRoomController {
	
	private Main main;
	
	@FXML
	private Button btNext;
	
	@FXML
	private RadioButton rbMediun;

	@FXML
	private RadioButton rbMini;
	
	public void initialize() {
	
		btNext.setOnAction((ActionEvent e) ->{
			try {		
				if(rbMini.isSelected())
					main.showCinema1();
				else if(rbMediun.isSelected())
					main.showCinema2();
				else
					throw new EmptyElementsException();
			}catch(EmptyElementsException emptyElementsException) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Error en la información");
				alert.setContentText("Escoja una opción");
				alert.showAndWait();
			}
		});
	}
	 
	public void setMain(Main main) {
		this.main=main;
	}
	
	@FXML
	public void backScene() {
		main.showMainView();
	}
}
