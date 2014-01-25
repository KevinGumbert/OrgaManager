package orgamanager.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import orgamanager.model.OmModel;
import orgamanager.view.OmLoginPanel;
import orgamanager.view.OmView;
import orgamanager.view.OmWelcomePanel;

public class OmController {

        private OmModel model;
    private OmView view;
    private OmLoginPanel loginPanel;
    private OmWelcomePanel welcomePanel;
    private boolean isLoginView;
        private boolean isWelcomeView;
        private boolean isPublicationsView;
        private boolean isSignaturesView;
        private boolean isAuthorized;
        private String formUsername;
        private String formPassword;
    
    public OmController(OmModel model, OmView view){
            this.model = model;
        this.view = view;
        isWelcomeView = false;
                isLoginView = false;
                isPublicationsView = false;
                isSignaturesView = false;
    }
    
    
    public void prepareForView(){
                if (isWelcomeView){
                        
                } else if (isPublicationsView){
                        
                } else if (isSignaturesView){
                        
                } else {
                        isLoginView = true;
                        prepareForLoginView();
                }
    }
    
    private void prepareForLoginView(){
                isWelcomeView = false;
                isLoginView = true;
                isPublicationsView = false;
                isSignaturesView = false;
                loginPanel = new OmLoginPanel();
                JButton submitButton = loginPanel.getSubmit();
                ActionListener submitAction = new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent arg0){
                                doSubmit();
                        }
                };
                submitButton.addActionListener(submitAction);
                view.getMainPanel().removeAll();
                view.getMainPanel().add(loginPanel);
                view.getMainPanel().validate();
        }
    
    private void prepareForWelcomeView(){
                isWelcomeView = true;
                isLoginView = false;
                isPublicationsView = false;
                isSignaturesView = false;
                welcomePanel = new OmWelcomePanel();
                JButton logoutButton = welcomePanel.getLogout();
                ActionListener logoutAction = new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent arg0){
                                doLogout();
                        }
                };
                logoutButton.addActionListener(logoutAction);
                view.getMainPanel().removeAll();
                view.getMainPanel().add(welcomePanel);
                view.getMainPanel().validate();
        }
    
    @SuppressWarnings("deprecation")
        public void doSubmit(){
            formUsername = loginPanel.getUsername().getText();
            formPassword = loginPanel.getPassword().getText();
            boolean successfulLoggedIn = model.doLogin(formUsername, formPassword);
            if (successfulLoggedIn){
                    isAuthorized = true;
                    prepareForWelcomeView();
            } else {
                    isAuthorized = false;
                    prepareForLoginView();
            }
            // TODO
    }
    
    public void doLogout(){
            boolean successfulLoggedOut = model.doLogout();
            if (successfulLoggedOut){
                    isAuthorized = false;
                    prepareForLoginView();
            }
    }
}
