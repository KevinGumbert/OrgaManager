package orgamanager.utilities;

import java.awt.Dimension;

public class OmConfig {
	public String username = "xxx";
	public String password = "xxx";
	public Dimension mainPanelDimension;
	
	public OmConfig(){
		this.mainPanelDimension = new Dimension(600, 400);
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Dimension getMainPanelDimension() {
		return this.mainPanelDimension;
	}
}
