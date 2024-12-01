package Components;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatisticsPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton incomeButton;
	private JButton expensesButton;
	private JPanel expensesContainer;
	private PieChart expensesChart;

	/**
	 * Create the panel.
	 */
	public StatisticsPage() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setPreferredSize(new Dimension(450, 625));
		
		incomeButton = new StatButtons("Income");
		incomeButton.setBounds(0, 0, 89, 23);
		add(incomeButton);
		
		expensesButton = new StatButtons("Expenses");
		add(expensesButton);
		
		expensesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expensesButton.setBorderPainted(true);
				incomeButton.setBorderPainted(false);
			}
		});
		
		expensesButton.setBounds(87, 0, 89, 23);
		incomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expensesButton.setBorderPainted(false);
				incomeButton.setBorderPainted(true);
			}
		});
		
		expensesContainer = new JPanel();
		expensesContainer.setBackground(Color.WHITE);
		expensesContainer.setBounds(0, 21, 450, 602);
		add(expensesContainer);
		expensesContainer.setLayout(null);
		
		
		expensesChart = new PieChart("Expenses", 'e', null);
		expensesChart.getChartPanel().setBackground(Color.WHITE);
		expensesChart.setBackground(Color.WHITE);
		expensesChart.setBounds(0, 0, 450, 274);
		expensesContainer.add(expensesChart);
	}

	public JPanel getExpensesContainer() {
		return expensesContainer;
	}

	public void setExpensesContainer(JPanel expensesContainer) {
		this.expensesContainer = expensesContainer;
	}

	public PieChart getExpensesChart() {
		return expensesChart;
	}

	public void setExpensesChart(PieChart expensesChart) {
		this.expensesChart = expensesChart;
	}

	public JButton getIncomeButton() {
		return incomeButton;
	}

	public void setIncomeButton(JButton incomeButton) {
		this.incomeButton = incomeButton;
	}

	public JButton getExpensesButton() {
		return expensesButton;
	}

	public void setExpensesButton(JButton expensesButton) {
		this.expensesButton = expensesButton;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
