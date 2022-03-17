package simplilearnPhase1Project;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class LockedMe {
	static final String projectFilesPath="D:\\FSD\\PHASE 1 JAVA OOPS\\Test";
	
		public static void displayMenu()
		{
			System.out.println("*************************************************");
			System.out.println("\t*Welcome to LockedMe Secure Application*");
			System.out.println("\tDeveloped by : Snehal Suryabhan Sanap.");
			System.out.println("*************************************************");
			System.out.println("\t1. Display all files");
			System.out.println("\t2. Add a new file");
			System.out.println("\t3. Delete a  file");
			System.out.println("\t4. Search file");
			System.out.println("\t5. Exit");
			System.out.println("*************************************************");	 
 }
		public static void getAllFiles() {
			File folder = new File(projectFilesPath);
		    File[] listOfFiles= folder.listFiles();
		    
		    if(listOfFiles.length>0) {
		    
		    System.out.println("Flies list is below\n");
		    for(var l:listOfFiles)
		    {
		    System.out.println(l.getName());
		
		    }
		}
		    else {
		    	System.out.println("This folder is empty");
		    }
		  
		    }
		
		/**
		 * This method read file details from users and creates files.
		 */
		public static void createFiles() {
		  try {	
			  
			  //Variable declaration
			Scanner obj = new Scanner(System.in);
			String fileName;
			
			//Read file from users.
			System.out.println("Enter file name: ");
			fileName=obj.nextLine();
			int linesCount;
			
			System.out.println("Enter how many lines in the file: ");
			linesCount=Integer.parseInt(obj.nextLine());
			
			FileWriter fw= new FileWriter(projectFilesPath+"\\"+fileName);
			
			//Read line by line from users.
			for(int i=1;i<=linesCount;i++)
			{
				System.out.println("Enter file line: ");
				fw.write(obj.nextLine()+"\n");
			}
			System.out.println("File created successfully.");
			fw.close();
		}
		  catch(Exception Ex) {
			  
		  }
		}
		
		/** This method will take file name as parameters and check if it is present 
		 * in the project folder or not
		 * @param fileName string 
		 * @return boolean
		 */
		public static boolean checkFileExists(String fileName)
		
		{
			ArrayList<String> allFilesNames = new ArrayList<String>();
			File folder =   new File(projectFilesPath);
			
			File[] listOfFiles = folder.listFiles();
			if(listOfFiles.length>0)
			{
				for(var l:listOfFiles)
				{
					allFilesNames.add(l.getName());
				}
			}
			
			return allFilesNames.contains(fileName);
		}
		
		/**
		 * This method is used for delete file.
		 */
		public static void deleteFiles() {
			try
			{
			Scanner obj = new Scanner(System.in);
			String fileName;
			System.out.println("Enter file name to be deleted: ");
			fileName=obj.nextLine();
			File f= new File(projectFilesPath+"\\"+fileName);
			
			if(checkFileExists(fileName))
			{
				f.delete();
				System.out.println("File deleted successfully: ");
			}
			else
			{ 
				System.out.println("File does not exist: ");
			}
		}
		catch (Exception Ex)
		{
			System.out.println("Unable to delete file,  Please contact: admin@query.com ");
		}
		
	}
		
		/**
		 * 
		 * This method is used for search file from folder.
		 */
		public static void searchFiles() {
			try {
	
			
			Scanner obj = new Scanner(System.in);
			String fileName;
			System.out.println("Enter file name to be searched: ");
			fileName= obj.nextLine();
			
			if(checkFileExists(fileName))
			{
				System.out.println("File is available ");
			}
			else
			{
				System.out.println("File does not exist ");
			}
		}
			catch(Exception Ex)
			{
			
			}
		}
}

