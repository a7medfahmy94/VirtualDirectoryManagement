package main;

import java.util.ArrayList;
import java.util.Scanner;

import allocationMethods.AllocationMethod;
import allocationMethods.ContiguousAllocation;
import allocationMethods.IndexedAllocation;
import Memory.MemoryManager;
import fileSystem.Directory;
import fileSystem.File;

public class Main {
	private static MemoryManager MEMORY;
	private static AllocationMethod ALLOCATION_METHOD;
	private static int MEMORY_SIZE = 1000;
	private static Directory ROOT;
	
	private static String create_file = "CreateFile";
	private static String create_folder = "CreateFolder";
	private static String delete_file = "DeleteFile";
	private static String delete_folder = "DeleteFolder";
	private static String display_disk_structure = "DisplayDiskStructure";
	private static String display_disk_status = "DisplayDiskStatus";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MEMORY = new MemoryManager(MEMORY_SIZE);
		ROOT = new Directory("/");
//		ALLOCATION_METHOD = new ContiguousAllocation(MEMORY , ROOT);
		ALLOCATION_METHOD = new IndexedAllocation(MEMORY,ROOT);
		
		String user_input = "";
		Scanner input = new Scanner(System.in);
		user_input = input.nextLine();
		while(!user_input.equals("exit")){
			if(user_input.startsWith(create_file)){
				String path = user_input.split(" ")[1];
				int sz = Integer.valueOf(user_input.split(" ")[2]);
				ALLOCATION_METHOD.createFile(path, sz);
			}else if(user_input.startsWith(create_folder)){
				String path = user_input.split(" ")[1];
				ALLOCATION_METHOD.createFolder(path);
			}else if(user_input.startsWith(delete_file)){
				String path = user_input.split(" ")[1];
				ALLOCATION_METHOD.deleteFile(path);
			}else if(user_input.startsWith(delete_folder)){
				String path = user_input.split(" ")[1];
				ALLOCATION_METHOD.deleteFolder(path);
			}else if(user_input.startsWith(display_disk_status)){
				MEMORY.displayDiskStatus();
			}else if(user_input.startsWith(display_disk_structure)){
				displayDiskStructure();
			}
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
