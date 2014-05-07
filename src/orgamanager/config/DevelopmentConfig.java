package orgamanager.config;

public class DevelopmentConfig {
	
	private String fhemServerIp;
	
	public DevelopmentConfig() {
		this.fhemServerIp = "";
	}
	
	public String getFhemServerIp(){
		return this.fhemServerIp;
	}
	
}
