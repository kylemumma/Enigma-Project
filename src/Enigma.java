//Kyle Mumma
//APCS Period 1
//Enigma Checkpoint 3

import java.util.*;

public class Enigma {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //init userInput scanner

		System.out.println("Welcome to Kyle's Enigma Machine, please enter a command");
		
		while(true){
			String command = scan.next(); //put first word of input in var
			
			//decides what to do based on user command (encrypt, decrypt, or error)
			if(command.equalsIgnoreCase("ENCRYPT:")){ //Affine Cipher Encrypt
				System.out.println(affineEncrypt(scan.nextLine()));
			} else if(command.equalsIgnoreCase("DECRYPT:")){ //Affine Cipher Decrypt
				System.out.println(affineDecrypt(scan.nextLine()));
			} else if(command.contains("ENCRYPT")){ //Advanced Caesar Cipher Encrypt
				String shiftStr = scan.next();
				int shiftAmount = Integer.parseInt(shiftStr.substring(0, shiftStr.length() - 1));
				System.out.println(caesarEncrypt(scan.nextLine(), shiftAmount));
			} else if(command.contains("DECRYPT")){ //Advanced Caesar Cipher Decrypt
				String shiftStr = scan.next();
				int shiftAmount = Integer.parseInt(shiftStr.substring(0, shiftStr.length() - 1));
				System.out.println(caesarDecrypt(scan.nextLine(), shiftAmount));
			} else {
				System.out.println("Invalid input");
				scan.nextLine();
			}
		}
		
	}
	
	public static String affineEncrypt(String message){
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

	public static String affineDecrypt(String message){
		String[] decryptMap = {"S", "V", "Z", "G", "Y", "C", "P", "K", "X", "F", "N", "O", "U", "A",
				"D", "I", "T", "R", "B", "H", "W", "Q", "J", "E", "M", "L"};
		String newMessage = "";
		for(int i = 1; i < message.length(); i++){
			int charInt = message.charAt(i) - 65;
			if(charInt == 32 - 65){ //if its a space leave it
				newMessage += " ";
			} else {
				newMessage += decryptMap[charInt];
			}
		}
		return newMessage;
	}
	
	public static String caesarEncrypt(String message, int shiftAmount){
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
	
	public static String caesarDecrypt(String message, int shiftAmount){
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
	
}