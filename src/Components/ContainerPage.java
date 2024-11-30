package Components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Cursor;
import javax.swing.ButtonGroup;
import javax.swing.DefaultButtonModel;

public class ContainerPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton logoutButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton homeButton;

	/**
	 * Create the panel.
	 */
	public ContainerPage() {
		setPreferredSize(new Dimension(450, 686));
		setBackground(Color.WHITE);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 619, 450, 67);
		panel.setBackground(Color.WHITE);
		add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		homeButton = new NavButton("");
		homeButton.setIcon(new ImageIcon(ContainerPage.class.getResource("/Resources/home (1).png")));
		panel.add(homeButton);
		
		btnNewButton_2 = new NavButton("New button");
		panel.add(btnNewButton_2);
		
		btnNewButton_1 = new NavButton("New button");
		panel.add(btnNewButton_1);
		
		logoutButton = new NavButton("");
		logoutButton.setIcon(new ImageIcon(ContainerPage.class.getResource("/Resources/logout (2).png")));
		logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 21));

		panel.add(logoutButton);
		
		onClick();
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
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
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
}
