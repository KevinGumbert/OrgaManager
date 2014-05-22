package orgamanager.view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import orgamanager.config.OmConfig;

public class OmWelcomePanel extends JPanel {
	
	private JPanel innerPanel;
	private JPanel outerPanel;
	private JButton assignmentButton;
	private JButton neuerAnwendungsbereichButton;
	private JButton signaturesButton;
	private JButton publicationsButton;
	private JButton developmentButton;
	private JButton webAttachmentButton;
	private JButton logoutButton;
	private double buttonDimWidth;
	private double buttonDimHeight;
	private OmConfig config;

	public OmWelcomePanel() {
		config = new OmConfig(); // TODO enlarge buttons to full width
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createTitledBorder(config.getMessage("welcomePanelTitleText")));
		this.setPreferredSize(config.getMainPanelDimension());
		logoutButton = new JButton(config.getMessage("logoutButtonText"));
		buttonDimWidth = config.getMainPanelDimension().getWidth() - 40; // 20
		buttonDimHeight = config.getMainPanelDimension().getHeight() * 0.075; // 0.1
		Dimension buttonDim = new Dimension((int) buttonDimWidth, (int) buttonDimHeight);
		logoutButton.setPreferredSize(buttonDim);
		logoutButton.setMinimumSize(buttonDim);
		assignmentButton = new JButton(config.getMessage("assignmentButtonText"));
		assignmentButton.setPreferredSize(buttonDim);
		assignmentButton.setMinimumSize(buttonDim);
		
		neuerAnwendungsbereichButton = new JButton(config.getMessage("newUseCasesButtonText"));
		neuerAnwendungsbereichButton.setPreferredSize(buttonDim);
		neuerAnwendungsbereichButton.setMinimumSize(buttonDim);
		
		signaturesButton = new JButton(config.getMessage("signaturesButtonText"));
		signaturesButton.setPreferredSize(buttonDim);
		signaturesButton.setMinimumSize(buttonDim);
		publicationsButton = new JButton(config.getMessage("publicationsButtonText"));
		publicationsButton.setPreferredSize(buttonDim);
		publicationsButton.setMinimumSize(buttonDim);
		developmentButton = new JButton(config.getMessage("developmentButtonText"));
		developmentButton.setPreferredSize(buttonDim);
		developmentButton.setMinimumSize(buttonDim);
		webAttachmentButton = new JButton(config.getMessage("webAttachmentButtonText"));
		webAttachmentButton.setPreferredSize(buttonDim);
		webAttachmentButton.setMinimumSize(buttonDim);
		innerPanel = new JPanel();
		double panelWidth = config.getMainPanelDimension().getWidth() - 15; // embed navigation box
		double panelHeightInner = config.getMainPanelDimension().getHeight() * 0.7;
		double panelHeightOuter = config.getMainPanelDimension().getHeight() * 0.25;
		innerPanel.setPreferredSize(new Dimension((int) panelWidth, (int) panelHeightInner));
		innerPanel.setBorder(BorderFactory.createTitledBorder(config.getMessage("welcomePanelInnerTitleText")));
		innerPanel.add(assignmentButton);
		innerPanel.add(Box.createRigidArea(new Dimension(2, 2)));
		innerPanel.add(publicationsButton);
		innerPanel.add(Box.createRigidArea(new Dimension(2, 2)));
		innerPanel.add(signaturesButton);
		innerPanel.add(Box.createRigidArea(new Dimension(2, 2)));
		innerPanel.add(developmentButton);
		innerPanel.add(Box.createRigidArea(new Dimension(2, 2)));
		innerPanel.add(webAttachmentButton);
		innerPanel.add(Box.createRigidArea(new Dimension(2, 2)));
		innerPanel.add(neuerAnwendungsbereichButton);
		innerPanel.add(Box.createRigidArea(new Dimension(2, 2)));
		this.add(innerPanel);
		outerPanel = new JPanel();
		outerPanel.setPreferredSize(new Dimension((int) panelWidth, (int) panelHeightOuter));
		outerPanel.add(Box.createRigidArea(new Dimension(10,10)));
		outerPanel.add(logoutButton);
		innerPanel.add(Box.createRigidArea(new Dimension(10,10)));
		this.add(outerPanel);
	}

	public JButton getAssignmentButton() {
		return assignmentButton;
	}

	public void setAssignmentButton(JButton assignmentButton) {
		this.assignmentButton = assignmentButton;
	}
	
	public JButton getNeuerAnwendungsbereichButton() {
		return neuerAnwendungsbereichButton;
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

	public JButton getwebAttachmenButton() {
		return webAttachmentButton;
	}
	
	public void setwebAttachmenButton(JButton webAttachmenButton) {
		this.webAttachmentButton = webAttachmenButton;
	}
	
	public JButton getLogoutButton() {
		return logoutButton;
	}

	public void setLogoutButton(JButton logout) {
		this.logoutButton = logout;
	}
}
