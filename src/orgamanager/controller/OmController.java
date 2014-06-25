package orgamanager.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import orgamanager.model.OmModel;
import orgamanager.utilities.OmViewConstant;
import orgamanager.view.OmAssignmentPanel;
import orgamanager.view.OmDevelopmentPanel;
import orgamanager.view.OmLoginPanel;
import orgamanager.view.OmPublicationsPanel;
import orgamanager.view.OmSignaturePanel;
import orgamanager.view.OmView;
import orgamanager.view.OmWebAttachmentPanel;
import orgamanager.view.OmWelcomePanel;
import orgamanager.view.NewUseCasesPanel;

/**
 * OmController is the main controller.
 * 
 * Controller sets action listeners of corresponding view.
 * Each view has a prepareForView() method which initialises 
 * the view. A list of all views is available, because it is 
 * possible to iterate through all items of OmViewConstant.
 * Each view extends JPanel and only one panel is shown on 
 * screen, see setCurrentView().
 * A commandMethod(), i.e. invoked by a clicked button has 
 * a corresponding method in the model OmModel.  
 */
public class OmController {

	private OmModel model;
	private OmView view;
	private OmAssignmentPanel assignmentPanel;
	private OmLoginPanel loginPanel;
	private OmWelcomePanel welcomePanel;
	private OmDevelopmentPanel developmentPanel;
	private NewUseCasesPanel neuerAnwendungsbereichPanel;
	private OmPublicationsPanel publicationsPanel;
	private OmSignaturePanel signaturePanel; 
	private OmWebAttachmentPanel webAttachmentPanel;
	private OmViewConstant currentView;
	private boolean isAuthorized;
	private String formUsername;
	private String formPassword;

	public OmController(OmModel model, OmView view) {
		this.model = model;
		this.view = view;
		setCurrentView(OmViewConstant.LOGIN);
		isAuthorized = false;
	}

	public void prepareForView() {
		switch (currentView){
			case ASSIGNMENT:
				prepareForAssignmentView();
				break;
			case DEVELOPMENT:
				prepareForDevelopmentView();
				break;
			case LOGIN:
				prepareForLoginView();
				break;
			case NEUERANWENDUNGSBEREICH:
				prepareForNeuerAnwendungsbereichView();
				break;
			case PUBLICATIONS:
				prepareForPublicationsView();
				break;
			case SIGNATURES:
				prepareForSignaturesView();
				break;
			case WEBATTACHMENT:
				prepareForWebAttachmentView();
				break;
			case WELCOME:
				prepareForWelcomeView();
				break;
			default:
				prepareForLoginView();
				break;
		}
	}

	private void prepareForAssignmentView(){
		setCurrentView(OmViewConstant.ASSIGNMENT);
		assignmentPanel =  new OmAssignmentPanel();
		JButton backButton = assignmentPanel.getBackButton();
		ActionListener backAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				prepareForWelcomeView();
			}
		};
		backButton.addActionListener(backAction);
		JButton createAssignmentButton = assignmentPanel.getCreateAssignmentButton();
		ActionListener createAssignmentAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doCreateAssignment();
			}
		};
		createAssignmentButton.addActionListener(createAssignmentAction);
		view.setMainPanel(assignmentPanel);
	}
	
	private void prepareForLoginView() {
		setCurrentView(OmViewConstant.LOGIN);
		loginPanel = new OmLoginPanel();
		JButton submitButton = loginPanel.getSubmitButton();
		ActionListener submitAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doLogin();
			}
		};
		submitButton.addActionListener(submitAction);
		ActionListener submitKeyAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doLogin();
			}
		};
		JTextField passwordField = loginPanel.getPassword();
		passwordField.addActionListener(submitKeyAction);
		view.setMainPanel(loginPanel);
	}

	private void prepareForWelcomeView() {
		setCurrentView(OmViewConstant.WELCOME);
		welcomePanel = new OmWelcomePanel();
		JButton assignmentButton = welcomePanel.getAssignmentButton();
		ActionListener assignmentAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				prepareForAssignmentView();
			}
		};
		assignmentButton.addActionListener(assignmentAction);
		JButton developmentButton = welcomePanel.getDevelopmentButton();
		ActionListener developmentAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				prepareForDevelopmentView();
			}
		};
		developmentButton.addActionListener(developmentAction);
		
		JButton neuerAnwendungsbereichButton = welcomePanel.getNeuerAnwendungsbereichButton();
		ActionListener neuerAnwendungsbereichAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				prepareForNeuerAnwendungsbereichView();
			}
		};
		neuerAnwendungsbereichButton.addActionListener(neuerAnwendungsbereichAction);
		
		JButton signaturesButton = welcomePanel.getSignaturesButton();
		ActionListener signaturesAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				prepareForSignaturesView();
			}
		};
		signaturesButton.addActionListener(signaturesAction);
		JButton publicationsButton = welcomePanel.getPublicationsButton();
		ActionListener publicationsAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				prepareForPublicationsView();
			}
		};
		publicationsButton.addActionListener(publicationsAction);
		JButton webAttachmentButton = welcomePanel.getwebAttachmenButton();
		ActionListener webAttachmentAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//SwingFileUploadFTP();
				prepareForWebAttachmentView();
			}
		};
		webAttachmentButton.addActionListener(webAttachmentAction);
		JButton logoutButton = welcomePanel.getLogoutButton();
		ActionListener logoutAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doLogout();
			}
		};
		logoutButton.addActionListener(logoutAction);
		view.setMainPanel(welcomePanel);
	}

	private void prepareForDevelopmentView(){
		setCurrentView(OmViewConstant.DEVELOPMENT);
		developmentPanel = new OmDevelopmentPanel();
		JButton backButton = developmentPanel.getBackButton();
		ActionListener backAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				prepareForWelcomeView();
			}
		};
		backButton.addActionListener(backAction);
		
		JButton runTestsSeleniumEhcButton = developmentPanel.getRunTestsSeleniumEhcButton();
		ActionListener runTestsSeleniumEhcAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doRunTestsSeleniumEhc();
			}
		};
		runTestsSeleniumEhcButton.addActionListener(runTestsSeleniumEhcAction);
		
		JButton runTestsSeleniumJobaButton = developmentPanel.getRunTestsSeleniumJobaButton();
		ActionListener runTestsSeleniumJobaAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doRunTestsSeleniumJoba();
			}
		};
		runTestsSeleniumJobaButton.addActionListener(runTestsSeleniumJobaAction);
		
		JButton runTestsSeleniumSkpButton = developmentPanel.getRunTestsSeleniumSkpButton();
		ActionListener runTestsSeleniumSkpAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doRunTestsSeleniumSkp();
			}
		};
		runTestsSeleniumSkpButton.addActionListener(runTestsSeleniumSkpAction);
		
		JButton runTestsSeleniumTcBwSuroButton = developmentPanel.getRunTestsSeleniumTcBwSuroButton();
		ActionListener runTestsSeleniumTcBwSuroAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doRunTestsSeleniumTcBwSuro();
			}
		};
		runTestsSeleniumTcBwSuroButton.addActionListener(runTestsSeleniumTcBwSuroAction);
		
		JButton createClientReportButton = developmentPanel.getCreateClientReportButton();
		ActionListener createClientReportAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doCreateClientReport();
			}
		};
		createClientReportButton.addActionListener(createClientReportAction);
		
		JButton runTestsOrgaManagerButton = developmentPanel.getRunTestsOrgaManagerButton();
		ActionListener runTestsOrgaManagerAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doRunTestsOrgaManager();
			}
		};
		runTestsOrgaManagerButton.addActionListener(runTestsOrgaManagerAction);
		
		JButton ehcWebAppTurnSwitchOnButton = developmentPanel.getEhcWebAppTurnSwitchOnButton();
		ActionListener ehcWebAppTurnSwitchOnAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doEhcWebAppTurnSwitchOn();
			}
		};
		ehcWebAppTurnSwitchOnButton.addActionListener(ehcWebAppTurnSwitchOnAction);
		
		JButton ehcWebAppTurnSwitchOffButton = developmentPanel.getEhcWebAppTurnSwitchOffButton();
		ActionListener ehcWebAppTurnSwitchOffAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doEhcWebAppTurnSwitchOff();
			}
		};
		ehcWebAppTurnSwitchOffButton.addActionListener(ehcWebAppTurnSwitchOffAction);
		
		JButton ehcWebAppSelfInstallButton = developmentPanel.getEhcWebAppSelfInstallButton();
		ActionListener ehcWebAppSelfInstallAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doEhcWebAppSelfInstall();
			}
		};
		ehcWebAppSelfInstallButton.addActionListener(ehcWebAppSelfInstallAction);
		
		JButton ehcWebAppSelfCheckButton = developmentPanel.getEhcWebAppSelfCheckButton();
		ActionListener ehcWebAppSelfCheckAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doEhcWebAppSelfCheck();
			}
		};
		ehcWebAppSelfCheckButton.addActionListener(ehcWebAppSelfCheckAction);
		
		JButton ehcWebAppSelfDescribeButton = developmentPanel.getEhcWebAppSelfDescribeButton();
		ActionListener ehcWebAppSelfDescribeAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doEhcWebAppSelfDescribe();
			}
		};
		ehcWebAppSelfDescribeButton.addActionListener(ehcWebAppSelfDescribeAction);
		
		JButton ehcWebAppSelfConfigureButton = developmentPanel.getEhcWebAppSelfConfigureButton();
		ActionListener ehcWebAppSelfConfigureAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doEhcWebAppSelfConfigure();
			}
		};
		ehcWebAppSelfConfigureButton.addActionListener(ehcWebAppSelfConfigureAction);
		
		JButton createGalleryButton = developmentPanel.getCreateGalleryButton();
		ActionListener createGalleryAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doCreateGallery();
			}
		};
		createGalleryButton.addActionListener(createGalleryAction);
		
		view.setMainPanel(developmentPanel);
	}

	private void prepareForPublicationsView() {
		setCurrentView(OmViewConstant.PUBLICATIONS);
		publicationsPanel =  new OmPublicationsPanel();
		JButton backButton = publicationsPanel.getBackButton();
		ActionListener backAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				prepareForWelcomeView();
			}
		};
		backButton.addActionListener(backAction);
		JButton createInvoiceButton = publicationsPanel.getCreatePublicationsButton();
		ActionListener createInvoiceAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doCreatePublications();
			}
		};
		createInvoiceButton.addActionListener(createInvoiceAction);
		view.setMainPanel(publicationsPanel);
	}
	
	
	
	private void prepareForNeuerAnwendungsbereichView() {
		
		setCurrentView(OmViewConstant.NEUERANWENDUNGSBEREICH);
		neuerAnwendungsbereichPanel =  new NewUseCasesPanel();
		JButton backButton = neuerAnwendungsbereichPanel.getBackButton();
		ActionListener backAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) { //go back action
				prepareForWelcomeView();
				
			}
		};
		backButton.addActionListener(backAction);
		
		
		JButton neuerAnwendungsbereichButton_1 = neuerAnwendungsbereichPanel.getCreateNeuerAnwendungsbereichButton(1);
		ActionListener neuerAnwendungsbereichAction_1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doNeuerAnwendungsbereichButton1();
			}
		};
		neuerAnwendungsbereichButton_1.addActionListener(neuerAnwendungsbereichAction_1);
		view.setMainPanel(neuerAnwendungsbereichPanel);
		
		JButton neuerAnwendungsbereichButton_2 = neuerAnwendungsbereichPanel.getCreateNeuerAnwendungsbereichButton(2);
		ActionListener neuerAnwendungsbereichAction_2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doNeuerAnwendungsbereichButton2();  													// Hier kann man dann Button 2 einbauen.
			}
		};
		neuerAnwendungsbereichButton_2.addActionListener(neuerAnwendungsbereichAction_2);
		view.setMainPanel(neuerAnwendungsbereichPanel);
		
		JButton neuerAnwendungsbereichButton_3 = neuerAnwendungsbereichPanel.getCreateNeuerAnwendungsbereichButton(3);
		ActionListener neuerAnwendungsbereichAction_3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doNeuerAnwendungsbereich();
			}
		};
		neuerAnwendungsbereichButton_3.addActionListener(neuerAnwendungsbereichAction_3);
		view.setMainPanel(neuerAnwendungsbereichPanel);
		
	}
	
	private void prepareForSignaturesView() {
		
			setCurrentView(OmViewConstant.SIGNATURES);
			signaturePanel =  new OmSignaturePanel();
			JButton backButton = signaturePanel.getBackButton();
			ActionListener backAction = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) { //go back action
					prepareForWelcomeView();
					
				}
			};
			backButton.addActionListener(backAction);
			JButton signatureButton = signaturePanel.getCreateSignatureButton();
			ActionListener signatureAction = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					doSignatures();
				}
			};
			signatureButton.addActionListener(signatureAction);
			view.setMainPanel(signaturePanel);
		}
	
	
	private void prepareForWebAttachmentView() {
		setCurrentView(OmViewConstant.WEBATTACHMENT);
		webAttachmentPanel =  new OmWebAttachmentPanel();
		JButton backButton = webAttachmentPanel.getBackButton();
		ActionListener backAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) { //go back action
				prepareForWelcomeView();
				
			}
		};
		backButton.addActionListener(backAction);
		JButton webAttachmentButton = webAttachmentPanel.getCreateWebAttachmentButton();
		ActionListener webAttachmentAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doCreateWebAttachments();
			}
		};
		webAttachmentButton.addActionListener(webAttachmentAction);
		view.setMainPanel(webAttachmentPanel);
	}
	
	@SuppressWarnings("deprecation")
	public void doLogin() {
		formUsername = loginPanel.getUsername().getText();
		formPassword = loginPanel.getPassword().getText();
		boolean successfulLoggedIn = model.doLogin(formUsername, formPassword);
		if (successfulLoggedIn) {
			isAuthorized = true;
			prepareForWelcomeView();
		} else {
			isAuthorized = false;
			prepareForLoginView();
		}
	}

	public void doLogout() {
		boolean successfulLoggedOut = model.doLogout();
		if (successfulLoggedOut) {
			isAuthorized = false;
			prepareForLoginView();
		}
	}
	
	public void doCreateAssignment(){
		model.doCreateAssignment();
	}
	
	public void doCreateClientReport(){
		model.doCreateClientReport();
	}
	
	public void doCreateGallery(){
		model.doCreateGallery();
	}
	
	public void doCreatePublications(){
		model.doCreatePublications();
	}
	
	public void doNeuerAnwendungsbereich(){
		model.doNeuerAnwendungsbereich();
	}
	
	public void doNeuerAnwendungsbereichButton1(){
		model.doNeuerAnwendungsbereichButton1();
	}
	
	public void doNeuerAnwendungsbereichButton2(){
		model.doNeuerAnwendungsbereichButton2();
	}
	
	public void doSignatures(){
		model.doSignatures();
	}
	
	public void doCreateWebAttachments(){
		model.doWebAttachment();
	}
	
	public void doRunTestsOrgaManager(){
		model.doRunTestsOrgaManager();
	}
	
	public void doRunTestsSeleniumEhc(){
		model.doRunTestsSeleniumEhc();
	}
	
	public void doRunTestsSeleniumJoba(){
		model.doRunTestsSeleniumJoba();
	}
	
	public void doRunTestsSeleniumSkp() {
		model.doRunTestsSeleniumSkp();
	}
	
	public void doRunTestsSeleniumTcBwSuro(){
		model.doRunTestsSeleniumTcBwSuro();
	}
	
	public void doEhcWebAppTurnSwitchOn(){
		model.doEhcWebAppTurnSwitchOn();
	}
	
	public void doEhcWebAppTurnSwitchOff(){
		model.doEhcWebAppTurnSwitchOff();
	}
	
	public void doEhcWebAppSelfInstall(){
		model.doEhcWebAppSelfInstall();
	}
	
	public void doEhcWebAppSelfDescribe(){
		model.doEhcWebAppSelfDescribe();
	}
	
	public void doEhcWebAppSelfConfigure(){
		model.doEhcWebAppSelfConfigure();
	}
	
	public void doEhcWebAppSelfCheck(){
		model.doEhcWebAppSelfCheck();
	}
	
	private void setCurrentView(OmViewConstant currentViewConstant){
		this.currentView = currentViewConstant;
	}
}
