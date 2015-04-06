package allocationMethods;

import java.util.ArrayList;

import fileSystem.Directory;
import fileSystem.File;
import Memory.MemoryManager;

public class IndexedAllocation extends AllocationMethod{

	public IndexedAllocation(){}
	public IndexedAllocation(MemoryManager m,Directory d){
		super(m , d);
	}
	
	@Override
	public Boolean createFile(String path, int size) {
		if(size == 0)return false;
		if(MEMORY.getTotalFree() < size)return false;
		Directory parent = ROOT.getParentOf(path);
		if(parent == null)return false;

		File file = new File(path);
		for(int i = 0 ; size != 0 ; ++i){
			if(!MEMORY.isAllocated(i)){
				MEMORY.setAllocated(i);
				file.addBlock(i);
				size--;
			}
		}
		parent.addFile(file);
		return true;
	}

	@Override
	public Boolean createFolder(String path) {
		Directory parent = ROOT.getParentOf(path);
		if(parent == null)return false;
		Directory dir = new Directory(path);
		parent.addFolder(dir);
		return true;
	}

	@Override
	public Boolean deleteFile(String path) {
		Directory parent = ROOT.getParentOf(path);
		if(parent == null)return false;
		ArrayList<Integer> alloc = parent.deleteFile(new File(path));
		if(alloc == null)return null;
		for(Integer i: alloc){
			MEMORY.setUnallocated(i);
		}
		return true;
	}

	@Override
	public Boolean deleteFolder(String path) {
		Directory parent = ROOT.getParentOf(path);
		if(parent == null)return false;
		parent.deleteFolder(new Directory(path));
		return true;
	}
}
