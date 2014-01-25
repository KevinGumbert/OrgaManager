package orgamanager.utilities;

import java.awt.Dimension;
import java.util.Locale;
import java.util.ResourceBundle;

public class OmConfig {
	public String username = "xxx";
	public String password = "xxx";
	public Dimension mainPanelDimension;
	public Locale locale;
	public ResourceBundle messages;
	
	public OmConfig(){
		this.mainPanelDimension = new Dimension(600, 400);
		this.locale = new Locale("de", "DE");
		this.messages = ResourceBundle.getBundle("Messages");
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
	
	public Locale getLocale() {
		return this.locale;
	}
	
	public String getMessage(String key){
		return messages.getString(key);
	}
}
