package PCTCodingNew;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSortedString {

	@Test
	public void testSortedSub() {
		SortSub ob = new SortSub();
		assertEquals("spoonfeed", ob.sortedSub("ooneefspd", 0, 8));
		assertEquals("hlleo", ob.sortedSub("hlleo", 1, 3));
		assertEquals("erofft", ob.sortedSub("effort", 1, 4));
	}

}
