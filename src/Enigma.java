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
		String encryptMap = "QWERTYUIOPASDFGHJKLZXCVBNM";
		String newMessage = "";
		for(int i = 1; i < message.length(); i++){
			int charInt = message.charAt(i);
			if(charInt == 32){ //if its a space leave it
				newMessage += " ";
			} else {
				if(encryptMap.indexOf(charInt) == encryptMap.length() - 1){ //if its at the end of the map, bring it to the beginning
					newMessage += encryptMap.charAt(0);
				} else {
					newMessage += encryptMap.charAt(encryptMap.indexOf(charInt) + 1);
				}
			}
		}
		return newMessage;
	}

	public static String decrypt(String message){
		String encryptMap = "QWERTYUIOPASDFGHJKLZXCVBNM";
		String newMessage = "";
		for(int i = 1; i < message.length(); i++){
			int charInt = message.charAt(i);
			if(charInt == 32){ //if its a space leave it
				newMessage += " ";
			} else {
				if(encryptMap.indexOf(charInt) == 0){ //if its at the end of the map, bring it to the beginning
					newMessage += encryptMap.charAt(encryptMap.length() - 1);
				} else {
					newMessage += encryptMap.charAt(encryptMap.indexOf(charInt) - 1);
				}
			}
		}
		return newMessage;
	}
	
}
