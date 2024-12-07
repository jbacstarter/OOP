package Components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import Classes.User;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;

public class UserPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private User user = new User("john", "John1234");
	private JPanel NavPanel;
	private JButton logoutButton;
	private JButton homeButton;
	private JPanel container;
	private HomePage homePage;
	private JPanel transacPage;
	
	/**
	 * Create the panel.
	 */
	public UserPage() {
		setPreferredSize(new Dimension(450, 686));
		setBackground(Color.WHITE);
		setLayout(null);
		
		NavPanel = new JPanel();
		NavPanel.setBounds(0, 619, 450, 67);
		NavPanel.setBackground(Color.WHITE);
		NavPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		homeButton = new NavButton("");
		homeButton.setIcon(new ImageIcon(UserPage.class.getResource("/Resources/home (1).png")));
		NavPanel.add(homeButton);
		
		logoutButton = new NavButton("");
		logoutButton.setIcon(new ImageIcon(UserPage.class.getResource("/Resources/logout (2).png")));
		logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 21));

		NavPanel.add(logoutButton);

		add(NavPanel);
		
		container = new JPanel();
		container.setBounds(0, 0, 450, 619);
		add(container);
		container.setLayout(null);
		
		transacPage = new TransactionsPage(user);
		transacPage.setBounds(0, 0, 450, 619);
		container.add(transacPage);
		
		homePage = new HomePage();
		homePage.setBounds(0, 0, 450, 619);
		//container.add();
		onClick();
	}

	



	public JPanel getNavPanel() {
		return NavPanel;
	}

	public void setNavPanel(JPanel navPanel) {
		NavPanel = navPanel;
	}



	private void onClick() {
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeButton.setBorderPainted(true);
				logoutButton.setBorderPainted(false);
			}
		});
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeButton.setBorderPainted(false);
				logoutButton.setBorderPainted(true);
			}
		});
	}
	public JPanel getPanel() {
		return NavPanel;
	}

	public void setPanel(JPanel panel) {
		this.NavPanel = panel;
	}

	public JButton getLogoutButton() {
		return logoutButton;
	}

	public void setLogoutButton(JButton logoutButton) {
		this.logoutButton = logoutButton;
	}


	public JButton getHomeButton() {
		return homeButton;
	}

	public void setHomeButton(JButton homeButton) {
		this.homeButton = homeButton;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}





	public JPanel getContainer() {
		return container;
	}





	public void setContainer(JPanel container) {
		this.container = container;
	}





	public HomePage getHomePage() {
		return homePage;
	}





	public void setHomePage(HomePage homePage) {
		this.homePage = homePage;
	}





	public JPanel getTransacPage() {
		return transacPage;
	}





	public void setTransacPage(JPanel transacPage) {
		this.transacPage = transacPage;
	}

}
