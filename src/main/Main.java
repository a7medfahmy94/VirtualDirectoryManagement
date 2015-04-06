package main;

import fileSystem.Directory;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Directory root = new Directory("/");
		Directory homeFolder = new Directory("home");
		root.addFolder(homeFolder);
		
		Directory someFolder = new Directory("OS2");
		homeFolder.addFolder(someFolder);
		
		System.out.println(someFolder);
	}

}
