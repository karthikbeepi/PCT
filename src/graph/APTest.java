package graph;

import static org.junit.Assert.*;

import org.junit.Test;

public class APTest {

	@Test
	public void test() {
		
		AP ob = new AP(4);
		ob.addEdge(0, 1 , 1);
		ob.addEdge(0, 3, 1);
		ob.addEdge(1, 3, 1);
		ob.addEdge(1, 2, 1);
		assertEquals(1, ob.findMinNoEdge(0)[3]);
		assertEquals(1, ob.findMinNoEdge(0)[1]);
		assertEquals(0, ob.findMinNoEdge(0)[0]);
		assertEquals(2, ob.findMinNoEdge(0)[2]);
	}
	@Test
	public void test2() {
		
		AP ob = new AP(4);
		ob.addEdge(0, 1 ,1);
		ob.addEdge(0, 3, 1);
		ob.addEdge(1, 3, 1);
		ob.addEdge(1, 2, 1);
		assertEquals(1, ob.ap().size());
		
	}
	@Test
	public void test1() {
		
		AP ob = new AP(9);
		ob.addEdge(0, 1 , 1);
		ob.addEdge(0, 3, 1);
		ob.addEdge(0, 2, 1);
		ob.addEdge(2, 6, 1);
		ob.addEdge(3,4 , 1);
		ob.addEdge(6, 8, 1);
		ob.addEdge(4, 5, 1);
		ob.addEdge(4, 7, 1);
		ob.addEdge(6, 8, 1);
		ob.addEdge(6, 7, 1);
		ob.addEdge(2, 3, 1);
		ob.addEdge(0, 8, 1);
		assertEquals(1, ob.findMinNoEdge(0)[3]);
		assertEquals(1, ob.findMinNoEdge(0)[1]);
		assertEquals(0, ob.findMinNoEdge(0)[0]);
		assertEquals(1, ob.findMinNoEdge(0)[2]);
		assertEquals(2, ob.findMinNoEdge(0)[4]);
		assertEquals(2, ob.findMinNoEdge(0)[6]);
		assertEquals(3, ob.findMinNoEdge(0)[7]);
		assertEquals(1, ob.findMinNoEdge(0)[8]);
	}

	@Test
	public void test11() {
		
		AP ob = new AP(9);
		ob.addEdge(0, 1 , 1);
		ob.addEdge(0, 3, 1);
		ob.addEdge(0, 2, 1);
		ob.addEdge(2, 6, 1);
		ob.addEdge(3,4 , 1);
		ob.addEdge(6, 8, 1);
		ob.addEdge(4, 5, 1);
		ob.addEdge(4, 7, 1);
		ob.addEdge(6, 7, 1);
		ob.addEdge(2, 3, 1);
		assertEquals(1, ob.ap().size());
	}
}
