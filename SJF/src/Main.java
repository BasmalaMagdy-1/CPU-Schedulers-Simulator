import java.util.Scanner;
import java.util.Vector;
import java.util.*;

class Pair {
	 
    // Pair attributes
	public String first;
	public int second;
    //public int third;
    
 
    // Constructor to initialise pair
    public Pair(String first, int second)
    {
       
        this.first = first;
        this.second = second;
        //this.third = third;
    }
}

public class Main {

	public static void main(String[] args) {
		Vector<Process>v = new Vector();
        Scanner input = new Scanner(System.in);
		
		System.out.println("Enter n of processes :");
		
		int NumberOfProcess=input.nextInt();
		System.out.println("Enter Context Switching :");
		int ContextSwitching=input.nextInt();
		
		int totaltime=0;
		
		/*for(int i=0;i<NumberOfProcess;i++) {
			
			input = new Scanner(System.in);
			Process p = new Process();
			System.out.println(" Enter Process("+(i+1) +") Name");
			p.setName(input.nextLine());
			
			System.out.println("Enter Process("+(i+1) +") Burst Time");
			p.setBurstTime(input.nextInt())  ;
			
			System.out.println(" Enter Process("+(i+1) +") Arrival Time");
			p.setArrivalTime(input.nextInt()) ;
			v.add(p);
			
			System.out.println(" Enter Process("+(i+1) +") Priority");
			p.setPriority(input.nextInt());
			
			totaltime+=p.getBurstTime();
		}*/
		
		Process p1 = new Process("P1",1,0,0);
		totaltime+=p1.getBurstTime();
		v.add(p1);
		
		Process p2 = new Process("P2",7,1,0);
		totaltime+=p2.getBurstTime();
		v.add(p2);
		
		Process p3 = new Process("P3",3,2,0);
		totaltime+=p3.getBurstTime();
		v.add(p3);
		//System.out.print(p3.getBurstTime());
		
		Process p4 = new Process("P4",6,3,0);
		totaltime+=p4.getBurstTime();
		v.add(p4);
		
		Process p5 = new Process("P5",5,4,0);
		totaltime+=p5.getBurstTime();
		v.add(p5);
		
		Process p6 = new Process("P6",15,5,0);
		totaltime+=p6.getBurstTime();
		v.add(p6);
		
		Process p7 = new Process("P7",8,15,0);
		totaltime+=p7.getBurstTime();
		v.add(p7);
		
		//totaltime+= (ContextSwitching*NumberOfProcess);
		
		Shortest_Job_First sjf=new Shortest_Job_First();
		sjf.SJF(v, totaltime, ContextSwitching);
		

	}

}
