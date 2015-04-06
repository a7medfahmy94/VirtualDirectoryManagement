package allocationMethods;

import fileSystem.Directory;
import Memory.MemoryManager;

public abstract class AllocationMethod {
	protected MemoryManager MEMORY;
	protected Directory ROOT;

	public AllocationMethod(){}
	public AllocationMethod(MemoryManager m,Directory d) {
		MEMORY = m;
		ROOT = d;
	}
	public void setMemoryManager(MemoryManager m){
		MEMORY = m;
	}
	public void setRoot(Directory d){
		ROOT = d;
	}
	abstract public Boolean createFile(String path,int size);
	abstract public Boolean createFolder(String path);
	abstract public Boolean deleteFile(String path);
	abstract public Boolean deleteFolder(String path);
}
