package allocationMethods;

import java.util.ArrayList;

import fileSystem.Directory;
import fileSystem.File;
import Memory.MemoryManager;

public class ContiguousAllocation extends AllocationMethod{
	
	public ContiguousAllocation(){}
	public ContiguousAllocation(MemoryManager m,Directory d){
		super(m , d);
	}
	
	@Override
	public Boolean createFile(String path, int size) {
		Directory parent = ROOT.getParentOf(path);
		if(parent == null)return false;
		if(size == 0)return false;
		if(MEMORY.getTotalFree() < size)return false;
		File file = new File(path);
		for(int i = 0 ; i <= MEMORY.getTotalSize()-size; ++i){
			int j;
			for(j = 0 ; j < size; ++j){
				if(MEMORY.isAllocated(i+j))break;
			}
			if(j == size){
				j = 0;
				for(;j < size; ++j){
					MEMORY.setAllocated(i+j);
					file.addBlock(j+i);
				}
				parent.addFile(file);
				return true;
			}
		}
		return false;
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
