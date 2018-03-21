package pomIMDB.test;

import org.junit.After;
import org.junit.Before;

public class IMDBBase {
	@Before
	public void setUp() throws Exception {
		System.out.println("Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After");
	}
}
