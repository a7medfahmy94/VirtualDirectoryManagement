package fileSystem;

import java.util.ArrayList;

public class Directory {
	private ArrayList<File> files;
	private ArrayList<Directory> folders;
	private String directoryPath;
	private boolean deleted;
	
	public Directory(){
		files = new ArrayList<File>();
		folders = new ArrayList<Directory>();
	}
	public Directory(String p){
		this.directoryPath = p;
		files = new ArrayList<File>();
		folders = new ArrayList<Directory>();
	}
	public void delete(){
		this.deleted = true;
	}
	public boolean isDeleted(){
		return deleted;
	}
	public void addFolder(Directory d){
		d.directoryPath = 
				directoryPath.concat(d.directoryPath).concat("/");
		this.folders.add(d);
	}
	public void addFile(File f){
		this.files.add(f);
	}
	public String toString(){
		return directoryPath;
	}
	
}
