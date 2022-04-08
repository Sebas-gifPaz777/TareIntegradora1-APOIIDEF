package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class CreateEvent {
	
	private ArrayList<Room1> room1;
	private ArrayList<Room2> room2;
	
	public CreateEvent() {
		room1=new ArrayList<>();
		room2=new ArrayList<>();		
	}

	public void checkFilms(LocalTime lt, LocalTime lt2, String type, String name, LocalDate date) throws InterruptionOfHoursException {
		if(type.equalsIgnoreCase("Sala Mini")) {
			for(int i=0;i<room1.size();i++) {
				if(room1.get(i).getArray()[0].getDate().equals(date)) {
					Seat vr=room1.get(i).getArray()[0];
					if((vr.getStart().compareTo(lt)==1 && (vr.getStart().compareTo(lt2)==-1 && vr.getEnd().compareTo(lt2)==1)) || ((vr.getStart().compareTo(lt)==-1 && vr.getEnd().compareTo(lt)==1) &&
							vr.getEnd().compareTo(lt2)==-1) || ((vr.getStart().compareTo(lt)==-1 && vr.getEnd().compareTo(lt)==1) && (vr.getStart().compareTo(lt2)==-1 && vr.getEnd().compareTo(lt2)==1)) || (vr.getStart().compareTo(lt)==1 && vr.getEnd().compareTo(lt2)==-1)
							||(vr.getStart().compareTo(lt)==0 && vr.getEnd().compareTo(lt2)==0) || (vr.getStart().compareTo(lt)==0 && (vr.getStart().compareTo(lt2)==-1 && vr.getEnd().compareTo(lt2)==1)) || ((vr.getStart().compareTo(lt)==-1 && vr.getEnd().compareTo(lt)==1) && vr.getEnd().compareTo(lt2)==0)
							|| (vr.getStart().compareTo(lt)==1 &&vr.getStart().compareTo(lt2)==0) || (vr.getEnd().compareTo(lt)==0 && vr.getEnd().compareTo(lt2)==-1)) {
						throw new InterruptionOfHoursException();
					}
				}
			}
			
			room1.add(new Room1(lt, lt2, name, date));
		}
		else if(type.equalsIgnoreCase("Sala Media")) {
			for(int i=0;i<room2.size();i++) {
				if(room2.get(i).getArray()[0].getDate().equals(date)) {
					Seat vr=room2.get(i).getArray()[0];
					if((vr.getStart().compareTo(lt)==1 && (vr.getStart().compareTo(lt2)==-1 && vr.getEnd().compareTo(lt2)==1)) || ((vr.getStart().compareTo(lt)==-1 && vr.getEnd().compareTo(lt)==1) &&
							vr.getEnd().compareTo(lt2)==-1) || ((vr.getStart().compareTo(lt)==-1 && vr.getEnd().compareTo(lt)==1) && (vr.getStart().compareTo(lt2)==-1 && vr.getEnd().compareTo(lt2)==1)) || (vr.getStart().compareTo(lt)==1 && vr.getEnd().compareTo(lt2)==-1)
							||(vr.getStart().compareTo(lt)==0 && vr.getEnd().compareTo(lt2)==0) || (vr.getStart().compareTo(lt)==0 && (vr.getStart().compareTo(lt2)==-1 && vr.getEnd().compareTo(lt2)==1)) || ((vr.getStart().compareTo(lt)==-1 && vr.getEnd().compareTo(lt)==1) && vr.getEnd().compareTo(lt2)==0)
							|| (vr.getStart().compareTo(lt)==1 &&vr.getStart().compareTo(lt2)==0) || (vr.getEnd().compareTo(lt)==0 && vr.getEnd().compareTo(lt2)==-1)) {
						throw new InterruptionOfHoursException();
					}
				}
			}
			room2.add(new Room2(lt, lt2, name, date));
		}
	}
	
	public ArrayList<Room1> getRoom1(){
		return room1;
	}
	
	public ArrayList<Room2> getRoom2(){
		return room2;
	}
	
	public void setRoom1(ArrayList<Room1>room1) {
		this.room1=room1;
	}
	
	public void setRoom2(ArrayList<Room2>room2) {
		this.room2=room2;
	}
}
