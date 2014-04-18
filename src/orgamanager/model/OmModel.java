package orgamanager.model;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
import orgamanager.model.development.selenium.ehc.EhcTests;
import orgamanager.model.development.selenium.joba.JobaTests;
import orgamanager.model.development.selenium.skp.SkpTests;
import orgamanager.model.office.InvoiceRecipient;
import orgamanager.model.office.InvoicingParty;
import orgamanager.model.publications.PublicationsList;
import orgamanager.model.webAttachment.UploadTask;
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
		ArrayList<String> jobs = new ArrayList<String>(party.getJobOptions());
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
	
	public void doWebAttachment() {
		JOptionPane.showMessageDialog(null,
				"Waehlen Sie die Datei fuerr den Anhang aus.",
				"Anhangauswahl", JOptionPane.WARNING_MESSAGE); 
		String workingDir = System.getProperty("user.dir");
		JFileChooser fc = new JFileChooser(workingDir);
		int state = fc.showOpenDialog(null);
		if (state == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			String path = file.getPath();
//			AttachmentsList attachments;
//			try {
//				
//				attachments = new AttachmentsList(path);
				// TODO translate
//				JOptionPane.showMessageDialog(null,
//						"W�hlen Sie die Datei f�r den Anhang aus. ",
//						"OrgaManager | Attachments", JOptionPane.PLAIN_MESSAGE);
				
//				JFileChooser fcSave = new JFileChooser(workingDir);
//				OmUtilities utils = new OmUtilities();
				
//				OmOperatingSystemConstant os = utils.detectOperatingSystem();
//				String proposedFileName = "";
//				if (os == OmOperatingSystemConstant.WINDOWS) {
//					proposedFileName = workingDir + "\\"
//							+ "Gespeichert_als_CSV-Datei.csv";
//				} else {
//					proposedFileName = workingDir + "/"
//							+ "Gespeichert_als_CSV-Datei.csv";
//				}

				//fcSave.setSelectedFile(new File(proposedFileName));
				
				// hier geht der Upload los mit file
//				 UploadFile uploadFile = new UploadFile();
//				 uploadFile.doUpload(path, "/cloud");
				
//				UploadTask task = new UploadTask(webAttachmentConfig.getHost(),
//						21, webAttachmentConfig.getUsername(),
//						webAttachmentConfig.getPassword(), "/cloud/test", file);
//
//				task.execute();
//				
//				int stateSaveFileChooser = fcSave.showSaveDialog(null);
//				if (stateSaveFileChooser == JFileChooser.APPROVE_OPTION) { // 0
//					String saveFileName = fcSave.getSelectedFile().getPath();
//					attachments.saveAsCsv(saveFileName);
//					JOptionPane.showMessageDialog(null, "Datei erzeugt.",
//							"OrgaManager | Attachments",
//							JOptionPane.PLAIN_MESSAGE); // TODO translate
//				} else {
//					JOptionPane.showMessageDialog(null,
//							"Dateiname zum Speichern nicht erkannt!",
//							"OrgaManager | Publikationen",
//							JOptionPane.WARNING_MESSAGE); // TODO translate
//				}
//
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} else {
//			JOptionPane.showMessageDialog(null,
//					"Sie haben keinen Anhang ausgew�hlt. Klicken Sie auf X falls Sie das Programm beenden m�chten. ",
//					"Anhangauswahl", JOptionPane.WARNING_MESSAGE); 
		}
	}

	public void doEhcWebAppTurnLightOn(){
		// TODO Check warum geht das, wenn ich auf dem Uni-Netz-Rechner arbeite via Netzwerkkabel und mein Notebook via FAU-Staff via WLan verbunden ist?
		JOptionPane.showMessageDialog(null, "BP0", "Debug", JOptionPane.WARNING_MESSAGE);
		OmUtilities utils = new OmUtilities();
		// TODO use URL-Encoder instead of strings
		//String targetURL = "http://www.jochen-bauer.net";
		//String urlParameters = "";
		// http://10.20.66.71:8083/fhem?cmd.steckdose=set steckdose on&room=Buero
		// http://10.20.66.71:8083/fhem?cmd.steckdose=set steckdose on&room=Buero
		// String data = URLEncoder.encode("key1", "UTF-8") + "=" + URLEncoder.encode("value1", "UTF-8");
		// data += "&" + URLEncoder.encode("key2", "UTF-8") + "=" + URLEncoder.encode("value2", "UTF-8");
		String targetURL = "http://10.20.66.71:8083/fhem";
		String urlParameters = "cmd.steckdose=set steckdose on&room=Buero";
		String res = utils.executeHttpPost(targetURL, urlParameters);
		System.out.println("HTTP-Response: " + res);
		JOptionPane.showMessageDialog(null, "BP1", "Debug", JOptionPane.WARNING_MESSAGE);
	}
	
	public void doEhcWebAppTurnLightOff(){
		JOptionPane.showMessageDialog(null, "BP0", "Debug", JOptionPane.WARNING_MESSAGE);
		OmUtilities utils = new OmUtilities();
		String targetURL = "http://10.20.66.71:8083/fhem";
		String urlParameters = "cmd.steckdose=set steckdose off&room=Buero";
		String res = utils.executeHttpPost(targetURL, urlParameters);
		System.out.println("HTTP-Response: " + res);
		JOptionPane.showMessageDialog(null, "BP1", "Debug", JOptionPane.WARNING_MESSAGE);
	}
	
	public void doEhcWebAppSelfInstall(){
		JOptionPane.showMessageDialog(null, "BP0", "Debug", JOptionPane.WARNING_MESSAGE);
		// download all files
		// create all relations between components
		JOptionPane.showMessageDialog(null, "BP1", "Debug", JOptionPane.WARNING_MESSAGE);
	}
	
	public void doEhcWebAppSelfDescribe(){
		JOptionPane.showMessageDialog(null, "BP0", "Debug", JOptionPane.WARNING_MESSAGE);
		// collect all services
		// describe all services
		JOptionPane.showMessageDialog(null, "BP1", "Debug", JOptionPane.WARNING_MESSAGE);
	}
	
	public void doEhcWebAppSelfConfigure(){
		JOptionPane.showMessageDialog(null, "BP0", "Debug", JOptionPane.WARNING_MESSAGE);
		// grab all information
		// configure components related to current situation
		JOptionPane.showMessageDialog(null, "BP1", "Debug", JOptionPane.WARNING_MESSAGE);
	}
	
	public void doEhcWebAppSelfCheck(){
		JOptionPane.showMessageDialog(null, "BP0", "Debug", JOptionPane.WARNING_MESSAGE);
		// run tests
		// contact components
		// run test procedure component A i.e. fhem
		// create report
		JOptionPane.showMessageDialog(null, "BP1", "Debug", JOptionPane.WARNING_MESSAGE);
	}
	
	public String doEhcWebAppJsonApiAccess(int... optionalUseCaseParam){
		OmUtilities utils = new OmUtilities();
		String targetURL = "";
		String urlParameters = "";
		if (optionalUseCaseParam[0] == 1){ // check connection
			targetURL = "http://ehcserver.local/ehomejson/";
			String response = utils.executeHttpPost(targetURL, urlParameters);
			return response;
		} else if (optionalUseCaseParam[0] == 2){
			targetURL = "http://ehcserver.local/ehomejson/togglelightone/1";
			String response = utils.executeHttpPost(targetURL, urlParameters);
			return response;
		} else if (optionalUseCaseParam[0] == 3){
			// call fhem directly "http://10.20.65.108:8083/fhem?cmd.steckdose=set steckdose on&room=Buero";
			// TODO Check Java FHEM API Erweiterung siehe openAAL-Projekt
			String ip = "10.20.65.108"; 
			targetURL = "http://" + ip + ":8083/fhem?cmd.steckdose=set steckdose off&room=Buero";
			String response = utils.executeHttpGet(targetURL, urlParameters);
			return response;
		} else { // default: show modal use case picker
			
		}
		return null;
		
	}
	
	public boolean doOrgaManagerDeployment(){
		// TODO include in gui
		
		// export as runnable jar from eclipse and save on desktop 
		// mark as executable and open with openjdk java 7 runtime
		// jar contains referenced libs, size is 44mb
		
		// start orga manager: java -jar orgamanager-version-xx.jar
		return false;
	}
	
	public boolean doRbPiInstall(){
		// TODO include in gui
		
		// setup: rbpi board; rbpi power supply; sd-card with rbpi-linux; active hub; hdmi screen; mouse; keyboard; wlan-dongle to connect to net; 
		// raspian installation on sd-card - use windows way!
		// remember that keyboard is configured to english - type z for y and use numpad for special chars;
		// sudo apt-get update laufen lassen
		// install ssh server as daemon on rbpi 
		// connect to router via ethernet, use ifconfig to get the ip
		// connect as ssh pi@my.ip.address 
		
		// install useful software
		// java ...
		
		return false;
	}
	
	public boolean doOxidInstall(){
		// TODO include in gui
		
		// virtuellen host anlegen lacshop.local
		
		// 
		
		return false;
	}

}
