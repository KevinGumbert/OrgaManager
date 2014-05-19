package orgamanager.model.signatures;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import orgamanager.utilities.*;

//TODO put this later to OmUtilities
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class SignatureList {
	OmUtilities omUtilities;
	ArrayList<SignatureOwner> owners;
	ArrayList<Signature> signatures;

	public SignatureList(String pathToResourceFolder, String fileName) {
		// Ordnerstruktur muss sein:
		// mitarbeiter.xml, vorlage_faps_de.html, ...
		// Anlegen der Grundstruktur
		owners = new ArrayList<SignatureOwner>();
		signatures =  new ArrayList<Signature>();

		// Schritt: Mitarbeiterdatei 'mitarbeiter.xml'einlesen und
		// SignatureOwner-Objekte bilden
		String str;
		String pathToOwnerFile = pathToResourceFolder + "\\" + fileName;//"\\univis-mitarbeiter-02052014.xml"; 
		owners = parseXmlFile(pathToOwnerFile);
		signatures = new ArrayList<Signature>();
		Signature fapsDeHtmlSig = new Signature();
		fapsDeHtmlSig.setName("faps-de-html");
		fapsDeHtmlSig.setIcon("faps-logo.png");
		fapsDeHtmlSig.setEvent("");
		fapsDeHtmlSig.setGreetings("");
		// do not forget to add relation to owner
		signatures.add(fapsDeHtmlSig);
		Signature fapsDeHtmlMfgSig = new Signature();
		fapsDeHtmlMfgSig.setName("faps-de-html");
		fapsDeHtmlMfgSig.setIcon("faps-logo.png");
		fapsDeHtmlMfgSig.setEvent("");
		fapsDeHtmlMfgSig.setGreetings("Mit freundlichen Grüßen");
		// do not forget to add relation to owner
		signatures.add(fapsDeHtmlSig);
		// create relations for all objects
		for (SignatureOwner owner : owners){ // iterate through list
			for (Signature signature : signatures){
				signature.setOwner(owner); // TODO check if owner-object get copied.
			}
		}
		// all objects should be created!
	}

	public ArrayList<SignatureOwner> parseXmlFile(String pathToFile) {// TODO set to private
		// Ziel: Liste von Mitarbeitern also SignatureOwner ist befuellt.

		omUtilities = new OmUtilities();

		// read the file
		try {
			File fXmlFile = new File(pathToFile);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			//System.out.println("Root element :"+ doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("Person");
			//System.out.println("----------------------------");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					SignatureOwner signatureOwner = new SignatureOwner(
							eElement.getElementsByTagName("firstname").item(0).getTextContent(),
							eElement.getElementsByTagName("lastname").item(0).getTextContent(),
							eElement.getElementsByTagName("email").item(0).getTextContent(),
							eElement.getElementsByTagName("fax").item(0).getTextContent(),
							eElement.getElementsByTagName("tel").item(0).getTextContent(),
							eElement.getElementsByTagName("ort").item(0).getTextContent(), 
							eElement.getElementsByTagName("street").item(0).getTextContent(), 
							eElement.getElementsByTagName("title").item(0).getTextContent(),
							eElement.getElementsByTagName("id").item(0).getTextContent());
					owners.add(signatureOwner);
					
					//System.out.println("firstname : "+ eElement.getElementsByTagName("firstname").item(0).getTextContent());
					//System.out.println("id : "+ eElement.getElementsByTagName("id").item(0).getTextContent());
					//System.out.println("Last Name : "+ eElement.getElementsByTagName("lastname").item(0).getTextContent());
					//System.out.println("email : "+ eElement.getElementsByTagName("email").item(0).getTextContent());
					//System.out.println("fax : "+ eElement.getElementsByTagName("fax").item(0).getTextContent());
					//System.out.println("ort : "+ eElement.getElementsByTagName("ort").item(0).getTextContent());
					
					//System.out.println("office : "+ eElement.getElementsByTagName("office").item(0).getTextContent());
					
					//System.out.println("street : "+ eElement.getElementsByTagName("street").item(0).getTextContent());
					//System.out.println("tel : "+ eElement.getElementsByTagName("tel").item(0).getTextContent());
					//System.out.println("title : "+ eElement.getElementsByTagName("title").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return owners;
	}

	public String getSignaturesAsArchive(String pathToFile) { // TODO
		// Ziel: Archivdatei bilden
		
		/*Vorgehen:
		 * .txt Datei der Signatur in 
		 * zu .zip umwandeln un am gewuenschten Ort ablegen
		 * */
//		omUtilities.createFile(pathToFile);
//		omUtilities.printStringToFile(signature.signature, "Desktop\\newFile.txt");
		
		// Siehe dazu CONVERT FILE TO .ZIP FORMAT
		return null;
	}
}

/*
 * CONVERT FILE TO .ZIP FORMAT in OmUtilities packen import java.io.*; import
 * java.util.zip.*;
 * 
 * public class CreateZip { 
 * 	public static int buffer = 10240; 
 * 	protected void createZip(File zipFile, File[] listFiles) { 
 * 	try { byte b[] = new
 * 	byte[buffer]; 
 * 	FileOutputStream fout = new FileOutputStream(zipFile);
 * 	ZipOutputStream out = new ZipOutputStream(fout); 
 * 
 * 	for (int i = 0; i < listFiles.length; i++) { 
 * 		if (listFiles[i] == null || !listFiles[i].exists()|| listFiles[i].isDirectory()) 
 * 			System.out.println(); 
 * 
 * 	ZipEntry addFiles = new ZipEntry(listFiles[i].getName());
 * 	addFiles.setTime(listFiles[i].lastModified()); out.putNextEntry(addFiles);
 * 
 * 	FileInputStream fin = new FileInputStream(listFiles[i]); 
 * 	while (true) { 
 * 		int len = fin.read(b, 0, b.length); 
 * 		if (len <= 0) break; 
 * 		out.write(b, 0, len); 
 * 	}
 * 	fin.close(); 
 * 	} 
 * out.close(); 
 * fout.close();
 * System.out.println("Zip File is created successfully."); 
 * } catch (Exception ex) {
 * 
 * } 
 * } 
 * public static void main(String[]args){ 
 * CreateJar jar=new CreateJar(); 
 * File folder = new File("C://Answers//Examples"); 
 * File[] files = folder.listFiles(); 
 * File file=new File("C://Answers//Examples//Examples.zip"); 
 * jar.createZip(file, files); 
 * } 
 * }
 */
