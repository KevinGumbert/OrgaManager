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
import orgamanager.view.OmOfficePanel;
import orgamanager.view.OmPublicationsPanel;
import orgamanager.view.OmView;
import orgamanager.view.OmWebAttachmentPanel;
import orgamanager.view.OmWelcomePanel;

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
	private OmOfficePanel officePanel;
	private OmDevelopmentPanel developmentPanel;
	private OmPublicationsPanel publicationsPanel;
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
			case OFFICE:
				prepareForOfficeView();
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
		JButton officeButton = welcomePanel.getOfficeButton();
		ActionListener officeAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				prepareForOfficeView();
			}
		};
		officeButton.addActionListener(officeAction);
		JButton developmentButton = welcomePanel.getDevelopmentButton();
		ActionListener developmentAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				prepareForDevelopmentView();
			}
		};
		developmentButton.addActionListener(developmentAction);
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
	
	private void prepareForSignaturesView() {
		setCurrentView(OmViewConstant.SIGNATURES);
		// TODO
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

	private void prepareForOfficeView() {
		setCurrentView(OmViewConstant.OFFICE);
		officePanel = new OmOfficePanel();
		JButton backButton = officePanel.getBackButton();
		ActionListener backAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				prepareForWelcomeView();
			}
		};
		backButton.addActionListener(backAction);
		JButton createInvoiceButton = officePanel.getCreateInvoiceButton();
		ActionListener createInvoiceAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doCreateInvoice();
			}
		};
		createInvoiceButton.addActionListener(createInvoiceAction);
		view.setMainPanel(officePanel);
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
	
	public void doCreateInvoice(){
		model.doCreateInvoice();
	}
	
	public void doCreatePublications(){
		model.doCreatePublications();
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
	
	private void setCurrentView(OmViewConstant currentViewConstant){
		this.currentView = currentViewConstant;
	}
}
