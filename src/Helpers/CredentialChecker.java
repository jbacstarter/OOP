package Helpers;

public class CredentialChecker {

	public static boolean checkUsername(String user) {
		boolean res = false;
		if(user.matches("^[a-zA-Z0-9_-]{4,25}$")) {
			res = true;
		}
		
		return res;
	}
	public static boolean checkPassword(String pass) {
		boolean res = false;
		if(pass.matches("/^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d@.#$!%*?&]{8,15}$/")) {
			res = true;
		}
		
		return res;
	}
}
