package orgamanager.model.signatures;

import java.util.ArrayList;

import orgamanager.utilities.*;
import orgamanager.config.SignatureConfig;;

public class Signature {

	// Ziel: ehome-Sig
	private String name;// ehome-mfg-de
	private String icon;
	private String greetings;
	private String event;
	private SignatureOwner owner;
	private SignatureConfig signatureConfig;
	
	
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

	public String getSignatureAsString(SignatureOwner owner){
		
		String signature = null;
		signature =
				"-- \n"
				+ owner.getTitle()
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
		
	
		return signature;
	}
	
	public String getSignatureAsStringMFG(SignatureOwner owner){
		
		String signature = null;
		signature = 
				"Mit freundlichen Grüßen \n"
				+ "-- \n"
				+ owner.getTitle()
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
		
	
		return signature;
	}
	
	public String getSignatureAsStringHtml(SignatureOwner owner){
		
		String signatureHml = null;
		signatureConfig = new SignatureConfig();
				
			signatureHml = 
					
				"<html>" 
				+"<head>"
				+"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"		
				+"<title>FAPS_Signatur_de</title></head>"
				+"<body>"
				+"<table border= '0' cellspacing='0' cellpadding='0' style='width:420px;'>"
				+	"<tr>"
				+		"<td style='border-top: 1px solid black; width:110px; height:40px;'><span style='font-family: Arial, Helvetica, sans-serif;font-size:1px;color:#FFF;'>--</span></td>"
				+ 		"<td colspan='3' style='border-top: 1px solid black; width:310px; height:40px; vertical-align:bottom;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>"+ owner.getTitle() +"</span><br />"
				+			"<span style='font-family: Arial, Helvetica, sans-serif; font-size:13px; font-weight:bold; color:#000;'>"+owner.getFirstname()+" " + owner.getLastname()+"</span></td>"
				+	"</tr>"
				
				+	"<tr>"
			    +		"<td style='width:110px; height:48px;'>&nbsp;</td>"
			    +		"<td colspan='3' style='width:310px; height:48px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:13px; color:#000;'>Lehrstuhl für Fertigungsautomatisierung<br />und Produktionssystematik</span></td>"
			    +	"</tr>"

			    +	"<tr>"
			    +		"<td rowspan='3' style='width:110px; height:93px;'><img width='93' height='93' src='"+signatureConfig.getImgPathFapsLogo()+"' alt='FAPS Logo' title='FAPS Logo' /></td>"
			    +		"<td colspan='3' style='width:310px; height:31px; vertical-align:top;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>Prof. Dr.-Ing. Jörg Franke<br />"
			    +  		"Friedrich-Alexander-Universität Erlangen-Nürnberg</span></td>"
			    +	"</tr>"

			    +	"<tr>"
			    +		"<td style='width:125px; height:31px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>"+owner.getStreet()+"<br />"
			    +  		 owner.getCity() + "</span></td>"
			    +		"<td style='width:25px; height:31px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>Tel.:<br />Fax: </span></td>"
			    +		"<td style='width:160px; height:31px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>"+owner.getTel()+"<br />"
			    +  		owner.getFax()+"</span></td>"
			    +	"</tr>"

			    +	"<tr>"
			    +		"<td colspan='3' style='width:310px; height:31px; vertical-align:bottom;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'><a style='color:#000; text-decoration:none;' href='mailto:jochen.bauer@faps.uni-erlangen.de'>"+owner.getEmail()+"</a><br />"
			    + 		"<a style='color:#000; text-decoration:none;' href='http://www.faps.uni-erlangen.de/'>www.faps.uni-erlangen.de</a></span></td>"
			    +		"</tr>"
			  	+"</table>"
				+"</body></html>";
		
		return signatureHml;
	}
	
	public String getSignatureAsStringHtmlMFG(SignatureOwner owner){
		
		String signatureHml = null;
		signatureConfig = new SignatureConfig();
				
			signatureHml = 
					
				"<html>" 
				+"<head>"
				+"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"		
				+"<title>FAPS_Signatur_de</title></head>"
				+"<body>"
				+ "<br /><span style='font-family: Arial, Helvetica, sans-serif; font-size:13px; color:#000;'>Mit freundlichen Grüßen</span><br />"
				+ "<span style='font-family: Arial, Helvetica, sans-serif; font-size:13px; color:#000;'>"+owner.getFirstname() +" "+ owner.getLastname()+"</span><br /><br />"
				+ "<table border= '0' cellspacing='0' cellpadding='0' style='width:420px;'>"
				+	"<tr>"
				+		"<td style='border-top: 1px solid black; width:110px; height:40px;'><span style='font-family: Arial, Helvetica, sans-serif;font-size:1px;color:#FFF;'>--</span></td>"
				+ 		"<td colspan='3' style='border-top: 1px solid black; width:310px; height:40px; vertical-align:bottom;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>"+ owner.getTitle() +"</span><br />"
				+			"<span style='font-family: Arial, Helvetica, sans-serif; font-size:13px; font-weight:bold; color:#000;'>"+owner.getFirstname()+" " + owner.getLastname()+"</span></td>"
				+	"</tr>"
				
				+	"<tr>"
			    +		"<td style='width:110px; height:48px;'>&nbsp;</td>"
			    +		"<td colspan='3' style='width:310px; height:48px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:13px; color:#000;'>Lehrstuhl für Fertigungsautomatisierung<br />und Produktionssystematik</span></td>"
			    +	"</tr>"

			    +	"<tr>"
			    +		"<td rowspan='3' style='width:110px; height:93px;'><img width='93' height='93' src='"+signatureConfig.getImgPathFapsLogo()+"' alt='FAPS Logo' title='FAPS Logo' /></td>"
			    +		"<td colspan='3' style='width:310px; height:31px; vertical-align:top;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>Prof. Dr.-Ing. Jörg Franke<br />"
			    +  		"Friedrich-Alexander-Universität Erlangen-Nürnberg</span></td>"
			    +	"</tr>"

			    +	"<tr>"
			    +		"<td style='width:125px; height:31px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>"+owner.getStreet()+"<br />"
			    +  		 owner.getCity() + "</span></td>"
			    +		"<td style='width:25px; height:31px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>Tel.:<br />Fax: </span></td>"
			    +		"<td style='width:160px; height:31px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>"+owner.getTel()+"<br />"
			    +  		owner.getFax()+"</span></td>"
			    +	"</tr>"

			    +	"<tr>"
			    +		"<td colspan='3' style='width:310px; height:31px; vertical-align:bottom;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'><a style='color:#000; text-decoration:none;' href='mailto:jochen.bauer@faps.uni-erlangen.de'>"+owner.getEmail()+"</a><br />"
			    + 		"<a style='color:#000; text-decoration:none;' href='http://www.faps.uni-erlangen.de/'>www.faps.uni-erlangen.de</a></span></td>"
			    +		"</tr>"
			  	+"</table>"
				+"</body></html>";
		
		return signatureHml;
	}
	
		

}
