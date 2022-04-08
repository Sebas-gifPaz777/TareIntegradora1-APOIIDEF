package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Login {
	
	ArrayList<User> listUsers;
	
	public Login() throws IOException {
		listUsers= new ArrayList<>();
		
		File file = new File(".\\files\\users.txt");

		FileReader fr = new FileReader(file);

		BufferedReader input = new BufferedReader(fr);

		String line=input.readLine();
		while (input.ready()) {
			
			
			String [] data = line.split(";");

			String id = data[0];
			String pass = data[1];
			listUsers.add(new User(id,pass));
			line = input.readLine();
		}
		
		input.close();
		fr.close();
	}
	
	public void searchInfor(String password, String id) throws UserNotFoundException, PasswordNotMatchException {
			
		boolean idc=false;
		int c=0;
		
		for(int i=0;i<listUsers.size()&& idc==false;i++) {
			if(listUsers.get(i).getId().equals(id)) {
				idc=true;
				c=i;
			}
		}
		if (idc==false) {
			throw new UserNotFoundException();
		}
		else if(!listUsers.get(c).getPassword().equals(password)) {
			throw new PasswordNotMatchException();
		}
	}
}
