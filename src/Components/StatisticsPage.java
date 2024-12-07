package Components;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import org.json.JSONArray;

import Classes.BankAccount;
import Classes.Expense;
import Classes.User;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Random;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class StatisticsPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel PiePanel;
	private User user = null;
	private JPanel design1;
	private JLabel statisticsLabel;
	private JScrollPane listScrollPane;
	private JPanel listPanel;

	/**
	 * Create the panel.
	 */
	public StatisticsPage(User user) {
		this.user = user;
		
		setBackground(Color.WHITE);
		setLayout(null);
		
		PiePanel = new JPanel();
		PiePanel.setBackground(Color.white);
		PiePanel.setBounds(-9, 134, 456, 213);
		add(PiePanel);
		user.getUserChart().getChartPanel().setBorder(new LineBorder(Color.decode("#2b378b"), 3, true));

		
		PiePanel.add(user.getUserChart());
		
		design1 = new JPanel();
		design1.setLayout(null);
		design1.setBackground(new Color(82, 179, 225));
		design1.setBounds(0, 1, 451, 103);
		add(design1);
		
		statisticsLabel = new JLabel("Statistics");
		statisticsLabel.setForeground(Color.WHITE);
		statisticsLabel.setFont(new Font("Dialog", Font.PLAIN, 33));
		statisticsLabel.setBounds(148, 30, 182, 35);
		design1.add(statisticsLabel);
		
		listScrollPane = new JScrollPane();
		listScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listScrollPane.getVerticalScrollBar().setUI(new ModernScrollBarUI());
		listScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		listScrollPane.getViewport().setBackground(Color.WHITE);
		listScrollPane.getViewport().setBorder(null);
		listScrollPane.setBorder(null);
		listScrollPane.setBounds(0, 368, 451, 246);
		add(listScrollPane);
		
		listPanel = new JPanel();
		listPanel.setBorder(null);
		listPanel.setBackground(Color.WHITE);
		listPanel.setLayout(new WrapLayout(WrapLayout.LEFT, 0,0));
		listScrollPane.setViewportView(listPanel);
		
	}

	public void showList() {
		listPanel.removeAll();
		JSONArray exp = user.getAccount().getExpenses();
		if(exp!=null && exp.length()>0 ) {
			
			int total = (int)BankAccount.getTotal(exp);
			for(int i = 0 ; i< Expense.length; i++) {
				StatisticsCard card = new StatisticsCard();
				card.getLoadBar().setMaximum(total);
				card.getLoadBar().setValue((int)BankAccount.getSum(Expense.TYPES[i], exp));
				int percent = Integer.parseInt(card.getLoadBar().getString().split("%")[0]);
				if(percent <40) {
					card.getLoadBar().setForeground(Color.GREEN);
				}else if(percent < 85) {
					card.getLoadBar().setForeground(Color.YELLOW);
				}else{
					card.getLoadBar().setForeground(Color.RED);
				}
				card.getTypeLabel().setText(Expense.TYPES[i]);
				listPanel.add(card);
				listPanel.repaint();
				listPanel.revalidate();
			}
		}else {
			Random rand= new Random();
			for(int i = 0 ; i< Expense.length; i++) {
				StatisticsCard card = new StatisticsCard();
				card.getLoadBar().setMaximum(1000);
				card.getLoadBar().setValue(rand.nextInt(10, 1001));
				int percent = Integer.parseInt(card.getLoadBar().getString().split("%")[0]);
				if(percent <40) {
					card.getLoadBar().setForeground(Color.GREEN);
				}else if(percent < 85) {
					card.getLoadBar().setForeground(Color.YELLOW);
				}else{
					card.getLoadBar().setForeground(Color.RED);
				}
				card.getTypeLabel().setText(Expense.TYPES[i]);
				listPanel.add(card);
				listPanel.repaint();
				listPanel.revalidate();
			}
		}
	}
		
	
	public JPanel getPiePanel() {
		return PiePanel;
	}

	public void setPiePanel(JPanel piePanel) {
		PiePanel = piePanel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public JPanel getDesign1() {
		return design1;
	}

	public void setDesign1(JPanel design1) {
		this.design1 = design1;
	}

	public JLabel getStatisticsLabel() {
		return statisticsLabel;
	}

	public void setStatisticsLabel(JLabel statisticsLabel) {
		this.statisticsLabel = statisticsLabel;
	}

	public JScrollPane getListScrollPane() {
		return listScrollPane;
	}

	public void setListScrollPane(JScrollPane listScrollPane) {
		this.listScrollPane = listScrollPane;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
