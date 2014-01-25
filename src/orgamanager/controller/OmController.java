package orgamanager.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import orgamanager.model.OmModel;
import orgamanager.utilities.OmViewConstant;
import orgamanager.view.OmLoginPanel;
import orgamanager.view.OmView;
import orgamanager.view.OmWelcomePanel;

public class OmController {

	private OmModel model;
	private OmView view;
	private OmLoginPanel loginPanel;
	private OmWelcomePanel welcomePanel;
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
			case WELCOME:
				prepareForWelcomeView();
				break;
			default:
				setCurrentView(OmViewConstant.LOGIN);
				prepareForLoginView();
				break;
		}
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
	}
	
	private void prepareForSignaturesView() {
		setCurrentView(OmViewConstant.SIGNATURES);
		
	}

	private void prepareForPublicationsView() {
		setCurrentView(OmViewConstant.PUBLICATIONS);
		
	}

	private void prepareForOfficeView() {
		setCurrentView(OmViewConstant.OFFICE);
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
	
	private void setCurrentView(OmViewConstant currentViewConstant){
		this.currentView = currentViewConstant;
	}
}
