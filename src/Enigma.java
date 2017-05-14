import java.util.*;


public class Enigma {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //init userInput scanner
		
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
			newMessage += (char) (message.charAt(i) + 1) == '!' ? " " : (char) (message.charAt(i) + 1); //if its a space, don't change it
		}
		return newMessage;
	}

	public static String decrypt(String message){
		String newMessage = "";
		for(int i = 1; i < message.length(); i++){
			newMessage += (char) (message.charAt(i) + 1) == '!' ? " " : (char) (message.charAt(i) - 1);
		}
		return newMessage;
	}
	
}
