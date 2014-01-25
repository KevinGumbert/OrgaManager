package orgamanager.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import orgamanager.model.OmModel;
import orgamanager.utilities.OmConfig;

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
	

}
