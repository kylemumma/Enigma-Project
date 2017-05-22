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
			if(command.equalsIgnoreCase("BASICCAESARENCRYPT:")){
				System.out.println(basicCaesarEncrypt(scan.nextLine()));
			} else if (command.equalsIgnoreCase("BASICCAESARDECRYPT:")) {
				System.out.println(basicCaesarDecrypt(scan.nextLine()));
			} else if(command.contains("ADVANCEDCAESARENCRYPT")){
				String shiftStr = scan.next();
				int shiftAmount = Integer.parseInt(shiftStr.substring(0, shiftStr.length() - 1));
				System.out.println(advancedCaesarEncrypt(scan.nextLine(), shiftAmount));
			} else if(command.contains("ADVANCEDCAESARDECRYPT")) {
				String shiftStr = scan.next();
				int shiftAmount = Integer.parseInt(shiftStr.substring(0, shiftStr.length() - 1));
				System.out.println(advancedCaesarDecrypt(scan.nextLine(), shiftAmount));
			} else if(command.equalsIgnoreCase("AFFINEENCRYPT:")){
				System.out.println(affineEncrypt(scan.nextLine()));
			} else if(command.equalsIgnoreCase("AFFINEDECRYPT:")){
				System.out.println(affineDecrypt(scan.nextLine()));
			} else {
				System.out.println("Invalid input");
				scan.nextLine();
			}
		}
		
	}
	
	public static String basicCaesarEncrypt(String message){
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
	
	public static String basicCaesarDecrypt(String message){
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
	
	public static String advancedCaesarEncrypt(String message, int shiftAmount){
		String newMessage = "";
		for(int i = 1; i < message.length(); i++){
			int charInt = message.charAt(i) + shiftAmount;
			if(charInt > 90){ //if it goes past z, bring it back to a
				charInt -= 26;
			} else if(charInt == 32 + shiftAmount){ //if its a space leave it
				charInt = 32;
			}
			newMessage += (char) charInt;
		}
		return newMessage;
	}
	
	public static String advancedCaesarDecrypt(String message, int shiftAmount){
		String newMessage = "";
		for(int i = 1; i < message.length(); i++){
			int charInt = message.charAt(i) - shiftAmount;
			if(charInt < 65 && charInt != (32 - shiftAmount)){ //if it goes before a, bring it up to z
				charInt += 26;
			} else if(charInt == 32 - shiftAmount){ //if its a space leave it
				charInt = 32;
			}
			newMessage += (char) charInt;
		}
		return newMessage;
	}
	
	public static String affineEncrypt(String message){
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

	public static String affineDecrypt(String message){
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
