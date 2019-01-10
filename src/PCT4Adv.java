import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PCT4Adv {

	class Process{
		int id;
		ArrayList<Integer> resHold = new ArrayList<>();
		int resReq;
		Process next;
		public Process(int i, int j, int k) {
			id =i;
			if(j!=-1)
				resHold.add(j);
			if(k!=-1)
				resReq = k;
		}
	}
	
	HashMap<Integer, Process> processList = new HashMap<Integer, Process>();
	
	HashMap<Integer, Process> resourceList = new HashMap<Integer, Process>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		PCT4Adv obj = new PCT4Adv();
		obj.getInput();
		System.out.println(obj.checkDeadlock());
		
	}

	private String checkDeadlock() {
		
		makeConnections();
		for(Process i : processList.values())
		{
			ArrayList<Process> q = new ArrayList<Process>();
			HashSet <Process> vis = new HashSet<>();
			q.add(i);
			while(!q.isEmpty())
			{
				Process p = q.remove(0);
				if(!vis.contains(p))
					vis.add(p);
				else
					return "YES";
				if(p.next!=null)
					q.add(p.next);
				
			}
			
		}
		
		return "NO";
	}

	private void makeConnections() {
		
		for(int i: processList.keySet())
		{
			Process p = processList.get(i);
			if(p.resReq!=-1)
				p.next = resourceList.get(p.resReq);
			if(p.next!=null)
				System.out.println(p.id+" connected "+p.next.id);
		}
			
		
	}

	private void getInput() throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfInput = Integer.parseInt(br.readLine());
		
		for(int i=0; i<noOfInput; i++)
		{
			String[] str = br.readLine().split(" ");
			int pid = Integer.parseInt(str[0]);
			int rH = Integer.parseInt(str[1]);
			int rR = Integer.parseInt(str[2]);
			if(!processList.containsKey(pid))
			{
				Process newProc = new Process(pid, rH, rR);
				processList.put(pid, newProc);
				if(rH!=-1)
					resourceList.put(rH, newProc);
			}
			else
			{
				Process p = processList.get(pid);
				if(rH!=-1)
				{
					p.resHold.add(rH);
					resourceList.put(rH, p);
				}
				if(rR!=-1)
				{
					p.resReq = rR;
				}
				
			}
		}
		
		
	}

}
