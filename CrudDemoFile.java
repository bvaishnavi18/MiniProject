package com.file;

import java.io.*;
import java.io.File;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.ObjectOutputStream;

class Intern implements Serializable {
	int internId;
	String iName;
	int salary;

	Intern(int internId, String iName, int salary) {
		this.internId = internId;
		this.iName = iName;
		this.salary = salary;
	}

	public String toString() {
		return internId + " " + iName + " " + salary;
	}
}

class InternDemo {
	public static  void main(String[]args) throws Exception {
		  int choice= -1;
		  Scanner s= new  Scanner(System.in);
		  Scanner s1= new Scanner(System.in);
		  File file=new File("C:\\Users\\vaishnavi bane\\OneDrive\\Desktop\\Intern.");
		  ArrayList<Intern> al= new ArrayList<Intern>();
		  ObjectOutputStream oos= null;
		  ObjectInputStream ois= null;
		  ListIterator li=null;
		  
		  
		  if(file.isFile()) {
			  ois= new ObjectInputStream(new FileInputStream(file));
			 al=(ArrayList<Intern>)ois.readObject();
			  ois.close();
		  }
		  
		  
		  do {
			  System.out.println("1.Insert");
			  System.out.println("2.Display");
			  System.out.println("3.Search");
			  System.out.println("4.Delete");
			  System.out.println("5.Update");
			  System.out.println("6.Sort By Intern Id-(On Screen)");
			  System.out.println("7.Sort By Intern Id-(In Screen)");
			  System.out.println("8.Sort By Intern Name-(On Screen)");
			  System.out.println("9.Sort By Intern Name-(In Screen)");
			  System.out.println("10.Sort By Intern Salary-(Descending On Screen)");
			  System.out.println("11.Sort By Intern Salary-(Ascending In Screen)");
			  System.out.println("0.Exit--");
			  System.out.print("Enter your Choice: ");
			  choice=s.nextInt();
			  
			  switch(choice) {
			  case 1:
				  System.out.print("Enter How Many Intern Do You Want: ");
				  int n=s.nextInt();
				  
				  for(int i=0;i<n;i++) {
				  System.out.print("Enter Intern Id: ");
				  int internId= s.nextInt();
				  
				  System.out.print("Enter Intern Name: ");
				  String iName=s1.nextLine();
				  
				  System.out.print("Enter Intern Salary: ");
				  int salary= s.nextInt();

				  
				  al.add(new Intern(internId,iName,salary));
				  }
				  oos=new ObjectOutputStream(new FileOutputStream(file));
				  oos.writeObject(al);
				  oos.close();
				  break;
			  case 2:
				  if(file.isFile()) {
					  ois= new ObjectInputStream(new FileInputStream(file));
					  al=(ArrayList<Intern>)ois.readObject();
					  ois.close();
				  System.out.println("------------------------------");
				  li=al.listIterator();
				  while(li.hasNext())
				  System.out.println(li.next());
				  System.out.println("------------------------------");
				  }
				  else {
					  System.out.println("File Not Exists...!");
				  }
				  break;
				  
			  case 3:
				  if(file.isFile()) {
				  ois= new ObjectInputStream(new FileInputStream(file));
				  al=(ArrayList<Intern>)ois.readObject();
				  ois.close();
				  boolean found =false;
				  System.out.print("Enter Intern Id To Search: ");
				  int internId=s.nextInt();
				  System.out.println("------------------------------");
				  li=al.listIterator();
				  while(li.hasNext()) {
					  Intern i= (Intern)li.next();
					  if(i.internId == internId) {
				  System.out.println(i);
				  found= true;
				  }
				  }
				  if(!found) {
					  System.out.println("Record Not Found...!");
				  }
				  System.out.println("------------------------------");
				  }
				  else {
					  System.out.println("File Not Exists...!");
				  }
				  break;
				  
			  case 4:
				  if(file.isFile()) {
				  ois= new ObjectInputStream(new FileInputStream(file));
				  al=(ArrayList<Intern>)ois.readObject();
				  ois.close();
				  boolean found =false;
				  System.out.print("Enter Intern Id To Delete Record: ");
				  int internId=s.nextInt();
				  System.out.println("------------------------------");
				  li=al.listIterator();
				  while(li.hasNext()) {
					  Intern i= (Intern)li.next();
					  if(i.internId == internId) {
				       li.remove();
				      found= true;
				  }
				  }
				  if(found) {
					  oos=new ObjectOutputStream(new FileOutputStream(file));
					  oos.writeObject(al);
					  oos.close();
					  System.out.println("Record Deleted Successfully...!");  
				  }
				  else {
					  System.out.println("Record Not Found...!");
				  }
				  System.out.println("------------------------------");
				  }
				  else {
					  System.out.println("File Not Exists...!");
				  }
				  break;
				  
			  case 5:
				  if(file.isFile()) {
				  ois= new ObjectInputStream(new FileInputStream(file));
				  al=(ArrayList<Intern>)ois.readObject();
				  ois.close();
				  boolean found =false;
				  System.out.print("Enter Intern Id To Update Record: ");
				  int internId=s.nextInt();
				  System.out.println("------------------------------");
				  li=al.listIterator();
				  while(li.hasNext()) {
					  Intern i= (Intern)li.next();
					  if(i.internId == internId) {
				       System.out.print("Enter New Intern name: ");
				       String iName=s1.nextLine();
				       
				       System.out.println("Enter New Salary: ");
				       int salary= s.nextInt();
				       li.set(new Intern(internId,iName,salary));
				      found= true;
				  }
				  }
				  if(found) {
					  oos=new ObjectOutputStream(new FileOutputStream(file));
					  oos.writeObject(al);
					  oos.close();
					  System.out.println("Record Updated Successfully...!");  
				  }
				  else {
					  System.out.println("Record Not Found...!");
				  }
				  System.out.println("------------------------------");
				  }
				  else {
					  System.out.println("File Not Exists...!");
				  }
				  break;
				  
			  case 6:
				  if(file.isFile()) {
					  ois= new ObjectInputStream(new FileInputStream(file));
					  al=(ArrayList<Intern>)ois.readObject();
					  ois.close();
					  
					  Collections.sort(al, new Comparator<Intern>(){
						  public int compare(Intern i1, Intern i2) { 
						  return i1.internId - i2.internId;}
					  });
					  
				  System.out.println("------------------------------");
				  li=al.listIterator();
				  while(li.hasNext())
				  System.out.println(li.next());
				  System.out.println("------------------------------");
				  }
				  else {
					  System.out.println("File Not Exists...!");
				  }
				  break;
				  
			  case 7:
				  if(file.isFile()) {
					  ois= new ObjectInputStream(new FileInputStream(file));
					  al=(ArrayList<Intern>)ois.readObject();
					  ois.close();
					  
					  Collections.sort(al, new Comparator<Intern>(){
						  public int compare(Intern i1, Intern i2) { 
						  return i1.internId - i2.internId;}
					  });
					  
					  oos= new ObjectOutputStream(new FileOutputStream(file));
					  oos.writeObject(al);
					  oos.close();
					  
					  
				  System.out.println("------------------------------");
				  li=al.listIterator();
				  while(li.hasNext())
				  System.out.println(li.next());
				  System.out.println("------------------------------");
				  }
				  else {
					  System.out.println("File Not Exists...!");
				  }
				  break;
				  
			  case 8:
				  if(file.isFile()) {
					  ois= new ObjectInputStream(new FileInputStream(file));
					  al=(ArrayList<Intern>)ois.readObject();
					  ois.close();
					  
					  Collections.sort(al, new Comparator<Intern>(){
						  public int compare(Intern i1, Intern i2) { 
						  return i1.iName.compareTo(i2.iName);
						  }
					  });
					  
				  System.out.println("------------------------------");
				  li=al.listIterator();
				  while(li.hasNext())
				  System.out.println(li.next());
				  System.out.println("------------------------------");
				  }
				  else {
					  System.out.println("File Not Exists...!");
				  }
				  break;
				  
			  case 9:
				  if(file.isFile()) {
					  ois= new ObjectInputStream(new FileInputStream(file));
					  al=(ArrayList<Intern>)ois.readObject();
					  ois.close();
					  
					  Collections.sort(al, new Comparator<Intern>(){
						  public int compare(Intern i1, Intern i2) { 
							  return i1.iName.compareTo(i2.iName);}
					  });
					  
					  oos= new ObjectOutputStream(new FileOutputStream(file));
					  oos.writeObject(al);
					  oos.close();
					  
					  
				  System.out.println("------------------------------");
				  li=al.listIterator();
				  while(li.hasNext())
				  System.out.println(li.next());
				  System.out.println("------------------------------");
				  }
				  else {
					  System.out.println("File Not Exists...!");
				  }
				  break;
				  
			  case 10:
				  if(file.isFile()) {
					  ois= new ObjectInputStream(new FileInputStream(file));
					  al=(ArrayList<Intern>)ois.readObject();
					  ois.close();
					  
					  Collections.sort(al, new Comparator<Intern>(){
						  public int compare(Intern i1, Intern i2) { 
						  return i2.salary -i1.salary;
						  }
					  });
					  
				  System.out.println("------------------------------");
				  li=al.listIterator();
				  while(li.hasNext())
				  System.out.println(li.next());
				  System.out.println("------------------------------");
				  }
				  else {
					  System.out.println("File Not Exists...!");
				  }
				  break;
				  
			  case 11:
				  if(file.isFile()) {
					  ois= new ObjectInputStream(new FileInputStream(file));
					  al=(ArrayList<Intern>)ois.readObject();
					  ois.close();
					  
					  Collections.sort(al, new Comparator<Intern>(){
						  public int compare(Intern i1, Intern i2) { 
							  return i1.salary -i2.salary;
							  }
					  });
					  
					  oos= new ObjectOutputStream(new FileOutputStream(file));
					  oos.writeObject(al);
					  oos.close();
					  
					  
				  System.out.println("------------------------------");
				  li=al.listIterator();
				  while(li.hasNext())
				  System.out.println(li.next());
				  System.out.println("------------------------------");
				  }
				  else {
					  System.out.println("File Not Exists...!");
				  }
				  break;
				  
			  }
	  }while(choice!=0);
	  }
}

public class CrudDemoFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
