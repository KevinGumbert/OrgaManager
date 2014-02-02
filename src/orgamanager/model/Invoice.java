package orgamanager.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import orgamanager.utilities.OmOperatingSystemConstant;
import orgamanager.utilities.OmUtilities;

public class Invoice {
	private String firstName;
	private String lastName;
	private String street;
	private String streetNumber;
	private String postalCode;
	private String city;
	private String job;
	private ArrayList<String> jobOptions;
	private String phone;
	private String email;
	private String url;
	private String bankName;
	private String bankAccountNumber;
	private String bankCodeNumber;
	private String bankBic;
	private String bankIban;
	private String taxNumber;
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
	private OmUtilities utils;
	private String targetDir;
	private String targetFile;
	private String targetFileBaseName;
	private String targetBase;
	private String targetPath;
	private String targetPathPdf;
	private String compilerCommand;
	private String viewerCommand;
	
	public Invoice(){
		// computer related data
		utils = new OmUtilities();
		targetBase = "/home/jay/curdir/";
		targetFileBaseName = "rechnung";
		targetFile = targetFileBaseName + ".tex";
		targetDir = "rechnung";
		targetPath = targetBase + targetDir + "/"+ targetFile;
		targetPathPdf = targetBase + targetDir + "/"+ targetFileBaseName + ".pdf";
		compilerCommand = "pdflatex";
		viewerCommand = "evince";
		// invoicing party
		firstName = "Jochen";
		lastName = "Bauer";
		street = "Hugo-Geiger-Str.";
		streetNumber = "39";
		postalCode = "92237";
		city = "Sulzbach-Rosenberg";
		job = "Ernährungsberater";
		jobOptions = new ArrayList<String>();
		jobOptions.add("Ernährungsberater");
		jobOptions.add("Tennistrainer");
		jobOptions.add("Softwareentwickler");
		phone = "01733928709";
		email = "info@jochen-bauer.net";
		url = "www.jochen-bauer.net";
		bankName = "EthikBank";
		bankAccountNumber = "314 78 27";
		bankCodeNumber = "830 944 95";
		bankBic = "GENO DE F1 ETK";
		bankIban = "DE82 8309 4495 0003 1478 27";
		taxNumber = "201/202/91417";
		// invoice recipient
		clientFirstName = "Max";
		clientLastName = "Mustermann";
		clientMnemonic = "mamustermann";
		clientCompany = "Musterfirma GmbH";
		clientStreet = "Musterweg";
		clientStreetNumber = "2";
		clientCity = "Musterstadt";
		clientPostalCode = "12345";
		// invoice data
		invoiceOption = "Ernährungsberater";
		invoiceOptions = new ArrayList<String>();
		invoiceOptions.add("Ernährungsberatung");
		invoiceOptions.add("Ernährungstherapie");
		invoiceOptions.add("Softwareentwicklung");
		invoiceOptions.add("Webentwicklung");
		invoiceOptions.add("Tennistraining");
		invoiceTitle = "Rechnung";
		invoiceNumber = "2014-001";
		invoiceDate = "01.01.2014";
	}
	
	public boolean printAsPdf(){
		OmOperatingSystemConstant operatingSystem = utils.detectOperatingSystem();
		if (operatingSystem == OmOperatingSystemConstant.LINUX){
			String content = createLatexInvoice();
			utils.createDir(targetBase + targetDir);
			utils.createFile(targetPath);
			boolean res = utils.printStringToFile(content, targetPath);
			if (res){ 
				compileInvoice();
				try {
					Thread.sleep(2000); // 2 sec
					moveInvoice();
					Thread.sleep(2000);
					showInvoice();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
				return true;
			} else { 
				return false; 
			}
		} else {
			JOptionPane.showMessageDialog(null, "Rechnungsdruck ist aktuell nur unter Linux verfügbar.","OrgaManager", JOptionPane.WARNING_MESSAGE);
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
		endLetter += "\\end{letter}\n";
		return endLetter;
	}

	private String getLatexClosing() {
		String closing = "";
		closing += "\\closing{Mit freundlichen Grüßen}\n"; 
		return closing;
	}

	private String getLatexInvoiceContent() {
		String content = "";
		content += "ich bedanke mich für Ihr Vertrauen und stelle Ihnen wie vereinbart den unten aufgeführten Betrag in Rechnung. \n";
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
		opening += "\\opening{Sehr geehrter Herr Mustermann,}\n";
		return opening;
	}

	private String getLatexBeginLetter() {
		String beginLetter = "";
		beginLetter += "\\begin{letter}{\n";
		beginLetter += "Herr \\\\ \n"; // TODO
		beginLetter += "Max Mustermann \\\\ \n";
		beginLetter += "\\  \\\\ \n";
		beginLetter += "Musterweg 1\\\\ \n";
		beginLetter += "12345 Musterstadt\\\\ \n";
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
		komaVars += "\\setkomavar{fromphone}{" + phone.substring(0, 4) + "\\, " + phone.substring(4, phone.length()) + "}";
		komaVars += "\\setkomavar{fromemail}{" + email + "}";
		komaVars += "\\setkomavar{fromurl}{" + url + "}";
		komaVars += "\\setkomavar{signature}{" + firstName + " " + lastName + "}";
		komaVars += "\\setkomavar{location}{ \\usekomavar{frombank}}";
		komaVars += "\\setkomavar{customer}{" + clientMnemonic + "}";
		komaVars += "\\setkomavar{invoice}{" + invoiceNumber + "}";
		komaVars += "\\setkomavar{date}{" + invoiceDate + "}";
		komaVars += "\\setkomavar{place}{" + city +"}";
		komaVars += "\\setkomavar{subject}{" + invoiceTitle + "}";
		komaVars += "\\setkomavar{frombank}{\\raggedright\\textbf{Bankverbindung}:\\\\";
		komaVars += "Empf.: " + lastName + " " + firstName + "\\\\";
		String bankAccountNumber1 = new String(bankAccountNumber.substring(0, 4));
		String bankAccountNumber2 = new String(bankAccountNumber.substring(4, 6));
		String bankAccountNumber3 = new String(bankAccountNumber.substring(7, bankAccountNumber.length()));
		komaVars += "Konto: " + bankAccountNumber1 + " " + bankAccountNumber2 + " " +  bankAccountNumber3 + " \\\\";
		String blz1 = new String(bankCodeNumber.substring(0, 4));
		String blz2 = new String(bankCodeNumber.substring(4, 7));
		String blz3 = new String(bankCodeNumber.substring(8, bankCodeNumber.length()));
		komaVars += "Blz: " + blz1 + " " + blz2 + " " + blz3 + " \\\\";
		komaVars += "Bank: " + bankName + "\\\\";
		//komaVars += "IBAN: " + bankIban + "\\\\";
		//komaVars += "BIC: " + bankBic;
		komaVars += "}";
		return komaVars;
	}

	private void compileInvoice(){
		boolean res = utils.exec(compilerCommand, targetPath);
		if (res){
			System.out.println("... compile Invoice erfolgreich.");
		}
	}
	
	private void moveInvoice(){
		String auxFile = targetFileBaseName + ".aux";
		String logFile = targetFileBaseName + ".log";
		String pdfFile = targetFileBaseName + ".pdf";
		String command = "mv";
		String param = auxFile + " " + logFile + " " + pdfFile + " " + targetBase + targetDir + "/";
		boolean res = utils.exec(command, param);
		if (res){
			System.out.println("... move Invoice erfolgreich.");
		}
	}
	
	private void showInvoice(){
		boolean res = utils.exec(viewerCommand, targetPathPdf);
		if (res){
			System.out.println("... show Invoice erfolgreich.");
		}
	}
	
}
