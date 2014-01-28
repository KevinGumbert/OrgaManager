package orgamanager.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.xml.internal.bind.v2.model.impl.ModelBuilder;

import orgamanager.model.OmModel;

public class OmModelTest {

	@Before
	public void setUp() throws Exception{
	}

	@After
	public void tearDown() throws Exception{
	}

	@Test
	public void doLoginTest(){
		String username = "joba";
		String password = "geheim";
		OmModel model = new OmModel();
		boolean exp = true;
		boolean act = model.doLogin(username, password);
		assertEquals(exp, act);
		
		String username2 = "joba";
		String password2 = "falsch";
		OmModel model2 = new OmModel();
		boolean exp2 = false;
		boolean act2 = model2.doLogin(username2, password2);
		assertEquals(exp2, act2);
	}
	
//	@Test
//	public void test(){
//		fail("Not yet implemented");
//	}

}
