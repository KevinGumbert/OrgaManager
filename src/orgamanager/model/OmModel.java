package orgamanager.model;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import orgamanager.config.OmConfig;
import orgamanager.config.WebAttachmentConfig;
import orgamanager.model.development.selenium.ehc.EhcTests;
import orgamanager.model.development.selenium.joba.JobaTests;
import orgamanager.model.development.selenium.skp.SkpTests;
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

	public boolean doSignatures() {
		System.out.println("doSignatures");
		
		// Hinweise zum Aufbau.
		// php-Skript mit Prozedur um Platzhalter zu fuellen
		// HTML-Vorlagen-Verzeichnis mit Mitarbeiterdatei, Bildern, Vorlagen
		// ... Ende Hinweise
		
		// Aufgabe:
		// Vereinfachung der HTML-Signatur (weg mit Tabellen, hin zu Absaetzen
		// Testen der Signaturen auf Druckern
		// ... Ende der Aufgabenliste
		
		// Ressourcen-Verzeichnis (Mitarbeiterdatei, Bilder, Vorlagen)
		
		// Schleife ...
			// HTML-Vorlage waehlen		
			// HTML-Signatur erzeugen
		// ... end 
		
		// Archivdatei bilden
		
		// Archivdatei speichern
		
		System.out.println("doSignatures - end");
		return true;
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
			try {
				// start upload
				WebAttachmentConfig webAttachmentConfig = config.getWebAttachmentConfig();
				UploadTask task = new UploadTask(webAttachmentConfig.getHost(), webAttachmentConfig.getPort(), webAttachmentConfig.getUsername(), webAttachmentConfig.getPassword(), "/cloud/test", file);
				task.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"Sie haben keinen Anhang ausgewaehlt. Klicken Sie auf X falls Sie das Programm beenden moechten. ",
					"Anhangauswahl", JOptionPane.WARNING_MESSAGE); 
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
		// copy java project to rbpi, run ant, run software with parameter -tui;
		
		// set virtual host like vintetrez.local 
		// ping dev host
		// see etc/apache2 sites-available and sites-enabled, see etc/hosts
		// check ob notebook host auf rbpi erreichbar ist - nein ping ergibt unknown host;
		
		
		return false;
	}
	
	public boolean doOxidInstall(){
		// TODO include in gui
		
		// virtuellen host anlegen lacshop.local
		
		// === oxid update ===  
		
		return false;
	}
}
