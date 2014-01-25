package orgamanager.model;

import java.util.ArrayList;

import orgamanager.utilities.OmUtilities;

public class Invoice {

	// Vorname Rechnungssteller
	// Nachname Rechnungssteller
	// Straﬂe Rechnungssteller
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
	// Straﬂe Rechnungsempfaenger
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
	private String job;
	private ArrayList<String> jobOptions;
	private String bankName;
	private String bankAccountNumber;
	private String bankCodeNumber;
	private String bankBic;
	private String bankIban;
	
	private String clientFirstName;
	private String clientLastName;
	private String clientCompany;
	private String clientStreet;
	private String clientStreetNumber;
	private String clientCity;
	private String clientPostalCode;
	
	private String invoiceOption;
	private ArrayList<String> invoiceOptions;
	
	private String targetLocationInvoiceFile;
	
	// PDFLatexaufruf
	
	public Invoice(){
	}
	
	public boolean printAsPdf(){
		String dir = "C:\\Users\\joba\\Desktop\\javatest";
		String file = "meinedatei.txt";
		String path = dir + "\\" + file;
		String content = "Test";
		OmUtilities utils = new OmUtilities();
		boolean res = utils.printStringToFile(content, path);
		if (res){
			return true;
		} else {
			return false;
		}
	}
	
	
	
}
