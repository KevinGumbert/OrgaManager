package orgamanager.model.signatures;

import java.util.ArrayList;

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
	private ArrayList<SignatureOwner> owners;
	ArrayList<Signature> signatures;

	public SignatureList(String pathToResourceFolder, String fileName) {
		omUtilities = new OmUtilities();
		signatureConfig = new SignatureConfig();		
		setOwners(new ArrayList<SignatureOwner>());
		signatures =  new ArrayList<Signature>();
		
		//create signatures for each owner
		String pathToOwnerFile = pathToResourceFolder + "\\" + fileName; 
		setOwners(parseXmlFile(pathToOwnerFile));
		signatures = new ArrayList<Signature>();
		
		createAndSaveSignatures(getOwners(), pathToResourceFolder);
		
		
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
					
					getOwners().add(signatureOwner);					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getOwners();
	}
	
	private void createAndSaveSignatures(ArrayList<SignatureOwner> owners, String pathToResourceFolder){
		
		
		omUtilities = new OmUtilities();
		
		try {
			
			for (SignatureOwner owner : owners) {
				
				String firstLastName = owner.getLastname()+"_"+owner.getFirstname();
				
				//create a folder for each sognature owner
				File signatureFolder = new File(pathToResourceFolder + "\\" + firstLastName);
				signatureFolder.mkdir();						    
				
				//create signature.txt
				Signature fapsDetxtSig = new Signature();
				String txtSignature = fapsDetxtSig.getSignatureAsString(owner);
				omUtilities.createFileAndSave(signatureFolder.getAbsolutePath(), firstLastName+"_FAPS_de.txt");
				omUtilities.printStringToFile(txtSignature, signatureFolder.getAbsolutePath() + "\\" + firstLastName+"_FAPS_de.txt");
				
				//create signatureMFG.txt
				Signature fapsDetxtSigMFG = new Signature();
				String txtSignatureMFG = fapsDetxtSigMFG.getSignatureAsStringMFG(owner);
				omUtilities.createFileAndSave(signatureFolder.getAbsolutePath(), firstLastName+"_FAPS_de_MFG.txt");
				omUtilities.printStringToFile(txtSignatureMFG, signatureFolder.getAbsolutePath()+ "\\" +firstLastName+"_FAPS_de_MFG.txt");
				
				//create signatureVeranst.txt
				Signature fapsDetxtSigVeranst = new Signature();
				String txtSignatureVeranst = fapsDetxtSigVeranst.getSignatureAsStringVeranst(owner);
				omUtilities.createFileAndSave(signatureFolder.getAbsolutePath(), firstLastName+"_FAPS_de_Veranst.txt");
				omUtilities.printStringToFile(txtSignatureVeranst, signatureFolder.getAbsolutePath() + "\\" + firstLastName+"_FAPS_de_Veranst.txt");
				
				//create signatureVeranstMFG.txt
				Signature fapsDetxtSigVeranstMFG = new Signature();
				String txtSignatureVeranstMFG = fapsDetxtSigVeranstMFG.getSignatureAsStringVeranstMFG(owner);
				omUtilities.createFileAndSave(signatureFolder.getAbsolutePath(), firstLastName+"_FAPS_de_Veranst_MFG.txt");
				omUtilities.printStringToFile(txtSignatureVeranstMFG, signatureFolder.getAbsolutePath() + "\\" + firstLastName+"_FAPS_de_Veranst_MFG.txt");
					
				//create signatureEng.html
				Signature fapsEngtxtSig = new Signature();
				String txtSignatureEng = fapsEngtxtSig.getSignatureAsStringEng(owner);
				omUtilities.createFileAndSave(signatureFolder.getAbsolutePath(), firstLastName+"_FAPS_eng.txt");
				omUtilities.printStringToFile(txtSignatureEng, signatureFolder.getAbsolutePath() + "\\" + firstLastName+"_FAPS_eng.txt");
				
				//create signatureBR.txt
				Signature fapsEngtxtSigMFG = new Signature();
				String txtSignatureBR = fapsEngtxtSigMFG.getSignatureAsStringEngBR(owner);
				omUtilities.createFileAndSave(signatureFolder.getAbsolutePath(), firstLastName+"_FAPS_eng_BR.txt");
				omUtilities.printStringToFile(txtSignatureBR, signatureFolder.getAbsolutePath() + "\\" + firstLastName+"_FAPS_eng_BR.txt");
				
				//create signatureVeranstEng.txt
				Signature fapsEngtxtSigVeranst = new Signature();
				String txtSignatureVeranstEng = fapsEngtxtSigVeranst.getSignatureAsStringVeranstEng(owner);
				omUtilities.createFileAndSave(signatureFolder.getAbsolutePath(), firstLastName+"_FAPS_eng_Veranst.txt");
				omUtilities.printStringToFile(txtSignatureVeranstEng, signatureFolder.getAbsolutePath() + "\\" + firstLastName+"_FAPS_eng_Veranst.txt");
				
				
				//create signatureVeranstEngBR.txt
				Signature fapsEngtxtSigVeranstBR = new Signature();
				String txtSignatureVeranstEngBR = fapsEngtxtSigVeranstBR.getSignatureAsStringVeranstEngBR(owner);
				omUtilities.createFileAndSave(signatureFolder.getAbsolutePath(), firstLastName+"_FAPS_eng_Veranst_BR.txt");
				omUtilities.printStringToFile(txtSignatureVeranstEngBR, signatureFolder.getAbsolutePath() + "\\" + firstLastName+"_FAPS_eng_Veranst_BR.txt");
				
				
				
				//create signature.html
				Signature fapsDeHtmlSig = new Signature();
				String htmlSignature = fapsDeHtmlSig.getSignatureAsStringHtml(owner);
				omUtilities.createFileAndSave(signatureFolder.getAbsolutePath(), firstLastName+"_FAPS_de.html");
				omUtilities.printStringToFile(htmlSignature, signatureFolder.getAbsolutePath() + "\\" + firstLastName+"_FAPS_de.html");
				
				//create signatureMFG.html
				Signature fapsDeHtmlSigMFG = new Signature();
				String htmlSignatureMFG = fapsDeHtmlSigMFG.getSignatureAsStringHtmlMFG(owner);
				omUtilities.createFileAndSave(signatureFolder.getAbsolutePath(), firstLastName+"_FAPS_de_MFG.html");
				omUtilities.printStringToFile(htmlSignatureMFG, signatureFolder.getAbsolutePath() + "\\" + firstLastName+"_FAPS_de_MFG.html");
				
				//create signatureVeranst.html
				Signature fapsDeHtmlSigVeranst = new Signature();
				String htmlSignatureVeranst = fapsDeHtmlSigVeranst.getSignatureAsStringHtmlVeranst(owner);
				omUtilities.createFileAndSave(signatureFolder.getAbsolutePath(), firstLastName+"_FAPS_de_Veranst.html");
				omUtilities.printStringToFile(htmlSignatureVeranst, signatureFolder.getAbsolutePath() + "\\" + firstLastName+"_FAPS_de_Veranst.html");
				
				
				//create signatureVeranstMFG.html
				Signature fapsDeHtmlSigVeranstMFG = new Signature();
				String htmlSignatureVeranstMFG = fapsDeHtmlSigVeranstMFG.getSignatureAsStringHtmlVeranstMFG(owner);
				omUtilities.createFileAndSave(signatureFolder.getAbsolutePath(), firstLastName+"_FAPS_de_Veranst_MFG.html");
				omUtilities.printStringToFile(htmlSignatureVeranstMFG, signatureFolder.getAbsolutePath() + "\\" + firstLastName+"_FAPS_de_Veranst_MFG.html");
										
				//create signatureEng.html
				Signature fapsEngHtmlSig = new Signature();
				String htmlSignatureEng = fapsEngHtmlSig.getSignatureAsStringHtmlEng(owner);
				omUtilities.createFileAndSave(signatureFolder.getAbsolutePath(), firstLastName+"_FAPS_eng.html");
				omUtilities.printStringToFile(htmlSignatureEng, signatureFolder.getAbsolutePath() + "\\" + firstLastName+"_FAPS_eng.html");
			
				//create signatureEngBR.html
				Signature fapsEngHtmlSigBR = new Signature();
				String htmlSignatureEngBR = fapsEngHtmlSigBR.getSignatureAsStringHtmlEngBR(owner);
				omUtilities.createFileAndSave(signatureFolder.getAbsolutePath(), firstLastName+"_FAPS_eng_BR.html");
				omUtilities.printStringToFile(htmlSignatureEngBR, signatureFolder.getAbsolutePath() + "\\" + firstLastName+"_FAPS_eng_BR.html");
				
				//create signatureVeranstEng.html
				Signature fapsEngHtmlSigVeranst = new Signature();
				String htmlSignatureVeranstEng = fapsEngHtmlSigVeranst.getSignatureAsStringHtmlVeranstEng(owner);
				omUtilities.createFileAndSave(signatureFolder.getAbsolutePath(), firstLastName+"_FAPS_eng_Veranst.html");
				omUtilities.printStringToFile(htmlSignatureVeranstEng, signatureFolder.getAbsolutePath() + "\\" + firstLastName+"_FAPS_eng_Veranst.html");
				
				//create signatureVeranstEngBR.html
				Signature fapsEngHtmlSigVeranstBR = new Signature();
				String htmlSignatureVeranstEngBR = fapsEngHtmlSigVeranstBR.getSignatureAsStringHtmlVeranstEngBR(owner);
				omUtilities.createFileAndSave(signatureFolder.getAbsolutePath(),firstLastName+"_FAPS_eng_Veranst_BR.html");
				omUtilities.printStringToFile(htmlSignatureVeranstEngBR, signatureFolder.getAbsolutePath()+ "\\" +firstLastName+"_FAPS_eng_Veranst_BR.html");
				
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	
	public void getSignaturesAsArchive(String pathToZipFile, String pathToSignatures, String signaturesToZip) { 
		// Ziel: Archivdatei bilden
//		try {
//			OmUtilities omutilities = new OmUtilities();
//			File folder = new File(pathToSignatureFile); 
//			File[] files = folder.listFiles();
//			File file = new File(pathToZip);
//			omutilities.createZip(file, files, signaturesToZip);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			ZipDirectory zipDirectory = new ZipDirectory(pathToZipFile, pathToSignatures);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}

	
	private ArrayList<SignatureOwner> getOwners() {
		return owners;
	}

	
	private void setOwners(ArrayList<SignatureOwner> owners) {
		this.owners = owners;
	}

	public ArrayList<String> getNamesOfOwners() {
				
		ArrayList<String> namesOfOwners = new ArrayList<String>();
		
		for (int pos = 0; pos < getOwners().size(); pos++) {
			namesOfOwners.add(getOwners().get(pos).getLastname() + "_" + getOwners().get(pos).getFirstname());
		}
		
		namesOfOwners.add("Alle");
		return namesOfOwners;
	}

}
