package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import application.Main;

public class StorageList {
	
	private Main main;
	private ArrayList<Room1> temp1;
	private ArrayList<Room2> temp2;
	
	public void saveDoc() throws IOException,NullPointerException {
		File file= new File(".\\files\\storage.data");
		FileOutputStream fos= new FileOutputStream(file);
		ObjectOutputStream oos= new ObjectOutputStream(fos);
		oos.writeObject(temp1);
		
		File file2= new File(".\\files\\storage2.data");
		FileOutputStream fos2= new FileOutputStream(file2);
		ObjectOutputStream oos2= new ObjectOutputStream(fos2);
		
		oos2.writeObject(temp2);
		
		oos.close();
		oos2.close();
		fos.close();
		fos2.close();
	}
	
	public void chargeDoc()throws IOException, ClassNotFoundException {
		File file= new File(".\\files\\storage.data");
		FileInputStream fos= new FileInputStream(file);
		ObjectInputStream oos= new ObjectInputStream(fos);
		
		main.setRoom1m((ArrayList) oos.readObject());
		
		File file2= new File(".\\files\\storage2.data");
		FileInputStream fos2= new FileInputStream(file2);
		ObjectInputStream oos2= new ObjectInputStream(fos2);
		
		main.setRoom2m((ArrayList) oos2.readObject());
		
		oos.close();
		oos2.close();
		fos.close();
		fos2.close();
	}
	
	public void setMain(Main main) {
		this.main=main;
	}
	
	public void chargeList(ArrayList<Room1> r1,ArrayList<Room2> r2) {
		temp1=r1;
		temp2=r2;		
	}
}
