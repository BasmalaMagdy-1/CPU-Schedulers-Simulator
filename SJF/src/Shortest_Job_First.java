import java.util.Vector;

public class Shortest_Job_First {

	public void SJF(Vector<Process>v, int totaltime, int ContextSwitching) {
		
		
		
		
		
		Vector<Pair>ans = new Vector();
		int sec=0;
	    int index = 0;
	    while(totaltime>sec)   
	    {
	        int min_exec= 1000000000;   
	        for(int i=0;i<v.size();i++)
	        {

	        	
	            if(v.get(i).getArrivalTime()<=sec && v.get(i).getBurstTime()<min_exec  && v.get(i).getBurstTime()>0)
	            {
	                min_exec=v.get(i).getBurstTime();
	                index=i;
	            }
	        }

	        sec++;
	        //int T_sec=sec;
	        int exectime =v.get(index).getBurstTime(); //16
	        v.get(index).setBurstTime(exectime-1);

	        min_exec = v.get(index).getBurstTime();
	        
	        ///process is excuted
	        if(v.get(index).getBurstTime()<=0) {
	        	//sec+=ContextSwitching;
	        	Pair p = new Pair(v.get(index).getName(), sec);
	            ans.add(p);
	            continue;
	        }
	        
	        ///check if there is another SJ
	        Boolean flag =false;
	        int tmp;
	        for(int i=0;i<v.size();i++)
	        {
	            if(v.get(i).getArrivalTime()<=sec  && v.get(i).getBurstTime()>0 && v.get(i).getBurstTime()<min_exec )
	            	
	            {
	                min_exec=v.get(i).getBurstTime();
	                tmp=i;
	                
	                flag =true;
	            }
	        }
	        if(flag){
	        	//sec+=ContextSwitching;
	        	Pair p = new Pair(v.get(index).getName(), sec);
	            ans.add(p);
	        }
	    }
	    
	    int size = ans.size();
	    int T_CS= ContextSwitching;
	    int j=0;
	    while(true) {
	    	if(size<=0) break;
	    	ans.get(j).second += T_CS ;
	    	T_CS+=ContextSwitching;
	    	j++;
	    	size--;
	    }
	    /*for(int i=1;i<ans.size();i++){
	    	ans.get(i).second += i*ContextSwitching ;
P1 1
P2 2
P3 5
P5 10
P2 16
P4 22
P7 30
P6 45
	    }*/
	    
	    
	    for(int i=v.size()-1;i>=0;i--)
	    {
	    	
	    	//set completion time
	    	if(v.get(i).getEnd()==0) {
	    		for(int k=0;k<ans.size();k++){
	    	    	if(ans.get(k).first==v.get(i).getName()) {
	    	    		v.get(i).setEnd(ans.get(k).second);
	    	    	}
	    	    }
	    	}
	    	
	    	
	    	//set waiting time
	    	v.get(i).setWaitingTime(v.get(i).getEnd() - v.get(i).getFixedBurstTime() - v.get(i).getFixedArrivalTime());
	    	//set turnaround time
	    	v.get(i).setTurnaroundTime(v.get(i).getWaitingTime()+v.get(i).getFixedBurstTime());
	    }
	       
	 
	    System.out.println(" [Short Job First] ");
	    System.out.println();
	    
	    System.out.println("Processes execution order");
	    for(int i=0;i<ans.size();i++){
	    	
	    	System.out.print(ans.get(i).first+" ");
	    	System.out.print(" | ");
	    }
	    System.out.println();
	    System.out.println();
	    
	    int aver_WT=0;
	    int aver_TA=0;
	    
	    System.out.println("Process"+"    "+"     "+"Waiting Time"+"    "+"Turnaround Time");
	    for(int i=0;i<v.size();i++) {
	    	
	    	int waiting=v.get(i).getWaitingTime();
	    	int turnaround=v.get(i).getTurnaroundTime();
	    	aver_WT+=waiting;
	    	aver_TA+=turnaround;
	    	System.out.println("  "+v.get(i).getName()+"               "+waiting+"                 "+turnaround);
	    	//+"            "+v.get(i).getEnd()
	    	
	    }
	    aver_WT/=v.size();
	    aver_TA/=v.size();
	    
	    System.out.println("Average Waiting Time = "+aver_WT);
	    System.out.println("Average Turnaround Time = "+aver_TA);
	    
	    
	}
}
