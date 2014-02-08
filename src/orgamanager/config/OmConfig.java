package orgamanager.config;

import java.awt.Dimension;
import java.util.List;

import orgamanager.utilities.OmPublicationConstant;

public class OmConfig { // principle: favour composition over inheritance (FCOI), relations to other config classes are created by properties;
	
	private GuiConfig guiConfig;
	private MainConfig mainConfig;
	private OfficeConfig officeConfig;
	private PublicationsConfig publicationsConfig;
	
	public OmConfig(){
		this.guiConfig			= new GuiConfig();
		this.mainConfig 		= new MainConfig();
		this.officeConfig 		= new OfficeConfig();
		this.publicationsConfig = new PublicationsConfig();
	}
	
	public GuiConfig getGuiConfig() {
		return guiConfig;
	}

	public void setGuiConfig(GuiConfig guiConfig) {
		this.guiConfig = guiConfig;
	}
	
	public MainConfig getMainConfig() {
		return mainConfig;
	}

	public void setMainConfig(MainConfig mainConfig) {
		this.mainConfig = mainConfig;
	}

	public OfficeConfig getOfficeConfig() {
		return officeConfig;
	}

	public void setOfficeConfig(OfficeConfig officeConfig) {
		this.officeConfig = officeConfig;
	}

	public PublicationsConfig getPublicationsConfig() {
		return publicationsConfig;
	}

	public void setPublicationsConfig(PublicationsConfig publicationsConfig) {
		this.publicationsConfig = publicationsConfig;
	}
	
	public String getUsername(){
		String username = mainConfig.getUsername();
		return username;
	}
	
	public String getPassword(){
		String username = mainConfig.getPassword();
		return username;
	}
	
	public List<OmPublicationConstant> getPublicationsTypesToShow(){
		return publicationsConfig.getPublicationsTypesToShow();
	}
	
	public List<String> getPublicationsBookAuthorsToShow(){
		return publicationsConfig.getPublicationsBookAuthorsToShow();
	}
	
	public List<String> getPublicationsBookConstraints(){
		return publicationsConfig.getPublicationsBookConstraints();
	}
	
	public String getMessage(String message){
		return guiConfig.getMessage(message);
	}
	
	public Dimension getMainPanelDimension(){
		return guiConfig.getMainPanelDimension();
	}

}
