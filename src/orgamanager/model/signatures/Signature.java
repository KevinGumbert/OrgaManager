package orgamanager.model.signatures;

import java.util.ArrayList;
import orgamanager.utilities.*;

public class Signature {

	// Ziel: ehome-Sig
	String name_Signature;// ehome-mfg-de
	String logo;
	String schlussformel;
	String veranstaltungshinweis;
	String signature;
	SignatureOwner owner;
	
	public Signature(ArrayList<SignatureOwner> owners){
		name_Signature = "ehome-mfg-de";
		logo = "/resources/img/ehome-logo-120px-120px.png";
		schlussformel = "Mit freundlichen Grüßen";
		veranstaltungshinweis = "";
		
		signature = createSignature(owners);
	}
	
	public String createSignature(ArrayList<SignatureOwner> owners){
		
		String signature = owners.get(0).title + "\n" 
							+ owners.get(0).firstname + " " + owners.get(0).lastname +"\n"
							+ "Lehrstuhl für Fertigungsautomatisierung und Produktionssystematik" +"\n"
							+ "Prof. Dr.-Ing. Jörg Franke Friedrich-Alexander-Universität Erlangen-Nürnberg" +"\n"
							+ owners.get(0).street + "\n"
							+ owners.get(0).city + "\n"
							+ owners.get(0).tel +"\n"
							+ owners.get(0).fax + "\n" + "\n"
							+ owners.get(0).email;
		
		
		System.out.println(signature);
		
		return null;
	}
	
	
}
