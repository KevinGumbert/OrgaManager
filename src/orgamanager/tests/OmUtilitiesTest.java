package orgamanager.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import orgamanager.model.publications.Publication;
import orgamanager.utilities.OmUtilities;

public class OmUtilitiesTest {

	@Before
	public void setUp() throws Exception{
	}

	@After
	public void tearDown() throws Exception{
	}
	
	@Test
	public void cutStringAfterFirstOccuranceOfDelimiterTest(){
		String str = "title = {Optimierung der Datenvisualisierung von AAL-Serviceplattformen durch Usability-Tests},";
		String exp = "Optimierung der Datenvisualisierung von AAL-Serviceplattformen durch Usability-Tests},";
		OmUtilities utils = new OmUtilities();
		String act = utils.cutStringAfterFirstOccuranceOfDelimiter(str, '{');
		assertEquals("cutStringAfterFirstOccuranceOfDelimiterTest()", exp, act);
	}
	
	@Test
	public void cutStringAfterLastOccuranceOfDelimiterTest(){
		String str = "Optimierung der Datenvisualisierung von AAL-Serviceplattformen durch Usability-Tests},";
		String exp = "Optimierung der Datenvisualisierung von AAL-Serviceplattformen durch Usability-Tests";
		OmUtilities utils = new OmUtilities();
		String act = utils.cutStringAfterLastOccuranceOfDelimiter(str, '}');
		assertEquals("cutStringAfterLastOccuranceOfDelimiterTest()", exp, act);
	}
	
	@Test
	public void pickChildStringTest(){
		String str = "title = {Optimierung der Datenvisualisierung von AAL-Serviceplattformen durch Usability-Tests},";
		String exp = "Optimierung der Datenvisualisierung von AAL-Serviceplattformen durch Usability-Tests";
		OmUtilities utils = new OmUtilities();
		String act = utils.pickChildString(str, '{', '}');
		assertEquals("pickChildStringTest()", exp, act);
	}
	
	@Test
	public void replaceBibtexCharsTest(){
		String str = "{Tremel, Jan and Hofmann, Benjamin and Meyer, Alexander and Franke, J{\\\"o}rg and Eschrich, Sebastian}";
		String exp = "{Tremel, Jan and Hofmann, Benjamin and Meyer, Alexander and Franke, Jörg and Eschrich, Sebastian}";
		OmUtilities utils = new OmUtilities();
		String act = utils.replaceBibtexChars(str);
		assertEquals("replaceBibtexMutatedVowelsTest() - 0", exp, act);
		
		String str1 = "{N{\\\"u}rnberg}";
		String exp1 = "{Nürnberg}";
		OmUtilities utils1 = new OmUtilities();
		String act1 = utils1.replaceBibtexChars(str1);
		assertEquals("replaceBibtexMutatedVowelsTest()- 1", exp1, act1);
		
		String str2 = "Friedrich-Alexander-Universit{\\\"a}t Erlangen-N{\\\"u}rnberg";
		String exp2 = "Friedrich-Alexander-Universität Erlangen-Nürnberg";
		OmUtilities utils2 = new OmUtilities();
		String act2 = utils2.replaceBibtexChars(str2);
		assertEquals("replaceBibtexMutatedVowelsTest()- 2", exp2, act2);
		
		String str3 = "{Wohnen - Pflege - Teilhabe {\\dq}Besser leben durch Technik{\\dq}: 7. Deutscher AAL-Kongress mit Ausstellung, 21-22. Januar 2014, Berlin, Tagungsbeitr{\\\"a}ge}";
		String exp3 = "{Wohnen - Pflege - Teilhabe \"Besser leben durch Technik\": 7. Deutscher AAL-Kongress mit Ausstellung, 21-22. Januar 2014, Berlin, Tagungsbeiträge}";
		OmUtilities utils3 = new OmUtilities();
		String act3 = utils3.replaceBibtexChars(str3);
		assertEquals("replaceBibtexMutatedVowelsTest()- 3", exp3, act3);
		// TODO uppercasevowels
		
//		String inproceedingsCitation1 = "";
//		inproceedingsCitation1 += "@inproceedings{Bauer.2014,\n";
//		inproceedingsCitation1 += " abstract = {Mit dem Konzept des Ambient Assisted Living (AAL) sollen technische Hilfestellungen entwickelt werden, um den l{\\\"a}ngeren Verbleib {\\\"a}lterer Menschen im gewohnten Umfeld zu erm{\\\"o}glichen. Meist werden solche technischen Hilfestellungen jedoch stark technologiegetrieben entwickelt und entsprechen nicht dem tats{\\\"a}chlichen Bed{\\\"u}rfnis der Endanwender. Das im Projekt verwendete Vorgehen der menschzentrierten Gestaltung stellt hingegen den Benutzer in den Mittelpunkt: Auf diese Weise sollen Fehlentwicklungen von Anfang an vermieden werden und ein gebrauchstaugliches System entstehen. Durch Usability-Tests werden zielgruppenspezifische Probleme im Umgang mit AAL-Serviceplattformen erkannt und m{\\\"o}gliche L{\\\"o}sungsvorschl{\\\"a}ge durchdacht.},\n";
//		inproceedingsCitation1 += " author = {Bauer, Jochen and Kettschau, Anna and Franke, J{\\\"o}rg},\n";
//		inproceedingsCitation1 += " title = {Optimierung der Datenvisualisierung von AAL-Serviceplattformen durch Usability-Tests},\n";
//		inproceedingsCitation1 += " keywords = {E|Home;AAL;Smart Home;Mensch-Maschine-Interaktion},\n";
//		inproceedingsCitation1 += " publisher = {VDE Verlag Gmbh},\n";
//		inproceedingsCitation1 += " isbn = {978-3-8007-3574-7},\n";
//		inproceedingsCitation1 += " editor = {VDE and BMBF and {Sozialverband VdK} and Fraunhofer-AAL},\n";
//		inproceedingsCitation1 += " booktitle = {Wohnen - Pflege - Teilhabe {\\dq}Besser leben durch Technik{\\dq}},\n";
//		inproceedingsCitation1 += " year = {2014},\n";
//		inproceedingsCitation1 += " address = {Berlin}\n";
//		inproceedingsCitation1 += "}\n";
//		Citation citation1 = new Citation(inproceedingsCitation1);
//		String exp1 = "Bauer J.; Kettschau A.; Franke J.: Optimierung der Datenvisualisierung von AAL-Serviceplattformen durch Usability-Tests. In: VDE; BMBF; Sozialverband VdK; Fraunhofer-AAL: Wohnen - Pflege - Teilhabe {\\dq}Besser leben durch Technik{\\dq}. Berlin: VDE Verlag Gmbh, 2014";
//		String act1 = citation1.getReference();
//		assertEquals("doCreatePublicationsTest-1", exp1, act1);	
	}
}
