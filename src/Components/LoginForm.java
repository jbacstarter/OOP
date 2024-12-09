package Components;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPasswordField;

import Helpers.Draw;

import javax.swing.JFormattedTextField;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;

public class LoginForm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JLabel passwordLabel;
	private JFormattedTextField usernameText;
	private JLabel usernameLabel;
	private JLabel registerLabel;
	private JButton loginButton;

	
	private String color1 = "#2b378b"; 
	private String color2 = "#2d4360";
	private JLabel appName;
	/**
	 * Create the panel.
	 */
	public LoginForm() {
		setBackground(Color.decode("#52b3e1"));
		setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Dialog", Font.BOLD, 30));
		passwordField.setBounds(20, 399, 402, 64);
		add(passwordField);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		passwordLabel.setBounds(20, 365, 215, 33);
		add(passwordLabel);
		
		usernameText = new JFormattedTextField();
		usernameText.setFont(new Font("Dialog", Font.BOLD, 30));
		usernameText.setBounds(20, 281, 402, 64);
		add(usernameText);
		
		usernameLabel = new JLabel("Username");
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		usernameLabel.setBounds(20, 250, 215, 30);
		add(usernameLabel);
		
		registerLabel = new JLabel("Register Account");
		registerLabel.setForeground(new Color(65, 105, 225));
		registerLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				registerLabel.setForeground(new Color(65, 105, 225));
				registerLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		registerLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				registerLabel.setForeground(Color.BLUE);
				registerLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		registerLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		registerLabel.setBounds(231, 568, 191, 33);
		add(registerLabel);
		
		
		loginButton = new JButton("SIGN-IN") {
			@Override
			protected void paintComponent(Graphics g) {
				int w = loginButton.getWidth();
				int h = loginButton.getHeight();
				Graphics2D g2 = (Graphics2D)g;
				GradientPaint gra = new GradientPaint(0,0, Color.decode(color1), w/4,0, Color.decode(color2));
				g2.setPaint(gra);
				g2.fillRoundRect(0, 0, w, h, h, h);
				super.paintComponent(g);
			}
		};
		loginButton.setForeground(Color.BLACK);
		loginButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				loginButton.setForeground(Color.WHITE);
				color2 = "#92acdf"; 
				color1 = "#cedaf0";
				loginButton.repaint();
				loginButton.revalidate();
			}
		});
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				loginButton.setForeground(Color.BLACK);
				color1 = "#2b378b"; 
				color2 = "#2d4360";
				loginButton.repaint();
				loginButton.revalidate();
			}
		});
		loginButton.setContentAreaFilled(false);
		loginButton.setBorder(null);
		loginButton.setFocusPainted(false);
		loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		loginButton.setBounds(20, 493, 403, 64);
		add(loginButton);
		
		appName = new JLabel("Bantay Budget");
		appName.setForeground(Color.WHITE);
		appName.setFont(new Font("Dialog", Font.PLAIN, 30));
		appName.setBounds(122, 162, 222, 48);
		add(appName);
	}

	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		int w = getWidth(), h = getHeight();
		g2.drawImage(Draw.getLogo(), (w/4)+30, 20, 150, 150, null);
	}
	public JButton getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(JButton btnNewButton) {
		this.loginButton = btnNewButton;
	}



	public String getColor1() {
		return color1;
	}

	public void setColor1(String color1) {
		this.color1 = color1;
	}

	public String getColor2() {
		return color2;
	}

	public void setColor2(String color2) {
		this.color2 = color2;
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

	public JLabel getRegisterLabel() {
		return registerLabel;
	}

	public void setRegisterLabel(JLabel registerLabel) {
		this.registerLabel = registerLabel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
