package Components;

import javax.swing.JPanel;

import Helpers.Draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Classes.User;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel welcome;
	private JButton transactionButton;
	private JButton budgetButton;
	private JButton statButton;
	private JLabel appName;
	private UserPage userPage;
	
	public HomePage(UserPage userPage) {
		this.userPage = userPage;
		User user = userPage.getUser();
		JPanel container = userPage.getContainer();
		setBackground(Color.decode("#52b3e1"));
		setLayout(null);
		
		welcome = new JLabel("Welcome!");
		welcome.setFont(new Font("Dialog", Font.PLAIN, 28));
		welcome.setForeground(new Color(255, 255, 255));
		welcome.setBounds(44, 202, 149, 48);
		add(welcome);
		
		transactionButton = new JButton("Transactions");
		transactionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				container.add(userPage.getTransacPage());
				userPage.getTransacPage().showLists();
				container.repaint();
				container.revalidate();
			}
		});
		transactionButton.setIconTextGap(20);
		transactionButton.setIcon(new ImageIcon(HomePage.class.getResource("/Resources/transaction.gif")));
		transactionButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		budgetButton.setFocusPainted(false);
		budgetButton.setFont(new Font("Dialog", Font.BOLD, 21));
		budgetButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		budgetButton.setBackground(Color.WHITE);
		budgetButton.setBounds(44, 347, 354, 60);
		add(budgetButton);
		
		statButton = new JButton("Statistics");
		statButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				container.add(userPage.getStatPage());
				userPage.getStatPage().showList();
				if(user.getAccount().getExpenses().length() > 0) {
					
					user.getUserChart().updateChart(user.getAccount().getExpenses(), "Expenses");
				}else {
					user.getUserChart().updateChart(null, "(NO EXPENSES YET)");
					
				}
				container.repaint();
				container.revalidate();
			}
		});
		statButton.setIcon(new ImageIcon(HomePage.class.getResource("/Resources/test.gif")));
		statButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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

		budgetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				userPage.getBudgetPage().initialize();
				userPage.getBudgetPage().updateLabelPanel();
				container.add(userPage.getBudgetPage());
				container.repaint();
				container.revalidate();
			}
		});
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
