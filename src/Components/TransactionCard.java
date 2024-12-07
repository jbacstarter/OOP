package Components;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class TransactionCard extends JPanel {

	private static final long serialVersionUID = 1L;
	public int index = 0;
	private JLabel dateLabel;
	private JLabel paymentLabel;
	private JLabel paymentValue;
	private JLabel typeLabel;
	private JLabel type;
	private static TransactionCard selected = null;
	/**
	 * Create the panel.
	 */
	public TransactionCard() {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				setBackground(Color.decode("#92acdf"));
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
					if(selected!= null && selected.index == index) {
						setBackground(Color.RED);
					}else {
						
						setBackground(Color.decode("#cedaf0"));
					}
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(selected);
			    if (selected != null && selected.index == index) {
			        // If the clicked card is already selected, unselect it
			        selected.setBackground(Color.decode("#cedaf0")); // Revert to the original color
			        selected = null; // Set selected to null
			    } else {
			        // If another card is selected, reset its background color
			        if (selected != null) {
			            selected.setBackground(Color.decode("#cedaf0"));
			        }
			        // Select the current card
			        setBackground(Color.RED);
			        selected = getInstance();
			    }
			}
		});
		setBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(0, 0, 0)));
		setBackground(Color.decode("#cedaf0"));
		setPreferredSize(new Dimension(497, 116));
		setLayout(null);
		
		dateLabel = new JLabel("Date");
		dateLabel.setFont(new Font("Dialog", Font.ITALIC, 20));
		dateLabel.setBounds(10, 11, 253, 26);
		add(dateLabel);
		
		paymentLabel = new JLabel("Paid");
		paymentLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		paymentLabel.setBounds(36, 79, 192, 26);
		add(paymentLabel);
		
		paymentValue = new JLabel("-100.00");
		paymentValue.setFont(new Font("Dialog", Font.ITALIC, 20));
		paymentValue.setBounds(289, 79, 134, 26);
		add(paymentValue);
		
		typeLabel = new JLabel("Type");
		typeLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		typeLabel.setBounds(36, 42, 192, 26);
		add(typeLabel);
		
		type = new JLabel("Food/Groceries");
		type.setFont(new Font("Dialog", Font.ITALIC, 23));
		type.setBounds(264, 42, 198, 26);
		add(type);
	}
	public TransactionCard getInstance() {
		return this;
	}
	public JLabel getDateLabel() {
		return dateLabel;
	}

	public void setDateLabel(JLabel dateLabel) {
		this.dateLabel = dateLabel;
	}

	public JLabel getPaymentLabel() {
		return paymentLabel;
	}

	public void setPaymentLabel(JLabel paymentLabel) {
		this.paymentLabel = paymentLabel;
	}

	public JLabel getPaymentValue() {
		return paymentValue;
	}

	public void setPaymentValue(JLabel paymentValue) {
		this.paymentValue = paymentValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JLabel getTypeLabel() {
		return typeLabel;
	}

	public void setTypeLabel(JLabel typeLabel) {
		this.typeLabel = typeLabel;
	}

	public JLabel getType() {
		return type;
	}

	public void setType(JLabel type) {
		this.type = type;
	}

	public static TransactionCard getSelected() {
		return selected;
	}

	public static void setSelected(TransactionCard selected) {
		TransactionCard.selected = selected;
	}

}
