package orgamanager.view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import orgamanager.utilities.OmConfig;

public class OmWelcomePanel extends JPanel {
	
	private JPanel rightPanel;
	private JPanel leftPanel;
	private JButton signaturesButton;
	private JButton publicationsButton;
	private JButton developmentButton;
	private JButton officeButton;
	private JButton logoutButton;
	private OmConfig config;

	public OmWelcomePanel() {
		config = new OmConfig(); // TODO enlarge buttons to full width
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createTitledBorder(config.getMessage("welcomePanelTitleText")));
		this.setPreferredSize(config.getMainPanelDimension());
		logoutButton = new JButton(config.getMessage("logoutButtonText"));
		// size in relation to overall height
		double buttonDimWidth = config.getMainPanelDimension().getWidth() - 10;
		double buttonDimHeight = config.getMainPanelDimension().getHeight() * 0.1;
		Dimension buttonDim = new Dimension((int) buttonDimWidth, (int) buttonDimHeight);
		logoutButton.setPreferredSize(buttonDim);
		logoutButton.setMinimumSize(buttonDim);
		signaturesButton = new JButton(config.getMessage("signaturesButtonText"));
		signaturesButton.setPreferredSize(buttonDim);
		signaturesButton.setMinimumSize(buttonDim);
		publicationsButton = new JButton(config.getMessage("publicationsButtonText"));
		publicationsButton.setPreferredSize(buttonDim);
		publicationsButton.setMinimumSize(buttonDim);
		developmentButton = new JButton(config.getMessage("developmentButtonText"));
		developmentButton.setPreferredSize(buttonDim);
		developmentButton.setMinimumSize(buttonDim);
		officeButton = new JButton(config.getMessage("officeButtonText"));
		officeButton.setPreferredSize(buttonDim);
		officeButton.setMinimumSize(buttonDim);
		this.add(Box.createRigidArea(new Dimension(10,10)));
		this.add(publicationsButton);
		this.add(Box.createRigidArea(new Dimension(10,10)));
		this.add(signaturesButton);
		this.add(Box.createRigidArea(new Dimension(10,10)));
		this.add(officeButton);
		this.add(Box.createRigidArea(new Dimension(10,10)));
		this.add(developmentButton);
		this.add(Box.createRigidArea(new Dimension(10,10)));
		this.add(logoutButton);
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
