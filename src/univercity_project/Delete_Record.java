package univercity_project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Delete_Record
{
        PreparedStatement p;  
        Connection  con;         
        Scanner s1;
        String name,fatherName,address,email;
        int id,phone;
        String ch;
       public Delete_Record(Scanner s,Connection con)
    {
       s1=s;
       this.con=con;       
       this.delete_rec();
    } 
       public void delete_rec()
    {
        do
        {
       System.out.println("Please enter your id");
       id=s1.nextInt();
       
       try
       {
       p=con.prepareStatement("delete from student where id=(?)");        
        p.setInt(1,id);
          int i=p.executeUpdate(); 
          
          if(i>=0)
          {
             System.out.println("\n******* Delete Successfuly :) ********");
          }
          else
          {
               System.out.println("Delete not complete :( ");
          }
       }                
    catch(Exception e)
    {
          System.out.println("Error  1 "+e);
    }         
     System.out.println("\n________ Do you want to delete more record press y________");
          ch=s1.next();
          
       } while(ch.equals("y")) ;
          Menu m=new Menu(s1,con);
      } 
}
