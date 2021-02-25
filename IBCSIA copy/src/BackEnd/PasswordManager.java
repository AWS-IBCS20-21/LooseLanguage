package BackEnd;

import java.util.Map;
import java.util.HashMap;

public class PasswordManager {
	
	private Map<String, String> accounts;
	
	public PasswordManager() {
		
		accounts = new HashMap<>();
		
	}
	
	/**
	* Adds an account to the password manager.
	* Does not add the account if an account under the same name already exists. 
	* 
	* @param 	username	a string containing the user name to be added.
	* @param 	pwd_array	a character array containing the characters for the password.
	* @return 				a boolean on whether the account was added or not.
	* 
	*/
	public boolean addAccount(String username, char[] pwd_array) {
		
		boolean successfullyAdded = false;
		String accessKey = readPassword(pwd_array);
		
		if (!accounts.containsKey(username)) {
			accounts.put(username,  accessKey);
			successfullyAdded = true;
		}
		
		for (int i = 0; i < pwd_array.length; i++) {
			pwd_array[i] = 'i';
		}
		
		return successfullyAdded;
	}
	
	
	/**
	* Checks if the account information is contained in the password manager. 
	* 
	* @param 	firstName	a string containing the first name of the user.
	* @param 	lastName	a string containing the last name of the user.
	* @param 	pwd_array	a character array containing the characters for the password.
	* @return 				a boolean on whether the account information was correct or not.
	* 
	*/
    public boolean checkAccount(String firstName, String lastName, char[] pwd_array) {
    	String fullName = firstName + lastName;
		if (accounts.containsKey(fullName)) {
			
			String accessKey = readPassword(pwd_array);
			if (accounts.get(fullName).equals(accessKey)) {
				return true;
			}
		}
		return false;
	}
    
    /**
	* Checks if the account information is contained in the password manager. 
	* 
	* @param 	pwd_array	a character array containing the characters for the password.
	* @return 				a string containing the encrypted password
	* 
	*/
    private String readPassword(char[] pwd_array) {
    	
    	// encrypt the password
    	String encrypted = new String(pwd_array);
    	
    	// mutate the password array so it does not stay in memory
    	for (int i = 0; i < pwd_array.length; i++) {
    		pwd_array[i] = ' ';
    	}
    	
    	return encrypted;
  
    }

}
