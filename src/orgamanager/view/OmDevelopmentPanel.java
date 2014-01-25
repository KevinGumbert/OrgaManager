package orgamanager.view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import orgamanager.utilities.OmConfig;

public class OmDevelopmentPanel extends JPanel {

	OmConfig config;
	JPanel customActionsPanel;
	JPanel clientsPanel;
	JButton createGalleryButton;
	JButton createClientReportButton;
	JButton backButton;
	
	public OmDevelopmentPanel(){
		config = new OmConfig();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createTitledBorder(config.getMessage("developmentPanelTitleText")));
		this.setPreferredSize(config.getMainPanelDimension());
		clientsPanel = new JPanel(); // FlowLayout
		clientsPanel.setBorder(BorderFactory.createTitledBorder(config.getMessage("developmentPanelClientsPanelTitleText")));
		createClientReportButton = new JButton(config.getMessage("developmentClientActionsCreateReportButtonText"));
		clientsPanel.add(createClientReportButton);
		customActionsPanel = new JPanel(); // FlowLayout
		customActionsPanel.setBorder(BorderFactory.createTitledBorder(config.getMessage("developmentPanelCustomActionsPanelTitleText")));
		createGalleryButton = new JButton(config.getMessage("developmentCustomActionsCreateGalleryButtonText"));
		createGalleryButton = new JButton(config.getMessage("developmentCustomActionsCreateGalleryButtonText"));
		customActionsPanel.add(createGalleryButton);
		backButton = new JButton(config.getMessage("backButtonText"));
		this.add(Box.createRigidArea(new Dimension(10,10)));
		this.add(clientsPanel);
		this.add(Box.createRigidArea(new Dimension(10,10)));
		this.add(customActionsPanel);
		this.add(Box.createRigidArea(new Dimension(10,10)));
		this.add(backButton);
	}
	
	public JButton getCreateClientReportButton(){
		return this.createClientReportButton;
	}

	public JButton getCreateGalleryButton() {
		return this.createGalleryButton;
	}
	
	public JButton getBackButton(){
		return this.backButton;
	}
	
}
