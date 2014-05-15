package orgamanager.tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import orgamanager.config.OmConfig;
import orgamanager.model.OmModel;
import orgamanager.model.publications.Publication;
import orgamanager.model.publications.PublicationParent;
import orgamanager.model.publications.PublicationsList;
import orgamanager.utilities.OmUtilities;
import orgamanager.view.OmSignaturePanel;
import orgamanager.model.signatures.*;

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
		String username = config.getUsername();
		String password = config.getPassword();
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
		OmModel model = new OmModel();
		model.doCreatePublications();
		String act0 = "Test";
		String exp0 = "Test";
		assertEquals("doCreatePublicationsTest-0", exp0, act0);

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
		publicationString3 += " author = {Buschhaus, Arnd and Franke, J{\\\"o}rg},\n";
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
		
		String articleString4 = "";
		articleString4 += "@article{Albrecht.2012,\n";
		articleString4 += " author = {Albrecht, Thomas and Risch, Florian and Franke, J{\\\"o}rg and Tremel, Jan},\n";
		articleString4 += " year = {2012},\n";
		articleString4 += " title = {Recyclinggerechte Montagetechnik f{\\\"u}r permanent erregte Synchronmotoren},\n";
		articleString4 += " pages = {146--151},\n";
		articleString4 += " volume = {5},\n";
		articleString4 += " number = {03},\n";
		articleString4 += " journal = {ATZ produktion}\n";
		articleString4 += "}\n";
		Publication publication4 = new Publication(articleString4);
		String act4 = publication4.getReference();
		//String exp4 = "Albrecht, T.; Risch, F.; Franke, J.; Tremel, J.: Recyclinggerechte Montagetechnik für permanent erregte Synchronmotoren. In: ATZ produktion 03 (2012)";
		String exp4 = "Albrecht, T.; Risch, F.; Franke, J.; Tremel, J.: Recyclinggerechte Montagetechnik für permanent erregte Synchronmotoren. In: ATZ produktion 5 (2012), Nr. 03, S. 146--151";
		assertEquals("doCreatePublicationsTest-4", exp4, act4);
		
		String articleString5 = "";
		articleString5 += "@article{Risch.2011,\n";
		articleString5 += " author = {Risch, Florian and Bernt, R{\\\"u}diger and Franke, J{\\\"o}rg},\n";
		articleString5 += " year = {2011},\n";
		articleString5 += " title = {Schlanke Informationsfl{\\\"u}sse f{\\\"u}r eine effiziente Produktion},\n";
		articleString5 += " pages = {706--710},\n";
		articleString5 += " volume = {106},\n";
		articleString5 += " number = {10},\n";
		articleString5 += " issn = {0947-0085},\n";
		articleString5 += " journal = {Zeitschrift f{\\\"u}r wirtschaftlichen Fabrikbetrieb}\n";
		articleString5 += "}\n";
		Publication publication5 = new Publication(articleString5);
		String act5 = publication5.getReference();
		String exp5 = "Risch, F.; Bernt, R.; Franke, J.: Schlanke Informationsflüsse für eine effiziente Produktion. In: Zeitschrift für wirtschaftlichen Fabrikbetrieb 106 (2011), Nr. 10, S. 706--710";
		assertEquals("doCreatePublicationsTest-5", exp5, act5);

		String bookString6 = "";
		bookString6 += "@book{Shen.2006,\n";
		bookString6 += " year = {2006},\n";
		bookString6 += " title = {Computer Supported Cooperative Work in Design},\n";
		bookString6 += " address = {Berlin and Heidelberg},\n";
		bookString6 += " volume = {2},\n";
		bookString6 += " publisher = {Springer Verlag},\n";
		bookString6 += " editor = {Shen, W. and Chao, K.-M and Lin, Z. and Barthes, Jean-Paul and James, A.}\n";
		bookString6 += "}\n";
		String publicationString6 = "";
		publicationString6 += "@incollection{Ruckel.2006,\n";
		publicationString6 += " author = {R{\\\"u}ckel, Veit and Koch, Alexander and Feldmann, Klaus and Meerkamm, Harald},\n";
		publicationString6 += " title = {Process Data Management for the Shortening of the whole Product Creation Process},\n";
		publicationString6 += " pages = {616--625},\n";
		publicationString6 += " volume = {2},\n";
		publicationString6 += " publisher = {Springer Verlag},\n";
		publicationString6 += " editor = {Shen, W. and Chao, K.-M and Lin, Z. and Barthes, Jean-Paul and James, A.},\n";
		publicationString6 += " booktitle = {Computer Supported Cooperative Work in Design},\n";
		publicationString6 += " year = {2006},\n";
		publicationString6 += " address = {Berlin and Heidelberg}\n";
		publicationString6 += "}\n";
		PublicationParent book6 = new PublicationParent(bookString6);
		ArrayList<PublicationParent> parents6 = new ArrayList<PublicationParent>();
		parents6.add(book6);
		Publication publication6 = new Publication(publicationString6, parents6);
		String act6 = publication6.getReference();
		//String exp6 = "Rückel, V.; Koch, A.; Feldmann, K.; Meerkamm, H.: Process Data Management for the Shortening of the whole Product Creation Process. In: Shen, W.; Chao, K.-M.; Lin, Z.; Barthes, J.-P.; James, A. (Hrsg.): Computer Supported Cooperative Work in Design. Berlin; Heidelberg: Springer Verlag, 2006 (2), S. 616--625";
		String exp6 = "Rückel, V.; Koch, A.; Feldmann, K.; Meerkamm, H.: Process Data Management for the Shortening of the whole Product Creation Process. In: W. Shen; K.-M Chao; Z. Lin; Jean-Paul Barthes; A. James (Hrsg.): Computer Supported Cooperative Work in Design. Berlin; Heidelberg: Springer Verlag, 2006 (2), S. 616--625";
		assertEquals("doCreatePublicationsTest-6", exp6, act6);
		
		String publicationString7 = "";
		publicationString7 += "@book{Franke.2013f,\n";
		publicationString7 += " year = {2013},\n";
		publicationString7 += " title = {R{\\\"a}umliche elektronische Baugruppen (3D-MID): Werkstoffe, Herstellung, Montage und Anwendungen f{\\\"u}r spritzgegossene Schaltungstr{\\\"a}ger},\n";
		publicationString7 += " address = {M{\\\"u}nchen},\n";
		publicationString7 += " publisher = {Carl Hanser Verlag},\n";
		publicationString7 += " isbn = {978-3-446-43441-7},\n";
		publicationString7 += " editor = {Franke, J{\\\"o}rg}\n";
		publicationString7 += "}\n";
		Publication publication7 = new Publication(publicationString7);
		String act7 = publication7.getReference();
		//String exp7 = "Franke, J. (Hrsg.): Räumliche elektronische Baugruppen (3D-MID): Werkstoffe, Herstellung, Montage und Anwendungen für spritzgegossene Schaltungsträger. München: Carl Hanser Verlag GmbH, 2013";
		String exp7 = "Franke, J. (Hrsg.): Räumliche elektronische Baugruppen (3D-MID): Werkstoffe, Herstellung, Montage und Anwendungen für spritzgegossene Schaltungsträger. München: Carl Hanser Verlag, 2013";
		assertEquals("doCreatePublicationsTest-7", exp7, act7);
		
		String parentString8 = "";
		parentString8 += "@proceedings{VDIWissensforumGmbH.2013,\n";
		parentString8 += " year = {2013},\n";
		parentString8 += " title = {Kongress Automation: Automation (in the) cloud},\n";
		parentString8 += " editor = {{VDI Wissensforum GmbH}}\n";
		parentString8 += "}\n";
		String publicationString8 = "";
		publicationString8 += "@inproceedings{Ramer.2013,\n";
		publicationString8 += " author = {Ramer, Christina and Reitelsh{\\\"o}fer, Sebastian and Franke, J{\\\"o}rg},,\n";
		publicationString8 += " title = {Automatisierte Pfadgenerierung und Kollisions{\\\"u}berwachung f{\\\"u}r Sechsachs-Industrieroboter durch 3D-kameragest{\\\"u}tzte Umgebungserfassung},\n";
		publicationString8 += " editor = {{VDI Wissensforum GmbH}},\n";	
		publicationString8 += " booktitle = {Kongress Automation},\n";
		publicationString8 += " year = {2013},\n";
		publicationString8 += "}\n";
		PublicationParent parent8 = new PublicationParent(parentString8);
		ArrayList<PublicationParent> parents8 = new ArrayList<PublicationParent>();
		parents8.add(parent8);
		Publication publication8 = new Publication(publicationString8, parents8);
		String act8 = publication8.getReference();
		String exp8 = "Ramer, C.; Reitelshöfer, S.; Franke, J.: Automatisierte Pfadgenerierung und Kollisionsüberwachung für Sechsachs-Industrieroboter durch 3D-kameragestützte Umgebungserfassung. In: VDI Wissensforum GmbH (Hrsg.): Kongress Automation: Automation (in the) cloud. 2013";
		assertEquals("doCreatePublicationsTest-8", exp8, act8);
		
		String parentString9 = "";
		parentString9 = "@book{SenGupta.2013,";
		parentString9 += " year = {2013},\n";
		parentString9 += " title = {Recent Advances in Robotics and Automation},\n";
		parentString9 += " edition = {480},\n";
		parentString9 += " publisher = {Springer},\n";
		parentString9 += " isbn = {987-3-642-37386-2},\n";
		parentString9 += " series = {Studies in Computational Intelligence},\n";
		parentString9 += " editor = {Sen Gupta, Gourab and Bailey, Donald and Demidenko, Serge and Carnegie, Dale}\n";
		parentString9 += "}\n";
		PublicationParent parent9 = new PublicationParent(parentString9);
		ArrayList<PublicationParent> parents9 = new ArrayList<PublicationParent>();
		parents9.add(parent9);
		String publicationString9 = "";
		publicationString9 += "@incollection{Ziegler.2013,\n";
		publicationString9 += " abstract = {Patient handling robots are increasingly employed to enable a flexible positioning of the patient for diagnostic and therapeutic purposes. Due to the greatly differing robot loads because of varying patient weights especially serial kinematics are no longer able to keep up with the constantly increasing medical demands for positioning accuracy. In this chapter a low-cost measuring system for a permanent integration into the workspace of a patient handling robot is introduced which can measure the pose of a patient couch with high accuracy. This enables closed-loop control of the patient couch. In tests on a robot system an average positioning error of 0.12 mm was achieved for a diversity of medically relevant poses.},\n";
		publicationString9 += " author = {Ziegler, Christian and Franke, J{\\\"o}rg},\n";
		publicationString9 += " title = {Closed-loop control of patient handling robots},\n";
		publicationString9 += " pages = {231--241},\n";
		publicationString9 += " publisher = {Springer},\n";
		publicationString9 += " isbn = {987-3-642-37386-2},\n";
		publicationString9 += " series = {Studies in Computational Intelligence},\n";
		publicationString9 += " editor = {Sen Gupta, Gourab and Bailey, Donald and Demidenko, Serge and Carnegie, Dale},\n"; // PROBLEM Sen Gupta as two word editor
		publicationString9 += " booktitle = {Recent Advances in Robotics and Automation},\n";
		publicationString9 += " year = {2013}\n";
		publicationString9 += "}\n";
		Publication publication9 = new Publication(publicationString9, parents9);
		String act9 = publication9.getReference();
		String exp9 = "Ziegler, C.; Franke, J.: Closed-loop control of patient handling robots. In: Gourab Sen Gupta; Donald Bailey; Serge Demidenko; Dale Carnegie (Hrsg.): Recent Advances in Robotics and Automation. Springer, 2013, S. 231--241";
		assertEquals("doCreatePublicationsTest-9", exp9, act9);
		
		// Test Bauer 2014
		
		// TODO Problem Boenig
//		String parentString10 = "";
//		parentString10 = "@book{SenGupta.2013,";
//		parentString10 += " year = {2013},\n";
//		parentString10 += " title = {Recent Advances in Robotics and Automation},\n";
//		parentString10 += " edition = {480},\n";
//		parentString10 += " publisher = {Springer},\n";
//		parentString10 += " isbn = {987-3-642-37386-2},\n";
//		parentString10 += " series = {Studies in Computational Intelligence},\n";
//		parentString10 += " editor = {Sen Gupta, Gourab and Bailey, Donald and Demidenko, Serge and Carnegie, Dale}\n";
//		parentString10 += "}\n";
//		PublicationParent parent10 = new PublicationParent(parentString10);
//		ArrayList<PublicationParent> parents10 = new ArrayList<PublicationParent>();
//		parents10.add(parent10);
//		String publicationString10 = "";
//		publicationString10 += "@incollection{Ziegler.2013,\n";
//		publicationString10 += " abstract = {Patient handling robots are increasingly employed to enable a flexible positioning of the patient for diagnostic and therapeutic purposes. Due to the greatly differing robot loads because of varying patient weights especially serial kinematics are no longer able to keep up with the constantly increasing medical demands for positioning accuracy. In this chapter a low-cost measuring system for a permanent integration into the workspace of a patient handling robot is introduced which can measure the pose of a patient couch with high accuracy. This enables closed-loop control of the patient couch. In tests on a robot system an average positioning error of 0.12 mm was achieved for a diversity of medically relevant poses.},\n";
//		publicationString10 += " author = {Ziegler, Christian and Franke, J{\\\"o}rg},\n";
//		publicationString10 += " title = {Closed-loop control of patient handling robots},\n";
//		publicationString10 += " pages = {231--241},\n";
//		publicationString10 += " publisher = {Springer},\n";
//		publicationString10 += " isbn = {987-3-642-37386-2},\n";
//		publicationString10 += " series = {Studies in Computational Intelligence},\n";
//		publicationString10 += " editor = {Sen Gupta, Gourab and Bailey, Donald and Demidenko, Serge and Carnegie, Dale},\n"; // PROBLEM Sen Gupta as two word editor
//		publicationString10 += " booktitle = {Recent Advances in Robotics and Automation},\n";
//		publicationString10 += " year = {2013}\n";
//		publicationString10 += "}\n";
//		Publication publication10 = new Publication(publicationString10, parents10);
//		String act10 = publication10.getReference();
//		String exp10 = "Ziegler, C.; Franke, J.: Closed-loop control of patient handling robots. In: Gourab Sen Gupta; Donald Bailey; Serge Demidenko; Dale Carnegie (Hrsg.): Recent Advances in Robotics and Automation. Springer, 2013, S. 231--241";
//		assertEquals("doCreatePublicationsTest-10", exp10, act10);
	}

	@Test
	public void doCreateAssignmentTest(){
		// Development area, trigger model without gui ...
		OmModel model = new OmModel();
		model.doCreateAssignment();
		String act0 = "Test";
		String exp0 = "Test";
		assertEquals("doCreateAssignmentsTest-0", exp0, act0);
	}
	
	@Test
	public void doWebAttachmentTest(){
		// Development area, trigger model without gui ...
		OmModel model = new OmModel();
		model.doWebAttachment();
		String act0 = "Test";
		String exp0 = "Test";
		assertEquals("doWebAttachmentTest-0", exp0, act0);
	}
	
	@Test
	public void doEhcWebAppJsonApiAccessTest(){
		OmModel model = new OmModel();
		// Test 0: check connection
//		String act0 = model.doEhcWebAppJsonApiAccess(1).trim();
//		String exp0 = "{\"connection\":\"ok\"}"; // {"connection":"ok"}
//		assertEquals("doEhcWebAppJsonApiAccessTest-0", exp0, act0);
		
		// Test 1: trigger event through webapp, ehcserver.local/ehomejson/togglelightone/1
//		String act1 = model.doEhcWebAppJsonApiAccess(2).trim();
//		String exp1 = "{\"connection\":\"ok\"}";
//		assertEquals("doEhcWebAppJsonApiAccessTest-1", exp1, act1);
		
		// TODO: create test suite for fhem 
		// Test 1: trigger event through fhem, $uri = 'http://' . $ip . ':8083/fhem?cmd.steckdose=set steckdose on&room=Buero'; 
		String act1 = model.doEhcWebAppJsonApiAccess(3).trim();
		String exp1 = "Test";
		assertEquals("doEhcWebAppJsonApiAccessTest-2", exp1, act1);
	}
	
	@Test
	public void doOrgaManagerDeploymentTest(){
		OmModel model = new OmModel();
		boolean act1 = model.doOrgaManagerDeployment();
		boolean exp1 = true;
		assertEquals("doOrgaManagerDeploymentTest-0", exp1, act1);
	}
	
	@Test
	public void doRbPiInstallTest(){
		OmModel model = new OmModel();
		boolean act1 = model.doRbPiInstall();
		boolean exp1 = true;
		assertEquals("doRbPiInstallTest-0", exp1, act1);
	}
	
	@Test
	public void doOxidInstallTest(){
		OmModel model = new OmModel();
		boolean act1 = model.doOxidInstall();
		boolean exp1 = true;
		assertEquals("doOxidInstallTest-0", exp1, act1);
	}
	
	@Test
	public void doSignaturesTest(){
		OmModel model = new OmModel();
		boolean act1 = model.doSignatures();
		boolean exp1 = true;
		assertEquals("doSignaturesTest-0", exp1, act1);
	}
//	@Test
//	public void doSignatureListTest(){
//	    String pathToFile= "D:\\Dropbox\\E-Home\\Arbeitspackete\\Signatures\\SignaturenSergej\\Outlook-Signatur\\Administratives\\Vorlagen";
//		SignatureList signatureList = new SignatureList(pathToFile);
//		String act1 = signatureList.parseXmlFile(pathToFile + "\\univis-mitarbeiter-02052014.xml");
//		
//		String exp1 = "Mitarbeiter";
//		assertEquals("doSignatureListTest", exp1, act1);
//	}
}
