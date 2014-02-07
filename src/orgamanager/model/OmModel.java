package orgamanager.model;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import junit.textui.TestRunner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runners.JUnit4;

import orgamanager.model.publications.PublicationsList;
import orgamanager.selenium.ehc.EhcTests;
import orgamanager.selenium.joba.JobaTests;
import orgamanager.selenium.skp.SkpTests;
import orgamanager.tests.OmModelTest;
import orgamanager.utilities.OmConfig;
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
		if (!isAuthorized){
			return false;
		}
		Invoice invoice = new Invoice();
		invoice.printAsPdf();
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
