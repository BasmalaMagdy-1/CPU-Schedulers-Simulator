package RR;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
public class Main {
	
	static void sort(ArrayList<Pair>p)
	{

	      for(int i=0;i<p.size();++i){

	        int j = i;
	        
	        while(j > 0 && p.get(j-1).arrivaltime>p.get(j).arrivaltime){

	          int key = p.get(j).arrivaltime;
	          int kk=p.get(j).bursttime;
	          String n=p.get(j).name;
	          p.get(j).name=p.get(j-1).name;
	          p.get(j).arrivaltime = p.get(j-1).arrivaltime;
	          p.get(j).bursttime = p.get(j-1).bursttime;
	          
	          p.get(j-1).arrivaltime = key;
	          p.get(j-1).bursttime = kk;
	          p.get(j-1).name=n;
	          j = j-1; 

	        }
	      }
	    
		
		
	}

	

	public static void main(String[] args) {
		
	    Queue<Pair> readyQueue= new LinkedList<>();
		ArrayList<Pair> process = new ArrayList<Pair>(); 
		ArrayList<Process> p = new ArrayList<Process>();
	    Map<String, Integer> completeTime= new HashMap<String, Integer>();
	    Map<String, Integer> startTime= new HashMap<String, Integer>();
		ArrayList<String> orderProcess = new ArrayList<String>();


		System.out.print("Enter the quantam time:");
		Scanner O3 = new Scanner(System.in); 
	    int q = O3.nextInt();
	    System.out.print("Enter the context switching time:");
		Scanner O4 = new Scanner(System.in); 
	    int contextSwitch = O4.nextInt();
		System.out.print("Enter the number of processes:");
		Scanner O1 = new Scanner(System.in); 
	    int n = O1.nextInt();  
	    int arrivalTime;
	    int burstTime;
	    String name;
	    
	    for(int i=0;i<n;i++)
	    {
	    	 Scanner O2 = new Scanner(System.in);
	    	int temp=i+1;
	    	System.out.println("Enter the name of process "+temp+" :");
	    	name=O2.nextLine();
	    	System.out.println("Enter the arrival time of process "+temp+" :");
	    	arrivalTime=O2.nextInt();
	    	System.out.println("Enter the burst time of process "+temp+" :");
	    	burstTime=O2.nextInt();
	    	Pair pair=new Pair(arrivalTime,burstTime,name) ;	    	
	    	process.add(pair);
	    	Process processx=new Process(name,burstTime,arrivalTime);
	    	p.add(processx);
	    }
	    
	   sort(process);
	
	   ////doWork
	   int curTime=0;
	   if(!process.isEmpty())
	   readyQueue.add(process.get(0));
	   int i=0;
	   while(!readyQueue.isEmpty())
	   {
		   	   
		   if(readyQueue.peek().arrivaltime>curTime) {
			   curTime++;
		   }
		   else {
			if(!startTime.containsKey(readyQueue.peek().name))
		        startTime.put(readyQueue.peek().name, curTime);
		   curTime+=(Math.min(q, process.get(i).bursttime));
		   process.get(i).bursttime-=Math.min(q, process.get(i).bursttime);
		   
		   if(process.get(i).bursttime==0)
		   {
			   completeTime.put(readyQueue.peek().name, curTime-contextSwitch);
		   }
		   orderProcess.add(readyQueue.peek().name);
		   readyQueue.remove();
		   i++;
		      
		   }
		   if(readyQueue.isEmpty()&&!process.isEmpty())
		   {
			   int steps=0;
			 i%=n;
			   while((i<n)&&process.get(i).bursttime==0)
			   {
				   i++;
				   i%=n;
				   steps++;
				   if(steps==n)break;
			   }
			   if(i<n&&process.get(i).bursttime!=0)
			  {readyQueue.add(process.get(i));
			   curTime+=contextSwitch;}
		   }
	   }
	   
	   System.out.println("order of excuted processes:");
	   for(int j=0;j<orderProcess.size();j++)
	    {
		   if(j!=orderProcess.size()-1)
		       System.out.print(orderProcess.get(j)+'|');
		   else
			   System.out.println(orderProcess.get(j));
	    }
	   System.out.println("Process name  "+"Arrival time  "+"Excution time  "+"completetion time  "+"Turnaround time  "+"Waiting time  "+"Response time");
	   int sumWating=0;
	   int sumTurn=0;
	   for(int j=0;j<process.size();j++)
	   {
		   int turnaround=completeTime.get(process.get(j).name)-process.get(j).arrivaltime;
		   int w=turnaround-process.get(j).originalBurstTime;
		   sumWating+=w;
		   sumTurn+=turnaround;
		   
		   System.out.print(process.get(j).name+"                 "+process.get(j).arrivaltime+"                 "+process.get(j).originalBurstTime+"                "+completeTime.get(process.get(j).name)+"            "); 
		   System.out.println(turnaround+"               "+w+"           "+startTime.get(process.get(j).name)); 
	   } 
	   int avg=(sumWating/process.size());
	   System.out.println("Average Waiting Time "+avg);
	   System.out.println("Average turnaround Time "+(sumTurn/process.size()));

	   
	 
	   

	    
	    
	    
	}

}
