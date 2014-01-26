package orgamanager.utilities;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JOptionPane;

public class OmUtilities {

	public boolean printStringToFile(String content, String path){
		PrintWriter writer;
		try {
			writer = new PrintWriter(path, "UTF-8");
			writer.println(content);
			writer.close();
			OmConfig config = new OmConfig();
			String dialogTitle = config.getMessage("dialogTitle");
			String dialogText = config.getMessage("dialogTextFilePrinted");
			JOptionPane.showMessageDialog(null, dialogText, dialogTitle, JOptionPane.PLAIN_MESSAGE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public OmOperatingSystemConstant detectOperatingSystem(){
		String osName = System.getProperty("os.name");
		if (osName.equals("Windows")){
			return OmOperatingSystemConstant.WINDOWS;
		} else if (osName.equals("Linux")){
			return OmOperatingSystemConstant.LINUX;
		} else {
			return OmOperatingSystemConstant.UNKNOWN;
		}
		// TODO Mac
	}
}
