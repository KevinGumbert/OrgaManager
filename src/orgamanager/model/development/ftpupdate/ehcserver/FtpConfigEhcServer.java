package orgamanager.model.development.ftpupdate.ehcserver;

public class FtpConfigEhcServer {

	private String pathToServerRoot;
	private String pathToLocalRoot;
	private String ftpHost;
	private String ftpPort;
	private String ftpUser;
	private String ftpPass;
	
	public FtpConfigEhcServer() {
		pathToServerRoot = "xxx";
		pathToLocalRoot = "xxx";
		ftpHost = "xxx";
		ftpPort = "xxx";
		ftpUser = "xxx";
		ftpPass = "xxx";
	}
	
	public String getPathToServerRoot() {
		return pathToServerRoot;
	}
	public void setPathToServerRoot(String pathToServerRoot) {
		this.pathToServerRoot = pathToServerRoot;
	}
	public String getPathToLocalRoot() {
		return pathToLocalRoot;
	}
	public void setPathToLocalRoot(String pathToLocalRoot) {
		this.pathToLocalRoot = pathToLocalRoot;
	}
	public String getFtpHost() {
		return ftpHost;
	}
	public void setFtpHost(String ftpHost) {
		this.ftpHost = ftpHost;
	}
	public String getFtpPort() {
		return ftpPort;
	}
	public void setFtpPort(String ftpPort) {
		this.ftpPort = ftpPort;
	}
	public String getFtpUser() {
		return ftpUser;
	}
	public void setFtpUser(String ftpUser) {
		this.ftpUser = ftpUser;
	}
	public String getFtpPass() {
		return ftpPass;
	}
	public void setFtpPass(String ftpPass) {
		this.ftpPass = ftpPass;
	}
}
