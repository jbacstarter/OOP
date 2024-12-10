package Components;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GradientPaint;

import javax.swing.JPasswordField;
import javax.swing.JProgressBar;

import org.json.JSONArray;
import org.json.JSONObject;

import Helpers.CredentialChecker;
import Helpers.Data;
import Helpers.Draw;
import Helpers.ErrorHandler;

import javax.swing.JFormattedTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class RegisterForm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel register;
	private JPasswordField passwordField;
	private JLabel passwordLabel;
	private JFormattedTextField usernameText;
	private JLabel usernameLabel;
	private JLabel returnLabel;
	private JButton registerButton;
	
	private String color1 = "#2b378b"; 
	private String color2 = "#2d4360";
	private JLabel appName;
	/**
	 * Create the panel.
	 */
	public RegisterForm() {
		setBackground(Color.decode("#52b3e1"));
		setLayout(null);
		setPreferredSize(new Dimension(450, getToolkit().getScreenSize().height));
		
		register = new JLabel("Register an account");
		register.setForeground(Color.WHITE);
		register.setBackground(Color.WHITE);
		register.setBounds(77, 175, 324, 63);
		register.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		add(register);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Dialog", Font.BOLD, 30));
		passwordField.setBounds(20, 403, 405, 63);
		add(passwordField);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setBounds(20, 372, 134, 24);
		passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		add(passwordLabel);
		
		usernameText = new JFormattedTextField();
		usernameText.setBorder(null);
		usernameText.setBounds(20, 298, 405, 63);
		usernameText.setFont(new Font("Dialog", Font.BOLD, 30));
		add(usernameText);
		usernameLabel = new JLabel("Name");
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setBounds(20, 263, 84, 24);
		usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		add(usernameLabel);
		
		returnLabel = new JLabel("Sign-In");
		returnLabel.setForeground(new Color(65, 105, 225));
		returnLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				returnLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				returnLabel.setForeground(new Color(65, 105, 225));
			}
		});
		returnLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				returnLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
				returnLabel.setForeground(Color.BLUE);
			}
		});
		returnLabel.setBounds(335, 586, 90, 30);
		returnLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		add(returnLabel);
		
		registerButton = new JButton("SIGN-UP") {
			protected void paintComponent(Graphics g) {
				int w = registerButton.getWidth();
				int h = registerButton.getHeight();
				Graphics2D g2 = (Graphics2D)g;
				GradientPaint gra = new GradientPaint(0,0, Color.decode(color1), w/4,0, Color.decode(color2));
				g2.setPaint(gra);
				g2.fillRoundRect(0, 0, w, h, h, h);
				super.paintComponent(g);
			}
		};
		registerButton.setForeground(Color.BLACK);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread.startVirtualThread(new Runnable() {
					
					@Override
					public void run() {
						
						String username = usernameText.getText();
						String password = String.valueOf(passwordField.getPassword());
						if(CredentialChecker.checkUsername(username) && CredentialChecker.checkPassword(password) && !checkDuplicate()) {
							registerAccount();
							createBankAccount();
							passwordField.setText("");
							usernameText.setText("");
						}else if(!CredentialChecker.checkUsername(username)) {
							new ErrorHandler("\nUsername must have:\na length of 4-25 characters;\nno whitespaces;", getParent());
						}else if(!CredentialChecker.checkPassword(password)){
							new ErrorHandler("\nPassword must contain:\nat least one lowercase letter;\nat least one uppercase letter;\nat least one digit;\nat least 8 characters long;", getParent());
						}else if(checkDuplicate()) {
							new ErrorHandler("user already exists", getParent());
						}else {
							new ErrorHandler("Please enter valid credentials", getParent());
						}
					}
				});
			}
			private boolean checkDuplicate() {
				boolean status = false;
				String user = usernameText.getText();
				File file = new File("src/Data/bankaccounts.json");
				JSONArray arr = Data.getData(file, getParent());
				for(int i = 0; i < arr.length(); i++) {
					String fileUser = arr.getJSONObject(i).getString("username");
					if(fileUser.equals(user)) {
						status = true;
					}
				}
				return status;
			}
			private void createBankAccount() {
				File file = new File("src/Data/bankaccounts.json");
				JProgressBar bar = new JProgressBar(0, 100); 
				bar.setStringPainted(true);
				bar.setValue(0);
				bar.setBounds(getWidth()/6, getHeight()/2, 300,30);
				bar.setForeground(Color.GREEN);
				add(bar);
				repaint();
				revalidate();
				String user = usernameText.getText();
				String pass = String.valueOf(passwordField.getPassword());
				JSONArray arr = Data.getData(file, getParent());
				bar.setValue(45);
				// Delay
				try {
					for(int i = 0; i < 10; i++) {
						Thread.sleep(100);
						bar.setValue(bar.getValue()+ new Random().nextInt(2, 5));
					}
				} catch (InterruptedException e) {
					new ErrorHandler("error in thread;\n" + e.getStackTrace(), getParent());
				}
				JSONObject obj = new JSONObject();
				obj.put("password", pass);
				obj.put("username", user);
				obj.put("expenses", new JSONArray());
				obj.put("budget", 0);
				obj.put("originalBudget", 0);
				
				arr.put(obj);
				
				FileWriter write;
				try {
					write = new FileWriter(file);
					arr.write(write);
					bar.setValue(90);
					write.flush();
					write.close();
				} catch (IOException e) {
					new ErrorHandler("error found in writing username and password", getParent());
				}
				remove(bar);
				repaint();
				revalidate();
			}
			
			private void registerAccount() {
				JProgressBar bar = new JProgressBar(0, 100); 
				bar.setStringPainted(true);
				bar.setValue(0);
				bar.setBounds(getWidth()/6, getHeight()/2, 300,30);
				bar.setForeground(Color.GREEN);
				add(bar);
				repaint();
				revalidate();
				String user = usernameText.getText();
				String pass = String.valueOf(passwordField.getPassword());
				bar.setValue(10);
				addAccount(user, pass, bar);
				JSONArray arr = Data.getData(new File("src/Data/users.json"),getParent());
				JOptionPane.showMessageDialog(getParent(), "Account added: " + arr.getJSONObject(arr.length()-1).getString("username"), "Register", JOptionPane.INFORMATION_MESSAGE);
				bar.setValue(100);
				
				remove(bar);
				repaint();
				revalidate();
				}

			private void addAccount(String user, String pass, JProgressBar bar) {
				File file = new File("src/Data/users.json");
				bar.setValue(15);
				JSONArray arr = Data.getData(file, getParent());
				bar.setValue(45);
				// Delay
				try {
					for(int i = 0; i < 10; i++) {
						Thread.sleep(100);
						bar.setValue(bar.getValue()+4);
					}
				} catch (InterruptedException e) {
					new ErrorHandler("error in thread;\n" + e.getStackTrace(), getParent());
				}
				JSONObject obj = new JSONObject();
				obj.put("password", pass);
				obj.put("username", user);
				
				arr.put(obj);
				
				FileWriter write;
				try {
					write = new FileWriter(file);
					arr.write(write);
					bar.setValue(90);
					write.flush();
					write.close();
				} catch (IOException e) {
					new ErrorHandler("error found in writing username and password", getParent());
				}
			}
		});
		
		registerButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				registerButton.setForeground(Color.WHITE);
				color2 = "#92acdf"; 
				color1 = "#cedaf0";
				registerButton.repaint();
				registerButton.revalidate();
			}
		});
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				registerButton.setForeground(Color.BLACK);
				color1 = "#2b378b"; 
				color2 = "#2d4360";
				registerButton.repaint();
				registerButton.revalidate();
			}
		});
		registerButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		registerButton.setFocusPainted(false);
		registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		registerButton.setContentAreaFilled(false);
		registerButton.setBorder(null);
		registerButton.setBounds(20, 512, 405, 63);
		add(registerButton);
		
		appName = new JLabel("Bantay Budget");
		appName.setForeground(Color.WHITE);
		appName.setFont(new Font("Dialog", Font.PLAIN, 28));
		appName.setBounds(134, 104, 191, 48);
		add(appName);

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		int w = getWidth(), h = getHeight();
		g2.drawImage(Draw.getLogo(), (w/3)+20, 20, 100, 100, null);
	}

	public JLabel getRegister() {
		return register;
	}

	public void setRegister(JLabel register) {
		this.register = register;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JLabel getPasswordLabel() {
		return passwordLabel;
	}

	public void setPasswordLabel(JLabel passwordLabel) {
		this.passwordLabel = passwordLabel;
	}

	public JFormattedTextField getUsernameText() {
		return usernameText;
	}

	public void setUsernameText(JFormattedTextField usernameText) {
		this.usernameText = usernameText;
	}

	public JLabel getUsernameLabel() {
		return usernameLabel;
	}

	public void setUsernameLabel(JLabel usernameLabel) {
		this.usernameLabel = usernameLabel;
	}

	public JLabel getReturnLabel() {
		return returnLabel;
	}

	public void setReturnLabel(JLabel returnLabel) {
		this.returnLabel = returnLabel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
