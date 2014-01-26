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
	JButton runTestsOrgaManagerButton;
	JButton runTestsSeleniumEhcButton;
	JButton backButton;
	
	public OmDevelopmentPanel(){
		config = new OmConfig();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createTitledBorder(config.getMessage("developmentPanelTitleText")));
		this.setPreferredSize(config.getMainPanelDimension());
		clientsPanel = new JPanel(); // FlowLayout
		clientsPanel.setBorder(BorderFactory.createTitledBorder(config.getMessage("developmentPanelClientsPanelTitleText")));
		createClientReportButton = new JButton(config.getMessage("developmentClientActionsCreateReportButtonText"));
		runTestsSeleniumEhcButton = new JButton(config.getMessage("developmentClientActionsRunSeleniumEhcButtonText"));
		clientsPanel.add(createClientReportButton);
		clientsPanel.add(runTestsSeleniumEhcButton);
		customActionsPanel = new JPanel(); // FlowLayout
		customActionsPanel.setBorder(BorderFactory.createTitledBorder(config.getMessage("developmentPanelCustomActionsPanelTitleText")));
		createGalleryButton = new JButton(config.getMessage("developmentCustomActionsCreateGalleryButtonText"));
		runTestsOrgaManagerButton = new JButton(config.getMessage("developmentCustomActionsRunTestsButtonText"));
		customActionsPanel.add(createGalleryButton);
		customActionsPanel.add(runTestsOrgaManagerButton );
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
	
	public JButton getRunTestsOrgaManagerButton() {
		return this.runTestsOrgaManagerButton;
	}
	
	public JButton getRunTestsSeleniumEhcButton() {
		return this.runTestsSeleniumEhcButton;
	}
	
	public JButton getBackButton(){
		return this.backButton;
	}
	
}
