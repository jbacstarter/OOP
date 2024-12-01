package Components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import Classes.User;
import Driver.Window;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;

public class ContainerPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private User user = null;
	private JPanel NavPanel;
	private JButton logoutButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton homeButton;
	private StatisticsPage StatPage;
	
	/**
	 * Create the panel.
	 */
	public ContainerPage() {
		setPreferredSize(new Dimension(450, 686));
		setBackground(Color.WHITE);
		setLayout(null);
		
		NavPanel = new JPanel();
		NavPanel.setBounds(0, 619, 450, 67);
		NavPanel.setBackground(Color.WHITE);
		add(NavPanel);
		NavPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		homeButton = new NavButton("");
		homeButton.setIcon(new ImageIcon(ContainerPage.class.getResource("/Resources/home (1).png")));
		NavPanel.add(homeButton);
		
		btnNewButton_2 = new NavButton("New button");
		btnNewButton_2.setIcon(new ImageIcon(ContainerPage.class.getResource("/Resources/bar-chart.png")));
		btnNewButton_2.setText("");
		NavPanel.add(btnNewButton_2);
		
		btnNewButton_1 = new NavButton("New button");
		NavPanel.add(btnNewButton_1);
		
		logoutButton = new NavButton("");
		logoutButton.setIcon(new ImageIcon(ContainerPage.class.getResource("/Resources/logout (2).png")));
		logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 21));

		NavPanel.add(logoutButton);
		
		StatPage = new StatisticsPage();
		StatPage.setBounds(0, 0, 450, 620);
		add(StatPage);
		

		
		onClick();
	}

	



	public JPanel getNavPanel() {
		return NavPanel;
	}

	public void setNavPanel(JPanel navPanel) {
		NavPanel = navPanel;
	}

	public StatisticsPage getStatPage() {
		return StatPage;
	}

	public void setStatPage(StatisticsPage statPage) {
		StatPage = statPage;
	}



	private void onClick() {
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeButton.setBorderPainted(true);
				btnNewButton_1.setBorderPainted(false);
				btnNewButton_2.setBorderPainted(false);
				logoutButton.setBorderPainted(false);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeButton.setBorderPainted(false);
				btnNewButton_1.setBorderPainted(true);
				btnNewButton_2.setBorderPainted(false);
				logoutButton.setBorderPainted(false);
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeButton.setBorderPainted(false);
				btnNewButton_1.setBorderPainted(false);
				btnNewButton_2.setBorderPainted(true);
				logoutButton.setBorderPainted(false);
			}
		});
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeButton.setBorderPainted(false);
				btnNewButton_1.setBorderPainted(false);
				btnNewButton_2.setBorderPainted(false);
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

	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}

	public void setBtnNewButton_1(JButton btnNewButton_1) {
		this.btnNewButton_1 = btnNewButton_1;
	}

	public JButton getBtnNewButton_2() {
		return btnNewButton_2;
	}

	public void setBtnNewButton_2(JButton btnNewButton_2) {
		this.btnNewButton_2 = btnNewButton_2;
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

}
