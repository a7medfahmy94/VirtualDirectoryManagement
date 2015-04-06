package fileSystem;

import java.util.ArrayList;
import java.util.List;

public class File {
	private String filePath;
	private ArrayList<Integer> allocatedBlocks;
	private boolean deleted;
	
	public File(){
		this.allocatedBlocks = new ArrayList<Integer>();
	}
	public File(String p){
		int idx = p.lastIndexOf('/');
		this.filePath = p.substring(idx+1);
		this.allocatedBlocks = new ArrayList<Integer>();
	}
	public void addBlock(Integer i){
		this.allocatedBlocks.add(i);
	}
	public void delete(){
		this.deleted = true;
	}
	public String getName(){
		return filePath;
	}
	public List<Integer> getAllocatedBlocks(){
		return allocatedBlocks;
	}
}
