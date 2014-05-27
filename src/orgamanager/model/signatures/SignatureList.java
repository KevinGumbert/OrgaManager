package orgamanager.model.signatures;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import orgamanager.utilities.*;
import orgamanager.config.SignatureConfig;

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
	SignatureConfig signatureConfig;
	ArrayList<SignatureOwner> owners;
	ArrayList<Signature> signatures;

	public SignatureList(String pathToResourceFolder, String fileName) {
		omUtilities = new OmUtilities();
		signatureConfig = new SignatureConfig();		
		owners = new ArrayList<SignatureOwner>();
		signatures =  new ArrayList<Signature>();
		
		//create signatures for each owner
		String pathToOwnerFile = pathToResourceFolder + "\\" + fileName;//"\\univis-mitarbeiter-02052014.xml"; 
		owners = parseXmlFile(pathToOwnerFile);
		signatures = new ArrayList<Signature>();
		
		
		for (SignatureOwner owner : owners) {
			
			//create signature.txt
			Signature fapsDetxtSig = new Signature();
			String txtSignature = fapsDetxtSig.getSignatureAsString(owner);
			omUtilities.createFileAndSave(pathToResourceFolder, "signature"+owner.getFirstname()+owner.getLastname()+".txt");
			omUtilities.printStringToFile(txtSignature, pathToResourceFolder + "\\signature"+owner.getFirstname()+owner.getLastname()+".txt");
			
			//create signatureMFG.txt
			Signature fapsDetxtSigMFG = new Signature();
			String txtSignatureMFG = fapsDetxtSigMFG.getSignatureAsStringMFG(owner);
			omUtilities.createFileAndSave(pathToResourceFolder, "signature"+owner.getFirstname()+owner.getLastname()+"_MFG.txt");
			omUtilities.printStringToFile(txtSignatureMFG, pathToResourceFolder + "\\signature"+owner.getFirstname()+owner.getLastname()+"_MFG.txt");
			
			
			//create signature.html
			Signature fapsDeHtmlSig = new Signature();
			String htmlSignature = fapsDeHtmlSig.getSignatureAsStringHtml(owner);
			omUtilities.createFileAndSave(pathToResourceFolder, "signature"+owner.getFirstname()+owner.getLastname()+".html");
			omUtilities.printStringToFile(htmlSignature, pathToResourceFolder + "\\signature"+owner.getFirstname()+owner.getLastname()+"_MFG.html");
			
			//create signatureMFG.html
			Signature fapsDeHtmlSigMFG = new Signature();
			String htmlSignatureMFG = fapsDeHtmlSigMFG.getSignatureAsStringHtmlMFG(owner);
			omUtilities.createFileAndSave(pathToResourceFolder, "signature"+owner.getFirstname()+owner.getLastname()+".html");
			omUtilities.printStringToFile(htmlSignatureMFG, pathToResourceFolder + "\\signature"+owner.getFirstname()+owner.getLastname()+"_MFG.html");
			
		}	
		
		//code for HTML-Signatures
//		Signature fapsDeHtmlSig = new Signature();
//		fapsDeHtmlSig.setName("faps-de-html");
//		fapsDeHtmlSig.setIcon("faps-logo.png");
//		fapsDeHtmlSig.setEvent("");
//		fapsDeHtmlSig.setGreetings("");
//		// do not forget to add relation to owner
//		signatures.add(fapsDeHtmlSig);
//		Signature fapsDeHtmlMfgSig = new Signature();
//		fapsDeHtmlMfgSig.setName("faps-de-html");
//		fapsDeHtmlMfgSig.setIcon("faps-logo.png");
//		fapsDeHtmlMfgSig.setEvent("");
//		fapsDeHtmlMfgSig.setGreetings("Mit freundlichen Grüßen");
//		// do not forget to add relation to owner
//		signatures.add(fapsDeHtmlSig);
//		// create relations for all objects
//		for (SignatureOwner owner : owners){ // iterate through list
//			for (Signature signature : signatures){
//				signature.setOwner(owner); // TODO check if owner-object get copied.
//			}
//		}
		// all objects should be created!
	}

	private ArrayList<SignatureOwner> parseXmlFile(String pathToFile) {
		// Ziel: Liste von Mitarbeitern also SignatureOwner ist befuellt.
		String firstname = null, lastname=null, email=null, fax=null, tel=null, ort=null, street=null, title=null, id=null;
		omUtilities = new OmUtilities();

		// get the owners an their data
		try {
			File fXmlFile = new File(pathToFile);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			
			NodeList nList = doc.getElementsByTagName("Person");
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					if (eElement.getElementsByTagName("firstname").item(0) == null) {
						firstname = ""; 	
					}else firstname = eElement.getElementsByTagName("firstname").item(0).getTextContent();
					
					if (eElement.getElementsByTagName("lastname").item(0).getTextContent() == null) {
						lastname = "";	 
					}else lastname = eElement.getElementsByTagName("lastname").item(0).getTextContent();
					
					if (eElement.getElementsByTagName("email").item(0) == null) {
						email = ""; 
					}else email = eElement.getElementsByTagName("email").item(0).getTextContent();
					
					if (eElement.getElementsByTagName("fax").item(0) == null) {
						fax = " ";						
					}else fax = eElement.getElementsByTagName("fax").item(0).getTextContent();
					
					if (eElement.getElementsByTagName("tel").item(0) == null) {
						tel ="";
					}else tel = eElement.getElementsByTagName("tel").item(0).getTextContent();
					
					if (eElement.getElementsByTagName("ort").item(0) == null) {
						ort = "";	
					}else ort = eElement.getElementsByTagName("ort").item(0).getTextContent();
					
					if (eElement.getElementsByTagName("street").item(0) == null) {
						street = "";	
					}else street = eElement.getElementsByTagName("street").item(0).getTextContent();
					
					if (eElement.getElementsByTagName("title").item(0) == null) {
						title = " ";						
					}else 
						title = eElement.getElementsByTagName("title").item(0).getTextContent();
					
					if (eElement.getElementsByTagName("id").item(0) == null) {
						id = "";
					}else id = eElement.getElementsByTagName("id").item(0).getTextContent();
					
					SignatureOwner signatureOwner = new SignatureOwner(
							firstname,
							lastname,
							email,
							fax,
							tel,
							ort, 
							street, 
							title,
							id);
					
					owners.add(signatureOwner);					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return owners;
	}

	public String getSignaturesAsArchive(String pathToZip, String pathToSignatureFile) { 
		// Ziel: Archivdatei bilden
		try {
			OmUtilities omutilities = new OmUtilities();
			File folder = new File(pathToSignatureFile); 
			File[] files = folder.listFiles();
			File file = new File(pathToZip);
			omutilities.createZip(file, files);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
