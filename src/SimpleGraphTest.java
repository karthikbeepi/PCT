import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleGraphTest {

	@Test
	public void test() {
		SimpleGraph g = new SimpleGraph(5);
		g.addEdge(1, 2, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(1, 4, 1);
		g.addEdge(4, 5, 1);
		g.addEdge(5, 3, 1);
		StringBuilder op = new StringBuilder();
		g.bfs();
		for(int i : g.vis)
			op.append(i+" ");
		op.deleteCharAt(op.length()-1);
		op.append("\n");
		g.dfs();
		for(int i : g.vis)
			op.append(i+" ");
		op.deleteCharAt(op.length()-1);	
		System.out.print(op.toString());
	}

}
