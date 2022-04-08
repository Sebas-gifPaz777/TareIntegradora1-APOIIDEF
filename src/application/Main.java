package application;
	
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import controller.Cinema1Controller;
import controller.Cinema2Controller;
import controller.LoginController;
import controller.MenuController;
import controller.NewEventController;
import controller.PreRoomController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.CreateEvent;
import model.InterruptionOfHoursException;
import model.Login;
import model.PasswordNotMatchException;
import model.ReportInfo;
import model.Room1;
import model.Room2;
import model.StorageList;
import model.UserNotFoundException;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private Login login;
	private Stage currentStage;
	private CreateEvent ce;
	private ReportInfo ri;
	private StorageList sl;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			showLogin();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showLogin() {
		try {
			
			BorderPane root;
			
			FXMLLoader loader= new FXMLLoader(getClass().getResource("../ui/Login.fxml"));
			root= (BorderPane)loader.load();
			
			LoginController controller=loader.getController();
			controller.setMain(this);
			
			
			Scene scene=new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../ui/application.css").toExternalForm());
			
			Stage stage= new Stage();
			stage.setScene(scene);
			stage.show();
			currentStage=stage;
			login=new Login();
			ce= new CreateEvent();
			sl= new StorageList();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void checkUser(String password, String id) throws UserNotFoundException, PasswordNotMatchException {
			login.searchInfor(password, id);
	}
	
	public void showMainView() {
		try {
			BorderPane root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Menu.fxml"));
			BorderPane list1= (BorderPane)loader.load();
			
			Stage stage = currentStage;
			MenuController controller=loader.getController();
			
			controller.setMain(this);
			
			
			root = (BorderPane)stage.getScene().getRoot();
			root.setCenter(null);
			root.setCenter(list1);
			//stage.setHeight(list1.getPrefHeight());
			//stage.setWidth(list1.getPrefWidth());	
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public void showNewEvent() {
		try {
			BorderPane root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/NewEvent.fxml"));
			BorderPane list1= (BorderPane)loader.load();
			
			Stage stage = currentStage;
			NewEventController controller=loader.getController();
			
			controller.setMain(this);
			
			root = (BorderPane)stage.getScene().getRoot();
			root.setCenter(null);
			root.setCenter(list1);
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void showPreRoom() {
		try {
			BorderPane root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/PreRoom.fxml"));
			BorderPane list1= (BorderPane)loader.load();
			
			Stage stage = currentStage;
			PreRoomController controller=loader.getController();
			
			controller.setMain(this);
			
			root = (BorderPane)stage.getScene().getRoot();
			root.setCenter(null);
			root.setCenter(list1);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void createFilm(LocalTime lt, LocalTime lt2, String type, String text, LocalDate date) throws InterruptionOfHoursException {
		ce.checkFilms( lt, lt2, type, text, date);
	}
	
	public ArrayList<Room1> getRoom1() {
		ArrayList<Room1>gt=ce.getRoom1();
		return gt; 
	}
	
	public ArrayList<Room2> getRoom2(){
		ArrayList<Room2>gt=ce.getRoom2();
		return gt; 
	}
	
	public void setRoom1m(ArrayList<Room1>room1) {
		ce.setRoom1(room1);
	}
	
	public void setRoom2m(ArrayList<Room2>room2) {
		ce.setRoom2(room2);
	}

	public void showCinema1() {
		try {
			BorderPane root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Cinema1.fxml"));
			BorderPane list1= (BorderPane)loader.load();
			
			Stage stage = currentStage;
			Cinema1Controller controller=loader.getController();
			
			controller.setMain(this);
			
			
			root = (BorderPane)stage.getScene().getRoot();
			root.setCenter(null);
			root.setCenter(list1);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void showCinema2() {
		try {
			BorderPane root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Cinema2.fxml"));
			BorderPane list1= (BorderPane)loader.load();
			
			Stage stage = currentStage;
			Cinema2Controller controller=loader.getController();
			
			controller.setMain(this);
			controller.chargeList();
			
			root = (BorderPane)stage.getScene().getRoot();
			root.setCenter(null);
			root.setCenter(list1);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showReport() {
		ri= new ReportInfo();
		ri.setMain(this);
		ri.chargeList(getRoom1(), getRoom2());
		ri.printReport();
	}
	
	public void chargeList() {
		try {
			sl.chargeDoc();
		} catch (ClassNotFoundException | IOException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error en información ");
			alert.setContentText("Occurió un error al cargar la información");
			
		}
	}
	
	public void saveList() {
		try {
			sl.chargeList(getRoom1(), getRoom2());
			sl.saveDoc();
		} catch (NullPointerException | IOException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error en información ");
			if(e instanceof NullPointerException)
				alert.setContentText("Occurió un error al cargar la lista");
			else
				alert.setContentText("Occurió un error al guardar la información");
			alert.showAndWait();
		}
		
	}
	
	
}
