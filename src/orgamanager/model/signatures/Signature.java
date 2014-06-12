package orgamanager.model.signatures;

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
	private OmUtilities omUtilities;
	
	
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
						"-- \n \n"
						+ owner.getTitle()
						+ "\n"
						+ owner.getFirstname()
						+ " "
						+ owner.getLastname()
						+ "\n \n"
						+ "Lehrstuhl für Fertigungsautomatisierung \n"
						+ "und Produktionssystematik"
						+ "\n \n"
						+ "Prof. Dr.-Ing. Jörg Franke \n"
						+ "Friedrich-Alexander-Universität Erlangen-Nürnberg \n"
						+ "\n" + owner.getStreet() + "\n" + owner.getCity()
						+ "\n\nTel.: " + owner.getTel() + "\nFax:  " + owner.getFax() + "\n"
						+ "\n" + owner.getEmail()
						+ "\nhttp://www.faps.uni-erlangen.de";
		
	
		return signature;
	}
	
	public String getSignatureAsStringMFG(SignatureOwner owner){
		
		String signature = null;
		signature = 
				"Mit freundlichen Grüßen \n"
						+owner.getFirstname() + " " + owner.getLastname() + "\n \n"
				+ "-- \n \n"
				+ owner.getTitle()
				+ "\n"
				+ owner.getFirstname()
				+ " "
				+ owner.getLastname()
				+ "\n \n"
				+ "Lehrstuhl für Fertigungsautomatisierung \n"
				+ "und Produktionssystematik"
				+ "\n \n"
				+ "Prof. Dr.-Ing. Jörg Franke \n"
				+ "Friedrich-Alexander-Universität Erlangen-Nürnberg \n"
				+ "\n" + owner.getStreet() + "\n" + owner.getCity()
				+ "\n\nTel.: " + owner.getTel() + "\nFax:  " + owner.getFax() + "\n"
				+ "\n" + owner.getEmail()
				+ "\nhttp://www.faps.uni-erlangen.de";	
		
	
		return signature;
	}
	
	public String getSignatureAsStringVeranst(SignatureOwner owner){
		
		String signature = null;
		signature = 
				"-- \n \n"
				+ owner.getTitle()
				+ "\n"
				+ owner.getFirstname()
				+ " "
				+ owner.getLastname()
				+ "\n\n"
				+ "Lehrstuhl für Fertigungsautomatisierung \n"
				+ "und Produktionssystematik \n"
				+ "\n"
				+ "Prof. Dr.-Ing. Jörg Franke \n"
				+ "Friedrich-Alexander-Universität Erlangen-Nürnberg \n" 
				+ "\n" + owner.getStreet() + "\n" + owner.getCity()
				+ "\n\nTel.: " + owner.getTel() + "\nFax:  " + owner.getFax() + "\n"
				+ "\n" + owner.getEmail()
				+ "\nhttp://www.faps.uni-erlangen.de"	
		        + "\n \n__ \n \n"
		        + "Mark Your Calendar: \n \n" //put the event here
		        + "MID 2014 \n"
		        + "11. International Congress \n"
		        + "September 24th - 25th, 2014 \n"
		        + "http://www.3d-mid.de/ \n \n"
		        + "E|DPC-2014 \n"
		        + "Electric Drives Production Conference \n"
		        + "September 30th - October 1st, 2014 \n"
		        + "http://www.edpc.eu \n";
		
	
		return signature;
	}

	public String getSignatureAsStringVeranstMFG(SignatureOwner owner){
		
		String signature = null;
		signature = 
				"Mit freundlichen Grüßen \n"
				+owner.getFirstname() + " " + owner.getLastname() + "\n \n"
				+ "-- \n \n"
				+ owner.getTitle()
				+ "\n"
				+ owner.getFirstname()
				+ " "
				+ owner.getLastname()
				+ "\n\n"
				+ "Lehrstuhl für Fertigungsautomatisierung \n"
				+ "und Produktionssystematik \n"
				+ "\n"
				+ "Prof. Dr.-Ing. Jörg Franke \n"
				+ "Friedrich-Alexander-Universität Erlangen-Nürnberg \n" 
				+ "\n" + owner.getStreet() + "\n" + owner.getCity()
				+ "\n\nTel.: " + owner.getTel() + "\nFax:  " + owner.getFax() + "\n"
				+ "\n" + owner.getEmail()
				+ "\nhttp://www.faps.uni-erlangen.de"	
		        + "\n \n__ \n \n"
		        + "Mark Your Calendar: \n \n" //put the event here
		        + "MID 2014 \n"
		        + "11. International Congress \n"
		        + "September 24th - 25th, 2014 \n"
		        + "http://www.3d-mid.de/ \n \n"
		        + "E|DPC-2014 \n"
		        + "Electric Drives Production Conference \n"
		        + "September 30th - October 1st, 2014 \n"
		        + "http://www.edpc.eu \n";
		
	
		return signature;
	}
	
	public String getSignatureAsStringEng(SignatureOwner owner){
		
		String signature = null;
		omUtilities = new OmUtilities();
		signature =
				"-- \n \n"
				+ owner.getTitle()
				+ "\n"
				+ omUtilities.translateToEnglish(owner.getFirstname()) 
				+ " "
				+ omUtilities.translateToEnglish(owner.getLastname())
				+ "\n \n"
				+ "Institute for Factory Automation \n"
				+ "and Production Systems"
				+ "\n \n"
				+ "Prof. Dr.-Ing. Joerg Franke \n" 
				+ "Friedrich-Alexander-University of Erlangen-Nuremberg \n"
				+ "\n" + omUtilities.translateToEnglish(owner.getStreet()) + "\n" + omUtilities.translateToEnglish(owner.getCity()) 
				+ "\n\nphone: " + owner.getTel() + "\nfax:   " + owner.getFax() + "\n"
				+ "\n" + owner.getEmail()
				+ "\nhttp://www.faps.uni-erlangen.de";		
		
	
		return signature;
	}
	
	public String getSignatureAsStringEngBR(SignatureOwner owner){
		
		String signature = null;
		omUtilities = new OmUtilities();
		signature =
				"Best regards, \n"
				+ omUtilities.translateToEnglish(owner.getFirstname())  + " " + omUtilities.translateToEnglish(owner.getLastname()) + "\n \n"
				+"-- \n \n"
				+ owner.getTitle()
				+ "\n"
				+ omUtilities.translateToEnglish(owner.getFirstname())
				+ " "
				+ omUtilities.translateToEnglish(owner.getLastname())
				+ "\n \n"
				+ "Institute for Factory Automation \n"
				+ "and Production Systems"
				+ "\n \n"
				+ "Prof. Dr.-Ing. Joerg Franke \n" 
				+ "Friedrich-Alexander-University of Erlangen-Nuremberg \n"
				+ "\n" + omUtilities.translateToEnglish(owner.getStreet()) + "\n" + omUtilities.translateToEnglish(owner.getCity())
				+ "\n\nphone: " + owner.getTel() + "\nfax:   " + owner.getFax() + "\n"
				+ "\n" + owner.getEmail()
				+ "\nhttp://www.faps.uni-erlangen.de";		
		
	
		return signature;
	}
	
	public String getSignatureAsStringVeranstEng(SignatureOwner owner){
		
		String signature = null;
		omUtilities = new OmUtilities();
		signature =
				"-- \n \n"
				+ owner.getTitle()
				+ "\n"
				+ omUtilities.translateToEnglish(owner.getFirstname())
				+ " "
				+ omUtilities.translateToEnglish(owner.getLastname())
				+ "\n\n"
				+ "Institute for Factory Automation \n"
				+ "and Production Systems"
				+ "\n \n"
				+ "Prof. Dr.-Ing. Joerg Franke \n" 
				+ "Friedrich-Alexander-University of Erlangen-Nuremberg \n"
				+ "\n" + omUtilities.translateToEnglish(owner.getStreet()) + "\n" + omUtilities.translateToEnglish(owner.getCity())
				+ "\n\nphone: " + owner.getTel() + "\nfax:   " + owner.getFax() + "\n"
				+ "\n" + owner.getEmail()
				+ "\nhttp://www.faps.uni-erlangen.de"	
				+ "\n \n"
				+ "__ \n\n"
				+ "Mark Your Calendar: \n \n" //put the event here
		        + "MID 2014 \n"
		        + "11. International Congress \n"
		        + "September 24th - 25th, 2014 \n"
		        + "http://www.3d-mid.de/ \n \n"
		        + "E|DPC-2014 \n"
		        + "Electric Drives Production Conference \n"
		        + "September 30th - October 1st, 2014 \n"
		        + "http://www.edpc.eu \n";
			
		return signature;
	}
	
	public String getSignatureAsStringVeranstEngBR(SignatureOwner owner){
		
		String signature = null;
		omUtilities = new OmUtilities();
		signature =
				"Best regards, \n"
				+ omUtilities.translateToEnglish(owner.getFirstname()) + " " + omUtilities.translateToEnglish(owner.getLastname()) + "\n \n"
				+ "-- \n \n"
				+ owner.getTitle()
				+ "\n"
				+ omUtilities.translateToEnglish(owner.getFirstname())
				+ " "
				+ omUtilities.translateToEnglish(owner.getLastname())
				+ "\n\n"
				+ "Institute for Factory Automation \n"
				+ "and Production Systems"
				+ "\n \n"
				+ "Prof. Dr.-Ing. Joerg Franke \n" 
				+ "Friedrich-Alexander-University of Erlangen-Nuremberg \n"
				+ "\n" + omUtilities.translateToEnglish(owner.getStreet()) + "\n" + omUtilities.translateToEnglish(owner.getCity())
				+ "\n\nphone: " + owner.getTel() + "\nfax:   " + owner.getFax() + "\n"
				+ "\n" + owner.getEmail()
				+ "\nhttp://www.faps.uni-erlangen.de"	
				+ "\n \n"
				+ "__ \n\n"
				+ "Mark Your Calendar: \n \n" //put the event here
		        + "MID 2014 \n"
		        + "11. International Congress \n"
		        + "September 24th - 25th, 2014 \n"
		        + "http://www.3d-mid.de/ \n \n"
		        + "E|DPC-2014 \n"
		        + "Electric Drives Production Conference \n"
		        + "September 30th - October 1st, 2014 \n"
		        + "http://www.edpc.eu \n";
			
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
				+"&nbsp;"
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
			    +		"<td colspan='3' style='width:310px; height:31px; vertical-align:bottom;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'><a style='color:#000; text-decoration:none;' href='mailto:'"+owner.getEmail() +"'>"+owner.getEmail()+"</a><br />"
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
			    +		"<td colspan='3' style='width:310px; height:31px; vertical-align:bottom;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'><a style='color:#000; text-decoration:none;' href='mailto:'"+owner.getEmail() +"'>"+owner.getEmail()+"</a><br />"
			    + 		"<a style='color:#000; text-decoration:none;' href='http://www.faps.uni-erlangen.de/'>www.faps.uni-erlangen.de</a></span></td>"
			    +		"</tr>"
			  	+"</table>"
				+"</body></html>";
		
		return signatureHml;
	}

	public String getSignatureAsStringHtmlVeranst(SignatureOwner owner){
		
		String signatureHml = null;
		signatureConfig = new SignatureConfig();
				
			signatureHml = 
					
				"<html>" 
				+"<head>"
				+"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"		
				+"<title>FAPS_Signatur_de</title></head>"
				+"<body>"
				+"&nbsp;"
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
			    +		"<td colspan='3' style='width:310px; height:31px; vertical-align:bottom;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'><a style='color:#000; text-decoration:none;' href='mailto:'"+owner.getEmail() +"'>"+owner.getEmail()+"</a><br />"
			    + 		"<a style='color:#000; text-decoration:none;' href='http://www.faps.uni-erlangen.de/'>www.faps.uni-erlangen.de</a></span></td>"
			    +		"</tr>"
			  	+"</table>"
			  	+"<table border='0' cellspacing='0' cellpadding='0' style='width:420px;'>"
			    +	"<tr>"
			    + 		"<td colspan='4' style='height:30px;'></td>"
			    +	"</tr>"
			    +	"<tr>"
			    +		"<td colspan='4' style='width:420px; height:30px;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>Mark Your Calendar:<br /><br /></span>"
			    +		"</td>"
			    +	"</tr>"
			    +	"<tr>"
			    +		"<td colspan='2' style='width:180px;'><img width='180' height='57' src='"+signatureConfig.getImgPathMidLogo() + "' alt='Logo MID' title='Logo MID' /><br />"
			    + 		"</td>"
			    +		"<td style='width:54px; vertical-align:top;'>"
			    + 		"</td>"
			    +		"<td style='padding-left:10px; padding-top:6px; width:186px; vertical-align:top;'>"
			    +		"</td>"
			    +		"<td colspan='2' style='width:180px;'><img width='140' height='58' src='" +signatureConfig.getGifPathLogoEDPC()+ "' alt='Logo EDPC' title='Logo EDPC' /><br />"
			    +		"</td>"
			    +		"<td style='width:54px; vertical-align:top;'>"
			    + 		"</td>"
			    +		"<td style='padding-left:10px; padding-top:6px; width:186px; vertical-align:top;'>"
			    +		"</td>"
			    +	"</tr>"
			    +	"<tr>"
			    +		"<td style='width:53px; height:25px;'>"
				+		"</td>"
			    +		"<td style='width:230px; height:30px; vertical-align:top;'><span style='font-family: Arial, Helvetica, sans-serif; color:#000; font-size:9px;'>September 24th - 25th<br />"
			    +		"<a style='color:#000; text-decoration:none;' href='http://www.3d-mid.de/'>www.3d-mid.de</a></span>"
			    +		"</td>"
			    +		"<td style='width:54px; height:25px;'>&nbsp;</td>"
			    +		"<td style='width:186px; height:25px;'>&nbsp;</td>"
			    +		"<td style='width:53px; height:25px;'>&nbsp;</td>"
			    +		"<td style='width:230px; height:30px; vertical-align:top;'><span style='font-family: Arial, Helvetica, sans-serif; color:#000; font-size:9px;'>September 30th - October 1st<br />"
			    +		"<a style='color:#000; text-decoration:none;' href='http://www.edpc.eu/'>www.edpc.eu</a></span></td>"
			    +		"<td style='width:54px; height:25px;'>&nbsp;</td>"
			    +		"<td style='width:186px; height:25px;'>&nbsp;</td>"
			    +	"</tr>"
			    +"</table>"
				+"</body></html>";
		
		return signatureHml;
	}
	
	public String getSignatureAsStringHtmlVeranstMFG(SignatureOwner owner){
		
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
			    +		"<td colspan='3' style='width:310px; height:31px; vertical-align:bottom;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'><a style='color:#000; text-decoration:none;' href='mailto:'mailto:'"+owner.getEmail() +"'>"+owner.getEmail()+"</a><br />"
			    + 		"<a style='color:#000; text-decoration:none;' href='http://www.faps.uni-erlangen.de/'>www.faps.uni-erlangen.de</a></span></td>"
			    +		"</tr>"
			  	+"</table>"
			  	+"<table border='0' cellspacing='0' cellpadding='0' style='width:420px;'>"
			    +	"<tr>"
			    + 		"<td colspan='4' style='height:30px;'></td>"
			    +	"</tr>"
			    +	"<tr>"
			    +		"<td colspan='4' style='width:420px; height:30px;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>Mark Your Calendar:<br /><br /></span>"
			    +		"</td>"
			    +	"</tr>"
			    +	"<tr>"
			    +		"<td colspan='2' style='width:180px;'><img width='180' height='57' src='"+signatureConfig.getImgPathMidLogo() + "' alt='Logo MID' title='Logo MID' /><br />"
			    + 		"</td>"
			    +		"<td style='width:54px; vertical-align:top;'>"
			    + 		"</td>"
			    +		"<td style='padding-left:10px; padding-top:6px; width:186px; vertical-align:top;'>"
			    +		"</td>"
			    +		"<td colspan='2' style='width:180px;'><img width='140' height='58' src='" +signatureConfig.getGifPathLogoEDPC()+ "' alt='Logo EDPC' title='Logo EDPC' /><br />"
			    +		"</td>"
			    +		"<td style='width:54px; vertical-align:top;'>"
			    + 		"</td>"
			    +		"<td style='padding-left:10px; padding-top:6px; width:186px; vertical-align:top;'>"
			    +		"</td>"
			    +	"</tr>"
			    +	"<tr>"
			    +		"<td style='width:53px; height:25px;'>"
				+		"</td>"
			    +		"<td style='width:230px; height:30px; vertical-align:top;'><span style='font-family: Arial, Helvetica, sans-serif; color:#000; font-size:9px;'>September 24th - 25th<br />"
			    +		"<a style='color:#000; text-decoration:none;' href='http://www.3d-mid.de/'>www.3d-mid.de</a></span>"
			    +		"</td>"
			    +		"<td style='width:54px; height:25px;'>&nbsp;</td>"
			    +		"<td style='width:186px; height:25px;'>&nbsp;</td>"
			    +		"<td style='width:53px; height:25px;'>&nbsp;</td>"
			    +		"<td style='width:230px; height:30px; vertical-align:top;'><span style='font-family: Arial, Helvetica, sans-serif; color:#000; font-size:9px;'>September 30th - October 1st<br />"
			    +		"<a style='color:#000; text-decoration:none;' href='http://www.edpc.eu/'>www.edpc.eu</a></span></td>"
			    +		"<td style='width:54px; height:25px;'>&nbsp;</td>"
			    +		"<td style='width:186px; height:25px;'>&nbsp;</td>"
			    +	"</tr>"
			    +"</table>"
				+"</body></html>";
		
		return signatureHml;
	}
		
	
	public String getSignatureAsStringHtmlEng(SignatureOwner owner){
		
		String signatureHml = null;
		signatureConfig = new SignatureConfig();
		omUtilities = new OmUtilities();
				
			signatureHml = 
					
				"<html>" 
				+"<head>"
				+"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"		
				+"<title>FAPS_Signatur_de</title></head>"
				+"<body>"
				+"&nbsp;"
				+"<table border= '0' cellspacing='0' cellpadding='0' style='width:420px;'>"
				+	"<tr>"
				+		"<td style='border-top: 1px solid black; width:110px; height:40px;'><span style='font-family: Arial, Helvetica, sans-serif;font-size:1px;color:#FFF;'>--</span></td>"
				+ 		"<td colspan='3' style='border-top: 1px solid black; width:310px; height:40px; vertical-align:bottom;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>"+ owner.getTitle() +"</span><br />"
				+			"<span style='font-family: Arial, Helvetica, sans-serif; font-size:13px; font-weight:bold; color:#000;'>"+omUtilities.translateToEnglish(owner.getFirstname())+" " + omUtilities.translateToEnglish(owner.getLastname())+"</span></td>"
				+	"</tr>"
				
				+	"<tr>"
			    +		"<td style='width:110px; height:48px;'>&nbsp;</td>"
			    +		"<td colspan='3' style='width:310px; height:48px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:13px; color:#000;'>Institute for Factory Automation<br />and Production Systems</span></td>"
			    +	"</tr>"

			    +	"<tr>"
			    +		"<td rowspan='3' style='width:110px; height:93px;'><img width='93' height='93' src='"+signatureConfig.getImgPathFapsLogo()+"' alt='FAPS Logo' title='FAPS Logo' /></td>"
			    +		"<td colspan='3' style='width:310px; height:31px; vertical-align:top;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>Prof. Dr.-Ing. Joerg Franke<br />"
			    +  		"Friedrich-Alexander-University of Erlangen-Nuremberg</span></td>"
			    +	"</tr>"

			    +	"<tr>"
			    +		"<td style='width:125px; height:31px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>"+omUtilities.translateToEnglish(owner.getStreet())+"<br />"
			    +  		 omUtilities.translateToEnglish(owner.getCity()) + "</span></td>"
			    +		"<td style='width:25px; height:31px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>phone:&nbsp<br />fax: </span></td>"
			    +		"<td style='width:160px; height:31px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>"+owner.getTel()+"<br />"
			    +  		owner.getFax()+"</span></td>"
			    +	"</tr>"

			    +	"<tr>"
			    +		"<td colspan='3' style='width:310px; height:31px; vertical-align:bottom;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'><a style='color:#000; text-decoration:none;' href='mailto:'"+owner.getEmail() +"'>"+owner.getEmail()+"</a><br />"
			    + 		"<a style='color:#000; text-decoration:none;' href='http://www.faps.uni-erlangen.de/'>www.faps.uni-erlangen.de</a></span></td>"
			    +		"</tr>"
			  	+"</table>"
				+"</body></html>";
		
		return signatureHml;
	}

	public String getSignatureAsStringHtmlEngBR(SignatureOwner owner){
	
	String signatureHml = null;
	signatureConfig = new SignatureConfig();
	omUtilities = new OmUtilities();
			
		signatureHml = 
				
			"<html>" 
			+"<head>"
			+"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"		
			+"<title>FAPS_Signatur_de</title></head>"
			+"<body>"
			+ "<br /><span style='font-family: Arial, Helvetica, sans-serif; font-size:13px; color:#000;'>Best regards,</span><br />"
			+ "<span style='font-family: Arial, Helvetica, sans-serif; font-size:13px; color:#000;'>"+omUtilities.translateToEnglish(owner.getFirstname())+" " + omUtilities.translateToEnglish(owner.getLastname())+"</span><br /><br />"
			+ "<table border= '0' cellspacing='0' cellpadding='0' style='width:420px;'>"
			+	"<tr>"
			+		"<td style='border-top: 1px solid black; width:110px; height:40px;'><span style='font-family: Arial, Helvetica, sans-serif;font-size:1px;color:#FFF;'>--</span></td>"
			+ 		"<td colspan='3' style='border-top: 1px solid black; width:310px; height:40px; vertical-align:bottom;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>"+ owner.getTitle() +"</span><br />"
			+			"<span style='font-family: Arial, Helvetica, sans-serif; font-size:13px; font-weight:bold; color:#000;'>"+omUtilities.translateToEnglish(owner.getFirstname())+" " + omUtilities.translateToEnglish(owner.getLastname())+"</span></td>"
			+	"</tr>"
			
			+	"<tr>"
		    +		"<td style='width:110px; height:48px;'>&nbsp;</td>"
		    +		"<td colspan='3' style='width:310px; height:48px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:13px; color:#000;'>Institute for Factory Automation<br />and Production Systems</span></td>"
		    +	"</tr>"

		    +	"<tr>"
		    +		"<td rowspan='3' style='width:110px; height:93px;'><img width='93' height='93' src='"+signatureConfig.getImgPathFapsLogo()+"' alt='FAPS Logo' title='FAPS Logo' /></td>"
		    +		"<td colspan='3' style='width:310px; height:31px; vertical-align:top;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>Prof. Dr.-Ing. Joerg Franke<br />"
		    +  		"Friedrich-Alexander-University of Erlangen-Nuremberg</span></td>"
		    +	"</tr>"

		    +	"<tr>"
		    +		"<td style='width:125px; height:31px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>"+omUtilities.translateToEnglish(owner.getStreet())+"<br />"
		    +  		 omUtilities.translateToEnglish(owner.getCity()) + "</span></td>"
		    +		"<td style='width:25px; height:31px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>phone:&nbsp<br />fax: </span></td>"
		    +		"<td style='width:160px; height:31px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>"+owner.getTel()+"<br />"
		    +  		owner.getFax()+"</span></td>"
		    +	"</tr>"

		    +	"<tr>"
		    +		"<td colspan='3' style='width:310px; height:31px; vertical-align:bottom;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'><a style='color:#000; text-decoration:none;' href='mailto:'"+owner.getEmail() +"'>"+owner.getEmail()+"</a><br />"
		    + 		"<a style='color:#000; text-decoration:none;' href='http://www.faps.uni-erlangen.de/'>www.faps.uni-erlangen.de</a></span></td>"
		    +		"</tr>"
		  	+"</table>"
			+"</body></html>";
	
	return signatureHml;
}

	public String getSignatureAsStringHtmlVeranstEng(SignatureOwner owner	){
	
	String signatureHml = null;
	signatureConfig = new SignatureConfig();
	omUtilities = new OmUtilities();
			
		signatureHml = 
				
			"<html>" 
			+"<head>"
			+"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"		
			+"<title>FAPS_Signatur_de</title></head>"
			+"<body>"
			+"&nbsp;"
			+ "<table border= '0' cellspacing='0' cellpadding='0' style='width:420px;'>"
			+	"<tr>"
			+		"<td style='border-top: 1px solid black; width:110px; height:40px;'><span style='font-family: Arial, Helvetica, sans-serif;font-size:1px;color:#FFF;'>--</span></td>"
			+ 		"<td colspan='3' style='border-top: 1px solid black; width:310px; height:40px; vertical-align:bottom;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>"+ owner.getTitle() +"</span><br />"
			+			"<span style='font-family: Arial, Helvetica, sans-serif; font-size:13px; font-weight:bold; color:#000;'>"+omUtilities.translateToEnglish(owner.getFirstname())+" " + omUtilities.translateToEnglish(owner.getLastname())+"</span></td>"
			+	"</tr>"
			
			+	"<tr>"
		    +		"<td style='width:110px; height:48px;'>&nbsp;</td>"
		    +		"<td colspan='3' style='width:310px; height:48px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:13px; color:#000;'>Institute for Factory Automation<br />and Production Systems</span></td>"
		    +	"</tr>"

		    +	"<tr>"
		    +		"<td rowspan='3' style='width:110px; height:93px;'><img width='93' height='93' src='"+signatureConfig.getImgPathFapsLogo()+"' alt='FAPS Logo' title='FAPS Logo' /></td>"
		    +		"<td colspan='3' style='width:310px; height:31px; vertical-align:top;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>Prof. Dr.-Ing. Joerg Franke<br />"
		    +  		"Friedrich-Alexander-University of Erlangen-Nuremberg</span></td>"
		    +	"</tr>"

		    +	"<tr>"
		    +		"<td style='width:125px; height:31px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>"+omUtilities.translateToEnglish(owner.getStreet())+"<br />"
		    +  		 omUtilities.translateToEnglish(owner.getCity()) + "</span></td>"
		    +		"<td style='width:25px; height:31px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>phone:&nbsp<br />fax: </span></td>"
		    +		"<td style='width:160px; height:31px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>"+owner.getTel()+"<br />"
		    +  		owner.getFax()+"</span></td>"
		    +	"</tr>"

		    +	"<tr>"
		    +		"<td colspan='3' style='width:310px; height:31px; vertical-align:bottom;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'><a style='color:#000; text-decoration:none;' href='mailto:'"+owner.getEmail() +"'>"+owner.getEmail()+"</a><br />"
		    + 		"<a style='color:#000; text-decoration:none;' href='http://www.faps.uni-erlangen.de/'>www.faps.uni-erlangen.de</a></span></td>"
		    +		"</tr>"
		  	+"</table>"
		  	+"<table border='0' cellspacing='0' cellpadding='0' style='width:420px;'>"
		    +	"<tr>"
		    + 		"<td colspan='4' style='height:30px;'></td>"
		    +	"</tr>"
		    +	"<tr>"
		    +		"<td colspan='4' style='width:420px; height:30px;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>Mark Your Calendar:<br /><br /></span>"
		    +		"</td>"
		    +	"</tr>"
		    +	"<tr>"
		    +		"<td colspan='2' style='width:180px;'><img width='180' height='57' src='"+signatureConfig.getImgPathMidLogo() + "' alt='Logo MID' title='Logo MID' /><br />"
		    + 		"</td>"
		    +		"<td style='width:54px; vertical-align:top;'>"
		    + 		"</td>"
		    +		"<td style='padding-left:10px; padding-top:6px; width:186px; vertical-align:top;'>"
		    +		"</td>"
		    +		"<td colspan='2' style='width:180px;'><img width='140' height='58' src='" +signatureConfig.getGifPathLogoEDPC()+ "' alt='Logo EDPC' title='Logo EDPC' /><br />"
		    +		"</td>"
		    +		"<td style='width:54px; vertical-align:top;'>"
		    + 		"</td>"
		    +		"<td style='padding-left:10px; padding-top:6px; width:186px; vertical-align:top;'>"
		    +		"</td>"
		    +	"</tr>"
		    +	"<tr>"
		    +		"<td style='width:53px; height:25px;'>"
			+		"</td>"
		    +		"<td style='width:230px; height:30px; vertical-align:top;'><span style='font-family: Arial, Helvetica, sans-serif; color:#000; font-size:9px;'>September 24th - 25th<br />"
		    +		"<a style='color:#000; text-decoration:none;' href='http://www.3d-mid.de/'>www.3d-mid.de</a></span>"
		    +		"</td>"
		    +		"<td style='width:54px; height:25px;'>&nbsp;</td>"
		    +		"<td style='width:186px; height:25px;'>&nbsp;</td>"
		    +		"<td style='width:53px; height:25px;'>&nbsp;</td>"
		    +		"<td style='width:230px; height:30px; vertical-align:top;'><span style='font-family: Arial, Helvetica, sans-serif; color:#000; font-size:9px;'>September 30th - October 1st<br />"
		    +		"<a style='color:#000; text-decoration:none;' href='http://www.edpc.eu/'>www.edpc.eu</a></span></td>"
		    +		"<td style='width:54px; height:25px;'>&nbsp;</td>"
		    +		"<td style='width:186px; height:25px;'>&nbsp;</td>"
		    +	"</tr>"
		    +"</table>"
			+"</body></html>";
	
	return signatureHml;
}

	public String getSignatureAsStringHtmlVeranstEngBR(SignatureOwner owner){
	
	String signatureHml = null;
	signatureConfig = new SignatureConfig();
	omUtilities = new OmUtilities();
		signatureHml = 
				
			"<html>" 
			+"<head>"
			+"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"		
			+"<title>FAPS_Signatur_de</title></head>"
			+"<body>"
			+ "<br /><span style='font-family: Arial, Helvetica, sans-serif; font-size:13px; color:#000;'>Best regards,</span><br />"
			+ "<span style='font-family: Arial, Helvetica, sans-serif; font-size:13px; color:#000;'>"+omUtilities.translateToEnglish(owner.getFirstname())+" " + omUtilities.translateToEnglish(owner.getLastname())+"</span><br /><br />"
			+ "<table border= '0' cellspacing='0' cellpadding='0' style='width:420px;'>"
			+	"<tr>"
			+		"<td style='border-top: 1px solid black; width:110px; height:40px;'><span style='font-family: Arial, Helvetica, sans-serif;font-size:1px;color:#FFF;'>--</span></td>"
			+ 		"<td colspan='3' style='border-top: 1px solid black; width:310px; height:40px; vertical-align:bottom;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>"+ owner.getTitle() +"</span><br />"
			+			"<span style='font-family: Arial, Helvetica, sans-serif; font-size:13px; font-weight:bold; color:#000;'>"+omUtilities.translateToEnglish(owner.getFirstname())+" " + omUtilities.translateToEnglish(owner.getLastname())+"</span></td>"
			+	"</tr>"
			
			+	"<tr>"
		    +		"<td style='width:110px; height:48px;'>&nbsp;</td>"
		    +		"<td colspan='3' style='width:310px; height:48px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:13px; color:#000;'>Institute for Factory Automation<br />and Production Systems</span></td>"
		    +	"</tr>"

		    +	"<tr>"
		    +		"<td rowspan='3' style='width:110px; height:93px;'><img width='93' height='93' src='"+signatureConfig.getImgPathFapsLogo()+"' alt='FAPS Logo' title='FAPS Logo' /></td>"
		    +		"<td colspan='3' style='width:310px; height:31px; vertical-align:top;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>Prof. Dr.-Ing. Joerg Franke<br />"
		    +  		"Friedrich-Alexander-University of Erlangen-Nuremberg</span></td>"
		    +	"</tr>"

		    +	"<tr>"
		    +		"<td style='width:125px; height:31px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>"+omUtilities.translateToEnglish(owner.getStreet())+"<br />"
		    +  		 omUtilities.translateToEnglish(owner.getCity()) + "</span></td>"
		    +		"<td style='width:25px; height:31px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>phone:&nbsp<br />fax: </span></td>"
		    +		"<td style='width:160px; height:31px; vertical-align:middle;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>"+owner.getTel()+"<br />"
		    +  		owner.getFax()+"</span></td>"
		    +	"</tr>"

		    +	"<tr>"
		    +		"<td colspan='3' style='width:310px; height:31px; vertical-align:bottom;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'><a style='color:#000; text-decoration:none;' href='mailto:'mailto:'"+owner.getEmail() +"'>"+owner.getEmail()+"</a><br />"
		    + 		"<a style='color:#000; text-decoration:none;' href='http://www.faps.uni-erlangen.de/'>www.faps.uni-erlangen.de</a></span></td>"
		    +		"</tr>"
		  	+"</table>"
		  	+"<table border='0' cellspacing='0' cellpadding='0' style='width:420px;'>"
		    +	"<tr>"
		    + 		"<td colspan='4' style='height:30px;'></td>"
		    +	"</tr>"
		    +	"<tr>"
		    +		"<td colspan='4' style='width:420px; height:30px;'><span style='font-family: Arial, Helvetica, sans-serif; font-size:11px; color:#000;'>Mark Your Calendar:<br /><br /></span>"
		    +		"</td>"
		    +	"</tr>"
		    +	"<tr>"
		    +		"<td colspan='2' style='width:180px;'><img width='180' height='57' src='"+signatureConfig.getImgPathMidLogo() + "' alt='Logo MID' title='Logo MID' /><br />"
		    + 		"</td>"
		    +		"<td style='width:54px; vertical-align:top;'>"
		    + 		"</td>"
		    +		"<td style='padding-left:10px; padding-top:6px; width:186px; vertical-align:top;'>"
		    +		"</td>"
		    +		"<td colspan='2' style='width:180px;'><img width='140' height='58' src='" +signatureConfig.getGifPathLogoEDPC()+ "' alt='Logo EDPC' title='Logo EDPC' /><br />"
		    +		"</td>"
		    +		"<td style='width:54px; vertical-align:top;'>"
		    + 		"</td>"
		    +		"<td style='padding-left:10px; padding-top:6px; width:186px; vertical-align:top;'>"
		    +		"</td>"
		    +	"</tr>"
		    +	"<tr>"
		    +		"<td style='width:53px; height:25px;'>"
			+		"</td>"
		    +		"<td style='width:230px; height:30px; vertical-align:top;'><span style='font-family: Arial, Helvetica, sans-serif; color:#000; font-size:9px;'>September 24th - 25th<br />"
		    +		"<a style='color:#000; text-decoration:none;' href='http://www.3d-mid.de/'>www.3d-mid.de</a></span>"
		    +		"</td>"
		    +		"<td style='width:54px; height:25px;'>&nbsp;</td>"
		    +		"<td style='width:186px; height:25px;'>&nbsp;</td>"
		    +		"<td style='width:53px; height:25px;'>&nbsp;</td>"
		    +		"<td style='width:230px; height:30px; vertical-align:top;'><span style='font-family: Arial, Helvetica, sans-serif; color:#000; font-size:9px;'>September 30th - October 1st<br />"
		    +		"<a style='color:#000; text-decoration:none;' href='http://www.edpc.eu/'>www.edpc.eu</a></span></td>"
		    +		"<td style='width:54px; height:25px;'>&nbsp;</td>"
		    +		"<td style='width:186px; height:25px;'>&nbsp;</td>"
		    +	"</tr>"
		    +"</table>"
			+"</body></html>";
	
	return signatureHml;
}

}
