package orgamanager.model.signatures;

import java.util.ArrayList;
import java.util.List;

public class SignatureList {

	ArrayList<SignatureOwner> owners;
	
	public SignatureList(String pathToResourceFolder){
		// Ordnerstruktur muss sein: 
		// mitarbeiter.xml, vorlage_faps_de.html, ...
		
		// Anlegen der Grundstruktur
		owners = new ArrayList<SignatureOwner>();
		
		// Schritt: Mitarbeiterdatei 'mitarbeiter.xml'einlesen und SignatureOwner-Objekte bilden
		String pathToOwnerFile = pathToResourceFolder + "/mitarbeiter.xml"; // TODO Check ob Slash gebraucht wird
		parseXmlFile(pathToOwnerFile);
		createSignatures();
		getSignatureAsArchive();
	}
	
	private boolean parseXmlFile(String pathToFile){
		// Ziel: Liste von Mitarbeitern also SignatureOwner ist befuellt.
		return true;
	}
	
	private boolean createSignatures(){
		// Ziel: pro Mitarbeiter wurde eine Signatur erzeugt;
		return true;
	}
	
	public List<Signature> getSignatureAsArchive(){
		// Ziel: Archivdatei bilden  
		return null; 
	}
	
}
