package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Save {
	
	public static void savePlayerCoordinates() {
		try {
			FileOutputStream outputIt = new FileOutputStream("C:\\Tilerun\\Player.bin");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void getPlayerCoordinates() {
		try {
			FileInputStream inputIt = new FileInputStream("C:\\Tilerun\\Player.bin");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
