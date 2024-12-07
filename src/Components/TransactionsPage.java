package Components;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import org.json.JSONArray;
import org.json.JSONObject;

import Classes.User;
import Helpers.Data;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TransactionsPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel design1;
	private JLabel transactionsLabel;
	private JScrollPane scrollPanel;
	private JPanel listsPanel;
	private JButton addButton;
	private JButton removeButton;
	private User user =null;

	public TransactionsPage(User user) {
		this.user = user;
		
		setBackground(Color.WHITE);
		setLayout(null);
		
		design1 = new JPanel();
		design1.setBackground(Color.decode("#52b3e1"));
		design1.setBounds(0, 0, 451, 103);
		add(design1);
		design1.setLayout(null);
		
		transactionsLabel = new JLabel("Transaction History");
		transactionsLabel.setBounds(108, 29, 234, 35);
		design1.add(transactionsLabel);
		transactionsLabel.setForeground(Color.WHITE);
		transactionsLabel.setFont(new Font("Dialog", Font.PLAIN, 27));
		
		scrollPanel = new JScrollPane();
		scrollPanel.setBorder(null);
		scrollPanel.setBackground(Color.WHITE);
		scrollPanel.getVerticalScrollBar().setUI(new ModernScrollBarUI());
		scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setBounds(0, 151, 451, 461);
		add(scrollPanel);
		
		listsPanel = new JPanel();
		listsPanel.setBackground(Color.WHITE);
		listsPanel.setLayout(new WrapLayout(WrapLayout.CENTER, 0,20));
		scrollPanel.setViewportView(listsPanel);
		
		addButton = new JButton("+");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addButton.setFocusPainted(false);
		addButton.setContentAreaFilled(false);
		addButton.setBorderPainted(false);
		addButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		addButton.setBackground(Color.WHITE);
		addButton.setBounds(315, 127, 52, 23);
		add(addButton);
		
		removeButton = new JButton("-");
		removeButton.setContentAreaFilled(false);
		removeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(TransactionCard.getSelected()!= null) {
					
					Data.removeExpense(TransactionCard.getSelected(), user);
					showLists();
				}
			}
		});
		removeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		removeButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		removeButton.setFocusPainted(false);
		removeButton.setBorderPainted(false);
		removeButton.setBackground(Color.WHITE);
		removeButton.setBounds(377, 127, 52, 23);
		add(removeButton);
		showLists();
		

	}
	
	public void showLists() {
		listsPanel.removeAll();
		listsPanel.repaint();
		listsPanel.revalidate();
		JSONArray expenses = user.getAccount().getExpenses();
		if(expenses.length() > 0 || expenses != null) {
			
			for(int i = 0; i < expenses.length(); i++) {
			TransactionCard card = new TransactionCard();
			JSONObject obj = expenses.getJSONObject(i);
				card.index = i;
				card.getDateLabel().setText(obj.getString("date"));
				card.getType().setText(obj.getString("type"));
				card.getPaymentValue().setText("₱ " + String.valueOf(obj.getDouble("value")));
				listsPanel.add(card);
				listsPanel.repaint();
				listsPanel.revalidate();
			}
		}
	}
}
