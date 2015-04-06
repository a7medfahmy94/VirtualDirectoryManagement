package fileSystem;

import java.util.ArrayList;

public class File {
	private String filePath;
	private ArrayList<Integer> allocatedBlocks;
	private boolean deleted;
	
	public File(){
		this.allocatedBlocks = new ArrayList<Integer>();
	}
	public File(String p){
		this.filePath = p;
		this.allocatedBlocks = new ArrayList<Integer>();
	}
	public void addBlock(Integer i){
		this.allocatedBlocks.add(i);
	}
	public void delete(){
		this.deleted = true;
	}
	
}
