package orgamanager.tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import orgamanager.model.OmModel;
import orgamanager.model.citation.Citation;
import orgamanager.model.citation.CitationList;
import orgamanager.model.citation.Proceeding;
import orgamanager.utilities.OmConfig;
import orgamanager.utilities.OmUtilities;

public class OmModelTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void doLoginTest(){
		OmModel omModel = new OmModel();
		OmConfig config = new OmConfig();
		String username = config.username;
		String password = config.password;
		boolean act = omModel.doLogin(username, password);
		assertTrue("doLoginTest", act);
	}
	
	@Test
	public void doLoginFailedTest(){
		OmModel omModel = new OmModel();
		String username = "falsch";
		String password = "falsch";
		boolean act = omModel.doLogin(username, password);
		assertFalse("doLoginFailedTest", act);
	}
	
	@Test
	public void doCreatePublicationsTest() throws InterruptedException, FileNotFoundException{
		String inproceedingsCitation1 = "";
		inproceedingsCitation1 += "@inproceedings{Bauer.2014,\n";
		inproceedingsCitation1 += " abstract = {Mit dem Konzept des Ambient Assisted Living (AAL) sollen technische Hilfestellungen entwickelt werden, um den l{\\\"a}ngeren Verbleib {\\\"a}lterer Menschen im gewohnten Umfeld zu erm{\\\"o}glichen. Meist werden solche technischen Hilfestellungen jedoch stark technologiegetrieben entwickelt und entsprechen nicht dem tats{\\\"a}chlichen Bed{\\\"u}rfnis der Endanwender. Das im Projekt verwendete Vorgehen der menschzentrierten Gestaltung stellt hingegen den Benutzer in den Mittelpunkt: Auf diese Weise sollen Fehlentwicklungen von Anfang an vermieden werden und ein gebrauchstaugliches System entstehen. Durch Usability-Tests werden zielgruppenspezifische Probleme im Umgang mit AAL-Serviceplattformen erkannt und m{\\\"o}gliche L{\\\"o}sungsvorschl{\\\"a}ge durchdacht.},\n";
		inproceedingsCitation1 += " author = {Bauer, Jochen and Kettschau, Anna and Franke, J{\\\"o}rg},\n";
		inproceedingsCitation1 += " title = {Optimierung der Datenvisualisierung von AAL-Serviceplattformen durch Usability-Tests},\n";
		inproceedingsCitation1 += " keywords = {E|Home;AAL;Smart Home;Mensch-Maschine-Interaktion},\n";
		inproceedingsCitation1 += " publisher = {VDE Verlag Gmbh},\n";
		inproceedingsCitation1 += " isbn = {978-3-8007-3574-7},\n";
		inproceedingsCitation1 += " editor = {VDE and BMBF and {Sozialverband VdK} and Fraunhofer-AAL},\n";
		inproceedingsCitation1 += " booktitle = {Wohnen - Pflege - Teilhabe {\\dq}Besser leben durch Technik{\\dq}},\n";
		inproceedingsCitation1 += " year = {2014},\n";
		inproceedingsCitation1 += " address = {Berlin}\n";
		inproceedingsCitation1 += "}\n";
		Citation citation1 = new Citation(inproceedingsCitation1);
		String exp1 = "Bauer, J.; Kettschau, A.; Franke, J.: Optimierung der Datenvisualisierung von AAL-Serviceplattformen durch Usability-Tests. In: VDE; BMBF; Sozialverband VdK; Fraunhofer-AAL (Hrsg.): Wohnen - Pflege - Teilhabe \"Besser leben durch Technik\". Berlin: VDE Verlag Gmbh, 2014";
		String act1 = citation1.getReference();
		assertEquals("doCreatePublicationsTest-1", exp1, act1);	 
		
		String proceeding2 = "";
		proceeding2 += "@proceedings{VDE.2013,\n";
		proceeding2 += " abstract = {Neue Assistenzsysteme und Dienstleistungen werden f{\\\"u}r vielf{\\\"a}ltige Zielgruppen und Lebensumst{\\\"a}nde entwickelt, f{\\\"u}r die sie Unterst{\\\"u}tzung bieten k{\\\"o}nnen. Die L{\\\"o}sungsans{\\\"a}tze spiegeln das wider - und finden zunehmend ihren Weg in die praktische Erprobung und in den Alltag. Dieser Mannigfaltigkeit stellt sich der 6. Deutsche AAL-Kongress, wenn er seinen Fokus f{\\\"u}r 2013 auf Lebensqualit{\\\"a}t im Wandel von Demografie und Technik richtet. Mit der gro{\\ss}en Bandbreite der Themen sollen viele Lebensbereiche einbezogen werden, in denen AAL-Systeme neue und zus{\\\"a}tzliche Lebensqualit{\\\"a}t bieten k{\\\"o}nnen. Hierzu werden wieder praktische Anwendungsbeispiele, Konzeptstudien von morgen und technische L{\\\"o}sungen von heute diskutiert. Neben Plenarbeitr{\\\"a}gen und Vortr{\\\"a}gen werden erstmals auch Workshops angeboten. Der Deutsche AAL-Kongress wird zum sechsten Mal ausgerichtet. Er avancierte in den vergangenen f{\\\"u}nf Jahren zum Leitkongress im Innovationsfeld AAL.},\n";
		proceeding2 += " year = {2013},\n";
		proceeding2 += " title = {Lebensqualit{\\\"a}t im Wandel von Demografie und Technik: 6. deutscher AAL-Kongress mit Ausstellung, 22-23. Januar 2013, Berlin, Tagungsbeitr{\\\"a}ge},\n";
		proceeding2 += " address = {Berlin},\n";
		proceeding2 += " number = {1},\n";
		proceeding2 += " publisher = {VDE~Verlag GmbH},\n";
		proceeding2 += " isbn = {978-3-8007-3484-9},\n";
		proceeding2 += " editor = {VDE and BMBF and {Sozialverband VdK} and Fraunhofer-AAL}\n";
		proceeding2 += "}\n";
		Proceeding proc2 = new Proceeding(proceeding2);
		ArrayList<Proceeding> proceedings2 = new ArrayList<Proceeding>();
		proceedings2.add(proc2);
		String inproceedingsCitation2 = "";
		inproceedingsCitation2 += "@inproceedings{Franke.2013b,\n";
		inproceedingsCitation2 += " abstract = {Deutschland wird {\\\"a}lter. Deutschland wird vielf{\\\"a}ltiger. Deutschland wird moderner. Deutschland muss aber auch Energie und Strom sparen. Vor diesem Hintergrund wurde im Mai 2012 das bayerische Technologiezentrum f{\\\"u}r privates Wohnen gegr{\\\"u}ndet. Die gr{\\\"o}{\\ss}ten Erfolgschancen versprechen ganzheitlich ausgerichtete Forschungsans{\\\"a}tze im Bereich Smart Living, da nur so Innovationen akzeptiert und die Lebensqualit{\\\"a}t der Bewohner nachhaltig gesteigert werden. Ein interdisziplin{\\\"a}res Forscherteam, bestehend aus Ingenieuren, Informatikern und Sozialwissenschaftlern erarbeitet ein ganzheitliches Konzept, welches die Bed{\\\"u}rfnisse der Bewohner in den Mittelpunkt stellt. Zusammen mit Partnern aus Forschung und Wirtschaft sollen marktf{\\\"a}hige L{\\\"o}sungen entwickelt werden. So soll sichergestellt werden, dass die entwickelten L{\\\"o}sungen tats{\\\"a}chlich Anwendung finden und sich Smart Homes am Markt etablieren k{\\\"o}nnen.},\n";
		inproceedingsCitation2 += " author = {Franke, J{\\\"o}rg and Zerth, J{\\\"u}rgen and Kleineidam, Gerhard and Kettschau, Anna},\n";
		inproceedingsCitation2 += " title = {Mehr Lebensqualit{\\\"a}t durch Smart Homes? Die Notwendigkeit ganzheitlicher Forschung im Bereich Smart Living},\n";
		inproceedingsCitation2 += " keywords = {AAL;Smart Home},\n";
		inproceedingsCitation2 += " pages = {304--307},\n";
		inproceedingsCitation2 += " publisher = {VDE~Verlag GmbH},\n";
		inproceedingsCitation2 += " isbn = {978-3-8007-3484-9},\n";
		inproceedingsCitation2 += " editor = {VDE and BMBF and {Sozialverband VdK} and Fraunhofer-AAL},\n";
		inproceedingsCitation2 += " booktitle = {Lebensqualit{\\\"a}t im Wandel von Demografie und Technik},\n";
		inproceedingsCitation2 += " year = {2013},\n";
		inproceedingsCitation2 += " address = {Berlin}\n";
		inproceedingsCitation2 += "}\n";
		Citation citation2 = new Citation(inproceedingsCitation2, proceedings2);
		String exp2 = "Franke, J.; Zerth, J.; Kleineidam, G.; Kettschau, A.: Mehr Lebensqualität durch Smart Homes? Die Notwendigkeit ganzheitlicher Forschung im Bereich Smart Living. In: VDE; BMBF; Sozialverband VdK; Fraunhofer-AAL (Hrsg.): Lebensqualität im Wandel von Demografie und Technik: 6. deutscher AAL-Kongress mit Ausstellung, 22-23. Januar 2013, Berlin, Tagungsbeiträge. Berlin: VDE-Verlag GmbH, 2013, S. 304--307";
		String act2 = citation2.getReference();
		assertEquals("doCreatePublicationsTest-2", exp2, act2);		 
			 
//		OmModel model = new OmModel();
//		model.doCreatePublications();
//		String act0 = "Test";
//		String exp0 = "Test";
//		assertEquals("doCreatePublicationsTest-0", exp0, act0);
		
		// inproceedings
		//OmUtilities utils = new OmUtilities();
		//String path = "testfile3.txt";
		//utils.printStringToFile(entry, path); // Workspace
		//Thread.sleep(2000); // 2 secs
		//CitationList citationList = new CitationList(path);
		//citationList.printList();
		//Tremel, J. ; Franke, J. ; Dobroschke, A. ; Kühl, A.: Innovative Processes and Systems for the Automated Manufacture, Assembly and Test of Magnetic Components for Electrical Machines (2011), S. 228–234
		//fail("Not yet implemented!");
		//utils.deleteFile(path);
		//@misc{Bauer.13.11.2013,
		//	 author = {Bauer, Jochen and Kettschau, Anna},
		//	 year = {13.11.2013},
		//	 title = {Alter, Wohnen und Technik: Mit technischen Innovationen gesellschaftliche Herausforderungen l{\"o}sen},
		//	 address = {N{\"u}rnberg},
		//	 series = {Energie und Forschung {\dq} Die Forschung von heute - die Energie von morgen{\dq}}
		//	}
	}
	
}
