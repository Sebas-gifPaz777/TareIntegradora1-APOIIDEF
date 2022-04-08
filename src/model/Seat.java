package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Seat {
	
	private String nameFilm;
	private LocalTime start;
	private LocalTime end;
	private String nameOccupant;
	private LocalDate date;
	
	public Seat(LocalTime start, LocalTime end, String nameFilm, String nameOccupant, LocalDate date) {
		this.nameFilm = nameFilm;
		this.start = start;
		this.end = end;
		this.nameOccupant = nameOccupant;
		this.date = date;
	}
	public String getNameFilm() {
		return nameFilm;
	}
	public LocalTime getStart() {
		return start;
	}
	public LocalTime getEnd() {
		return end;
	}
	public String getNameOccupant() {
		return nameOccupant;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setNameOccupant(String name) {
		nameOccupant=name;
	}
	
}
