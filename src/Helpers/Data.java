package Helpers;

import java.awt.Container;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import Classes.User;
import Components.TransactionCard;

public class Data {
	public static File accounts = new File("src/Data/bankaccounts.json");
	public static File users = new File("src/Data/users.json");
	private static int removeIndex = 0;
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
			for(int i =0 ; i< exp.length();i++) {
				JSONObject ob = exp.getJSONObject(i);
				if(type.contains(ob.getString("type")) && value == ob.getDouble("value")) {
					exp.remove(i);
				}
			}
		}
		obj.put("expenses", exp);
		arr.remove(removeIndex);
		arr.put(obj);
		
		FileWriter write;
		try {
			write = new FileWriter(accounts);
			arr.write(write);
			write.flush();
			write.close();
		} catch (IOException e) {
			new ErrorHandler("error found in writing username and password", null);
		}
	}
	
	public static JSONObject findUser(File file, User user) {
		JSONArray arr = getData(file, null);
		JSONObject userObj = null;
		for(int i = 0; i < arr.length();i++) {
			JSONObject obj = arr.getJSONObject(i);
			String username = obj.getString("username");
			String password = obj.getString("password");
			
			if(username.contains(user.getUsername()) && password.contains(user.getPassword())) {
				userObj = obj;
				removeIndex = i;
			}
			
		}
		
		return userObj;
	}
}
