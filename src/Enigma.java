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
		String newMessage = "";
		for(int i = 1; i < message.length(); i++){
			int charInt = message.charAt(i) + 1;
			if(charInt > 90){ //if it goes past z, bring it back to a
				charInt -= 26;
			} else if(charInt == 33){ //if its a space leave it
				charInt = 32;
			}
			newMessage += (char) charInt;
		}
		return newMessage;
	}

	public static String decrypt(String message){
		String newMessage = "";
		for(int i = 1; i < message.length(); i++){
			int charInt = message.charAt(i) - 1;
			if(charInt < 65 && charInt != 31){ //if it goes before a, bring it up to z
				charInt += 26;
			} else if(charInt == 31){ //if its a space leave it
				charInt = 32;
			}
			newMessage += (char) charInt;
		}
		return newMessage;
	}
	
}
