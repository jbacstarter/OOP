package Classes;

import java.io.File;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import Helpers.Data;

public class BankAccount {

	private JSONArray expenses = null, income = null;
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
        			   income = new JSONArray(obj.getJSONArray("income"));
        		   }else {
        			   System.out.println("ACCOUNT NOT FOUND!");
        		   }
        	   }
           }
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




	public JSONArray getIncome() {
		return income;
	}




	public void setIncome(JSONArray newIncome) {
		this.income = newIncome;
	}
}
