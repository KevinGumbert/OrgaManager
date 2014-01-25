package orgamanager.view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import orgamanager.utilities.OmConfig;

public class OmOfficePanel extends JPanel {
	
	private JPanel invoicePanel;
	private JButton createInvoiceButton;
	private JButton backButton;
	private OmConfig config;

	public OmOfficePanel() {
		config = new OmConfig();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createTitledBorder(config.getMessage("officePanelTitleText")));
		this.setPreferredSize(config.getMainPanelDimension());
		invoicePanel = new JPanel(); // FlowLayout
		invoicePanel.setBorder(BorderFactory.createTitledBorder(config.getMessage("officePanelInvoicePanelTitleText")));
		createInvoiceButton = new JButton(config.getMessage("officeCreateInvoiceButtonText"));
		invoicePanel.add(createInvoiceButton);
		backButton = new JButton(config.getMessage("backButtonText"));
		this.add(Box.createRigidArea(new Dimension(10,10)));
		this.add(invoicePanel);
		this.add(backButton);
	}
	
	public JButton getBackButton(){
		return this.backButton;
	}
	
	public JButton getCreateInvoiceButton(){
		return this.createInvoiceButton;
	}
	
}
