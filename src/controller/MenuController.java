package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {
	
	Main main;

	@FXML
	private Button btRegist;

	@FXML
	private Button btBooking;

	@FXML
	private Button btReport;
	
	@FXML
	public void initialize() {
		btRegist.setOnAction((ActionEvent b1) ->{
			main.showNewEvent();
		});
		
		btBooking.setOnAction((ActionEvent b2) ->{
			main.showPreRoom();
		});
		
		btReport.setOnAction((ActionEvent b3) ->{
			main.showReport();
		});
	}
	
	public void setMain(Main main) {
		this.main=main;
	}
	
	public void chargeDoc() {
		
	}
}
