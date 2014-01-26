package orgamanager.model;

import java.util.ArrayList;

import orgamanager.utilities.OmOperatingSystemConstant;
import orgamanager.utilities.OmUtilities;

public class Invoice {

	// Vorname Rechnungssteller
	// Nachname Rechnungssteller
	// Strasse Rechnungssteller
	// Hausnummer Rechnungssteller
	// Ort Rechnungssteller
	// PLZ Rechnungssteller
	// Beruf Rechnungssteller
	// Bankverbindung Rechnungssteller Konto
	// Bankverbindung Rechnungssteller Blz
	// Bankverbindung Rechnungssteller IBAN
	// Bankverbindung Rechnungssteller BIC
	
	// Geschlecht Rechnungsempfaenger
	// Vorname Rechnungsempfaenger
	// Nachname Rechnungsempfaenger
	// Firma Rechnungsempfaenger
	// Strasse Rechnungsempfaenger
	// Ort Rechnungsempfaenger
	// Kundennummer Rechnungsempfaenger
	
	// Rechnungskategorie
	// Rechnungsnummer
	// Rechnungsdatum
	
	// Rechnungstitel
	// Rechnungsanrede 
	// Rechnungseinleitung
	// Rechnungspostenueberschrift
	// Rechnungspostenliste
	// Rechnungspostenlistenelement
	// Rechnungspostenlistenelement-Text,
	// Rechnungspostenlistenelement-Einzelpreis,
	// Rechnungspostenlistenelement-Gesamtpreis,
	
	// Rechnungskalkulation zur Verdeutlichung
	// Rechnungsendbetrag
	// Rechnungsanmerkung Kleinunternehmer
	// Rechnungszahlungsaufforderung
	// Schlussformel
	// Rechnungsfuss
	
	private String firstName;
	private String lastName;
	private String street;
	private String streetNumber;
	private String postalCode;
	private String city;
	private String job;
	private String phonePrefix;
	private String phonePostfix;
	private String email;
	private String url;
	private ArrayList<String> jobOptions;
	private String bankName;
	private String bankAccountNumber;
	private String bankCodeNumber;
	private String bankBic;
	private String bankIban;
	
	private String clientFirstName;
	private String clientLastName;
	private String clientMnemonic;
	private String clientCompany;
	private String clientStreet;
	private String clientStreetNumber;
	private String clientCity;
	private String clientPostalCode;
	
	private String invoiceOption;
	private ArrayList<String> invoiceOptions;
	private String invoiceNumber;
	private String invoiceDate;
	private String invoiceTitle;
	
	private String targetLocationInvoiceFile;
	
	// PDFLatexaufruf
	
	public Invoice(){
	}
	
	public boolean printAsPdf(){
		// create invoice as pdf with the help of latex on unix
		// steps:
		// create dir
		// create file 
		// fill file with latex
		// check for pdflatex
		// if not install texlive full package due to komascript, see wiki.ubuntuusers.de/Tex_Live
		// check for evince
		// run pdflatex
		// run pdflatex
		// run evince
		
		String dir = "";
		String file = "rechnung.tex";
		String path = "";
		String content = createLatexInvoice();
		OmUtilities utils = new OmUtilities();
		OmOperatingSystemConstant osConst = OmOperatingSystemConstant.UNKNOWN;
		osConst = utils.detectOperatingSystem();
		if (osConst == OmOperatingSystemConstant.WINDOWS){ // Windows
			dir = "C:\\Users\\joba\\Desktop\\javatest";
			path = dir + "\\" + file;
		} else if (osConst == OmOperatingSystemConstant.LINUX) { // Linux
			dir = "/home/jay/curdir/javatest";
			path = dir + "/" + file;
		} else { // Windows
			dir = "C:\\Users\\joba\\Desktop\\javatest";
			path = dir + "\\" + file;
		}
		boolean res = utils.printStringToFile(content, path);
		if (res){
			return true;
		} else {
			return false;
		}
	}
	
	private String createLatexInvoice(){
		String latexDoc = "";
		String docClass = getLatexDocumentClass();
		String usePackage = getLatexUsePackage();
		String komaVars = getLatexKomaVars();
		String firstFoot = getLatexFirstFoot();
		String beginDoc = getLatexBeginDocument();
		String beginLetter = getLatexBeginLetter();
		String opening = getLatexOpening();
		String invoiceContent = getLatexInvoiceContent();
		String closingDoc = getLatexClosing();
		String endLetter = getLatexEndLetter();
		String endDoc = getLatexEndDocument();
		latexDoc += docClass + usePackage + komaVars + firstFoot + beginDoc + beginLetter + opening + invoiceContent + closingDoc + endLetter + endDoc;
		return latexDoc;
	}

	private String getLatexEndDocument() {
		String end = "";
		end += "\\end{document}\n";
		return end;
	}

	private String getLatexEndLetter() {
		String endLetter = "";
		endLetter += "\\end{letter}";
		return endLetter;
	}

	private String getLatexClosing() {
		String closing = "";
		closing += "\\closing{Mit freundlichen Grüßen}\n"; 
		return closing;
	}

	private String getLatexInvoiceContent() {
		String content = "";
		content += "ich bedanke mich für Ihr Vertrauen und stelle Ihnen wie vereinbart den unten aufgeführten Betrag in Rechnung.";
		content += "\\begin{flushleft}\n";
		content += "\\textbf{Ernährungstherapie für Max Mustermann nach §43 SGB V:}\n";
		content += "\\end{flushleft}\n";
		content += "\\begin{quote}\n";
		content += "- Ernährungsanamnese, 61 min., pauschal 50 \\EUR;\\\\ \n";
		content += "- 4 Folgeberatungen je 31 min., je Beratung pauschal 40 \\EUR, gesamt 160 \\EUR;\\\\ \n";
		content += "\\end{quote}\n";
		content += "\\begin{center} \n";
		content += "(1 * 50) + (4 * 40) = 210 \n";
		content += "\\end{center} \n";
		content += "\\begin{flushright} \n";
		content += "\\textbf{Betrag: 210} \\EUR \n";
		content += "\\end{flushright}\n";
		content += "\\par \n";
		content += "\\noindent \n";
		content += "Anmerkung: \\\\ \n";
		content += "Ich nehme die Kleinunternehmerregelung ( § 19 Abs. 1 UStG ) in Anspruch.\\\\ \n";
		content += "Somit weise ich in meinen Rechnungen die Umsatzsteuer nicht gesondert aus.\n";
		content += "\\par\\medskip";
		content += "\\noindent \n";
		content += "Bitte überweisen Sie den Rechnungsbetrag innerhalb der kommenden 7 Tage auf das rechts oben angegebene Konto - Vielen Dank.\\par \n";
		return content;
	}

	private String getLatexOpening() {
		String opening = "";
		opening += "\\opening{Sehr geehrter Herr Mustermann,}";
		return opening;
	}

	private String getLatexBeginLetter() {
		String beginLetter = "";
		beginLetter += "\\begin{letter}{";
		beginLetter += "Herr \\\\"; // TODO
		beginLetter += "Max Mustermann \\\\";
		beginLetter += "\\  \\\\";
		beginLetter += "Musterweg 1\\\\";
		beginLetter += "12345 Musterstadt\\\\";
		beginLetter += "}\n";
		return beginLetter;
	}

	private String getLatexBeginDocument() {
		String beginString = "";
		beginString += "\\begin{document}\n";
		return beginString;
	}

	private String getLatexFirstFoot() {
		String firstFoot = "";
		firstFoot += "\\firstfoot{\\parbox[b][5mm]{\\linewidth}{\\footnotesize\\begin{tabbing}";
		firstFoot += "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa \\= \n";
		firstFoot += "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa \\= \n";
		firstFoot += "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa \\kill \n";
		firstFoot += "Jochen Bauer \\> Adresse: \\> Kontakt: \\\\ \n"; // TODO
		firstFoot += "Diplom-Oecotrophologe (FH) \\> Hugo-Geiger-Str. 39 \\> info@jochen-bauer.net \\\\ \n"; // TODO
		firstFoot += "Ernährungsberater/DGE \\> 92237 Sulzbach-Rosenberg \\> www.jochen-bauer.net\\\\ \n";
		firstFoot += "Master of Computer Science \\> Steuer-Nr.: 201/202/91417 \\> 0173 3928709\\\\ \n";
		firstFoot += "\\end{tabbing}\n}\n}\n";
		return firstFoot;
	}

	private String getLatexDocumentClass() {
		String docClass = "";
		docClass += "\\documentclass[";
		docClass += "fromalign=right,fromrule=aftername,foldmarks=true,fromaddress=false,";
		docClass += "fromurl=false,fromemail=false,fromphone=false,fontsize=12pt,version=last";    
		docClass += "]{scrlttr2}\n";
		return docClass;
	}
	
	private String getLatexUsePackage() {
		String usePackage = "";
		usePackage += "\\usepackage[ngerman]{babel}\n";
		usePackage += "\\usepackage[utf8]{inputenc}\n";
		usePackage += "\\usepackage{mathptmx, charter, courier}\n";
		usePackage += "\\usepackage[scaled]{helvet}\n";
		usePackage += "\\usepackage{marvosym}\n";
		return usePackage;
	}
	
	private String getLatexKomaVars() {
		String komaVars = "";
		komaVars += "\\setkomavar{fromname}{";
		komaVars += firstName + " " + lastName + "\\\\";
		komaVars += job + "}";
		komaVars += "\\setkomavar{fromaddress}{" + street + " " + streetNumber + "\\\\" + postalCode + " " + city + "}";
		komaVars += "\\setkomavar{fromphone}{" + phonePrefix + "\\, " + phonePostfix + "}";
		komaVars += "\\setkomavar{fromemail}{" + email + "}";
		komaVars += "\\setkomavar{fromurl}{" + url + "}";
		komaVars += "\\setkomavar{signature}{" + firstName + " " + lastName + "}";
		komaVars += "\\setkomavar{location}{ \\usekomavar{frombank}}";
		komaVars += "\\setkomavar{customer}{" + clientMnemonic + "}";
		komaVars += "\\setkomavar{invoice}{" + invoiceNumber + "}";
		komaVars += "\\setkomavar{date}{" + invoiceDate + "}";
		komaVars += "\\setkomavar{place}{" + city +"}";
		komaVars += "\\setkomavar{subject}{Rechnung" + " " +  invoiceTitle + "}";
		komaVars += "\\setkomavar{frombank}{\\raggedright\\textbf{Bankverbindung}:\\\\";
		komaVars += "Empf.:" + lastName + " " + firstName + "\\\\";
//		komaVars += "Konto:" + bankAccountNumber.substring(0,2) + "\\, " + bankAccountNumber.substring(3,4) + "\\, " +  bankAccountNumber.substring(5,6) + " \\\\";
//		komaVars += "Blz:" + bankCodeNumber.substring(0, 2) + "\\, " + bankCodeNumber.substring(3, 5) + "\\, " + bankCodeNumber.substring(6, 7) + " \\\\";
//		komaVars += "Bank:" + bankName + "\\\\";
//		komaVars += "IBAN:" + bankIban + "\\\\";
//		komaVars += "BIC:" + bankBic;
		komaVars += "}";
		return komaVars;
	}

	private void showInvoice(){
		// check for evince
	}
	
}
