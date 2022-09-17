package univercity_project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

//**************************** Student login *******************************

class Student_login
{
     PreparedStatement p;  
    String studentName,password;
    Scanner s1;
    Connection con;
    ResultSet rs;
    public Student_login(Scanner s)
    {          
        try
        {
            s1=s;
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Univercity","root", "");
        }
        catch(Exception e)
        {
            System.out.println("Error= "+e);
        }
    }      
    public void insert()
     {
         System.out.println("\nEnter student name");
         studentName=s1.next();
         System.out.println("Enter student password");
         password=s1.next();
     }     
     public void validate()
     {
         try
         {
         p = con.prepareStatement("select * from St_login where Studentname=? and password=?");
         p.setString(1,studentName);
         p.setString(2, password);
    
         rs=p.executeQuery(); 
        
         if(rs.next())
         {
            
               Student_Menu sm =new Student_Menu(s1,con);
         }
         else
         {
                     System.out.println("Record Not found");
         }        
     }
         catch(Exception ee)
         {
             System.out.println("Error= "+ee);
         }
     }
    
}

//**************************** User Login *******************************************
class Login
{
     PreparedStatement p;  
    String userName,password;
    Scanner s1;
    Connection con;
    int ch;
    ResultSet rs;
    public Login(Scanner s)
    {          
        try
        {
            s1=s;
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Univercity","root", "");
        }
        catch(Exception e)
        {
            System.out.println("Error= "+e);
        }
        System.out.println("\n______________ T.M.V-UNIVERSITY ____________");
    }  
  //*************************** choice *********************
    public void choice()
    {
        System.out.println("Enter your choice");
        System.out.println("1 Admin");
        System.out.println("2 Student");
        
        ch=s1.nextInt();
        switch(ch)
        {
            case 1:
                Student_login st=new Student_login(s1);
                break;
            case 2:
              Login obj=new Login(s1);  
                break;
        }
    }
    // *********************** end choice ******************
     public void insert()
     {
         System.out.println("\nEnter user name");
         userName=s1.next();
         System.out.println("Enter password");
         password=s1.next();
     }     
     public void validate()
     {
         try
         {
         p = con.prepareStatement("select * from admin where Username=? and password=?");
         p.setString(1,userName);
         p.setString(2, password);
    
         rs=p.executeQuery(); 
          if(rs.next())
         {
               Menu m=new Menu(s1,con);
         }
         else
         {
                     System.out.println("Record Not found");
         }        
     }
         catch(Exception ee)
         {
             System.out.println("Error= "+ee);
         }
     }
}

public class Univercity_Project
{
    public static void main(String[] args)
    {
       Scanner s1=new Scanner(System.in);
       Login lg =new Login(s1);
       Student_login st =new Student_login(s1);
     
      int ch;
      
          System.out.println("\n1 Admin login");
          System.out.println("2 Student login");
          System.out.println("\n_____________ Enter your choice _____________");
          ch=s1.nextInt();
      switch(ch)
      {
              case 1:System.out.println("\t*** Admin Login ***");
                  lg.insert();
                  lg.validate();
                  break;
                  
                  case 2:System.out.println("\t*** Student login ***");
                  st.insert();
                  st.validate();
                  break;
      }

    }
    
}
