package orgamanager.config;

public class MainConfig {

	private String username;
	private String password;
	
	public MainConfig(){
		this.username = "xxx"; 
		this.password = "xxx";
	}
	
	public MainConfig(String username, String password){
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
	
}
