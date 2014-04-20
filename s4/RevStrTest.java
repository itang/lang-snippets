import static org.junit.Assert.*;

import org.junit.Test;

public class RevStrTest {

	private RevStr rever = new RevStr();

	class TestData {
		public final String input;
		public final String expected;

		public TestData(String expected, String input) {
			this.expected = expected;
			this.input = input;
		}
	}

	TestData[] testDatas = { new TestData("ef  cd ab", "ab cd  ef"),
			new TestData(null, null), new TestData("", ""),
			new TestData(" ", " "), new TestData("itang", "itang"),
			new TestData("  itang", "itang  "),
			new TestData("itang  world hello", "hello world  itang"), };

	@Test
	public void test() {
		for (TestData d : testDatas) {
			assertEquals(d.expected, rever.rev1(d.input));
			assertEquals(d.expected, rever.rev2(d.input));
		}
	}
}
