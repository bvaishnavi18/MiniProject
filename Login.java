package login;
import java.util.*;

public class Login {
	
		   private static final String USERNAME = "username";
		   private static final String PASSWORD = "password";

		   public void run() {
		       Scanner keyboard = new Scanner(System.in);

		       System.out.println("Enter Username: ");
		       String inpUser = keyboard.nextLine();

		       System.out.println("Enter Password: ");
		       String inpPass = keyboard.nextLine(); // reads username and password from console

		       if (inpUser.equals(USERNAME) && inpPass.equals(PASSWORD)) {
		           System.out.println("Login successful!");
		       } else {
		           System.out.println("Invalid username or password!");
		       }
		   }
		


}
