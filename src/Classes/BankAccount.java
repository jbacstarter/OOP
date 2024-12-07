package Classes;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;

import Helpers.Data;

public class BankAccount {

	private JSONArray expenses = null;
	private File file = new File("src/Data/bankaccounts.json");
	
	public BankAccount(String user, String pass) {
		getLists(user, pass);
	}
	
	
	private void getLists(String username, String password) {
			 
			JSONArray arr = Data.getData(file, null);
          
           if(arr.length() > 0) {
        	   for(int i = 0; i < arr.length(); i++) {
        		   JSONObject obj =  arr.getJSONObject(i);
        		   String name = obj.getString("username");
        		   String pass = obj.getString("password");
        		   if(name.contains(username) && pass.contains(password)) {
        			   expenses = new JSONArray(obj.getJSONArray("expenses"));
        		   }else {
        			   System.out.println("ACCOUNT NOT FOUND!");
        		   }
        	   }
           }
	}

	public static double getTotal(JSONArray arr) {
		double sum = 0;
    	for(int col = 0;col < arr.length(); col++) {
    		JSONObject obj = arr.getJSONObject(col);
    		double value = obj.getDouble("value");
    		sum+= value;
    	}
    	return sum;
	}
	public static double getSum(String type, JSONArray arr) {
		double result = 0;
		
		if(arr != null && arr.length() > 0) {
			for(int i = 0 ; i < arr.length(); i++) {
				JSONObject obj =  arr.getJSONObject(i);
			String ty =	obj.getString("type");
			if(ty.contains(type)) {
				result += obj.getDouble("value");
			}
			}
		}
		return result;
		
		
	}

	public JSONArray getExpenses() {
		return expenses;
	}




	public void setExpenses(JSONArray expenses) {
		this.expenses = expenses;
	}

}
