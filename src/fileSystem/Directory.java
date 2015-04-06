package fileSystem;

import java.util.ArrayList;
import java.util.List;

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
		int idx = p.lastIndexOf('/');
		
		this.directoryPath = p.substring(idx+1) + "/";
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
		this.folders.add(d);
	}
	public void addFile(File f){
		this.files.add(f);
	}
	public String toString(){
		return directoryPath;
	}
	public Directory getParentOf(String path){
		if(!path.startsWith(directoryPath))return null;
		String rest = path.substring(directoryPath.length());
		for(Directory d: folders){
			if(rest.startsWith(d.directoryPath)){
				return d.getParentOf(rest);
			}
		}
		return this;
	}
	
	public List<Directory> getFolders(){
		return folders;
	}
	public List<File> getFiles(){
		return files;
	}
	public void deleteFile(File f){
		for(int i = 0 ; i < files.size(); ++i){
			if(files.get(i).getName().equals(f.getName())){
				files.remove(i);
				return;
			}
		}
	}
	
}
