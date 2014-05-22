package orgamanager.config;

public class SignatureConfig {

	private String workungDir; // path to the src folder
	private String imgPathFapsLogo;
	private String imgPathMidLogo; 
	private String gifPathLogoEDPC;
	private String pathToResourceFolder; // path to the resources: pics, owners ...
	private String pathToSignatures; //where to store the created signature files
	private String pathToZip; //where to store the .zip file
	
	
	public SignatureConfig() {
		this.setWorkungDir("C:\\Eclipse Workspace\\OrgaManager\\src\\");
		this.setImgPathFapsLogo("file:\\" + getWorkungDir() + "orgamanager\\files\\signatures\\faps_logo.png");
		this.setImgPathMidLogo("file:\\" +  getWorkungDir() + "orgamanager\\files\\signatures\\mid_logo.jpg");
		this.setGifPathLogoEDPC("file:\\" +  getWorkungDir() + "orgamanager\\files\\signatures\\LogoEDPC.gif");
		this.setPathToResourceFolder(getWorkungDir() + "orgamanager\\files\\signatures");
		this.setPathToSignatures(getWorkungDir() +"orgamanager\\files\\signatures");
		this.setPathToZip(getPathToSignatures() +"\\signatures.zip");
		
	}

	public String getPathToResourceFolder() {
		return pathToResourceFolder;
	}

	public void setPathToResourceFolder(String pathToResourceFolder) {
		this.pathToResourceFolder = pathToResourceFolder;
	}

	public String getGifPathLogoEDPC() {
		return gifPathLogoEDPC;
	}

	public void setGifPathLogoEDPC(String gifPathLogoEDPC) {
		this.gifPathLogoEDPC = gifPathLogoEDPC;
	}

	public String getImgPathMidLogo() {
		return imgPathMidLogo;
	}

	public void setImgPathMidLogo(String imgPathMidLogo) {
		this.imgPathMidLogo = imgPathMidLogo;
	}

	public String getImgPathFapsLogo() {
		return imgPathFapsLogo;
	}

	public void setImgPathFapsLogo(String imgPathFapsLogo) {
		this.imgPathFapsLogo = imgPathFapsLogo;
	}

	public String getWorkungDir() {
		return workungDir;
	}

	public void setWorkungDir(String workungDir) {
		this.workungDir = workungDir;
	}

	public String getPathToSignatures() {
		return pathToSignatures;
	}

	public void setPathToSignatures(String pathToSignatures) {
		this.pathToSignatures = pathToSignatures;
	}

	public String getPathToZip() {
		return pathToZip;
	}

	public void setPathToZip(String pathToZip) {
		this.pathToZip = pathToZip;
	}

}
