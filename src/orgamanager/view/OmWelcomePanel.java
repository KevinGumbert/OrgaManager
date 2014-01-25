package orgamanager.view;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import orgamanager.utilities.OmConfig;

public class OmWelcomePanel extends JPanel {

	private JLabel headerLabel;
	private JButton signaturesButton;
	private JButton publicationsButton;
	private JButton developmentButton;
	private JButton officeButton;
	private JButton logoutButton;
	private OmConfig config;

	public OmWelcomePanel() {
		config = new OmConfig();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(config.getMainPanelDimension());
		headerLabel = new JLabel("Cockpit");
		headerLabel.setPreferredSize(new Dimension(600, 50));
		logoutButton = new JButton(config.getMessage("logoutButtonText"));
		signaturesButton = new JButton(config.getMessage("signaturesButtonText"));
		publicationsButton = new JButton(config.getMessage("publicationsButtonText"));
		developmentButton = new JButton(config.getMessage("developmentButtonText"));
		officeButton = new JButton(config.getMessage("officeButtonText"));
		this.add(headerLabel);
		this.add(signaturesButton);
		this.add(publicationsButton);
		this.add(developmentButton);
		this.add(officeButton);
		this.add(logoutButton);
	}

	public JLabel getHeaderLabel() {
		return headerLabel;
	}

	public void setHeaderLabel(JLabel headerLabel) {
		this.headerLabel = headerLabel;
	}
	
	public JButton getSignaturesButton() {
		return signaturesButton;
	}

	public void setSignaturesButton(JButton signaturesButton) {
		this.signaturesButton = signaturesButton;
	}

	public JButton getPublicationsButton() {
		return publicationsButton;
	}

	public void setPublicationsButton(JButton publicationsButton) {
		this.publicationsButton = publicationsButton;
	}

	public JButton getDevelopmentButton() {
		return developmentButton;
	}

	public void setDevelopmentButton(JButton developmentButton) {
		this.developmentButton = developmentButton;
	}

	public JButton getOfficeButton() {
		return officeButton;
	}

	public void setOfficeButton(JButton officeButton) {
		this.officeButton = officeButton;
	}

	public JButton getLogoutButton() {
		return logoutButton;
	}

	public void setLogoutButton(JButton logout) {
		this.logoutButton = logout;
	}
}
