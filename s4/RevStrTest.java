import static org.junit.Assert.*;

import org.junit.Test;

public class RevStrTest {

	private RevStr rever = new RevStr();

	@Test
	public void test() {
		assertEquals(null, rever.rev(null));
		assertEquals("", rever.rev(""));
		assertEquals(" ", rever.rev(" "));
		assertEquals("itang", rever.rev("itang"));
		assertEquals("  itang", rever.rev("itang  "));
		assertEquals("itang  world Hello", rever.rev("Hello world  itang"));
	}
}
