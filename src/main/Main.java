package main;

import java.util.ArrayList;
import java.util.Scanner;

import allocationMethods.AllocationMethod;
import allocationMethods.ContiguousAllocation;
import Memory.MemoryManager;
import fileSystem.Directory;
import fileSystem.File;

public class Main {
	private static MemoryManager MEMORY;
	private static AllocationMethod ALLOCATION_METHOD;
	private static int MEMORY_SIZE = 1000;
	private static Directory ROOT;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MEMORY = new MemoryManager(MEMORY_SIZE);
		ROOT = new Directory("/");
		ALLOCATION_METHOD = new ContiguousAllocation(MEMORY , ROOT);
		
		
		String user_input = "";
		Scanner input = new Scanner(System.in);
		user_input = input.nextLine();
		while(!user_input.equals("exit")){
			if(user_input.startsWith("CreateFile")){
				String path = user_input.split(" ")[1];
				int sz = Integer.valueOf(user_input.split(" ")[2]);
				ALLOCATION_METHOD.createFile(path, sz);
			}else if(user_input.startsWith("CreateFolder")){
				String path = user_input.split(" ")[1];
				ALLOCATION_METHOD.createFolder(path);
			}else if(user_input.startsWith("DeleteFile")){
				String path = user_input.split(" ")[1];
				ALLOCATION_METHOD.deleteFile(path);
			}else if(user_input.startsWith("DeleteFolder")){
				String path = user_input.split(" ")[1];
				ALLOCATION_METHOD.deleteFolder(path);
			}
			displayDiskStructure();
			user_input = input.nextLine();
		}
		input.close();
	}

	public static void recursivePrint(Directory dir,int lvl){

		ArrayList<Directory> dirs = (ArrayList<Directory>)dir.getFolders();
		ArrayList<File> files = (ArrayList<File>)dir.getFiles();
		String spaces = "";
		for(int i = 0 ; i < lvl-1; ++i){
			spaces += " ";
		}
		for(int i = 0 ; i < files.size(); ++i){
			System.out.print(spaces);
			System.out.println("-" + files.get(i).getName());
		}
		for(int i = 0 ; i < dirs.size(); ++i){
			System.out.print(spaces);
			System.out.println(">" + dirs.get(i).toString());
			recursivePrint(dirs.get(i), lvl+1);
		}
	}
	public static void displayDiskStructure(){
		System.out.println("/");
		recursivePrint(ROOT, 1);
	}
	
}
