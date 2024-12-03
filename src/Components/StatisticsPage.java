package Components;

import java.awt.Dimension;

import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatisticsPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton incomeButton;
	private JButton expensesButton;
	private ExpensesForm expensesForm;

	/**
	 * Create the panel.
	 */
	public StatisticsPage() {
		setBackground(Color.WHITE);
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
		
		expensesButton.setBounds(89, 0, 89, 23);
		incomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expensesButton.setBorderPainted(false);
				incomeButton.setBorderPainted(true);
			}
		});
		
		expensesForm = new ExpensesForm();
		expensesForm.setBackground(Color.WHITE);
		expensesForm.setBounds(0, 21, 450, 602);
		add(expensesForm);
		expensesForm.setLayout(null);
		

	}

	public ExpensesForm getExpensesForm() {
		return expensesForm;
	}

	public void setExpensesForm(ExpensesForm expensesForm) {
		this.expensesForm = expensesForm;
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
