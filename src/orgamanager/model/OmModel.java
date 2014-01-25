package orgamanager.model;

import javax.swing.JOptionPane;

import orgamanager.utilities.OmConfig;

public class OmModel {

	private OmConfig config;
	private boolean isAuthorized;

	public OmModel() {
		config = new OmConfig();
		isAuthorized = false;
	}

	public int doSignatures() {
		System.out.println("doSignatures");
		return 0;
	}

	public boolean doLogin(String username, String password) {
		if (username.equals(config.getUsername())
				&& password.equals(config.getPassword())) {
			isAuthorized = true;
			// JOptionPane.showMessageDialog(null, "BP1", "Debug",
			// JOptionPane.WARNING_MESSAGE);
			return true;
		}
		return false;
	}

	public boolean doLogout() {
		isAuthorized = false;
		return true;
	}

}
