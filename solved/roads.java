import java.util.ArrayList;
import java.util.Scanner;

public class roads {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i=0;i<testCases;i++) {
			int numEnd = in.nextInt();
			endpoint[] endList = new endpoint[numEnd];
			for (int j = 0; j < endList.length; j++) {
				endList[j] = new endpoint();
			}
			
			int r = in.nextInt();
			for (int j = 0; j < r; j++) {
				int a = in.nextInt();
				int b= in.nextInt();

				endList[a].connections.add(endList[b]);
				endList[b].connections.add(endList[a]);
			}
			int sections=0;
			for (int j=0; j<numEnd;j++) {
				if (endList[j].visited==false) {
					sections++;
					endList[j].bubbleOut();
				}
			}
			System.out.println(sections-1);
		}
	}
}

class endpoint{
	ArrayList<endpoint> connections = new ArrayList<endpoint>();
	boolean visited=false;
	
	void bubbleOut() {
		this.visited=true;
		for (endpoint e:connections) {
			if (!e.visited)e.bubbleOut();
		}
	}
}
