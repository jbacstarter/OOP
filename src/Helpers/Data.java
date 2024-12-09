package Helpers;

import java.awt.Container;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import Classes.User;
import Components.TransactionCard;

public class Data {
	public static File accounts = new File("src/Data/bankaccounts.json");
	public static File users = new File("src/Data/users.json");
	private static int index = 0;
	public static JSONArray getData(File file, Container parent) {
        String jsonTxt = null;
		try {
			jsonTxt = IOUtils.toString(new FileReader(file));
		} catch (FileNotFoundException e) {
			new ErrorHandler( file.getPath()+" not found", null);
		} catch (IOException e) {
			new ErrorHandler("Could not read " + file.toString(), null);
		}
		JSONArray arr = new JSONArray(jsonTxt);
		return arr;
	}
	public static void removeExpense(TransactionCard card, User user) {
		JSONArray arr = getData(accounts, null);
		JSONObject obj = findUser(accounts, user);
		JSONArray exp = user.getAccount().getExpenses();
		if(card.getSelected()!= null) {
			String type =  card.getType().getText();
			double value = Double.parseDouble(card.getPaymentValue().getText().split(" ")[1]);
			user.getAccount().setBudget(user.getAccount().getBudget() + value);
			obj.put("budget", user.getAccount().getBudget());
			for(int i =0 ; i< exp.length();i++) {
				JSONObject ob = exp.getJSONObject(i);
				if(type.equals(ob.getString("type")) && value == ob.getDouble("value")) {
					exp.remove(i);
				}
			}
		}
		obj.put("expenses", exp);
		arr.remove(index);
		arr.put(obj);
		
		FileWriter write;
		try {
			write = new FileWriter(accounts);
			arr.write(write);
			write.flush();
			write.close();
		} catch (IOException e) {
			new ErrorHandler("error in removing transaction", null);
		}
	}
	
	public static void addExpense(User user, String type, String date, double amount) {
		JSONArray arr = getData(accounts, null);
		JSONObject obj = findUser(accounts, user);
		JSONArray exp = user.getAccount().getExpenses();
		user.getAccount().setBudget(user.getAccount().getBudget() - amount);
		obj.put("budget", user.getAccount().getBudget());
		
		JSONObject tempObj = new JSONObject();
		tempObj.put("date", date);
		tempObj.put("type", type);
		tempObj.put("value", amount);
		exp.put(tempObj);
		
		obj.remove("expenses");
		obj.put("expenses", exp);
		arr.remove(index);
		arr.put(obj);
		
		FileWriter write;
		try {
			write = new FileWriter(accounts);
			arr.write(write);
			write.flush();
			write.close();
		} catch (IOException e) {
			new ErrorHandler("error in adding transaction", null);
		}
	}
	
	public static JSONObject findUser(File file, User user) {
		JSONArray arr = getData(file, null);
		JSONObject userObj = null;
		for(int i = 0; i < arr.length();i++) {
			JSONObject obj = arr.getJSONObject(i);
			String username = obj.getString("username");
			String password = obj.getString("password");
			
			if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
				userObj = obj;
				index = i;
			}
			
		}
		
		return userObj;
	}
	
	public static void addFunds(User user, double value) {
		JSONArray arr = getData(accounts, null);
		JSONObject obj = findUser(accounts, user);
		JSONArray exp = user.getAccount().getExpenses();
		
		
		user.getAccount().setInitialBudget(user.getAccount().getInitialBudget() + value);
		obj.remove("originalBudget");
		obj.put("originalBudget", user.getAccount().getInitialBudget());
		user.getAccount().setBudget(user.getAccount().getBudget() + value);
		obj.remove("budget");
		obj.put("budget", user.getAccount().getBudget());
		
		arr.remove(index);
		arr.put(obj);
		
		FileWriter write;
		try {
			write = new FileWriter(accounts);
			arr.write(write);
			write.flush();
			write.close();
		} catch (IOException e) {
			new ErrorHandler("Error found: error in adding funds", null);
		}
	}
	
	public static void resetFunds(User user, double value) {
		JSONArray arr = getData(accounts, null);
		JSONObject obj = findUser(accounts, user);
		user.getAccount().setBudget(0);
		user.getAccount().setInitialBudget(0);
		user.getAccount().setExpenses(new JSONArray());
		
		obj.put("originalBudget", 0);
		obj.put("budget", 0);
		obj.remove("expenses");
		obj.put("expenses", new JSONArray());
		
		arr.remove(index);
		arr.put(obj);
		
		FileWriter write;
		try {
			write = new FileWriter(accounts);
			arr.write(write);
			write.flush();
			write.close();
		} catch (IOException e) {
			new ErrorHandler("Error found: error in adding funds", null);
		}
		
		addFunds(user, value);
	}
}
