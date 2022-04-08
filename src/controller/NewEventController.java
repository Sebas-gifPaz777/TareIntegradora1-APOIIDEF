package controller;

import java.time.LocalTime;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.EmptyElementsException;
import model.InterruptionOfHoursException;

public class NewEventController {
	private Main main;
	
	private LocalTime lt;
	
	private LocalTime lt2;
	
	private String type;
	
	@FXML
	private TextField tfName;

	@FXML
	private TextField tfHour;

	@FXML
	private TextField tfMinutes;

	@FXML
	private TextField tfMinutes2;

	@FXML
	private ComboBox<String> cbType;

	@FXML
	private Button btCreate;
	
	@FXML
	private DatePicker dpDate;
	
	public void initialize() {
		ObservableList<String> options = FXCollections.observableArrayList("Sala Mini", "Sala Media");
		cbType.setItems(options);
		
		
		btCreate.setOnAction((ActionEvent b1) ->{
			
			try {
				if(tfName.getText()=="" || tfHour.getText().equals("") || tfMinutes.getText().equals("") || tfMinutes2.getText().equals("") || cbType.getValue().equals("")) {
					System.out.println("ok");
					throw new EmptyElementsException();
				}
				lt=LocalTime.of(Integer.parseInt(tfHour.getText()),Integer.parseInt(tfMinutes.getText()));
				lt2=lt.plusMinutes(Long.parseLong(tfMinutes2.getText()));
				type=cbType.getValue();

				main.createFilm(lt,lt2,type,tfName.getText(),dpDate.getValue());
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Se ha agregado un filme a la programación");
				alert.showAndWait();
				
				main.showMainView();
				
			}catch(EmptyElementsException | InterruptionOfHoursException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Error en la información");
				if(e instanceof EmptyElementsException)
					alert.setContentText("Complete todos los campos en el documento");
				if(e instanceof InterruptionOfHoursException)
					alert.setContentText("Escoja un horario o día diferente");
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
