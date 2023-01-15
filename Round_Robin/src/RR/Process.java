package RR;

public class Process {

	private String Name;
	private int ArrivalTime;
	private int BurstTime;
	
	
	private int WaitingTime=0;              
	private int TurnaroundTime=0;          
	private int End=0; 
	
	private int FixedArrivalTime;     
	private int FixedBurstTime;       

	public Process()
	{}
	
	public Process(Process P)
	{
		Name =P.getName();
		BurstTime = P.getBurstTime();
		ArrivalTime = P.getArrivalTime();
		
		
			
	}
	
	public Process(String Name , int BurstTime , int ArrivalTime)
	{
		this.Name = Name;
		this.BurstTime = BurstTime;
		this.ArrivalTime = ArrivalTime;
		
		
		this.FixedBurstTime=BurstTime;
		this.FixedArrivalTime=ArrivalTime;
	}


	public void setName(String name) {
		Name = name;
	}

	public void setBurstTime(int bt) {
		BurstTime = bt;
		
	}

	public void setArrivalTime(int at) {
		ArrivalTime = at;
		
	}

	
	public void setWaitingTime(int wt) {
		WaitingTime = wt;
	}
	public void setTurnaroundTime(int tt) {
		TurnaroundTime = tt;
	}
	
	public void setEnd(int e) {
		End=e;
	}


	public String getName() {
		return Name;
	}

	public int getBurstTime() {
		return BurstTime;
	}

	public int getArrivalTime() {
		return ArrivalTime;
	}


	public int getWaitingTime() {
		return WaitingTime;
	}
	public int getTurnaroundTime() {
		return TurnaroundTime;
	}
	
	public int getEnd() {
		return End;
	}

	public int getFixedArrivalTime() {
		return  FixedArrivalTime;
	}
	
	public int getFixedBurstTime() {
		return  FixedBurstTime;
	}

}
