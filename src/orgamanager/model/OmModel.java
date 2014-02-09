package orgamanager.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

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
//		if (!isAuthorized){
//			return false;
//		}
		
		// db: sqlite, create and manage via firefox addon and copy to workspace
		// tutorial see tutorialspoint.com/sqlite/sqlite_java.htm
//		Connection c = null;
//		try {
//			Class.forName("org.sqlite.JDBC");
//			c = DriverManager.getConnection("jdbc:sqlite:orgamanager.sqlite");
//			//JOptionPane.showMessageDialog(null, "BP0", "DEBUG", JOptionPane.WARNING_MESSAGE);
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "BP1", "DEBUG", JOptionPane.WARNING_MESSAGE);
//			System.err.println(e.getClass().getName() + ": " + e.getMessage());
//			System.exit(0);
//		}
		
		// JPA EclipseLink
		
		// Ablauf: 
		// Rechnung soll erzeugt werden, ich will eine PDF-Datei;
		// Komponente SaveAs wird im Dialog als FileChooser gebraucht;
		// Komponente Job und Jobvariante sollte vorab klar sein, damit die passenden Vorbelegungen gesetzt werden;
		// Absendebutton 
		// Konfigurationsbildschirm erlaubt Angabe aller Empfaengerdetails, Absendervarianten und Textbloecke;
		// Verzeichnis mit allen Dateien erzeugen wird, wieder geloescht;
		
		// configuration:
		// targetBase verzeichnis;
		// latex compiler, here pdflatex;
		// pdfviewer, here evince;
		// jobvariante via dropdown, ebenso die zugehoerigen optionen
		// recipient angaben
		// rechnungsnummer aus speicher letzte lesen und um eins erhoehen
		// TODO vorlage auswahl erlauben bzw. beim erstellen als vorlage speichern ...
		
		
		// Dialog zur Auswahl des Jobs und der Subrechnung
		
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
		String PERSISTENCE_UNIT_NAME = "InvoiceRecipient";
		EntityManagerFactory factory;
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		Query q = em.createQuery("select r from InvoiceRecipient r"); // Query to existing data
		List<InvoiceRecipient> recipientsList = q.getResultList();
		for (InvoiceRecipient recipient : recipientsList) { // loping trough riderList and print out rider
			System.out.println(recipient);
		}
		System.out.println("Size befor insert: " + recipientsList.size()); // Print number of rider
		em.getTransaction().begin(); // start transaction with method begin()
		for (int i = 0; i < 10; i++) { // create around 10 rider with dummy data
			InvoiceRecipient recipient = new InvoiceRecipient();
			recipient.setFirstName("Recipient-" + i);
			em.persist(recipient); // insert into database
		}
		em.getTransaction().commit(); // commit transaction commit();
		//List<InvoiceRecipient> recipientsList = q.getResultList();
		recipientsList = q.getResultList();
		System.out.println("Size after insert: " + recipientsList.size());
		em.close();
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

	public void doCreateAssignment(){
		JOptionPane.showMessageDialog(null, "BP1","Debug", JOptionPane.WARNING_MESSAGE);
	}

}
