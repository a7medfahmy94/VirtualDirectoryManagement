package Memory;

import java.util.ArrayList;
import java.util.List;

public class MemoryManager {
	private ArrayList<Boolean> blocks;
	private int totalSize;
	private int totalFree;

	public MemoryManager(){
		totalSize = totalFree = 1;
		blocks = new ArrayList<Boolean>();
		blocks.add(false);
	}
	public MemoryManager(int sz){
		totalSize = sz;
		totalFree = totalSize;
		blocks = new ArrayList<Boolean>();
		for(int i = 0 ; i < totalSize; ++i){
			blocks.add(false);
		}
	}
	public void setAllocated(int idx){
		blocks.set(idx, true);
	}
	public void setUnallocated(int idx){
		blocks.set(idx, false);
	}
	public int getTotalFree(){
		return totalFree;
	}
	public int getTotalSize(){
		return totalSize;
	}
	public Boolean isAllocated(int idx){
		return blocks.get(idx);
	}
	public List<Boolean> getAllBlocks(){
		return blocks;
	}
	public void displayDiskStatus(){
		
	}
}
