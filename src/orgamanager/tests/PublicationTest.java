package orgamanager.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import orgamanager.model.publications.Publication;

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
}

