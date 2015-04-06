package fileSys;

import java.util.ArrayList;

public class IndexedAllocation extends AllocationMethod{
	
	private Integer indexBlock;
	private ArrayList<Integer> blocks;
	
	public IndexedAllocation() {
		blocks = new ArrayList<Integer>();
	}
	
	public Boolean allocate(ArrayList<Boolean> sysBlocks,Integer size){
		for(int i = 0 ; i < sysBlocks.size(); ++i){
			if(this.blocks.size() == size+1)break;
			if(!sysBlocks.get(i)){
				this.blocks.add(i);
			}
		}
		if(this.blocks.size() < size+1){
			this.blocks.clear();
			return false;
		}
		
		for(Integer i : this.blocks){
			sysBlocks.set(i , true);
		}
		
		indexBlock = this.blocks.get(size);
		this.blocks.remove(size);
		return true;
	}
	
}
