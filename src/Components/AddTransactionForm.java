package Components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Classes.Expense;
import Classes.User;
import Helpers.ErrorHandler;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class AddTransactionForm extends JDialog {

	private static final long serialVersionUID = 1L;
	 private JPanel mainPanel;
	 private JPanel whitePanel;
	 private JLabel nameLabel;
     private JLabel header;
     private JTextField nameField;
     private JLabel amountLabel;
     private JTextField amountField;
     private JLabel dateLabel;
     private JTextField dateField;
     private JLabel typeLabel;
     private JComboBox<String> typeComboBox;
     private JButton submitButton;
     private User user = null;
	/**
	 * Create the panel.
	 */
	public AddTransactionForm(User user) {
		this.user =user;
		initialize();
	}

	private void initialize() {
        setTitle("Add Transactions");
        setSize(450, 686);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
        setModalityType(ModalityType.APPLICATION_MODAL);
      
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.decode("#52b3e1"));
        
        whitePanel = new JPanel();
        whitePanel.setLayout(null);
        whitePanel.setBackground(Color.WHITE);
        whitePanel.setBounds(0, 60, 450, 550); // Adjusted height of the white panel to fit within the frame
        mainPanel.add(whitePanel);

        header = new JLabel("Add Transactions", SwingConstants.CENTER);
        header.setBounds(0, 10, 450, 40);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Agrandir", Font.BOLD, 20));
        mainPanel.add(header);
        
        nameLabel = new JLabel("Transaction name");
        nameLabel.setBounds(20, 20, 150, 20);
        nameLabel.setForeground(Color.decode("#2d4360"));
        nameLabel.setFont(new Font("Agrandir", Font.PLAIN, 14));
        whitePanel.add(nameLabel);
        
        nameField = new JTextField();
        nameField.setBounds(20, 50, 410, 35);
        nameField.setFont(new Font("Agrandir", Font.PLAIN, 16));
        nameField.setBackground(Color.decode("#2d4360"));
        nameField.setForeground(Color.WHITE);
        whitePanel.add(nameField);
        
        amountLabel = new JLabel("Amount");
        amountLabel.setBounds(20, 100, 150, 20);
        amountLabel.setForeground(Color.decode("#2d4360"));
        amountLabel.setFont(new Font("Agrandir", Font.PLAIN, 14));
        whitePanel.add(amountLabel);
        
        amountField = new JTextField();
        amountField.setBounds(20, 130, 410, 35);
        amountField.setFont(new Font("Agrandir", Font.PLAIN, 16));
        amountField.setBackground(Color.decode("#2d4360"));
        amountField.setForeground(Color.WHITE);
        whitePanel.add(amountField);
        
        dateLabel = new JLabel("DATE");
        dateLabel.setBounds(20, 180, 150, 20);
        dateLabel.setForeground(Color.decode("#2d4360"));
        dateLabel.setFont(new Font("Agrandir", Font.PLAIN, 14));
        whitePanel.add(dateLabel);
        
        dateField = new JTextField("MM/DD/YYYY");
        dateField.setBounds(20, 210, 330, 35);
        dateField.setFont(new Font("Agrandir", Font.PLAIN, 16));
        dateField.setBackground(Color.decode("#2d4360"));
        dateField.setForeground(Color.WHITE);
        whitePanel.add(dateField);
        
        typeLabel = new JLabel("Type of Transaction");
        typeLabel.setBounds(20, 260, 150, 20);
        typeLabel.setForeground(Color.decode("#2d4360"));
        typeLabel.setFont(new Font("Agrandir", Font.PLAIN, 14));
        whitePanel.add(typeLabel);
        
        typeComboBox = new JComboBox<>(Expense.TYPES);
        typeComboBox.setBounds(20, 290, 410, 35);
        typeComboBox.setFont(new Font("Agrandir", Font.PLAIN, 14));
        whitePanel.add(typeComboBox);
        
        submitButton = new JButton("Submit");
        submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submitButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkAmount() && checkDate() && isValidAmount()) {
        			dispose();
        		}else if(!isValidAmount()) {
        			new ErrorHandler("Budget not enough!!", null);
        		}else if(!checkAmount()) {
        			new ErrorHandler("please enter valid amount", getInstance());
        		}else if(!checkDate()) {
        			new ErrorHandler("please enter valid format: MM/DD/YYYY", getInstance());
        		}else {
        			new ErrorHandler("Error found: please enter valid input", getInstance());
        		}
        	}
        });
        submitButton.setFont(new Font("Dialog", Font.PLAIN, 21));
        submitButton.setFocusPainted(false);
        submitButton.setBackground(SystemColor.activeCaption);
        submitButton.setBounds(313, 392, 106, 35);
        whitePanel.add(submitButton);
        
        getContentPane().add(mainPanel);
        setVisible(true);
	}

	private AddTransactionForm getInstance() {
		return this;
	}
	public boolean isValidAmount() {
		boolean status = false;
		if((user.getAccount().getBudget() - Double.parseDouble(amountField.getText())) >= 0) {
			status = true;
		}
		return status;
	}
	public boolean checkAmount() {
		boolean status = false;
		if(amountField.getText().matches("^(0|[1-9]\\d*)(\\.\\d+)?$")) {
			status = true;
		}
		return status;
	}
	public boolean checkDate() {
		boolean status = false;
		if(dateField.getText().matches("^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/(19|20)\\d{2}$")) {
			status = true;
		}
		return status;
	}
	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public JPanel getWhitePanel() {
		return whitePanel;
	}

	public void setWhitePanel(JPanel whitePanel) {
		this.whitePanel = whitePanel;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}

	public JLabel getHeader() {
		return header;
	}

	public void setHeader(JLabel header) {
		this.header = header;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	public JLabel getAmountLabel() {
		return amountLabel;
	}

	public void setAmountLabel(JLabel amountLabel) {
		this.amountLabel = amountLabel;
	}

	public JTextField getAmountField() {
		return amountField;
	}

	public void setAmountField(JTextField amountField) {
		this.amountField = amountField;
	}

	public JLabel getDateLabel() {
		return dateLabel;
	}

	public void setDateLabel(JLabel dateLabel) {
		this.dateLabel = dateLabel;
	}

	public JTextField getDateField() {
		return dateField;
	}

	public void setDateField(JTextField dateField) {
		this.dateField = dateField;
	}

	public JLabel getTypeLabel() {
		return typeLabel;
	}

	public void setTypeLabel(JLabel typeLabel) {
		this.typeLabel = typeLabel;
	}

	public JComboBox<String> getTypeComboBox() {
		return typeComboBox;
	}

	public void setTypeComboBox(JComboBox<String> typeComboBox) {
		this.typeComboBox = typeComboBox;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
