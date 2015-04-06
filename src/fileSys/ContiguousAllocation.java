package fileSys;

import java.util.ArrayList;

public class ContiguousAllocation extends AllocationMethod{
	
	private Integer start , length;
	
	public Boolean allocate(ArrayList<Boolean> blocks,Integer size){
		//if success , return true , set start & length
		
		return true;
	}
	
	public Integer getStart(){return start;}
	public Integer getLength(){return length;}
	
	
}
