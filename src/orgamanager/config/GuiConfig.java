package orgamanager.config;

import java.awt.Dimension;
import java.util.Locale;
import java.util.ResourceBundle;

public class GuiConfig {

	public ResourceBundle messages;
	public Dimension mainPanelDimension;
	public Locale locale;
	
	public GuiConfig(){
		this.mainPanelDimension = new Dimension(600, 400);
		this.locale = new Locale("de", "DE"); 
		this.messages = ResourceBundle.getBundle("Messages");
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
