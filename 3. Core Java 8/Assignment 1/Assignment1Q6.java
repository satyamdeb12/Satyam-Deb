package Assignment1;

import java.util.Scanner;

class Login {
	String userId = "Ajay", password = "password";
	int count=3;
	public String loginUser(String user, String pass) {
		
		if(user.equals(userId) && pass.equals(password) ){
			return "Welcome "+user;
		}
		else {
			if(count==1) {
				count--;
				return "Contact Admin";
			}
			else {
				count--;
				return "You have entered incorrect credentials";
			}
			
		}
		
	}

}

public class Assignment1Q6 {
	public static void main(String[] args) {
		String user = "", pass = "", result;
		Login login = new Login();
		Scanner scanner = new Scanner(System.in);

		while(login.count>0) {
			System.out.println("Enter userId");
			user = scanner.nextLine();
			System.out.println("Enter password");
			pass = scanner.nextLine();
			
			result = login.loginUser(user, pass);
			if(result=="Contact Admin" || result == "You have entered incorrect credentials") {
				System.out.println(result);
				continue;
			}
			System.out.println(result);
			scanner.close();
			break;
		}
		
	}
}