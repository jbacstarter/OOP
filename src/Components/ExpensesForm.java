package Components;

import java.awt.Color;

import javax.swing.JPanel;

public class ExpensesForm extends JPanel {

	private static final long serialVersionUID = 1L;
	private ExpenseChart expensesChart = null;
	/**
	 * Create the panel.
	 */
	public ExpensesForm() {
		setBackground(new Color(255, 255, 255));
		expensesChart = new ExpenseChart("Expenses", null);
		expensesChart.getChartPanel().setBackground(Color.WHITE);
		expensesChart.setBackground(Color.WHITE);
		expensesChart.setBounds(0, 0, 450, 274);
		add(expensesChart);
	}
	public ExpenseChart getExpensesChart() {
		return expensesChart;
	}
	public void setExpensesChart(ExpenseChart expensesChart) {
		this.expensesChart = expensesChart;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
