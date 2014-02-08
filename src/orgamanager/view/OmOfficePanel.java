package orgamanager.view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import orgamanager.config.OmConfig;

public class OmOfficePanel extends JPanel {
	
	private JPanel invoicePanel;
	private JPanel invoiceConfigPanel;
	private JPanel addressePanel;
	private JTextField addresseFirstName;
	private JTextField addresseLastName;
	private JTextField addresseStreet;
	private JTextField addresseStreetNumber;
	private JTextField addressePostalCode;
	private JTextField addresseCity;
	private JTextField addresseCompany;
	private JLabel addresseFirstNameLabel;
	private JLabel addresseLastNameLabel;
	private JLabel addresseStreetLabel;
	private JLabel addresseStreetNumberLabel;
	private JLabel addressePostalCodeLabel;
	private JLabel addresseCityLabel;
	private JLabel addresseCompanyLabel;
	private JScrollPane invoiceConfigScrollPane;
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
		invoiceConfigPanel = new JPanel();
		invoiceConfigPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		invoiceConfigPanel.setBorder(BorderFactory.createTitledBorder(config.getMessage("officePanelInvoiceConfigPanelTitleText")));
		//invoiceConfigPanel.setPreferredSize(new Dimension(((int) config.getMainPanelDimension().getWidth() - 20), 260));
		invoiceConfigPanel.setPreferredSize(new Dimension(530, 500));
		invoiceConfigScrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
		invoiceConfigScrollPane.setPreferredSize(new Dimension(550, 270));
		addressePanel = new JPanel();
		addressePanel.setLayout(new BoxLayout(addressePanel, BoxLayout.Y_AXIS));
		//addressePanel.setPreferredSize(new Dimension(200, 490));
		addressePanel.setBorder(BorderFactory.createTitledBorder("Anschrift"));
		addresseFirstNameLabel = new JLabel("Vorname");
		addresseLastNameLabel = new JLabel("Nachname");
		addresseStreetLabel = new JLabel("Straße");
		addresseStreetNumberLabel = new JLabel("Hausnummer");
		addressePostalCodeLabel = new JLabel("Postleitzahl");
		addresseCityLabel = new JLabel("Stadt");
		addresseCompanyLabel = new JLabel("Firma");
		addresseFirstName = new JTextField(10);
		addresseLastName = new JTextField(10);
		addresseStreet = new JTextField(10);
		addresseStreetNumber = new JTextField(3);
		addressePostalCode = new JTextField(5);
		addresseCity = new JTextField(10);
		addresseCompany = new JTextField(10);
		addressePanel.add(Box.createRigidArea(new Dimension(5,5)));
		addressePanel.add(addresseFirstNameLabel);
		addressePanel.add(addresseFirstName);
		addressePanel.add(Box.createRigidArea(new Dimension(5,5)));
		addressePanel.add(addresseLastNameLabel);
		addressePanel.add(addresseLastName);
		addressePanel.add(Box.createRigidArea(new Dimension(5,5)));
		addressePanel.add(addresseStreetLabel);
		addressePanel.add(addresseStreet);
		addressePanel.add(Box.createRigidArea(new Dimension(5,5)));
		addressePanel.add(addresseStreetNumberLabel);
		addressePanel.add(addresseStreetNumber);
		addressePanel.add(Box.createRigidArea(new Dimension(5,5)));
		addressePanel.add(addressePostalCodeLabel);
		addressePanel.add(addressePostalCode);
		addressePanel.add(Box.createRigidArea(new Dimension(5,5)));
		addressePanel.add(addresseCityLabel);
		addressePanel.add(addresseCity);
		addressePanel.add(Box.createRigidArea(new Dimension(5,5)));
		addressePanel.add(addresseCompanyLabel);
		addressePanel.add(addresseCompany);
		addressePanel.add(Box.createRigidArea(new Dimension(5,5)));
		invoiceConfigPanel.add(addressePanel);
		invoiceConfigScrollPane.setViewportView(invoiceConfigPanel);
		// Rechnungsnummer JTextField mit Vordruck aus Properties
		// Rechnungsdatum JTextField
		// Rechnungsbetrag (Gesamt) 
		// Rechnungsheadline (spaeter fett) JTextField
		// Rechnungsposten (Liste) Freitext
		// Rechnungsbetragvisualisierungzeile JTextField
		// Beruf - Dropdown
		// Empfaengergeschlecht - Dropdown
		// Empfaengername - JTextField, 2x
		// Empfaengeradresse - JTextField, 4x (Strasse, Hausnummer, Plz, Stadt)
		// Empfaengerfirma - JTextField
		// Empfaengerkundennummer - JTextField
		createInvoiceButton = new JButton(config.getMessage("officeCreateInvoiceButtonText"));
		invoicePanel.add(invoiceConfigScrollPane);
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
