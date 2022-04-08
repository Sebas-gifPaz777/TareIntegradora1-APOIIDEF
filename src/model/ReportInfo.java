package model;

import java.util.ArrayList;

import application.Main;

public class ReportInfo {
	
	ArrayList<Room1>r1;
	ArrayList<Room2>r2;
	Main main;
	
	

	public void printReport() {
		
		for(int i=0; i<r1.size();i++) {
			System.out.println(r1.get(i).getArray()[0].getNameFilm()+"-"+r1.get(i).getArray()[0].getDate()+"-"+"Sala Mini");
			for(int j=0;j<r1.get(i).getArray().length;i++) {
				System.out.println(r1.get(i).getArray()[j].getNameOccupant());
			}
			System.out.println("\n");
		}
		for(int i=0; i<r2.size();i++) {
			System.out.println(r2.get(i).getArray()[0].getNameFilm()+"-"+r2.get(i).getArray()[0].getDate()+"-"+"Sala Media");
			for(int j=0;j<r2.get(i).getArray().length;i++) {
				System.out.println(r2.get(i).getArray()[j].getNameOccupant());
			}
			System.out.println("\n");
		}
	}
	
	public void setMain(Main main) {
		this.main=main;
	}
	
	public void chargeList(ArrayList<Room1> r1,ArrayList<Room2> r2) {
		this.r1=r1;
		this.r2=r2;		
	}

}
