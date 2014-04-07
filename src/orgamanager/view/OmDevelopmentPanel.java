package orgamanager.view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import orgamanager.config.OmConfig;

public class OmDevelopmentPanel extends JPanel {

	OmConfig config;
	JPanel customActionsPanel;
	JPanel clientsPanel;
	JButton createGalleryButton;
	JButton createClientReportButton;
	JButton ehcWebAppTurnLightOnButton;
	JButton ehcWebAppTurnLightOffButton;
	JButton ehcWebAppSelfInstallButton;
	JButton ehcWebAppSelfDescribeButton;
	JButton ehcWebAppSelfConfigureButton;
	JButton ehcWebAppSelfCheckButton;
	JButton runTestsOrgaManagerButton;
	JButton runTestsSeleniumEhcButton;
	JButton runTestsSeleniumJobaButton;
	JButton runTestsSeleniumTcBwSuroButton;
	JButton runTestsSeleniumSkpButton;
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
		runTestsSeleniumJobaButton = new JButton(config.getMessage("developmentClientActionsRunSeleniumJobaButtonText"));
		runTestsSeleniumTcBwSuroButton = new JButton(config.getMessage("developmentClientActionsRunSeleniumTcBwSuroButtonText"));
		runTestsSeleniumSkpButton = new JButton(config.getMessage("developmentClientActionsRunSeleniumSkpButtonText"));
		clientsPanel.add(createClientReportButton);
		clientsPanel.add(runTestsSeleniumEhcButton);
		clientsPanel.add(runTestsSeleniumJobaButton);
		clientsPanel.add(runTestsSeleniumSkpButton);
		clientsPanel.add(runTestsSeleniumTcBwSuroButton);
		customActionsPanel = new JPanel(); // FlowLayout
		customActionsPanel.setBorder(BorderFactory.createTitledBorder(config.getMessage("developmentPanelCustomActionsPanelTitleText")));
		createGalleryButton = new JButton(config.getMessage("developmentCustomActionsCreateGalleryButtonText"));
		runTestsOrgaManagerButton = new JButton(config.getMessage("developmentCustomActionsRunTestsButtonText"));
		ehcWebAppTurnLightOnButton = new JButton("EhcWebApp Licht An");
		ehcWebAppTurnLightOffButton = new JButton("EhcWebApp Licht Aus");
		ehcWebAppSelfInstallButton = new JButton("EhcWebApp Selbstinstallation");
		ehcWebAppSelfDescribeButton = new JButton("EhcWebApp Selbstbeschreibung");
		ehcWebAppSelfConfigureButton = new JButton("EhcWebApp Selbstkonfiguration");
		ehcWebAppSelfCheckButton = new JButton("EhcWebApp Selbstcheck");
		customActionsPanel.add(createGalleryButton);
		customActionsPanel.add(runTestsOrgaManagerButton);
		customActionsPanel.add(ehcWebAppTurnLightOnButton);
		customActionsPanel.add(ehcWebAppTurnLightOffButton);
		customActionsPanel.add(ehcWebAppSelfInstallButton);
		customActionsPanel.add(ehcWebAppSelfDescribeButton);
		customActionsPanel.add(ehcWebAppSelfConfigureButton);
		customActionsPanel.add(ehcWebAppSelfCheckButton);
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
	
	public JButton getRunTestsSeleniumJobaButton() {
		return runTestsSeleniumJobaButton;
	}

	public JButton getRunTestsSeleniumTcBwSuroButton() {
		return runTestsSeleniumTcBwSuroButton;
	}

	public JButton getRunTestsSeleniumSkpButton() {
		return runTestsSeleniumSkpButton;
	}
	
	public JButton getEhcWebAppTurnLightOnButton() {
		return ehcWebAppTurnLightOnButton;
	}
	
	public JButton getEhcWebAppTurnLightOffButton() {
		return ehcWebAppTurnLightOffButton;
	}
	
	public JButton getEhcWebAppSelfInstallButton() {
		return ehcWebAppSelfInstallButton;
	}
	
	public JButton getEhcWebAppSelfCheckButton() {
		return ehcWebAppSelfCheckButton;
	}
	
	public JButton getEhcWebAppSelfConfigureButton() {
		return ehcWebAppSelfConfigureButton;
	}
	
	public JButton getEhcWebAppSelfDescribeButton() {
		return ehcWebAppSelfDescribeButton;
	}
	
	public JButton getBackButton(){
		return this.backButton;
	}
}
