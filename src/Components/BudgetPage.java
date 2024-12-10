package Components;

import javax.swing.JPanel;

import Classes.BankAccount;
import Classes.User;
import Helpers.Data;
import Helpers.ErrorHandler;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class BudgetPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel design1;
	private JLabel budgetLabel;
	private JPanel setPanel;
	private JRadioButton increaseBudget;
	private JRadioButton resetBudget;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField amountField;
	private JLabel amountLabel;
	private JButton setButton;
	private JPanel labelPanel;
	private JLabel budgetAmoutLabel;
	private JLabel totalExpensesLabel;
	private JLabel lblFundsLeft;
	private JLabel budgetLabelAmount;
	private JLabel fundsLeftAmount;
	private JLabel totalExpensesAmount;
	private User user = null;
	/**
	 * Create the panel.
	 */
	public BudgetPage(User user) {
		this.user = user;
		initialize();
	}
	public void initialize() {
		removeAll();
		setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		setBackground(Color.WHITE);
		setLayout(null);
		design1 = new JPanel();
		design1.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		design1.setLayout(null);
		design1.setBackground(new Color(82, 179, 225));
		design1.setBounds(0, 0, 451, 88);
		add(design1);
		
		budgetLabel = new JLabel("Budget");
		budgetLabel.setForeground(Color.WHITE);
		budgetLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
		budgetLabel.setBounds(173, 29, 104, 35);
		design1.add(budgetLabel);
		
		setPanel = new JPanel();
		setPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		setPanel.setBackground(Color.decode("#92acdf"));
		setPanel.setBounds(52, 151, 344, 192);
		add(setPanel);
		setPanel.setLayout(null);
		
		increaseBudget = new JRadioButton("Add funds");
		buttonGroup.add(increaseBudget);
		increaseBudget.setSelected(true);
		increaseBudget.setFocusPainted(false);
		increaseBudget.setFont(new Font("Dialog", Font.BOLD, 14));
		increaseBudget.setForeground(Color.WHITE);
		increaseBudget.setContentAreaFilled(false);
		increaseBudget.setBorder(null);
		increaseBudget.setBackground(Color.WHITE);
		increaseBudget.setBounds(6, 7, 111, 23);
		setPanel.add(increaseBudget);
		
		resetBudget = new JRadioButton("Reset funds");
		buttonGroup.add(resetBudget);
		resetBudget.setFont(new Font("Dialog", Font.BOLD, 14));
		resetBudget.setForeground(Color.WHITE);
		resetBudget.setFocusPainted(false);
		resetBudget.setContentAreaFilled(false);
		resetBudget.setBounds(134, 7, 111, 23);
		setPanel.add(resetBudget);
		
		amountField = new JTextField("0.0");
		amountField.setBorder(new LineBorder(Color.BLACK, 2, true));
		amountField.setFont(new Font("Dialog", Font.PLAIN, 20));
		amountField.setBounds(6, 73, 289, 42);
		setPanel.add(amountField);
		amountField.setColumns(10);
		
		amountLabel = new JLabel("Amount: ");
		amountLabel.setForeground(Color.WHITE);
		amountLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		amountLabel.setBounds(6, 42, 150, 20);
		setPanel.add(amountLabel);
		
		setButton = new JButton("Submit");

		setButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setButton.setBackground(Color.WHITE);
		setButton.setFocusPainted(false);
		setButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		setButton.setBounds(230, 134, 104, 37);
		setPanel.add(setButton);
		
		labelPanel = new JPanel();
		labelPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		labelPanel.setBackground(Color.decode("#f7dc6f"));
		labelPanel.setBounds(10, 397, 411, 209);
		add(labelPanel);
		labelPanel.setLayout(null);
		
		budgetAmoutLabel = new JLabel("Budget amount: ");
		budgetAmoutLabel.setHorizontalAlignment(SwingConstants.LEFT);
		budgetAmoutLabel.setFont(new Font("DialogInput", Font.BOLD, 24));
		budgetAmoutLabel.setForeground(Color.DARK_GRAY);
		budgetAmoutLabel.setBounds(10, 8, 242, 55);
		labelPanel.add(budgetAmoutLabel);
		
		totalExpensesLabel = new JLabel("Total expenses: ");
		totalExpensesLabel.setHorizontalAlignment(SwingConstants.LEFT);
		totalExpensesLabel.setForeground(Color.DARK_GRAY);
		totalExpensesLabel.setFont(new Font("DialogInput", Font.BOLD, 24));
		totalExpensesLabel.setBounds(10, 143, 242, 55);
		labelPanel.add(totalExpensesLabel);
		
		lblFundsLeft = new JLabel("Funds left: ");
		lblFundsLeft.setHorizontalAlignment(SwingConstants.LEFT);
		lblFundsLeft.setForeground(Color.DARK_GRAY);
		lblFundsLeft.setFont(new Font("DialogInput", Font.BOLD, 24));
		lblFundsLeft.setBounds(10, 74, 187, 55);
		labelPanel.add(lblFundsLeft);
		
		budgetLabelAmount = new JLabel("₱ 0.00");
		budgetLabelAmount.setHorizontalAlignment(SwingConstants.LEFT);
		budgetLabelAmount.setForeground(Color.DARK_GRAY);
		budgetLabelAmount.setFont(new Font("DialogInput", Font.BOLD, 24));
		budgetLabelAmount.setBounds(215, 8, 215, 55);
		labelPanel.add(budgetLabelAmount);
		
		fundsLeftAmount = new JLabel("₱ 0.00");
		fundsLeftAmount.setHorizontalAlignment(SwingConstants.LEFT);
		fundsLeftAmount.setForeground(Color.DARK_GRAY);
		fundsLeftAmount.setFont(new Font("DialogInput", Font.BOLD, 24));
		fundsLeftAmount.setBounds(182, 74, 215, 55);
		labelPanel.add(fundsLeftAmount);
		
		totalExpensesAmount = new JLabel("₱ 0.00");
		totalExpensesAmount.setHorizontalAlignment(SwingConstants.LEFT);
		totalExpensesAmount.setForeground(Color.DARK_GRAY);
		totalExpensesAmount.setFont(new Font("DialogInput", Font.BOLD, 24));
		totalExpensesAmount.setBounds(240, 143, 215, 55);
		labelPanel.add(totalExpensesAmount);
		
		setButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(increaseBudget.isSelected()) {
					if(checkAmount()) {
						Data.addFunds(user, Double.parseDouble(amountField.getText()));
						updateLabelPanel();
					}else {
						new ErrorHandler("Error found: Invalid amount", null);
					}
				}else if(resetBudget.isSelected()) {
					if(checkAmount()) {
						Data.resetFunds(user, Double.parseDouble(amountField.getText()));
						updateLabelPanel();
					}else {
						new ErrorHandler("Error found: Invalid amount", null);
					}
				}
				resetFields();
			}
			private boolean checkAmount() {
				boolean status = false;
				if(amountField.getText().matches("^(0|[1-9]\\d*)(\\.\\d+)?$")) {
					status = true;
				}
				return status;
			}
		});
	}
	public void resetFields() {
		amountField.setText("0.0");
	}
	public void updateLabelPanel() {
		budgetLabelAmount.setText("₱ " + user.getAccount().getInitialBudget());
		fundsLeftAmount.setText("₱ " + String.format("%.2f", user.getAccount().getBudget()));
		totalExpensesAmount.setText("₱ "+BankAccount.getTotal(user.getAccount().getExpenses()));
		labelPanel.repaint();
		labelPanel.revalidate();
	}
	public JPanel getDesign1() {
		return design1;
	}
	public void setDesign1(JPanel design1) {
		this.design1 = design1;
	}
	public JLabel getBudgetLabel() {
		return budgetLabel;
	}
	public void setBudgetLabel(JLabel budgetLabel) {
		this.budgetLabel = budgetLabel;
	}
	public JPanel getSetPanel() {
		return setPanel;
	}
	public void setSetPanel(JPanel setPanel) {
		this.setPanel = setPanel;
	}
	public JRadioButton getIncreaseBudget() {
		return increaseBudget;
	}
	public void setIncreaseBudget(JRadioButton increaseBudget) {
		this.increaseBudget = increaseBudget;
	}
	public JRadioButton getResetBudget() {
		return resetBudget;
	}
	public void setResetBudget(JRadioButton resetBudget) {
		this.resetBudget = resetBudget;
	}
	public JTextField getTxtTe() {
		return amountField;
	}
	public void setTxtTe(JTextField txtTe) {
		this.amountField = txtTe;
	}
	public JLabel getAmountLabel() {
		return amountLabel;
	}
	public void setAmountLabel(JLabel amountLabel) {
		this.amountLabel = amountLabel;
	}
	public JButton getSetButton() {
		return setButton;
	}
	public void setSetButton(JButton setButton) {
		this.setButton = setButton;
	}
	public JPanel getLabelPanel() {
		return labelPanel;
	}
	public void setLabelPanel(JPanel labelPanel) {
		this.labelPanel = labelPanel;
	}
	public JLabel getBudgetAmoutLabel() {
		return budgetAmoutLabel;
	}
	public void setBudgetAmoutLabel(JLabel budgetAmoutLabel) {
		this.budgetAmoutLabel = budgetAmoutLabel;
	}
	public JLabel getTotalExpensesLabel() {
		return totalExpensesLabel;
	}
	public void setTotalExpensesLabel(JLabel totalExpensesLabel) {
		this.totalExpensesLabel = totalExpensesLabel;
	}
	public JLabel getLblFundsLeft() {
		return lblFundsLeft;
	}
	public void setLblFundsLeft(JLabel lblFundsLeft) {
		this.lblFundsLeft = lblFundsLeft;
	}
	public JLabel getBudgetLabelAmount() {
		return budgetLabelAmount;
	}
	public void setBudgetLabelAmount(JLabel budgetLabelAmount) {
		this.budgetLabelAmount = budgetLabelAmount;
	}
	public JLabel getFundsLeftAmount() {
		return fundsLeftAmount;
	}
	public void setFundsLeftAmount(JLabel fundsLeftAmount) {
		this.fundsLeftAmount = fundsLeftAmount;
	}
	public JLabel getTotalExpensesAmount() {
		return totalExpensesAmount;
	}
	public void setTotalExpensesAmount(JLabel totalExpensesAmount) {
		this.totalExpensesAmount = totalExpensesAmount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}
}
