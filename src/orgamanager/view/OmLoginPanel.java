package orgamanager.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import orgamanager.config.OmConfig;

public class OmLoginPanel extends JPanel {

	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField username;
	private JPasswordField password;
	private JButton submitButton;
	private OmConfig config;

	public OmLoginPanel() {
		config = new OmConfig();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createTitledBorder(config.getMessage("loginPanelTitleText")));
		this.setPreferredSize(config.getMainPanelDimension());
		usernameLabel = new JLabel("Nutzername", JLabel.LEFT);
		passwordLabel = new JLabel("Passwort", JLabel.LEFT);
		username = new JTextField();
		username.setMaximumSize(new Dimension(250, 30));
		username.setAlignmentX(LEFT_ALIGNMENT);
		password = new JPasswordField();
		password.setMaximumSize(new Dimension(250, 30));
		password.setAlignmentX(LEFT_ALIGNMENT);
		submitButton = new JButton("Absenden");
		this.add(Box.createRigidArea(new Dimension(10,10)));
		this.add(usernameLabel);
		this.add(username);
		this.add(Box.createRigidArea(new Dimension(10,10)));
		this.add(passwordLabel);
		this.add(password);
		this.add(Box.createRigidArea(new Dimension(10,10)));
		this.add(submitButton);
	}

	public JLabel getUsernameLabel() {
		return usernameLabel;
	}

	public void setUsernameLabel(JLabel usernameLabel) {
		this.usernameLabel = usernameLabel;
	}

	public JLabel getPasswordLabel() {
		return passwordLabel;
	}

	public void setPasswordLabel(JLabel passwordLabel) {
		this.passwordLabel = passwordLabel;
	}

	public JTextField getUsername() {
		return username;
	}

	public void setUsername(JTextField username) {
		this.username = username;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	public JButton getSubmitButton() {
		return submitButton;
	}

	public void setSubmit(JButton submitButton) {
		this.submitButton = submitButton;
	}
}