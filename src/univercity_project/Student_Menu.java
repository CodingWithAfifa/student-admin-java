
package univercity_project;
import java.sql.Connection;
import java.util.Scanner;

public class Student_Menu {
    Scanner s1;
    Connection con;
    int ch;
    public Student_Menu(Scanner ss,Connection con)
    {
        s1=ss;
        this.con=con;         
        this.show_menu();
    }
     public void show_menu()
    {
        System.out.println("\n ____________ Select  Menu ___________");
        System.out.println("1. Display Record");
        System.out.println("2. Course Details");
        System.out.println("3. Logout");
        System.out.println("4. Exit(0)");
        System.out.println("\n_____________ Enter your choice _____________");
        ch=s1.nextInt();
         switch(ch)
        {
            case 1: 
                    Display_Record dr =new Display_Record(s1,con);   
                break;
            case 2:
                Course_Details cn = new Course_Details(s1,con);
                 case 5:
                System.exit(0);
                break;
         
         }
    }
}
