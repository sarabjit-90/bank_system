package mybank;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;
 public class Transaction {
    private String tsType;
    private double amount;
    private long accountNum;
    private Date date;
    private long accountNum1;
    private String accountype;
    private String name;
    Scanner sc = new Scanner(System.in);
    public Transaction() {
    }
/*
To Create account  and perfrom other  actions 
*/
    public void transaction(long accountNum, String  tsType,double amount,String name,String actype) {
        this.accountNum= accountNum;
        this.tsType = tsType;
        this.amount = amount;
        this.name=name;
    this.accountype=actype;
    System.out.println(this.accountype);
        date = new Date();
        operation();
    }
/* This  function is used to transfer money from one account  to anotheraccount */
    public  void moneytransfer(long accountNo, long mtNo, String  tsType,double amount,String name,String actype)
    {
    	
    	
    	this.accountNum= accountNum;
    	this.accountNum1= mtNo;
        this.tsType = tsType;
        this.amount = amount;
        this.name=name;
    this.accountype=actype;
    System.out.println(this.accountype);
        date = new Date();
        operation();	
    	
    	
    	
    	
    	
    	
    }
    /* This  function is  used to deposit amount in the account */

    public void transactiondep(long accountNum, String  tsType,double amount,String name) {
        this.accountNum= accountNum;
        this.tsType = tsType;
        this.amount = amount;
        this.name=name;
        date = new Date();
        operation();
    }
    /* This  method is  used to withdraw amount and pay eletricity bills */
    public void transactionwid(long accountNum, String  tsType,double amount) {
        this.accountNum= accountNum;
        this.tsType = tsType;
        this.amount = amount;
  
        date = new Date();
        operation();
    }
/* Method to handles multiply tasks like withdraw,deposit  etc */
 private void operation() {
     if (tsType.equalsIgnoreCase("Opening")) {
    	 try{
              // Create file
              FileWriter fstream = new FileWriter("Bank.txt", true);
              BufferedWriter out =new BufferedWriter(fstream);
              int userId=(int) (findMaxId()+1);
              out.write(Integer.toString(userId)+"\n");
          
              out.write(amount+"\n");
              out.write(name+"\n");
              out.write(date+"\n");
              out.write(accountype+"\n");
              //Close the output stream
              out.close();
             }catch (IOException e) {
                 System.err.println("Caught IOException: " + e.getMessage());
             }
           }

        else if (tsType.equalsIgnoreCase("withdraw")) {
        	Path path = Paths.get("Bank.txt");
        	if (Files.exists(path)) {
        		findUpdate() ;
        	}else{
        		System.out.println("File not Found");
        	}
        }

        else if (tsType.equalsIgnoreCase("deposit")) {
        	Path path = Paths.get("Bank.txt");
		   if (Files.exists(path)) {
		    findUpdate2() ;
		   }else{
		    System.out.println("File not Found");
		   }
        }
     
        else if (tsType.equalsIgnoreCase("changeinfo")) {
              Path path = Paths.get("Bank.txt");
		      if (Files.exists(path)) {
		    	  findUpdate1() ;
		      }else{
		       System.out.println("File not Found");
		      }
         }
     
     
     

        else if (tsType.equalsIgnoreCase("showInfo")) {
        	Path path = Paths.get("Bank.txt");
		   if (Files.exists(path)) {
		          findDisplay();
		   }else{
		    System.out.println("File not Found");
		   }
        }
     
        else if (tsType.equalsIgnoreCase("allInfo")) {
    	  Path path = Paths.get("Bank.txt");
	      if (Files.exists(path)) {
	             findAllDisplay();
	      }else{
	       System.out.println("File not Found");
	      }
       }
     
        else if (tsType.equalsIgnoreCase("transfer")) {
        		Path path = Paths.get("Bank.txt");
		      if (Files.exists(path)) {
		             //transferMoney();
		            }else{
		       System.out.println("File not Found");
		      }
        }
	     else {
	         System.out.println("Invalid option");
	         return;
	     }
     

    }
 private int findMaxId() {
  try{
	   BufferedReader reader = new BufferedReader(new FileReader("Bank.txt"));
	   int count=0;
	   while ((reader.readLine()) != null)
	   {
	    count=count+1;
	   }
	   reader.close();
	   // Logic for finding maximum Id
	   return count/3;
  }
  catch (Exception e)
  {
	   System.err.format("Exception occurred trying to read '%s'.", "Bank.txt");
	   e.printStackTrace();
  }
  return 0;
 }
/*  Method  to display  account information by enter account no */
 private void findDisplay() {
  try{
   BufferedReader reader = new BufferedReader(new FileReader("Bank.txt"));
   String line;
   String trmpaccountNum=Long.toString(accountNum);
   int count=1;
   while ((line = reader.readLine()) != null)
   {
    //my logic for displaying 2 more lines after found
	    if(count>1){
	      trmpaccountNum =line;
	     }
	     if((line.equals(trmpaccountNum))&&(count<4)){
	      System.out.println(line);
	      count=count+1;
	     }
    }
   reader.close();
  }
  catch (Exception e)
  {
   System.err.format("Exception occurred trying to read '%s'.", "Bank.txt");
   e.printStackTrace();
  }
 }
 
 
 
 /* This  method is used to print details of all account information */
 private void findAllDisplay() {
	  try{
	   BufferedReader reader = new BufferedReader(new FileReader("Bank.txt"));
	   String line;
	   String trmpaccountNum = Long.toString(accountNum);
	   int count=1;
	   while ((line = reader.readLine()) != null)
	   {
	    //my logic for displaying 2 more lines after found
	    
	      System.out.println(line+"\n");
	      count=count+1;
	       
	      }
	   reader.close();
	  }
	  catch (Exception e)
	  {
	   System.err.format("Exception occurred trying to read '%s'.", "Bank.txt");
	   e.printStackTrace();
	  }
	 }
 
 

 
 /* This  method is  used to withdraw/pay bills */
 
 private void findUpdate() {
  try{
   BufferedReader reader = new BufferedReader(new FileReader("Bank.txt"));
  
   FileWriter fstream = new FileWriter("TempFile.txt", true);
            BufferedWriter out =new BufferedWriter(fstream);
  
            String line;
   String trmpaccountNum=Long.toString(accountNum);
   int count=1;
   while ((line = reader.readLine()) != null)
   {
   
    //my logic for updating 3 lines after found
    if(count>1){
              trmpaccountNum =line;
             }
     if((line.equals(trmpaccountNum))&&(count<4)){
      double temp_amount = 0;
      if (count==1){
       out.write(accountNum+"\n");
      }
      else if (count==2){
       if(tsType.equalsIgnoreCase("withdraw")){
        temp_amount=Double.parseDouble(line)-amount;
       }else if(tsType.equalsIgnoreCase("deposit")){
        temp_amount=amount+Double.parseDouble(line);
       }
       if(temp_amount<0){
        System.out.println("Not change \n");
        out.write(Double.toString(amount)+"\n");
       }else{
        System.out.println(Double.toString(temp_amount)+" update amount\n");
        out.write(Double.toString(temp_amount)+"\n");
       }
      }
      else if(count==3){
       out.write(name+"\n");
      }
       count=count+1;
                    }else{
                      out.write(line+"\n");//System.out.println("if Accounts not present in file");
                    }
          }
   out.close();
   reader.close();
  // Rename the temporary file and delete original file
    File f1 = new File("Bank.txt");
    f1.delete();
    File f2 = new File("TempFile.txt");
    boolean b = f2.renameTo(f1);
    if(b){
    }else{
     System.out.println("Updated has Error");
    }
   // Rename the temporary file and delete original file
  }
  catch (Exception e)
  {
   System.err.format("Exception occurred trying to read '%s'.", "Bank.txt");
   e.printStackTrace();
  }
 }
/* This  method is used  deposit  amount in the account */
 
 private void findUpdate2() {
	  try{
	   BufferedReader reader = new BufferedReader(new FileReader("Bank.txt"));
	  
	   FileWriter fstream = new FileWriter("TempFile.txt", true);
	            BufferedWriter out =new BufferedWriter(fstream);
	  
	            String line;
	   String trmpaccountNum=Long.toString(accountNum);
	   int count=1;
	   while ((line = reader.readLine()) != null)
	   {
	   
	    //my logic for updating 3 lines after found
	    if(count>1){
	              trmpaccountNum =line;
	             }
	     if((line.equals(trmpaccountNum))&&(count<5)){
	      double temp_amount = 0;
	      if (count==1){
	       out.write(accountNum+"\n");
	      }
	      else if (count==2){
	       if(tsType.equalsIgnoreCase("deposit")){
	    	   temp_amount=amount+Double.parseDouble(line);
	       }else if(tsType.equalsIgnoreCase("withdraw")){
	        temp_amount=amount+Double.parseDouble(line);
	       }
	       if(temp_amount<0){
	        System.out.println("Not change \n");
	        out.write(Double.toString(amount)+"\n");
	       }else{
	        System.out.println(Double.toString(temp_amount)+" update amount\n");
	        out.write(Double.toString(temp_amount)+"\n");
	       }
	      }
	      else if(count==3){
	       out.write(name+"\n");
	      }
	      else if(count==4){
		       out.write(date+"\n");
		      }
	       count=count+1;
	                    }else{
	                      out.write(line+"\n");//System.out.println("if Accounts not present in file");
	                    }
	          }
	   out.close();
	   reader.close();
	  // Rename the temporary file and delete original file
	    File f1 = new File("Bank.txt");
	    f1.delete();
	    File f2 = new File("TempFile.txt");
	    boolean b = f2.renameTo(f1);
	    if(b){
	    }else{
	     System.out.println("Updated has Error");
	    }
	   // Rename the temporary file and delete original file
	  }
	  catch (Exception e)
	  {
	   System.err.format("Exception occurred trying to read '%s'.", "Bank.txt");
	   e.printStackTrace();
	  }
	 }


 
 
//  Edit Information about customer
 
 
 private void findUpdate1() {
	  try{
	   BufferedReader reader = new BufferedReader(new FileReader("Bank.txt"));
	  
	   FileWriter fstream = new FileWriter("TempFile.txt", true);
	            BufferedWriter out =new BufferedWriter(fstream);
	  
	            String line;
	   String trmpaccountNum=Long.toString(accountNum);
	   int count=1;
	   while ((line = reader.readLine()) != null)
	   {
	   
	    //my logic for updating 3 lines after found
	    if(count>1){
	              trmpaccountNum =line;
	              System.out.println(line);
	             }
	     if((line.equals(trmpaccountNum))&&(count<4)){
	      double temp_amount = 0;
	      if (count==1){
	       out.write(accountNum+"\n");
	      }
	      else if (count==2){
	     
	    	  out.write(line+"\n");
	      }
	      else if(count==3){
	    	//this.name=name;
	       out.write(name+"\n");
	      }
	       count=count+1;
	                    }else{
	                      out.write(line+"\n");//System.out.println("Account not found in file");
	                    }
	          }
	   out.close();
	   reader.close();
	  // Rename the temporary file and delete original file
	    File f1 = new File("Bank.txt");
	    f1.delete();
	    File f2 = new File("TempFile.txt");
	    boolean b = f2.renameTo(f1);
	    if(b){
	    }else{
	     System.out.println("Updated has Error");
	    }
	   // Rename the temporary file and delete original file
	  }
	  catch (Exception e)
	  {
	   System.err.format("Exception occurred trying to read '%s'.", "Bank.txt");
	   e.printStackTrace();
	  }
	 }
	}
