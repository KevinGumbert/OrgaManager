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
		
		System.out.println(signature);
		
		}
		return signature;
	}
}
