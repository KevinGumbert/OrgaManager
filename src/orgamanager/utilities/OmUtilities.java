package orgamanager.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
import java.util.Scanner;

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
			//JOptionPane.showMessageDialog(null, dialogText, dialogTitle, JOptionPane.PLAIN_MESSAGE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public String readStringFromFile(String path) throws FileNotFoundException{
		String content = "";
		Scanner in = new Scanner(new FileReader(path));
        while (in.hasNextLine()){
        	content += in.nextLine() + "\n";
        }
        in.close();
		return content;
	}
	
	public String cutStringAfterFirstOccuranceOfDelimiter(String fullString, char delimiter){
		String shortString = "";
		int indexOf = fullString.indexOf(delimiter);
		shortString = fullString.substring((indexOf + 1));
		return shortString;
	}
	
	public String cutStringAfterLastOccuranceOfDelimiter(String fullString, char delimiter){
		String shortString = "";
		int lastIndexOf = fullString.lastIndexOf(delimiter);
		shortString = fullString.substring(0, lastIndexOf);
		return shortString;
	}
	
	public String pickChildString(String str, char leftDelimiter, char rightDelimiter){
		String s1 = cutStringAfterFirstOccuranceOfDelimiter(str, leftDelimiter);
		String shortString = cutStringAfterLastOccuranceOfDelimiter(s1, rightDelimiter);
		return shortString;
	}
	
	public String replaceBibtexChars(String str){
		// Note: new instances are necessary due to replace-method;
		// ae, oe, ue, dg(""), ss, ~ (-), Ae, Oe, Ue, &, c-gehakt, e-akzent
		String newStringInstance = "";
		String afterAnd = "";
		CharSequence targetAnd = "{\\&}";
		CharSequence replacementAnd = "&";
		afterAnd = str.replace(targetAnd, replacementAnd);
		String afterEaccent = "";
		CharSequence targetEaccent = "{\\'e}";
		CharSequence replacementEaccent = "e";
		afterEaccent = afterAnd.replace(targetEaccent, replacementEaccent);
		String afterSpecialC = "";
		CharSequence targetSpecialC = "{\\'c}";
		CharSequence replacementSpecialC = "c";
		afterSpecialC = afterEaccent.replace(targetSpecialC, replacementSpecialC);
		String afterOeuc = "";
		CharSequence targetOeuc = "{\\\"O}";
		CharSequence replacementOeuc = "Ö";
		afterOeuc = afterSpecialC.replace(targetOeuc, replacementOeuc);
		String afterUeuc = "";
		CharSequence targetUeuc = "{\\\"U}";
		CharSequence replacementUeuc = "Ü";
		afterUeuc = afterOeuc.replace(targetUeuc, replacementUeuc);
		String afterAeuc = "";
		CharSequence targetAeuc = "{\\\"A}";
		CharSequence replacementAeuc = "Ä";
		afterAeuc = afterUeuc.replace(targetAeuc, replacementAeuc);
		String afterOe = "";
		CharSequence targetOe = "{\\\"o}";
		CharSequence replacementOe = "ö";
		afterOe = afterAeuc.replace(targetOe, replacementOe);
		String afterUe = "";
		CharSequence targetUe = "{\\\"u}";
		CharSequence replacementUe = "ü";
		afterUe = afterOe.replace(targetUe, replacementUe);
		String afterAe = "";
		CharSequence targetAe = "{\\\"a}";
		CharSequence replacementAe = "ä";
		afterAe = afterUe.replace(targetAe, replacementAe);
		String afterSharps = "";
		CharSequence targetSharps = "{\\ss}";
		CharSequence replacementSharps = "ß";
		afterSharps = afterAe.replace(targetSharps, replacementSharps);
		String afterDg = "";
		afterDg = afterSharps.replaceAll("\\{\\\\dq\\}", "\"");
		String afterTilde = "";
		CharSequence targetTilde = "~";
		CharSequence replacementTilde = "-";
		afterTilde = afterDg.replace(targetTilde, replacementTilde);
		newStringInstance = afterTilde;
		return newStringInstance;
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
	
	public boolean createDir(String path){
		boolean success = (new File(path)).mkdirs();
		if (success) {
		    return true;
		} else {
			return false;
		}
	}
	
	public boolean createFile(String path){
		File file = new File(path);
		if (file.exists()){
		    return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteFile(String path){
		File file = new File(path);
		boolean res = file.delete();
		if (res){
		    return true;
		} else {
			return false;
		}
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
	
	public boolean exec(String command, String param){
		JOptionPane.showMessageDialog(null, ("Exec-Call: " + command + " " + param), "OrgaManager", JOptionPane.PLAIN_MESSAGE);
		try {
			String com = command + " " + param;
			Process p = Runtime.getRuntime().exec(com);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line=reader.readLine();
            while (line != null) {    
                System.out.println(line);
                line = reader.readLine();
            }
        } catch(IOException e1) { return false; 
        } catch(InterruptedException e2) { return false;}
        System.out.println("exec finished.");
	    return true;
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
