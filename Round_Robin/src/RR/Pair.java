package RR;

public class Pair {

	public Pair() {}
	
	public int arrivaltime;
	public int bursttime;
	public String name;
	public int originalBurstTime;
	public Pair(int a,int b,String s)
	{
		arrivaltime=a;
		bursttime=b;
		name=s;
		originalBurstTime=b;
	}
	void setArrivalTime(int time)
	{
		arrivaltime=time;
	}
	void setburstTime(int time)
	{
		bursttime=time;
	}
	int getArrivalTime()
	{
		return arrivaltime;
	}
	int getBurstTime()
	{
		return bursttime;
	}
	

}
