package Components;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

public class StatisticsCard extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel typeLabel;
	private JProgressBar loadBar;

	/**
	 * Create the panel.
	 */
	public StatisticsCard() {
		setBorder(null);
		setBackground(Color.WHITE);
		setLayout(null);
		setPreferredSize(new Dimension(501, 97));
		
		typeLabel = new JLabel("Type");
		typeLabel.setFont(new Font("Dialog", Font.BOLD, 22));
		typeLabel.setBounds(9, 4, 209, 38);
		add(typeLabel);
		
		loadBar = new JProgressBar();
		loadBar.setValue(2);
		loadBar.setStringPainted(true);
		loadBar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		loadBar.setBackground(Color.WHITE);
		loadBar.setFont(new Font("Dialog", Font.PLAIN, 19));
		loadBar.setBounds(10, 45, 412, 46);
		add(loadBar);

	}

	public JLabel getTypeLabel() {
		return typeLabel;
	}

	public void setTypeLabel(JLabel typeLabel) {
		this.typeLabel = typeLabel;
	}

	public JProgressBar getLoadBar() {
		return loadBar;
	}

	public void setLoadBar(JProgressBar loadBar) {
		this.loadBar = loadBar;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
