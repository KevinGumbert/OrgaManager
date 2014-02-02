package orgamanager.tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import orgamanager.model.OmModel;
import orgamanager.model.publications.Publication;
import orgamanager.model.publications.PublicationParent;
import orgamanager.model.publications.PublicationsList;
import orgamanager.utilities.OmConfig;
import orgamanager.utilities.OmUtilities;

/**
 * OmModelTest contains all test cases related to the model respectively the api.
 * 
 * Moreover test methods are used for test driven development of core functionality.
 * 
 * @author Jochen Bauer
 * 
 */
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
	public void doCreatePublicationsTest() throws InterruptedException, FileNotFoundException{ //fail("Not yet implemented!");
		
		// Development area, trigger model without gui ...
//		OmModel model = new OmModel();
//		model.doCreatePublications();
//		String act0 = "Test";
//		String exp0 = "Test";
//		assertEquals("doCreatePublicationsTest-0", exp0, act0);
		
		// Vorgehen Validierung Eintrag: Publikation von Website holen - Buschhaus, A. ; Franke, J.: Industrial Robots Accuracy Optimization in the Area of Structuring and Metallization of Three Dimensional Molded Interconnect Devices. In: Pedro Neto; Antonio Paulo Moreira (Hrsg.): Robotics in Smart Manufacturing (FAIM). Heidelberg : Springer, 2013
		// Publikation in citavi-db.txt suchen und Art ermitteln: inproceeding
		// Bei inproceeding passendes proceeding entdecken, suche nach isbn, booktitle, year: 
		// Bibtex-Inhalt hier als Test uebernehmen und durchlaufen lassen
		// Eintrag in testfile0.txt einpflegen und kreierte testfile.txt scannen
		// Inhalt der CSV-Datei in Gespeichert_als_CSV-Datei.csv kopieren
		// faps.de Dateiverwaltung aktualisieren
		// Skript buchen... anstossen;
		// DB-Inhalte via showTable-Skript-Aufruf betrachten;
		// Mitarbeiterprofilseite auf faps.de betrachten;
		
		// Datentypen
		// article - Zeitschriftenaufsatz, nichts gehoert dazu;
		// book - Buch (Monographie); Zusatzinfo geht verloren ist vom Sammelwerk nicht unterscheidbar;
		// book - Buch (Sammelwerk); Beispiel 17. Workshop Mikrotechnische Produktion Feldmann
		// incollection - Beitrag in ..., book gehoert dazu, vgl. inproceedings und proceedings; 
		// inproceedings - Beitrag in ..., proceedings gehoeren dazu;
		// misc - etwa Vortraege; oft ungelistet!
		// Fazit: articles, books, incollection und inproceedings werden gelistet; 
		
		// Zhuo, Y. ; Alvarez, C. ; Feldmann, K.: 3D Gridless Routing for the Design of Molded Interconnect Devices (MID). In: Production Engineering - Annals of the German Academic Society for Production Engineering (WGP) 12 (2005), Nr. 2, S. 89–94
		
		String publicationString1 = "";
		publicationString1 += "@inproceedings{Bauer.2014,\n";
		publicationString1 += " abstract = {Mit dem Konzept des Ambient Assisted Living (AAL) sollen technische Hilfestellungen entwickelt werden, um den l{\\\"a}ngeren Verbleib {\\\"a}lterer Menschen im gewohnten Umfeld zu erm{\\\"o}glichen. Meist werden solche technischen Hilfestellungen jedoch stark technologiegetrieben entwickelt und entsprechen nicht dem tats{\\\"a}chlichen Bed{\\\"u}rfnis der Endanwender. Das im Projekt verwendete Vorgehen der menschzentrierten Gestaltung stellt hingegen den Benutzer in den Mittelpunkt: Auf diese Weise sollen Fehlentwicklungen von Anfang an vermieden werden und ein gebrauchstaugliches System entstehen. Durch Usability-Tests werden zielgruppenspezifische Probleme im Umgang mit AAL-Serviceplattformen erkannt und m{\\\"o}gliche L{\\\"o}sungsvorschl{\\\"a}ge durchdacht.},\n";
		publicationString1 += " author = {Bauer, Jochen and Kettschau, Anna and Franke, J{\\\"o}rg},\n";
		publicationString1 += " title = {Optimierung der Datenvisualisierung von AAL-Serviceplattformen durch Usability-Tests},\n";
		publicationString1 += " keywords = {E|Home;AAL;Smart Home;Mensch-Maschine-Interaktion},\n";
		publicationString1 += " publisher = {VDE Verlag Gmbh},\n";
		publicationString1 += " isbn = {978-3-8007-3574-7},\n";
		publicationString1 += " editor = {VDE and BMBF and {Sozialverband VdK} and Fraunhofer-AAL},\n";
		publicationString1 += " booktitle = {Wohnen - Pflege - Teilhabe {\\dq}Besser leben durch Technik{\\dq}},\n";
		publicationString1 += " year = {2014},\n";
		publicationString1 += " address = {Berlin}\n";
		publicationString1 += "}\n";
		Publication publication1 = new Publication(publicationString1);
		String exp1 = "Bauer, J.; Kettschau, A.; Franke, J.: Optimierung der Datenvisualisierung von AAL-Serviceplattformen durch Usability-Tests. In: VDE; BMBF; Sozialverband VdK; Fraunhofer-AAL (Hrsg.): Wohnen - Pflege - Teilhabe \"Besser leben durch Technik\". Berlin: VDE Verlag Gmbh, 2014";
		String act1 = publication1.getReference();
		assertEquals("doCreatePublicationsTest-1", exp1, act1);	 
		
		String proceedingString2 = "";
		proceedingString2 += "@proceedings{VDE.2013,\n";
		proceedingString2 += " abstract = {Neue Assistenzsysteme und Dienstleistungen werden f{\\\"u}r vielf{\\\"a}ltige Zielgruppen und Lebensumst{\\\"a}nde entwickelt, f{\\\"u}r die sie Unterst{\\\"u}tzung bieten k{\\\"o}nnen. Die L{\\\"o}sungsans{\\\"a}tze spiegeln das wider - und finden zunehmend ihren Weg in die praktische Erprobung und in den Alltag. Dieser Mannigfaltigkeit stellt sich der 6. Deutsche AAL-Kongress, wenn er seinen Fokus f{\\\"u}r 2013 auf Lebensqualit{\\\"a}t im Wandel von Demografie und Technik richtet. Mit der gro{\\ss}en Bandbreite der Themen sollen viele Lebensbereiche einbezogen werden, in denen AAL-Systeme neue und zus{\\\"a}tzliche Lebensqualit{\\\"a}t bieten k{\\\"o}nnen. Hierzu werden wieder praktische Anwendungsbeispiele, Konzeptstudien von morgen und technische L{\\\"o}sungen von heute diskutiert. Neben Plenarbeitr{\\\"a}gen und Vortr{\\\"a}gen werden erstmals auch Workshops angeboten. Der Deutsche AAL-Kongress wird zum sechsten Mal ausgerichtet. Er avancierte in den vergangenen f{\\\"u}nf Jahren zum Leitkongress im Innovationsfeld AAL.},\n";
		proceedingString2 += " year = {2013},\n";
		proceedingString2 += " title = {Lebensqualit{\\\"a}t im Wandel von Demografie und Technik: 6. deutscher AAL-Kongress mit Ausstellung, 22-23. Januar 2013, Berlin, Tagungsbeitr{\\\"a}ge},\n";
		proceedingString2 += " address = {Berlin},\n";
		proceedingString2 += " number = {1},\n";
		proceedingString2 += " publisher = {VDE~Verlag GmbH},\n";
		proceedingString2 += " isbn = {978-3-8007-3484-9},\n";
		proceedingString2 += " editor = {VDE and BMBF and {Sozialverband VdK} and Fraunhofer-AAL}\n";
		proceedingString2 += "}\n";
		PublicationParent publicationParent2 = new PublicationParent(proceedingString2);
		ArrayList<PublicationParent> parents2 = new ArrayList<PublicationParent>();
		parents2.add(publicationParent2);
		String publicationString2 = "";
		publicationString2 += "@inproceedings{Franke.2013b,\n";
		publicationString2 += " abstract = {Deutschland wird {\\\"a}lter. Deutschland wird vielf{\\\"a}ltiger. Deutschland wird moderner. Deutschland muss aber auch Energie und Strom sparen. Vor diesem Hintergrund wurde im Mai 2012 das bayerische Technologiezentrum f{\\\"u}r privates Wohnen gegr{\\\"u}ndet. Die gr{\\\"o}{\\ss}ten Erfolgschancen versprechen ganzheitlich ausgerichtete Forschungsans{\\\"a}tze im Bereich Smart Living, da nur so Innovationen akzeptiert und die Lebensqualit{\\\"a}t der Bewohner nachhaltig gesteigert werden. Ein interdisziplin{\\\"a}res Forscherteam, bestehend aus Ingenieuren, Informatikern und Sozialwissenschaftlern erarbeitet ein ganzheitliches Konzept, welches die Bed{\\\"u}rfnisse der Bewohner in den Mittelpunkt stellt. Zusammen mit Partnern aus Forschung und Wirtschaft sollen marktf{\\\"a}hige L{\\\"o}sungen entwickelt werden. So soll sichergestellt werden, dass die entwickelten L{\\\"o}sungen tats{\\\"a}chlich Anwendung finden und sich Smart Homes am Markt etablieren k{\\\"o}nnen.},\n";
		publicationString2 += " author = {Franke, J{\\\"o}rg and Zerth, J{\\\"u}rgen and Kleineidam, Gerhard and Kettschau, Anna},\n";
		publicationString2 += " title = {Mehr Lebensqualit{\\\"a}t durch Smart Homes? Die Notwendigkeit ganzheitlicher Forschung im Bereich Smart Living},\n";
		publicationString2 += " keywords = {AAL;Smart Home},\n";
		publicationString2 += " pages = {304--307},\n";
		publicationString2 += " publisher = {VDE~Verlag GmbH},\n";
		publicationString2 += " isbn = {978-3-8007-3484-9},\n";
		publicationString2 += " editor = {VDE and BMBF and {Sozialverband VdK} and Fraunhofer-AAL},\n";
		publicationString2 += " booktitle = {Lebensqualit{\\\"a}t im Wandel von Demografie und Technik},\n";
		publicationString2 += " year = {2013},\n";
		publicationString2 += " address = {Berlin}\n";
		publicationString2 += "}\n";
		Publication publication2 = new Publication(publicationString2, parents2);
		String exp2 = "Franke, J.; Zerth, J.; Kleineidam, G.; Kettschau, A.: Mehr Lebensqualität durch Smart Homes? Die Notwendigkeit ganzheitlicher Forschung im Bereich Smart Living. In: VDE; BMBF; Sozialverband VdK; Fraunhofer-AAL (Hrsg.): Lebensqualität im Wandel von Demografie und Technik: 6. deutscher AAL-Kongress mit Ausstellung, 22-23. Januar 2013, Berlin, Tagungsbeiträge. Berlin: VDE-Verlag GmbH, 2013, S. 304--307";
		String act2 = publication2.getReference();
		assertEquals("doCreatePublicationsTest-2", exp2, act2);		 
		
		String proceedingString3 = "";
		proceedingString3 += "@proceedings{PedroNeto.2013,\n";
		proceedingString3 += " year = {2013},\n";
		proceedingString3 += " title = {Robotics in Smart Manufacturing (FAIM)},\n";
		proceedingString3 += " address = {Heidelberg},\n";
		proceedingString3 += " publisher = {Springer},\n";
		proceedingString3 += " editor = {{Pedro Neto} and Moreira, Antonio Paulo}\n";
		proceedingString3 += "}\n";
		PublicationParent proceeding3 = new PublicationParent(proceedingString3);
		ArrayList<PublicationParent> parents3 = new ArrayList<PublicationParent>();
		parents3.add(proceeding3);
		String publicationString3 = "";
		publicationString3 += "@inproceedings{Buschhaus.2013,\n";
		publicationString3 += " abstract = {Based on their beneficial features, there is a growing importance of three dimensional molded interconnect\n";
		publicationString3 += "devices. An important process in course of their manufacturing is the metallization for generating the conducting\n";
		publicationString3 += "pattern layout. Therefore, flexible handling devices like industrial robots have to be provided, moving the substrate\n";
		publicationString3 += "with a high accuracy relative to a process nozzle. Due to complex three dimensional conducting patterns an offline\n";
		publicationString3 += "programming of the robots trajectory is needed. Given to the real robot, this leads to a geometric precision of the\n";
		publicationString3 += "movement not meeting the high product demands. To overcome this problem, the usage of modern optical sensor\n";
		publicationString3 += "systems for online process monitoring and subsequent real-time robot control is investigated. By continuously\n";
		publicationString3 += "supervising the conducting pattern generation the actual robots position is derived. Subsequently, compared to the\n";
		publicationString3 += "robots target position, geometric correction values are determined and given to the robot control position\n";
		publicationString3 += "deviations can be compensated. For this way of proceeding a highly efficient methodology for image data\n";
		publicationString3 += "processing and correction value determination has to be developed. First experiments already show good results\n";
		publicationString3 += "with very high geometric accuracies and a very promising data-processing performance.},\n";
		publicationString3 += " author = {Buschhaus, Arnd and Franke, J{\"o}rg},\n";
		publicationString3 += " title = {Industrial Robots Accuracy Optimization in the Area of Structuring and Metallization of Three Dimensional Molded Interconnect Devices},\n";
		publicationString3 += " keywords = {robotics;sensor systems;3D-MID;closed-loop-control},\n";
		publicationString3 += " publisher = {Springer},\n";
		publicationString3 += " editor = {{Pedro Neto} and Moreira, Antonio Paulo},\n";
		publicationString3 += " booktitle = {Robotics in Smart Manufacturing (FAIM)},\n";
		publicationString3 += " year = {2013},\n";
		publicationString3 += " address = {Heidelberg}\n";
		publicationString3 += "}\n";
		Publication publication3 = new Publication(publicationString3, parents3);
		String exp3 = "Buschhaus, A.; Franke, J.: Industrial Robots Accuracy Optimization in the Area of Structuring and Metallization of Three Dimensional Molded Interconnect Devices. In: Pedro Neto; Antonio Paulo Moreira (Hrsg.): Robotics in Smart Manufacturing (FAIM). Heidelberg: Springer, 2013";
		String act3 = publication3.getReference();
		assertEquals("doCreatePublicationsTest-3", exp3, act3);
		
		// TODO Artikel weicht von Zitationspattern ab!
//		String articleString4 = "";
//		articleString4 += "@article{Albrecht.2012,\n";
//		articleString4 += " author = {Albrecht, Thomas and Risch, Florian and Franke, J{\"o}rg and Tremel, Jan},\n";
//		articleString4 += " year = {2012},\n";
//		articleString4 += " title = {Recyclinggerechte Montagetechnik f{\"u}r permanent erregte Synchronmotoren},\n";
//		articleString4 += " pages = {146--151},\n";
//		articleString4 += " volume = {5},\n";
//		articleString4 += " number = {03},\n";
//		articleString4 += " journal = {ATZ produktion}\n";
//		articleString4 += "}\n";
//		Publication publication4 = new Publication(articleString4);
//		String act4 = publication4.getReference();
//		String exp4 = "Albrecht, T.; Risch, F.; Franke, J.; Tremel, J.: Recyclinggerechte Montagetechnik für permanent erregte Synchronmotoren. In: ATZ produktion 03 (2012)";
//		assertEquals("doCreatePublicationsTest-4", exp4, act4);
		
		String articleString4 = "";
		articleString4 += "@article{Risch.2011,\n";
		articleString4 += " author = {Risch, Florian and Bernt, R{\\\"u}diger and Franke, J{\\\"o}rg},\n";
		articleString4 += " year = {2011},\n";
		articleString4 += " title = {Schlanke Informationsfl{\\\"u}sse f{\\\"u}r eine effiziente Produktion},\n";
		articleString4 += " pages = {706--710},\n";
		articleString4 += " volume = {106},\n";
		articleString4 += " number = {10},\n";
		articleString4 += " issn = {0947-0085},\n";
		articleString4 += " journal = {Zeitschrift f{\\\"u}r wirtschaftlichen Fabrikbetrieb}\n";
		articleString4 += "}\n";
		Publication publication4 = new Publication(articleString4);
		String act4 = publication4.getReference();
		String exp4 = "Risch, F.; Bernt, R.; Franke, J.: Schlanke Informationsflüsse für eine effiziente Produktion. In: Zeitschrift für wirtschaftlichen Fabrikbetrieb 106 (2011), Nr. 10, S. 706--710";
		assertEquals("doCreatePublicationsTest-4", exp4, act4);

	}
	
}
