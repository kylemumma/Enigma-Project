//Kyle Mumma
//APCS Period 1
//Enigma Checkpoint 1

import java.util.*;

public class Enigma {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //init userInput scanner

		System.out.println("Welcome to Kyle's Enigma Machine, please enter a command");
		
		while(true){
			String command = scan.next(); //put first word of input in var
			
			//decides what to do based on user command (encrypt, decrypt, or error)
			if(command.equalsIgnoreCase("ENCRYPT:")){
				System.out.println(encrypt(scan.nextLine()));
			} else if(command.equalsIgnoreCase("DECRYPT:")){
				System.out.println(decrypt(scan.nextLine()));
			} else {
				System.out.println("Invalid input");
				scan.nextLine();
			}
		}
		
	}
	
	public static String encrypt(String message){
		String[] encryptMap = {"N", "S", "F", "O", "X", "J", "D", "T", "P", "W", "H", "Z", "Y", "K", "L", "G", "V", "R", 
				"A", "Q", "M", "B", "U", "I", "E", "C"};
		String newMessage = "";
		for(int i = 1; i < message.length(); i++){
			int charInt = message.charAt(i) - 65;
			if(charInt == 32 - 65 ){ //if its a space leave it
				newMessage += " ";
			} else {
				newMessage += encryptMap[charInt];
			}
		}
		return newMessage;
	}

	public static String decrypt(String message){
		String[] encryptMap = {"S", "V", "Z", "G", "Y", "C", "P", "K", "X", "F", "N", "O", "U", "A",
				"D", "I", "T", "R", "B", "H", "W", "Q", "J", "E", "M", "L"};
		String newMessage = "";
		for(int i = 1; i < message.length(); i++){
			int charInt = message.charAt(i) - 65;
			if(charInt == 32 - 65){ //if its a space leave it
				newMessage += " ";
			} else {
				newMessage += encryptMap[charInt];
			}
		}
		return newMessage;
	}
	
}
