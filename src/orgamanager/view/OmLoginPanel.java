package orgamanager.view;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import orgamanager.utilities.OmConfig;

public class OmLoginPanel extends JPanel {

	private JLabel headerLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField username;
	private JPasswordField password;
	private JButton submit;

	public OmLoginPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		OmConfig config = new OmConfig();
		this.setPreferredSize(config.getMainPanelDimension());
		headerLabel = new JLabel("Einloggen");
		headerLabel.setPreferredSize(new Dimension(600, 50));
		usernameLabel = new JLabel("Nutzername", JLabel.RIGHT);
		passwordLabel = new JLabel("Passwort", JLabel.RIGHT);
		username = new JTextField();
		username.setMaximumSize(new Dimension(250, 30));
		password = new JPasswordField();
		password.setMaximumSize(new Dimension(250, 30));
		submit = new JButton("Absenden");
		this.add(headerLabel);
		this.add(usernameLabel);
		this.add(username);
		this.add(passwordLabel);
		this.add(password);
		this.add(submit);
	}

	public JLabel getHeaderLabel() {
		return headerLabel;
	}

	public void setHeaderLabel(JLabel headerLabel) {
		this.headerLabel = headerLabel;
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

	public JButton getSubmit() {
		return submit;
	}

	public void setSubmit(JButton submit) {
		this.submit = submit;
	}
}