
 package mybank;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import mybank.Transaction;

import java.io.IOException;
import java.io.InputStreamReader;

public class Mymenu {
  int count=0;
  List<String> FileRecords;
  public void StartBank(){
  @SuppressWarnings("resource")
  Scanner input = new Scanner(System.in);
  char mainYesOrNo = 'Y';
  while (mainYesOrNo =='Y'){
 
   System.out.print("Banking System \n");
   if(count<1){
    count=count+1;
   }else{
    System.out.print(" Again        \n");
   }
 
  
   System.out.print("\t:   Choose Option Please\n\n");
   if(count<2){
    System.out.print("\t\t1 : Start servives \n\n");
    count=count+1;
   }else{
    System.out.print("\t\t1 : Start Again\n\n");
   }
   System.out.print("\t\t2 : Exit\n\n");
   System.out.println("\t\t\tYou Select : ");
   int switchChoice = input.nextInt();
   switch (switchChoice)
   {
  
    case 1: {
     start();
     break;
    }
    case 2: {
     return;
    }
    default: {
      System.out.println("Invalid Selection");
      error();
       break;
    }
   }
   System.out.println("\n\tResume Again ? \n\t\t\tY = yes\n\t\t\tN = No\n");
   System.out.println("You Select : ");
  
   mainYesOrNo =(input.next()).charAt(0);
   if(Character.isLowerCase(mainYesOrNo )){
    mainYesOrNo =Character.toUpperCase(mainYesOrNo );
   }
  }
 }
 private List<String> readFile(String filename) {
  List<String> records = new ArrayList<String>();
    try
    {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line;
      while ((line = reader.readLine()) != null)
      {
        records.add(line);
      }
      reader.close();
      return records;
    }
    catch (Exception e)
    {
      System.err.format("Exception occurred trying to read '%s'.", filename);
      e.printStackTrace();
      return null;
    }
 }
 private void start()   {
  String choice, ch, operation;
        Transaction transac = new Transaction();
        Scanner sc = new Scanner(System.in);
        double amount;
        long accountNo=0;
        String name="";
  String actype="";
        do {
        
         System.out.print("\tQ:Select Your Choice \n\n");
   System.out.print("\t\t1 : New account\n\n");
   System.out.print("\t\t2 : Transaction-Pay bills  \n\n");
   System.out.print("\t\t3 : Enquery \n\n");
  
   System.out.print("\t\t4 :View All Acount Information\n\n");
   System.out.print("\t\t5 :Money Transfer\n\n");
 
   System.out.print("\t\tq : Exit\n\n");
            System.out.println("Your choice: ");
            choice = sc.next();
            switch (choice) {
            case "1":
                double openingBalance;
				
                System.out.println("Enter the opening balance :");
                openingBalance = sc.nextDouble();
                try{
                 BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
                 
                System.out.println("Enter your name: ");
                 name = reader.readLine();
                 
                
                System.out.println("Enter Account Type");
                
                actype=reader.readLine();
                
                }catch(Exception e){}
                
                //String name="";
                transac.transaction(accountNo, "Opening", openingBalance,name,actype);
                accountNo=accountNo+1;
                break;
            case "2":
             System.out.print("\tQ:What do you want to do for Transaction?\n\n");
             System.out.print("\t\ta : Deposit\n\n");
             System.out.print("\t\tb : Withdraw\n\n");
             System.out.print("\t\tc : infochange\n\n");
             System.out.print("\t\td : PayBills/utility actions\n\n");
                ch = sc.next();
                if (ch.equalsIgnoreCase("a"))
                {
                    operation = "Deposit";
                    
                    
                    
                    System.out.println("Account Number:");
                    accountNo = sc.nextLong();
                    System.out.println("Amount:");
                    amount = sc.nextDouble();
                    System.out.println("Enter Your Name");
                    
                    try{
                        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
                        
                       
                        name = reader.readLine();
                        
                       
                      
                       
                       }catch(Exception e){}
                   //name=sc.nextLine();
                    transac.transactiondep(accountNo, operation, amount,name);
                    
                }
                else if (ch.equalsIgnoreCase("b"))
                {
                	
                	
                	
                	
                
                    operation = "Withdraw";
                    
                    System.out.println("Account Number:");
                    accountNo = sc.nextLong();
                    System.out.println("Amount:");
                    amount = sc.nextDouble();
                    System.out.println("Enter Your Name");
                    
                    try{
                        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
                        
                       
                        name = reader.readLine();
                        
                       
                      
                       
                       }catch(Exception e){}
                   //name=sc.nextLine();
                    transac.transactiondep(accountNo, operation, amount,name); 
                    
                }
                else if (ch.equalsIgnoreCase("d"))
                	
                {
                    operation = "Withdraw";
                    
                    
                    System.out.println("Account Number:");
                    accountNo = sc.nextLong();
                    System.out.println(" Enter         bill Amount:");
                    amount = sc.nextDouble();
                    System.out.println("Enter Your Name");
                    
                    try{
                        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
                        
                       
                        name = reader.readLine();
                        
                       
                      
                       
                       }catch(Exception e){}
                   //name=sc.nextLine();
                    transac.transactiondep(accountNo, operation, amount,name);   
                    
                    
                    
                }
                
                else if (ch.equalsIgnoreCase("c"))
                {
                    operation = "changeinfo";
                    System.out.println("Account Number:");
                    accountNo = sc.nextLong();
                    System.out.println(" Enter Name");
                    amount=0;
                    try{
                        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
                        
                       
                        name = reader.readLine();
                        
                       
                      
                       
                       }catch(Exception e){}
                    transac.transaction(accountNo, "changeinfo", 0,name,actype);  
                    
                }
                else {
                    operation = "Invalid option";
                }
                
                break;
            case "3":
            
             System.out.println("Account Number:");
                accountNo = sc.nextLong();
                operation = "showInfo";
                 name=sc.nextLine();
                transac.transaction(accountNo, operation, 0,name,actype);
                break;
            case "4":
                
                System.out.println(" Please enter Your Account Number:");
                   //accountNo = sc.nextLong();
                   operation = "allInfo";
                    //name=sc.nextLine();
                   transac.transaction(accountNo, operation, 0,name,actype);
                   break;
                   
            case "5":
                
                System.out.println(" Enter Your Account Number:");
                   accountNo = sc.nextLong();
                   
                   System.out.println(" Enter another  Account Number:");
              long    mtNo = sc.nextLong();
                   operation = "transfer";
                   System.out.println(" Enter Amount to be Transfer:");
                   double amount1=sc.nextDouble();
                   transac.moneytransfer(accountNo,mtNo, operation, amount1,name,actype);
                   break;
            case "q":
                System.out.println("Thank you!");
                return;
            default:
                error();
            }
        } while (choice != "q");
        sc.close();
 }
 public static void error() {
  System.out.print("----*****************************--------\n");
  System.out.print("\t\t \t -**---***- ERROR <***------------ \n");
 
  System.out.print("\t\t     Select right option Please \n");
 
 }
}
 