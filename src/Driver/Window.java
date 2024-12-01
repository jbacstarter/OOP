package Driver;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

import org.json.JSONArray;
import org.json.JSONObject;

import Classes.User;
import Components.ContainerPage;
import Components.FormPage;
import Components.LoginForm;
import Helpers.CredentialChecker;
import Helpers.Data;
import Helpers.ErrorHandler;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Window {

	private JFrame window;
	private FormPage formPage = null; 
	private static ContainerPage containerPage = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					new ErrorHandler("window is not working", null);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		window = new JFrame();
		window.getContentPane().setBackground(Color.WHITE);
		window.setResizable(false);
		window.setBounds(100, 100, 450, window.getToolkit().getScreenSize().height);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.getContentPane().setLayout(null);
		formPage = new FormPage();
		containerPage = new ContainerPage();
		formPage.getLoginForm().getLoginButton().addActionListener(new ActionListener() {
			private JProgressBar bar = new JProgressBar(0,100);
			public void actionPerformed(ActionEvent e) {
				Thread.startVirtualThread(new Runnable() {
					
					@Override
					public void run() {
						bar.setStringPainted(true);
						bar.setValue(0);
						bar.setForeground(Color.GREEN);
						bar.setBounds(formPage.getWidth()/6, formPage.getHeight()/2, 300,30);
						formPage.add(bar);
						formPage.update();
							try {
								while(bar.getValue() < 100) {
									Thread.sleep(100);
									bar.setValue(bar.getValue() + new Random().nextInt(5, 15));
								}
							} catch (InterruptedException e) {
								new ErrorHandler("error in thread.sleep\n" + e.getStackTrace(), window);
								
							}
							
							formPage.remove(bar);
							formPage.update();
							loginHandler();
					}
				});
				

			}
			private void loginHandler() {
				LoginForm lForm = formPage.getLoginForm();
				String username =  lForm.getUsernameText().getText();
				String password = String.valueOf(lForm.getPasswordField().getPassword());
				boolean isLogin = checkAccount();

				if(CredentialChecker.checkUsername(username) && CredentialChecker.checkUsername(username) && isLogin) {
	                window.getContentPane().remove(formPage);
	                update();
	                bar.setValue(0);
	                window.getContentPane().add(bar);
	                update();
					try {	
						while(bar.getValue() < 100) {
							Thread.sleep(100);
							bar.setValue(bar.getValue() + new Random().nextInt(5, 15));
						}
					} catch (InterruptedException e) {
						new ErrorHandler("error in thread.sleep\n" + e.getStackTrace(), window);
						
					}
	                window.getContentPane().remove(bar);
	                update();
	                containerPage.setUser(new User(username, password));
	                containerPage.getStatPage().getExpensesChart().updateChart('e', containerPage.getUser().getAccount().getExpenses());
	                window.getContentPane().add(containerPage);
	                update();
				}else if(!CredentialChecker.checkUsername(username)) {
					new ErrorHandler("\nUsername must have:\na length of 4-25 characters;\nno whitespaces;", formPage);
				}else if(!CredentialChecker.checkPassword(password)){
					new ErrorHandler("\nPassword must contain:\nat least one lowercase letter;\nat least one uppercase letter;\nat least one digit;\nat least 8 characters long;", formPage);
				}else {
					new ErrorHandler("Account not found.", formPage);
				}
			}
			
			private boolean checkAccount() {
				boolean isLogin = false;
				LoginForm lForm = formPage.getLoginForm();
				String username =  lForm.getUsernameText().getText();
				String password = String.valueOf(lForm.getPasswordField().getPassword());
				
			JSONArray users = Data.getData(new File("src/Data/users.json"), window);
			
			for(int i =0 ; i < users.length(); i++) {
				JSONObject user = users.getJSONObject(i);
				if(username.contains(user.getString("username")) && password.contains(user.getString("password"))) {
					isLogin = true;
				}
				}
			return isLogin;
		    }
		});
		containerPage.setBounds(0, 0,450,containerPage.getToolkit().getScreenSize().height);
		formPage.setBounds(0, 0, 436, 683);
		window.getContentPane().add(formPage);
	}

	public void update() {
        window.getContentPane().repaint();
        window.getContentPane().revalidate();
	}
	public JFrame getFrame() {
		return window;
	}

	public void setFrame(JFrame frame) {
		this.window = frame;
	}

	public JFrame getWindow() {
		return window;
	}

	public void setWindow(JFrame window) {
		this.window = window;
	}

	public FormPage getFormPage() {
		return formPage;
	}

	public void setFormPage(FormPage formPage) {
		this.formPage = formPage;
	}


}
