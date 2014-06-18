package orgamanager.config;

public class SignatureConfig {

	private String workungDir; // path to the src folder
	private String imgPathFapsLogo;
	private String imgPathMidLogo; 
	private String gifPathLogoEDPC;
	private String pathToResourceFolder; // path to the resources: pics, owners ...
	private String pathToSignatures; //where to store the created signature files
	private String pathToZip; //where to store the .zip file
	private String nameFapsLogo;
	private String nameEDPCLogo;
	private String nameMidLogo;
	private String nameOwnerFile;
	
	public SignatureConfig() {
		this.setWorkungDir("C:\\Eclipse Workspace\\OrgaManager\\src\\"); // Check
		this.setImgPathFapsLogo("file:\\\\\\" + getWorkungDir() + "orgamanager\\files\\signatures\\faps_logo.png");
		this.setImgPathMidLogo("file:\\\\\\" +  getWorkungDir() + "orgamanager\\files\\signatures\\mid_logo.jpg");
		this.setGifPathLogoEDPC("file:\\\\\\" +  getWorkungDir() + "orgamanager\\files\\signatures\\LogoEDPC.gif");
		this.setPathToResourceFolder(getWorkungDir() + "orgamanager\\files\\signatures");
		this.setPathToSignatures(getWorkungDir() +"orgamanager\\files\\signatures");
		this.setPathToZip(getPathToSignatures() +"\\signatures.zip");	
		this.setNameFapsLogo("faps_logo.png");
		this.setNameEDPCLogo("LogoEDPC.gif");
		this.setNameMidLogo("mid_logo.jpg");
		this.setNameOwnerFile("owners.xml");
		
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

	public String getNameFapsLogo() {
		return nameFapsLogo;
	}

	public void setNameFapsLogo(String nameFapsLogo) {
		this.nameFapsLogo = nameFapsLogo;
	}

	public String getNameEDPCLogo() {
		return nameEDPCLogo;
	}

	public void setNameEDPCLogo(String nameEDPCLogo) {
		this.nameEDPCLogo = nameEDPCLogo;
	}

	public String getNameMidLogo() {
		return nameMidLogo;
	}

	public void setNameMidLogo(String nameMidLogo) {
		this.nameMidLogo = nameMidLogo;
	}

	public String getNameOwnerFile() {
		return nameOwnerFile;
	}

	public void setNameOwnerFile(String nameOwnerFile) {
		this.nameOwnerFile = nameOwnerFile;
	}
	


}
