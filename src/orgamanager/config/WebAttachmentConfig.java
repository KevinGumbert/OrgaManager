package orgamanager.config;

public class WebAttachmentConfig {
	private String username;
	private String password;
	private String host;
	private int port;
		
	public WebAttachmentConfig() {
		this.port = 21;
		this.username = "xxx"; 
		this.password = "xxx";
		this.host = "xxx";
	}
	
	public WebAttachmentConfig(String username, String password){
		this.setUsername(username);
		this.setPassword(password);
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
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return this.port;
	}
}