package orgamanager.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import orgamanager.model.publications.Publication;
import orgamanager.model.publications.PublicationParent;

public class PublicationTest {

	@Before
	public void setUp() throws Exception{
	}

	@After
	public void tearDown() throws Exception{
	}
	
	@Test
	public void createEditorTest(){
		String str = "Sen Gupta, Gourab and Bailey, Donald and Demidenko, Serge and Carnegie, Dale";
		Publication publication1 = new Publication();
		String exp = "Gourab Sen Gupta; Donald Bailey; Serge Demidenko; Dale Carnegie";
		String act = publication1.createEditor(str);
		assertEquals("createEditorTest()", exp, act);
		
		String str2 = "VDE and BMBF and {Sozialverband VdK} and Fraunhofer-AAL";
		Publication publication2 = new Publication();
		String exp2 = "VDE; BMBF; Sozialverband VdK; Fraunhofer-AAL";
		String act2 = publication2.createEditor(str2);
		assertEquals("createEditorTest()-2", exp2, act2);
	}
	
//	@Test
//	public void connectToParentTest(){
//		String inproceeding = "";
//		inproceeding += "@inproceedings{Bauer.2014,\n";
//		inproceeding += " abstract = {Mit dem Konzept des Ambient Assisted Living (AAL) sollen technische Hilfestellungen entwickelt werden, um den l{\"a}ngeren Verbleib {\"a}lterer Menschen im gewohnten Umfeld zu erm{\"o}glichen. Meist werden solche technischen Hilfestellungen jedoch stark technologiegetrieben entwickelt und entsprechen nicht dem tats{\"a}chlichen Bed{\"u}rfnis der Endanwender. Das im Projekt verwendete Vorgehen der menschzentrierten Gestaltung stellt hingegen den Benutzer in den Mittelpunkt: Auf diese Weise sollen Fehlentwicklungen von Anfang an vermieden werden und ein gebrauchstaugliches System entstehen. Durch Usability-Tests werden zielgruppenspezifische Probleme im Umgang mit AAL-Serviceplattformen erkannt und m{\"o}gliche L{\"o}sungsvorschl{\"a}ge durchdacht.},\n";
//		inproceeding += " author = {Bauer, Jochen and Kettschau, Anna and Franke, J{\"o}rg},\n";
//		inproceeding += " title = {Optimierung der Datenvisualisierung von AAL-Serviceplattformen durch Usability-Tests},\n";
//		inproceeding += " keywords = {E|Home;AAL;Smart Home;Mensch-Maschine-Interaktion},\n";
//		inproceeding += " publisher = {VDE Verlag Gmbh},\n";
//		inproceeding += " isbn = {978-3-8007-3574-7},\n";
//		inproceeding += " editor = {VDE and BMBF and {Sozialverband VdK} and Fraunhofer-AAL},\n";
//		inproceeding += " booktitle = {Wohnen - Pflege - Teilhabe {\\dq}Besser leben durch Technik{\\dq}},\n";
//		inproceeding += " year = {2014},\n";
//		inproceeding += " address = {Berlin}\n";
//		inproceeding += "}\n";
//		String proceedingA = "";
//		proceedingA += "@proceedings{VDE.2014,\n";
//		proceedingA += " year = {2014},\n";
//		proceedingA += " title = {Wohnen - Pflege - Teilhabe {\\dq}Besser leben durch Technik{\\dq}: 7. Deutscher AAL-Kongress mit Ausstellung, 21-22. Januar 2014, Berlin, Tagungsbeitr{\"a}ge},\n";
//		proceedingA += " address = {Berlin},\n";
//		proceedingA += " number = {1},\n";
//		proceedingA += " publisher = {VDE Verlag Gmbh},\n";
//		proceedingA += " isbn = {978-3-8007-3574-7},\n";
//		proceedingA += " editor = {VDE and BMBF and {Sozialverband VdK} and Fraunhofer-AAL}\n";
//		proceedingA += "}\n";
//		ArrayList<PublicationParent> possibleParents = new ArrayList<PublicationParent>();
//		PublicationParent possibleParentA = new PublicationParent(proceedingA);
//		possibleParents.add(possibleParentA);
//		Publication publication = new Publication(inproceeding, possibleParents);
//		String exp = "Bauer, J.; Kettschau, A.; Franke, J.: Optimierung der Datenvisualisierung von AAL-Serviceplattformen durch Usability-Tests. In: VDE; BMBF; Sozialverband VdK; Fraunhofer-AAL (Hrsg.): Wohnen - Pflege - Teilhabe Besser leben durch Technik: 7. Deutscher AAL-Kongress mit Ausstellung, 21-22. Januar 2014, Berlin, Tagungsbeiträge. Berlin: VDE Verlag Gmbh, 2014";
//		String act = publication.getReference();
//		assertEquals("createEditorTest()", exp, act);
//	}
}

