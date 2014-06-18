package orgamanager.utilities;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.zip.*;

import javax.swing.JOptionPane;

import orgamanager.config.OmConfig;
import orgamanager.config.SignatureConfig;
import orgamanager.services.office.OfficeService;


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
		if (osName.contains("Windows")){
			return OmOperatingSystemConstant.WINDOWS;
		} else if (osName.equals("Linux")){
			return OmOperatingSystemConstant.LINUX;
		} else if (osName.contains("Mac")){
			return OmOperatingSystemConstant.MACOS;
		} else {
			return OmOperatingSystemConstant.UNKNOWN;
		}
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
	
	public boolean createFileAndSave(String location, String fileName){
		
		
		File file = new File(location + "\\" + fileName);
		
		try {
			file.createNewFile();
			
		} catch (Exception e) {
			System.out.println("No file " + fileName +" created");
		}
		
		if (file.exists()){
		    return true;
		} else {
			return false;
		}
	}
	
	
	
	
	
	public void createZip(File zipFile, File[] listFiles, String signaturesToZip) {
		
		
		
		SignatureConfig signatureConfig = new SignatureConfig();
		int buffer = 10240;
		try {
			byte b[] = new byte[buffer];
			FileOutputStream fout = new FileOutputStream(zipFile);
			ZipOutputStream out = new ZipOutputStream(fout);

			if (signaturesToZip == "Alle") { // zip all signatures
				
				for (int i = 0; i < listFiles.length; i++) {
					
					if (listFiles[i] == null || !listFiles[i].exists()
						|| listFiles[i].isDirectory())
						System.out.println("There are no files to zip");
				
					// don't put this files into the .zip file
					if (listFiles[i].getName().contains(signatureConfig.getNameFapsLogo()) 
						|| listFiles[i].getName().contains(signatureConfig.getNameEDPCLogo())
						|| listFiles[i].getName().contains(signatureConfig.getNameMidLogo())
						|| listFiles[i].getName().contains(signatureConfig.getNameOwnerFile())) {
					
						continue;					
					}
					
					ZipEntry addFiles = new ZipEntry(listFiles[i].getName());
					addFiles.setTime(listFiles[i].lastModified());
					out.putNextEntry(addFiles);

					FileInputStream fin = new FileInputStream(listFiles[i]);
					while (true) {
						int len = fin.read(b, 0, b.length);
						if (len <= 0)
							break;
						out.write(b, 0, len);
					}
					fin.close();
				}
				out.close();
				fout.close();
				System.out.println("Zip File is created successfully.");
				
			}else{ // if only one name was chosen to be zipped
				
				for (int i = 0; i < listFiles.length; i++) {
					
					if (listFiles[i] == null || !listFiles[i].exists()
							|| listFiles[i].isDirectory())
							System.out.println("There are no files to zip");
					
					if (listFiles[i].getName().contains(signaturesToZip)) {
						ZipEntry addFiles = new ZipEntry(listFiles[i].getName());
						addFiles.setTime(listFiles[i].lastModified());
						out.putNextEntry(addFiles);

						FileInputStream fin = new FileInputStream(listFiles[i]);
						while (true) {
							int len = fin.read(b, 0, b.length);
							if (len <= 0)
								break;
							out.write(b, 0, len);
						}
						fin.close();
					}
					out.close();
					fout.close();
					System.out.println("Zip File is created successfully.");
					
				}
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
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
	
	public void deleteFolders(File pathToFolders){
		
		SignatureConfig signatureConfig = new SignatureConfig();
		try {
			for ( File file : pathToFolders.listFiles() )
		    {
				if (file.getName().contains(signatureConfig.getNameFapsLogo()) 
						|| file.getName().contains(signatureConfig.getNameEDPCLogo())
						|| file.getName().contains(signatureConfig.getNameMidLogo())
						|| file.getName().contains(signatureConfig.getNameOwnerFile())) {
					
					continue;					
				}
				
		      if ( file.isDirectory() ){
		    	  deleteFolders( file );
		      }else
		        if ( ! file.delete() ) {
		          System.err.println( file + " could not be deleted!" );	    
		        }
		    }
					
			if ( ! pathToFolders.delete() )
			      System.err.println( pathToFolders + " could not be deleted!" );
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void deleteFilesFromFolder(String pathToFolder){
		
		File folder = new File(pathToFolder);
		File[] filesInFolder = folder.listFiles();
		
		
		for (int i = 0; i < filesInFolder.length; i++) {
			try {				
				filesInFolder[i].delete();		
				
			} catch (Exception e) {
				e.printStackTrace();
			}					
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
	
	public String executeHttpPost(String targetURL, String urlParameters){
		// see xyzws.com/Javafaq/how-to-use-httpurlconnection-post-data-to-web-server/139
		// String urlParameters =
		//        "fName=" + URLEncoder.encode("???", "UTF-8") +
		//        "&lName=" + URLEncoder.encode("???", "UTF-8")
		// TODO create unit tests
		URL url;
		String httpResponse;
		HttpURLConnection connection = null;
		try {
			// Create connection
			url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			// Send request
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
			// Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			httpResponse = response.toString();
			//System.out.println("HTTP-Resonse: " + httpResponse);
			return httpResponse;

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
	
	public String executeHttpGet(String targetURL, String urlParameters){
		URL url;
		String httpResponse;
		HttpURLConnection connection = null;
		try {
			// Create connection
			url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			// Send request
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
			// Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			httpResponse = response.toString();
			//System.out.println("HTTP-Resonse: " + httpResponse);
			return httpResponse;

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
	
	public String translateToEnglish(String word){
	
		if(word.contains("Nürnberg")){
			word = word.replace("ürn", "urem");
		}else {
			word = word.replace("ä", "ae");
			word = word.replace("ö", "oe");
			word = word.replace("ü", "ue");	
		}
	
		return word;
	}
	
	
	
	// TODO delete when other dialog wizards are existing
//	public String askForInvoiceJob(InvoicingParty party) {
//		List<String> jobs = party.getJobOptions();
//		Object[] jobPossibilities = new Object[jobs.size()];
//		jobPossibilities = jobs.toArray();
//		String job = party.getJob();
//		String jobInput = (String) JOptionPane.showInputDialog(
//				null, // parent frame
//				"Beruf:\n", // content
//				"OrgaManager", // title
//				JOptionPane.PLAIN_MESSAGE, 
//				null, // icon
//				jobPossibilities, // dropdown
//				job // default value
//				);
//		return jobInput;
//	}
}
