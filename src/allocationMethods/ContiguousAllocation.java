package allocationMethods;

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
		parent.deleteFile(new File(path));
		return null;
	}

	@Override
	public Boolean deleteFolder(String path) {
		// TODO Auto-generated method stub
		return null;
	}

}
