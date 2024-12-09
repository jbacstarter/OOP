package Classes;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;

import Helpers.Data;
import Helpers.ErrorHandler;

public class BankAccount {

	private JSONArray expenses = null;
	private double budget = 0;
	private double initialBudget = 0;
	private File file = new File("src/Data/bankaccounts.json");
	
	public BankAccount(String user, String pass) {
		getValues(user, pass);
	}
	
	
	private void getValues(String username, String password) {
			 
			JSONArray arr = Data.getData(file, null);
          
           if(arr.length() > 0) {
        	   for(int i = 0; i < arr.length(); i++) {
        		   JSONObject obj =  arr.getJSONObject(i);
        		   String name = obj.getString("username");
        		   String pass = obj.getString("password");
        		   if(name.equals(username) && pass.equals(password)) {
        			   expenses = new JSONArray(obj.getJSONArray("expenses"));
        			   budget = obj.getDouble("budget");
        			   initialBudget = obj.getDouble("originalBudget");
        		   }else {
        			   System.err.println("Account not found!");
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
			if(ty.equals(type)) {
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


	public double getBudget() {
		return budget;
	}


	public void setBudget(double budget) {
		this.budget = budget;
	}


	public double getInitialBudget() {
		return initialBudget;
	}


	public void setInitialBudget(double initialBudget) {
		this.initialBudget = initialBudget;
	}

}
