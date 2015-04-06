package allocationMethods;

import fileSystem.Directory;
import Memory.MemoryManager;

public class IndexedAllocation extends AllocationMethod{

	public IndexedAllocation(){}
	public IndexedAllocation(MemoryManager m,Directory d){
		super(m , d);
	}
	@Override
	public Boolean createFile(String path, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean createFolder(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteFile(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteFolder(String path) {
		// TODO Auto-generated method stub
		return null;
	}
}
