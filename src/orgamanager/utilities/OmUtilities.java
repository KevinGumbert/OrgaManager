package orgamanager.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

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
	
	public String getProperty(String key){
		Reader reader = null;
		String value = "";
		try {
		  Properties prop = new Properties();
		  reader = new FileReader("properties.xml");
		  prop.load(reader);
		  value = prop.getProperty(key);
		} catch ( IOException e ){
		  e.printStackTrace();
		} finally {
		  try { reader.close(); } catch ( Exception e ) {e.printStackTrace();}
		}
		return value;
	}
	
	public void setProperty(String key, String value){
		Writer writer = null;
		Properties prop = new Properties();
		try {
		  writer = new FileWriter("properties.xml");
		  prop.setProperty(key, value);
		  prop.store(writer, "");
		} catch ( IOException e ){
		  e.printStackTrace();
		} finally {
		  try { writer.close(); } catch ( Exception e ) {e.printStackTrace();}
		}
	}
}
