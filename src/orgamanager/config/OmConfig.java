package orgamanager.config;

import java.awt.Dimension;
import java.util.List;

import orgamanager.utilities.OmPublicationConstant;

public class OmConfig { // principle: favour composition over inheritance (FCOI), relations to other config classes are created by properties;
	
	private GuiConfig guiConfig; 
	private MainConfig mainConfig;
	private DevelopmentConfig developmentConfig;
	private PublicationsConfig publicationsConfig;
	private WebAttachmentConfig webAttachmentConfig;
	
	public OmConfig(){
		this.guiConfig				= new GuiConfig();
		this.mainConfig 			= new MainConfig();
		this.developmentConfig 		= new DevelopmentConfig();
		this.publicationsConfig 	= new PublicationsConfig();
		this.webAttachmentConfig 	= new WebAttachmentConfig();
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

	public PublicationsConfig getPublicationsConfig() {
		return publicationsConfig;
	}

	public void setPublicationsConfig(PublicationsConfig publicationsConfig) {
		this.publicationsConfig = publicationsConfig;
	}
	
	public WebAttachmentConfig getWebAttachmentConfig() {
		return webAttachmentConfig;
	}

	public void setWebAttachmentsConfig(WebAttachmentConfig webAttachmentsConfig) {
		this.webAttachmentConfig = webAttachmentsConfig;
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
	
	public String getMessage(String message) {
		return guiConfig.getMessage(message);
	}
	
	public String getDevelopmentFhemServerIp() {
		return developmentConfig.getFhemServerIp();
	}
	
	public Dimension getMainPanelDimension(){
		return guiConfig.getMainPanelDimension();
	}

}
