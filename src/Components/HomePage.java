package Components;

import javax.swing.JPanel;

import Helpers.Draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class HomePage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel welcome;
	private JButton transactionButton;
	private JButton budgetButton;
	private JButton statButton;
	private JLabel appName;

	
	public HomePage() {
		setBackground(Color.decode("#52b3e1"));
		setLayout(null);
		
		welcome = new JLabel("Welcome!");
		welcome.setFont(new Font("Dialog", Font.PLAIN, 28));
		welcome.setForeground(new Color(255, 255, 255));
		welcome.setBounds(44, 202, 149, 48);
		add(welcome);
		
		transactionButton = new JButton("Transactions");
		transactionButton.setIconTextGap(20);
		transactionButton.setIcon(new ImageIcon(HomePage.class.getResource("/Resources/transaction.gif")));
		transactionButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		transactionButton.setBorderPainted(false);
		transactionButton.setFocusPainted(false);
		transactionButton.setFont(new Font("Dialog", Font.BOLD, 21));
		transactionButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		transactionButton.setBackground(Color.WHITE);
		transactionButton.setBounds(44, 261, 354, 60);
		add(transactionButton);
		
		budgetButton = new JButton("Budget");
		budgetButton.setIcon(new ImageIcon(HomePage.class.getResource("/Resources/budg.gif")));
		budgetButton.setIconTextGap(20);
		budgetButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		budgetButton.setBorderPainted(false);
		budgetButton.setFocusPainted(false);
		budgetButton.setFont(new Font("Dialog", Font.BOLD, 21));
		budgetButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		budgetButton.setBackground(Color.WHITE);
		budgetButton.setBounds(44, 347, 354, 60);
		add(budgetButton);
		
		statButton = new JButton("Statistics");
		statButton.setIcon(new ImageIcon(HomePage.class.getResource("/Resources/test.gif")));
		statButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		statButton.setBorderPainted(false);
		statButton.setFocusPainted(false);
		statButton.setFont(new Font("Dialog", Font.BOLD, 21));
		statButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		statButton.setBackground(Color.WHITE);
		statButton.setBounds(44, 438, 354, 60);
		add(statButton);
		
		appName = new JLabel("Bantay Budget");
		appName.setForeground(Color.WHITE);
		appName.setFont(new Font("Dialog", Font.PLAIN, 28));
		appName.setBounds(131, 108, 191, 48);
		add(appName);

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		int w = getWidth(), h = getHeight();
		g2.drawImage(Draw.getLogo(), (w/3)+20, 20, 100, 100, null);
	}
	
	public JLabel getWelcome() {
		return welcome;
	}
	public void setWelcome(JLabel welcome) {
		this.welcome = welcome;
	}
	public JButton getTransactionButton() {
		return transactionButton;
	}
	public void setTransactionButton(JButton transactionButton) {
		this.transactionButton = transactionButton;
	}
	public JButton getBudgetButton() {
		return budgetButton;
	}
	public void setBudgetButton(JButton budgetButton) {
		this.budgetButton = budgetButton;
	}
	public JButton getStatButton() {
		return statButton;
	}
	public void setStatButton(JButton statButton) {
		this.statButton = statButton;
	}
	public JLabel getAppName() {
		return appName;
	}
	public void setAppName(JLabel appName) {
		this.appName = appName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
