package orgamanager.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import orgamanager.config.OmConfig;
import orgamanager.model.office.InvoiceRecipient;
import orgamanager.model.office.InvoicingParty;
import orgamanager.model.publications.PublicationsList;
import orgamanager.selenium.ehc.EhcTests;
import orgamanager.selenium.joba.JobaTests;
import orgamanager.selenium.skp.SkpTests;
import orgamanager.tests.OmModelTest;
import orgamanager.utilities.OmOperatingSystemConstant;
import orgamanager.utilities.OmUtilities;

/**
 * OmModel represents the API which got invoked from a corresponding controller.
 */
public class OmModel {

	private OmConfig config;
	private boolean isAuthorized;

	public OmModel() {
		config = new OmConfig();
		isAuthorized = false;
	}

	public int doSignatures() {
		System.out.println("doSignatures");
		return 0;
	}

	public boolean doLogin(String username, String password) {
		if (username.equals(config.getUsername()) && password.equals(config.getPassword())) {
			isAuthorized = true;
			return true;
		}
		return false;
	}

	public boolean doLogout() {
		isAuthorized = false;
		return true;
	}
	
	public boolean doCreateInvoice(){
//		if (!isAuthorized){ // TODO uncomment!
//			return false;
//		}
		// Ablauf:
		// Rechnung soll erzeugt werden, ich will eine PDF-Datei;
		// Komponente SaveAs wird im Dialog als FileChooser gebraucht;
		// Komponente Job und Jobvariante sollte vorab klar sein, damit die
		// passenden Vorbelegungen gesetzt werden;
		// Absendebutton
		// Konfigurationsbildschirm erlaubt Angabe aller Empfaengerdetails,
		// Absendervarianten und Textbloecke;
		// Verzeichnis mit allen Dateien erzeugen wird, wieder geloescht;
		
		// configuration:
		// targetBase verzeichnis;
		// latex compiler, here pdflatex;
		// pdfviewer, here evince;
		// jobvariante via dropdown, ebenso die zugehoerigen optionen
		// recipient angaben
		// rechnungsnummer aus speicher letzte lesen und um eins erhoehen
		// TODO vorlage auswahl erlauben bzw. beim erstellen als vorlage speichern ...
		
		
		// JPA EclipseLink, create emf, em and close afterwards!
		String PERSISTENCE_UNIT_NAME = "OrgaManager"; // see META-INF persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME); // see JPA book p 57
		EntityManager em = emf.createEntityManager();
		String qs = "select r from InvoiceRecipient r";
		Query q = em.createQuery(qs); // find all entries
		List<InvoiceRecipient> recipientsList = q.getResultList();
		int size = recipientsList.size();
		//System.out.println("Size: " + size + ";");
		InvoiceRecipient defaultRecipient = null;
		if (size == 0){ // no entries
			defaultRecipient = new InvoiceRecipient();
			recipientsList.add(defaultRecipient);
		} else {
			String searchCriteriaLastName = "Aal";
			Long recId;
			for (InvoiceRecipient rec : recipientsList){
				String lastName = rec.getLastName();
				if (lastName.equals(searchCriteriaLastName)){
					recId = rec.getId();
					defaultRecipient = em.find(InvoiceRecipient.class, recId);
					break;
				}
			}
		}
		em.persist(defaultRecipient); 	// set object to state managed
		em.getTransaction().begin(); 	// start synchronizing
		em.getTransaction().commit(); 	// start to work
		em.close(); 	// close 1
		emf.close(); 	// close 2
		InvoicingParty party = new InvoicingParty();
		String job = party.getJob();
		ArrayList<String> jobs = new ArrayList<>(party.getJobOptions());
		Object[] jobPossibilities = new Object[jobs.size()];
		jobPossibilities = jobs.toArray();
		String jobInput = (String) JOptionPane.showInputDialog(
				null, 				// parent frame 
				"Beruf:\n",			// content 
				"OrgaManager", 		// title  
				JOptionPane.PLAIN_MESSAGE, 
				null, 				// icon
				jobPossibilities, 	// dropdown
				job 				// default value
		);
		if ((jobInput != null) && (jobInput.length() > 0)) {
			if (jobInput.equals(jobPossibilities[0])){
				// first job, sub options: ...
				Object[] subjobPossibilities = {"xx xx", "xx xx xx" }; // TODO get invoice options related to job
				String subJobInput = (String) JOptionPane.showInputDialog(
						null, 				// parent frame 
						"Rechnungsart:\n",	// content 
						"OrgaManager", 		// title  
						JOptionPane.PLAIN_MESSAGE, 
						null, 				// icon
						subjobPossibilities, 	// dropdown
						job 				// default value
				);
				if ((subJobInput != null) && (subJobInput.length() > 0)) {
					// ask for client template
					Object[] clientPossibilities = new Object[recipientsList.size()];
					int i = 0;
					for (InvoiceRecipient rec : recipientsList){
						clientPossibilities[i] = rec.getLastName() + " " + rec.getFirstName() + " " + rec.getId();
						i++;
					}
					String clientInput = (String) JOptionPane.showInputDialog(
							null, 					// parent frame 
							"Vorlage:\n",			// content 
							"OrgaManager", 			// title  
							JOptionPane.PLAIN_MESSAGE, 
							null, 					// icon
							clientPossibilities,	// dropdown
							clientPossibilities[0] 	// default value
					);
					//JOptionPane.showMessageDialog(null, ("BP0 " + clientInput + ";"), "DEBUG", JOptionPane.WARNING_MESSAGE);
					String fullName = new String(clientInput.toString());
					StringTokenizer st = new StringTokenizer(fullName, " ");
					String lastName = st.nextToken();
					String firstName = st.nextToken();
					String idString = st.nextToken();
					InvoiceRecipient curRec = null;
					for (InvoiceRecipient rec : recipientsList){
						Long idInput = new Long(idString);
						Long idRec = new Long(rec.getId());
						if (idInput.equals(idRec)){
							curRec = rec;
							break;
						}
					}
					// todo get file
					// todo create new invoice and print it 
				} else {
					// TODO throw
				}
			} else if (job.equals(jobPossibilities[1])){
				
			} else if (job.equals(jobPossibilities[2])){
				
			} else {
				// TODO throw 
			}
		} else {
			// TODO throw
		}
		
		// Dialog zum Speichern der Datei
		
		//String pathToPdf = "/home/jay/curdir/rechnung/rechnung.pdf";
		//String job = ""; // dropdown
		//String clientTemplate = ""; // dropdown // todo database is necesssary
		//InvoicingParty party = new InvoicingParty(); 
		// TODO create constructor or set new values to default party properties;
		//InvoiceRecipient recipient = new InvoiceRecipient();
		//Invoice invoice = new Invoice(pathToPdf, party, recipient);
		//invoice.printAsPdf();
		
		// JPA usage START
		// Create entity manager, this step will connect to database, please check JDBC driver on classpath, jdbc URL, jdbc driver name on persistence.xml
		//String PERSISTENCE_UNIT_NAME = "OrgaManager"; // see META-INF persistence.xml
//		EntityManagerFactory factory;
//		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//		EntityManager em = factory.createEntityManager();
//		Query q = em.createQuery("select r from InvoiceRecipient r"); // Query to existing data
//		List<InvoiceRecipient> recipientsList = q.getResultList();
//		for (InvoiceRecipient recipient : recipientsList) { // loping trough riderList and print out rider
//			System.out.println(recipient);
//		}
//		System.out.println("Size befor insert: " + recipientsList.size()); // Print number of rider
//		em.getTransaction().begin(); // start transaction with method begin()
//		for (int i = 0; i < 10; i++) { // create around 10 rider with dummy data
//			InvoiceRecipient recipient = new InvoiceRecipient();
//			recipient.setFirstName("Recipient-" + i);
//			em.persist(recipient); // insert into database
//		}
//		em.getTransaction().commit(); // commit transaction commit();
//		//List<InvoiceRecipient> recipientsList = q.getResultList();
//		recipientsList = q.getResultList();
//		System.out.println("Size after insert: " + recipientsList.size());
//		em.close();
		// end of JPA usage
		return true;
	}

	public void doRunTestsOrgaManager(){
		Result result = JUnitCore.runClasses(OmModelTest.class);
		String message = "Ran: " + result.getRunCount() + ", Ignored: " + result.getIgnoreCount() + ", Failed: " + result.getFailureCount();
		JOptionPane.showMessageDialog(null, message, "JUnit Tests OrgaManager", JOptionPane.WARNING_MESSAGE);
	}
	
	public void doRunTestsSeleniumEhc(){
		Result result = JUnitCore.runClasses(EhcTests.class);
		String message = "Ran: " + result.getRunCount() + ", Ignored: " + result.getIgnoreCount() + ", Failed: " + result.getFailureCount();
		JOptionPane.showMessageDialog(null, message, "Selenium Tests Ehc", JOptionPane.WARNING_MESSAGE);
	}
	
	public void doCreateClientReport() {
		JOptionPane.showMessageDialog(null, "TODO","Debug", JOptionPane.WARNING_MESSAGE);
	}

	public void doCreateGallery() {
		JOptionPane.showMessageDialog(null, "TODO","Debug", JOptionPane.WARNING_MESSAGE);
	}

	public void doRunTestsSeleniumJoba() {
		Result result = JUnitCore.runClasses(JobaTests.class);
		String message = "Ran: " + result.getRunCount() + ", Ignored: " + result.getIgnoreCount() + ", Failed: " + result.getFailureCount();
		JOptionPane.showMessageDialog(null, message, "Selenium Tests Joba", JOptionPane.WARNING_MESSAGE);
	}

	public void doRunTestsSeleniumSkp() {
		Result result = JUnitCore.runClasses(SkpTests.class);
		String message = "Ran: " + result.getRunCount() + ", Ignored: " + result.getIgnoreCount() + ", Failed: " + result.getFailureCount();
		JOptionPane.showMessageDialog(null, message, "Selenium Tests Skp", JOptionPane.WARNING_MESSAGE);
	}

	public void doRunTestsSeleniumTcBwSuro() {
		Result result = JUnitCore.runClasses(SkpTests.class);
		String message = "Ran: " + result.getRunCount() + ", Ignored: " + result.getIgnoreCount() + ", Failed: " + result.getFailureCount();
		JOptionPane.showMessageDialog(null, message, "Selenium Tests TCBW", JOptionPane.WARNING_MESSAGE);
	}

	public void doCreatePublications(){
		// TODO:
		// check one line adding as first line for web export
		// start selenium procedure to really upload file to webserver
		JOptionPane.showMessageDialog(null, "Bitte wählen Sie die Datei mit der Bibtex-Datenbank","OrgaManager | Publikationen", JOptionPane.WARNING_MESSAGE); // TODO translate
		String workingDir = System.getProperty("user.dir");
		JFileChooser fc = new JFileChooser(workingDir);
		int state = fc.showOpenDialog(null);
		if (state == JFileChooser.APPROVE_OPTION){
			File file = fc.getSelectedFile();
			String path = file.getPath();
			PublicationsList publications;
			try {
				publications = new PublicationsList(path);
				JOptionPane.showMessageDialog(null, "Literaturverzeichnis im Speicher angelegt. Speichern Sie die Datei ...","OrgaManager | Publikationen", JOptionPane.PLAIN_MESSAGE); // TODO translate
				JFileChooser fcSave = new JFileChooser(workingDir);
				OmUtilities utils = new OmUtilities();
				OmOperatingSystemConstant os = utils.detectOperatingSystem();
				String proposedFileName = "";
				if (os == OmOperatingSystemConstant.WINDOWS){
					proposedFileName = workingDir + "\\" + "Gespeichert_als_CSV-Datei.csv";
				} else {
					proposedFileName = workingDir + "/" + "Gespeichert_als_CSV-Datei.csv";
				}
				
				fcSave.setSelectedFile(new File(proposedFileName));
				int stateSaveFileChooser = fcSave.showSaveDialog(null);
				if (stateSaveFileChooser == JFileChooser.APPROVE_OPTION){ // 0
					String saveFileName = fcSave.getSelectedFile().getPath();
					publications.saveAsCsv(saveFileName);
					JOptionPane.showMessageDialog(null, "Datei erzeugt.","OrgaManager | Publikationen", JOptionPane.PLAIN_MESSAGE); // TODO translate
				} else {
					JOptionPane.showMessageDialog(null, "Dateiname zum Speichern nicht erkannt!","OrgaManager | Publikationen", JOptionPane.WARNING_MESSAGE); // TODO translate
				}
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Beenden Sie das Programm durch X","OrgaManager | Publikationen", JOptionPane.WARNING_MESSAGE); // TODO translate
		}
	}

	public void doCreateQuote(){
		JOptionPane.showMessageDialog(null, "BP0","Debug", JOptionPane.WARNING_MESSAGE);
		
	}
	
	public void doCreateAssignment(){
		JOptionPane.showMessageDialog(null, "BP0","Debug", JOptionPane.WARNING_MESSAGE);
		
		// Idee:
		// Abschlussarbeiten stehen auf website, im studon (Mail an Markus), eine Mail geht an Joerg, Ausdrucke sollten am FAPS sein und auch in der Mensa / Hoersaal 
		
		// Bausteine Abschlussarbeitsausschreibung:
		// Titel
		// Ausgangssituation
		// Aufgabenstellung
		// Inhaltliche Schwerpunkte
		// Abschlussfuss 
		
		// Prozess beim Laufen der Arbeit
		// Bearbeiter 
		// Startzeit, Endzeit
		
		// Prozess beim Hochladen auf ehome-website
		// Besuch URL, login via ...
		// letzte eigene Arbeit 'Artikel duplizieren'
		// Artikel Eigenschaften
	}
	/*		
	Themen
	
	Analyse bestehender Kombinations-Algorithmen und Prozesse im AAL- und SmartHome-Bereich
	Version 2; Status: offen;
	Ausgangssituation
	Das E|Home-Center ist eine interdisziplinäre Forschungsgruppe an der FAU Erlangen-Nürnberg. Ressourcenschonendes, 
	nachhaltiges und intelligentes Wohnen stehen im Vordergrund. Mit dem Älterwerden entstehen bestimmte Anforderungen an 
	das Wohnumfeld, damit ein selbstbestimmter Alltag möglichst lange aufrecht erhalten werden kann. Im Forschungsfeld 
	Ambient Assisted Living (AAL) werden technische Assistenzsysteme für diese Anforderungen entwickelt. Es besteht 
	Potential Prozeduren und Algorithmen aus dem AAL- und SmartHome-Bereich zu kombinieren und so für zusätzliche 
	Funktionalität zu sorgen.
	Aufgabenstellung
	Es existieren etwa Algorithmen, die die Beschleunigung und den Puls des Bewohners beobachten und darauf aufbauend 
	eine Aussage zu den Vitaldaten treffen. Am E|Home-Center besitzt das Herz der intelligenten Wohnung eine Schnittstelle 
	ins Internet. Aus diesem Grund sind Dienste, wie ifttt.com interessant, die es erlauben, verschiedene Webanwendungen, 
	wie etwa facebook, ´Weather und Dropbox automatisiert zu steuern. Hieraus ergibt sich durch Kombination eine schier 
	unendlich große Vielfalt an Funktionalität. Erste Geschäftsmodelle auf Basis ausschließlicher Algorithmik entstehen, 
	etwa die Firma YETU. Bestehende UseCases für den AAL- und SmartHome-Bereich sind zu detektieren und neue Ideen zu 
	kreieren. 
	Inhaltliche Schwerpunkte
	Ermittlung bestehender domänenübergreifenden Prozeduren im AAL- und SmartHome-Bereich; 
	Analyse des Service-Dienstes ifttt und YETU;
	Kreation neuer Anwendungsfälle;

Desease Management Systeme Ernährungsberatung
Version: 3; Status: offen;
Ausgangssituation
Das E|Home-Center ist eine interdisziplinäre Forschungsgruppe an der FAU Erlangen-Nürnberg. Ressourcenschonendes, 
nachhaltiges und intelligentes Wohnen stehen im Vordergrund. Mit dem Älterwerden entstehen bestimmte Anforderungen an
das Wohnumfeld. Im Forschungsfeld Ambient Assisted Living (AAL) werden technische Assistenzsysteme für diese 
Anforderungen entwickelt und damit dem Bewohner ermöglicht, dass dieser länger in seiner gewohntem Umgebung verbleiben 
kann. 
Aufgabenstellung
Für diverse Krankheitsbilder existieren Software-Werkzeuge oder Webawendungen, die versuchen den Alltag für den 
Betroffenen zu erleichtern, etwa Gewichtsreduktionsprogramme für Adipöse oder Blutzucker-Monitoring-Programme für 
Diabetiker. Es herrscht hingegen keine Verbindung zwischen Wohnung, Patient und Arzt. Smartphone-Anwendungen sind 
personenzentriert, 
es herrscht hingegen keine Verbindung in der Wohnung verfügbarer Sensorik. Die Wohnung als solche verfügt über die 
Daten, kann diese aber wiederum nicht exportieren. Die Beobachtung der Nährstoffe und Energieaufnahme ist für diverse 
Krankheitsbilder relevant. Der aktuelle Stand der Forschung soll erhoben werden, inwieweit eine Anbindung an einer 
Lebensmitteldatenbank als Quelle für eine Serviceplattform dienen kann.   
Inhaltliche Schwerpunkte
Ermittlung relevanter softwaregestützter Gewichtsreduktionsprogramme;
Ermittlung und Bewertung unterschiedlicher Strategien der Bereitstellung von Nahrungsmittelinhaltsstoffen dieser Programme; 
Konzeption der Bereitstellung von Nahrungsmittelbestandteilen auf einer AAL-Serviceplattform;
Realisierung des Konzepts in Form eines Demonstrators 

Dezentrale Ansätze Systeme zur Hausautomatisierung
Ausgangssituation
Das E|Home-Center ist eine interdisziplinäre Forschungsgruppe an der FAU Erlangen-Nürnberg. Ressourcenschonendes, 
nachhaltiges und intelligentes Wohnen stehen im Vordergrund. Mit dem Älterwerden entstehen bestimmte Anforderungen an
das Wohnumfeld. Im Forschungsfeld Ambient Assisted Living (AAL) werden technische Assistenzsysteme für diese 
Anforderungen entwickelt und damit dem Bewohner ermöglicht, dass dieser länger in seiner gewohntem Umgebung verbleiben 
kann. 
Aufgabenstellung
Für diverse Krankheitsbilder existieren Software-Werkzeuge oder Webawendungen, die versuchen den Alltag für den 
Betroffenen zu erleichtern, etwa Gewichtsreduktionsprogramme für Adipöse oder Blutzucker-Monitoring-Programme für 
Diabetiker. Es herrscht hingegen keine Verbindung zwischen Wohnung, Patient und Arzt. Smartphone-Anwendungen sind 
personenzentriert, 
es herrscht hingegen keine Verbindung in der Wohnung verfügbarer Sensorik. Die Wohnung als solche verfügt über die 
Daten, kann diese aber wiederum nicht exportieren. Die Beobachtung der Nährstoffe und Energieaufnahme ist für diverse 
Krankheitsbilder relevant. Der aktuelle Stand der Forschung soll erhoben werden, inwieweit eine Anbindung an einer 
Lebensmitteldatenbank als Quelle für eine Serviceplattform dienen kann.   
Inhaltliche Schwerpunkte
Ermittlung relevanter softwaregestützter Gewichtsreduktionsprogramme;
Ermittlung und Bewertung unterschiedlicher Strategien der Bereitstellung von Nahrungsmittelinhaltsstoffen dieser Programme; 
Konzeption der Bereitstellung von Nahrungsmittelbestandteilen auf einer AAL-Serviceplattform;
Realisierung des Konzepts in Form eines Demonstrators
 
OPC-UA und OSGI OpenHAB
Version: 2; Status: offen;
Ausgangssituation
Das E|Home-Center ist eine interdisziplinäre Forschungsgruppe an der FAU Erlangen-Nürnberg. Ressourcenschonendes, 
nachhaltiges und intelligentes Wohnen stehen im Vordergrund. In einer intelligenten Wohnung existieren oft Lösungen 
zum Monitoring von Energie- und Vitaldaten. Derartige Insellösungen sind zu vernetzen oder eine passende Middleware
zu finden. Für eine solche Middleware ist ein geschickter 
Ansatz zu wählen, der förderlich für die Interoperabilität und die dynamische Systemerweiterung ist. 
Aufgabenstellung
Das OSGi-Framework ist ein Rahmenwerk, um zur Laufzeit ein System um Komponenten zu erweitern. Als Referenzimplementierung
für die Gebäudeautomation dient openHAB.  
Die OPC Unified Architecture (OPC-UA) ist ein Kommunikationsstandard, der sich im Bereich der industriellen Maschine-Maschine-Kommunikation
bewährt hat. Es gilt im Rahmen der Arbeit das Potential von OPC-UA für den SmartHome-Bereich zu ermitteln. 
  
Inhaltliche Schwerpunkte
Analyse theoretischer Grundlagen von OSGI, openHAB und OPC-UA; 
Bau eines Demonstrators auf OSGI-Basis (openHAB);
Bau eines Demonstrators auf OPC-UA-Basis;
Ermittlung der Potentiale der beiden Ansätze für die Gebäudeautomation; 
	
*/

// OSGI openHab
// Webanwendung (PHP-MySQL-Basis/ZendFramework Abstraktionsschicht fuer Energie- und Gesundheitsdaten 
// SOA
// OPC-UA
	
}
