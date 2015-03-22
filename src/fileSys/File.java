package fileSys;

import java.util.Date;

public class File {
	private String name;
	private Date date;
	private Integer size;
	private AllocationMethod allocationMethod;
	

	File(){
		date = new Date();
		size = 0;
		allocationMethod = new ContiguousAllocation();
	}
	File(String n,Integer s,AllocationMethod a){
		name = n;
		size = s;
		allocationMethod = a;
	}
	
	public String getName(){return name;}
	public Integer getSize(){return size;}
	public Date getDate(){return date;}
	
	public void setName(String s){name = s;}
	public void setDate(Date d){date = d;}
	public void setSize(int i){size = i;}
	
}
