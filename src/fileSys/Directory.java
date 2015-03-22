package fileSys;

import java.util.ArrayList;
import java.util.List;


public class Directory {
	List<File> files;
	List<Directory> dirs;
	
	public Directory(){
		files = new ArrayList<File>();
		dirs = new ArrayList<Directory>();
	}
	public void addFile(File f){
		files.add(f);
	}
	public void addDir(Directory d){
		dirs.add(d);
	}
	
	public List<Directory> getDirs(){return dirs;}
	public List<File> getFiles(){return files;}
	
}
