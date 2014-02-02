package orgamanager.utilities;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class OmConfig {
	public String username = "xxx";
	public String password = "xxx";
	public Dimension mainPanelDimension;
	public Locale locale;
	public ArrayList<OmPublicationConstant> publicationsTypesToShow;
	
	public ArrayList<String> publicationsBookAuthorsToShow;
	public ArrayList<String> publicationsBookConstraints; /** keywords to prevent publication */
	public ResourceBundle messages;
	
	public OmConfig(){
		this.mainPanelDimension = new Dimension(600, 400);
		this.locale = new Locale("de", "DE");
		this.messages = ResourceBundle.getBundle("Messages");
		publicationsTypesToShow = new ArrayList<OmPublicationConstant>();
		publicationsTypesToShow.add(OmPublicationConstant.ARTICLE);
		publicationsTypesToShow.add(OmPublicationConstant.BOOK);
		publicationsTypesToShow.add(OmPublicationConstant.INCOLLECTION);
		publicationsTypesToShow.add(OmPublicationConstant.INPROCEEDING);
		publicationsBookAuthorsToShow = new ArrayList<String>();
		publicationsBookAuthorsToShow.add("Jörg Franke");
		publicationsBookAuthorsToShow.add("Klaus Feldmann");
		publicationsBookConstraints = new ArrayList<String>();
		publicationsBookConstraints.add("Faps-TT");
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
	
	public ArrayList<OmPublicationConstant> getPublicationsTypesToShow() {
		return publicationsTypesToShow;
	}

	public void setPublicationsTypesToShow(
			ArrayList<OmPublicationConstant> publicationsTypesToShow) {
		this.publicationsTypesToShow = publicationsTypesToShow;
	}

	public ArrayList<String> getPublicationsBookAuthorsToShow() {
		return publicationsBookAuthorsToShow;
	}

	public void setPublicationsBookAuthorsToShow(
			ArrayList<String> publicationsBookAuthorsToShow) {
		this.publicationsBookAuthorsToShow = publicationsBookAuthorsToShow;
	}

	public ArrayList<String> getPublicationsBookConstraints() {
		return publicationsBookConstraints;
	}

	public void setPublicationsBookConstraints(
			ArrayList<String> publicationsBookConstraints) {
		this.publicationsBookConstraints = publicationsBookConstraints;
	}

}
