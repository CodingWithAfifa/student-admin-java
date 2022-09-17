package univercity_project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert_rec
{
        PreparedStatement p;  
        Connection  con;         
        Scanner s1;
        String name,fatherName,address,email;
        int id,phone;
        String ch;

    public Insert_rec(Scanner s,Connection con)
    {
       s1=s;
       this.con=con;       
       this.insert_record();
    }    
    public void insert_record()
    {
        do
        {
       System.out.println("Please enter your id:");
       id=s1.nextInt();
       s1.nextLine();
       System.out.println("Please enter your name:");
       name=s1.nextLine(); 
       System.out.println("Please enter your father name:");
       fatherName=s1.nextLine();
       System.out.println("Please enter your phone number");
       phone=s1.nextInt();
     //  s1.nextInt();
       System.out.println("Please enter your email id");
       email=s1.next();
       s1.nextLine();
       System.out.println("Please enter your address");
       address=s1.nextLine();
       
       try
       {
       p=con.prepareStatement("insert into student values(?,?,?,?,?,?)");        
        p.setInt(1,id);
        p.setString(2,name);     
        p.setString(3,fatherName);
        p.setInt(4,phone);
        p.setString(5,email);
        p.setString(6,address);
        
          int i=p.executeUpdate(); 
          
          if(i>=0)
          {
             System.out.println("\n******* Insert Successfuly :) *******");
          }
          else
          {
               System.out.println("Insert not Complete :(");
          }
       }                
    catch(Exception e)
    {
          System.out.println("Error  1 "+e);
    }         
     System.out.println("\n _________ Do you want to insert more record press y_______");
          ch=s1.next();
          
       } while(ch.equals("y")) ;
          Menu m=new Menu(s1,con);
      } 

    
}
