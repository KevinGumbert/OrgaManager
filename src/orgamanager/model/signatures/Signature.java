package orgamanager.model.signatures;

import java.util.ArrayList;

import orgamanager.utilities.*;

public class Signature {

	// Ziel: ehome-Sig
	private String name;// ehome-mfg-de
	private String icon;
	private String greetings;
	private String event;
	private SignatureOwner owner;
	
	public Signature(){
		// TODO add constructor which accepts all properties as parameters
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getGreetings() {
		return greetings;
	}

	public void setGreetings(String greetings) {
		this.greetings = greetings;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public SignatureOwner getOwner() {
		return owner;
	}

	public void setOwner(SignatureOwner owner) {
		this.owner = owner;
	}

	public String getSignatureAsString(ArrayList<SignatureOwner> owners){//only a test method: there is one owner
		
		String signature = null;
		
		for(SignatureOwner owner : owners){
		
		signature = owner.getTitle()
				+ "\n"
				+ owner.getFirstname()
				+ " "
				+ owner.getLastname()
				+ "\n"
				+ "Lehrstuhl für Fertigungsautomatisierung und Produktionssystematik"
				+ "\n"
				+ "Prof. Dr.-Ing. Jörg Franke Friedrich-Alexander-Universität Erlangen-Nürnberg"
				+ "\n" + owner.getStreet() + "\n" + owner.getCity()
				+ "\n" + owner.getTel() + "\n" + owner.getFax() + "\n"
				+ "\n" + owner.getEmail();		
		
		}
		return signature;
	}
	
	public String getSignatureAsStringHtml(ArrayList<SignatureOwner> owners){//only a test method: there is one owner
		String imgPathFapsLogo = "file:\\C:\\Users\\jobauer\\workspacejava\\OrgaManager\\src\\orgamanager\\files\\signatures\\faps_logo.png";
		String signatureHml = null;
		for(SignatureOwner owner : owners){
		
			signatureHml = 
				"<html>" 
				+"<head>"
				+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"		
				+ "<title>HTML-Signatur</title></head>"
				+"<body>"
				+ "<p>"+owner.getTitle()+"</p>"
				+ "<h1>"+owner.getFirstname() + owner.getLastname() + "</h1>"
				+ "<p>Lehrstuhl für Fertigungsautomatisierung<br> und Produktionssystematik</p>"
				+ "<p><img src='" + imgPathFapsLogo + "' alt='faps_logo.png'></p>"
				+ "<h2>Prof. Dr.-Ing. Jörg Franke Friedrich-Alexander-Universität Erlangen-Nürnberg</h2>"
				+ "<h3>" + owner.getStreet() + "</h3>" + "<h4>"+owner.getCity()+"</h4>"
				+ "<h4> Tel.: " + owner.getTel() + "</h4>" +"<h5> Fax:" + owner.getFax() + "</h5>"
				+ "<h6>" + owner.getEmail()+"</h6>"
				+ "<h6>www.faps.uni-erlangen.de</h6>"
				
			+"</body></html>";
		
		}
		return signatureHml;
	}
}
