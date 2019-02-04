package assignment1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class testTsp {

	@Test
	public void test1() {
		//Test case given in the example 2
		TSP ob = new TSP();
		ob.g = new Graph(4);
		ob.g.addEdge(0, 1, 2);
		ob.g.addEdge(0, 2, 1);
		ob.g.addEdge(0, 3, 2);
		ob.g.addEdge(1, 2, 2);
		ob.g.addEdge(3, 1, 1);
		ob.g.addEdge(2, 3, 2);
		int v = ob.g.findTSP();
		assertEquals(v, 6);
	}
	
	@Test
	public void test2() {
		//Test case given in the example 1
		TSP ob = new TSP();
		ob.g = new Graph(3);
		ob.g.addEdge(0, 1, 1);
		ob.g.addEdge(0, 2, 1);
		ob.g.addEdge(1, 2, 1);
		int v = ob.g.findTSP();
		assertEquals(v, 3);
	}
	
	@Test
	public void test3() {
		//Simple test case with 5 nodes
		TSP ob = new TSP();
		ob.g = new Graph(5);
		ob.g.addEdge(0, 1, 5);
		ob.g.addEdge(1, 2, 5);
		ob.g.addEdge(2, 3, 5);
		ob.g.addEdge(3, 4, 5);
		ob.g.addEdge(0, 4, 5);
		ob.g.addEdge(0, 2, 1);
		ob.g.addEdge(4, 2, 1);
		ob.g.addEdge(1, 3, 1);
		ob.g.addEdge(1, 4, 1);
		ob.g.addEdge(0, 3, 1);
		
		int v = ob.g.findTSP();
		assertEquals(v, 5);
	}

}
